 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * This is the scanner for the compiler
 *
 * @author Dan Herold
 * @version 2014.3.19
 */
public class CScanner {

    private File input;
    private File out;
    private BufferedReader read;
    private BufferedWriter write;
    private int ptr = 1;
    private String fName;
    private char next = ' ';
    private HashMap<String, Integer> pValList;
    //the decalare section flag
    private boolean dec;
    //the generator for code
    private Generator gen;
    //the size flag
    private boolean size;
    //did we read in a value?
    private boolean readVal;
    String n, t, l, v;
    private SymbolTable st;

    /**
     * Creates a scanner for the given file
     *
     * @param fName the file to scan tokens from
     * @param g the code generator the parser is using
     * @throws compiler.CScanner.EndOfFileException
     */
    public CScanner(String fName, Generator g) throws EndOfFileException {
        gen = g;
        n = "";
        t = "";
        v = "";
        l = "";
        st = new SymbolTable();
        this.fName = fName;
        //input text from the source file
        input = new File(this.fName + ".txt");
        //output file without comments or whitespace
        out = new File(this.fName + "Stripped.txt");
        //create the parse value list
        pValList = new HashMap<>();
        //add all the words and their values to the list
        popValList();
        String line = "";
        readVal = false;
        size = false;
        dec = false;
        try {
            //create reader for source file
            read = new BufferedReader(new FileReader(input));
            //create writer for smaller source file
            write = new BufferedWriter(new FileWriter(out));
            //read each line from the source file
            multiLineComment:
            while ((line = read.readLine()) != null) {
                //line is comment
                if (line.startsWith("--")) {
                    //do not write to other file
                    continue;
                } //multi-line comment
                else if (line.startsWith("/*")) {
                    //multi-line comment ends on same line
                    if (line.endsWith("*/")) {
                        continue;
                    }
                    //read each line until find the end of multi-line comment marker
                    boolean end = false;
                    while (end == false) {
                        try {
                            line = read.readLine();
                            if (line == null) {
                                throw new EndOfFileException("Reached the end of file while still in a multi-line comment.");
                            } else if (line.endsWith("*/")) {
                                end = true;
                                continue multiLineComment;
                            } else if (line.startsWith("*/")) {
                                end = true;
                                continue multiLineComment;
                            }
                        } catch (IOException ie) {
                            System.err.println("IO error in multi-line comment logic.");
                            ie.printStackTrace(System.err);
                        }
                    }
                }
                //replace tabs with just a space, making tokens easier to locate
                line = line.replaceAll("\t", " ");
                write.write(line);
                //next line
                write.newLine();
            }
        } catch (FileNotFoundException fe) {
            System.err.println("The file the scanner is attempting to read from does not exist.");
            fe.printStackTrace(System.err);
        } catch (IOException ie) {
            System.err.println("The file the scanner is writing to encountered an error.");
            ie.printStackTrace(System.err);
        }
        //close readers and writers
        closeStreams();
        try {
            //set the scanner up to output tokens
            read = new BufferedReader(new FileReader(out));
        } catch (FileNotFoundException fe) {
            System.err.println("Stripped source file not found. (setting up for output of tokens)");
            fe.printStackTrace(System.err);
        }
    }

    /**
     * Scan the file for the next token
     *
     * @return the next token in the file
     * @throws IOException
     * @throws compiler.CScanner.MaxIDSizeError
     */
    public Token scan() throws IOException, MaxIDSizeError {
        //skip white space
        while (true) {
            next = (char) read.read();
            // String n = "" + next;
            if (next == ';') {
                if (dec) {
                    st.insert(new Symbol(n, t, v, l));
                    n = t = v = l = "";
                    //let the generator know to reduce on 4
                    gen.reduce(4);
                    readVal = false;
                }
                return new Token(";", 3);
            } else if (next == ' ' || next == '\t' || next == '\r') {
                continue;
            } else if (next == '\n') {
                ptr++;
            } else {
                break;
            }
        }
        //the next character is a digit
        if (Character.isDigit(next)) {
            String b = "";
            do {
                b += "" + next + "";
                read.mark(50);
                next = (char) read.read();
            } while (Character.isDigit(next));
            if (next != ' ' && next != '\t' && next != '\n') {
                read.reset();
            }
            if (!size) {
                if(dec){
                    v = b;
                }
                gen.push(b);
                readVal = true;
            }else{
                l = b;
            }
            return new Token(b, 7);
        }
        //the next character is a letter, part of an identifier
        if (Character.isLetter(next)) {
            StringBuilder b = new StringBuilder(20);
            do {
                b.append(next);
                read.mark(50);
                next = (char) read.read();
            } while (Character.isLetterOrDigit(next) || next == '_' || next == '.');
            if (next != ' ' && next != '\t' && next != '\n') {
                read.reset();
            }
            String s = b.toString();
            if (s.length() > 20) {
                throw new MaxIDSizeError("Identifier, " + s + ", exceeds character limit; line: " + ptr);
            }
            //string is an identifier
            if (pValList.get(s) == null) {
                if(dec){
                    n = s;
                }
                //if in declare section, put the id on gen stack
                gen.push(s);
                return new Token(s, 1);
            }
            if(dec && isType(s)){
                t = s;
            }
            if(s.compareTo("TRUE") == 0){
                gen.push("1");
            }
            if(s.compareTo("FALSE") == 0){
                gen.push("0");
            }
            if (pValList.get(s) == 2) {
                dec = true;
            }
            if (dec && pValList.get(s) == 13) {
                dec = false;
            }
            if (pValList.get(s) == 38) {
                gen.push("MOD");
            }
            //the string is a reserved word
            return new Token(s, pValList.get(s));
        }
        //the assignment token
        if (next == ':') {
            next = (char) read.read();
            if (next == '=') {
                return new Token(":=", pValList.get(":="));
            }
            next = ' ';
        }
        //comparaison ops
        if (next == '<') {
            next = (char) read.read();
            if (next == '=') {
                gen.push("<=");
                next = ' ';
                return new Token("<=", pValList.get("<="));
            }
            if (next == '>') {
                gen.push("<>");
                next = ' ';
                return new Token("<>", pValList.get("<>"));
            }
            gen.push("<");
            next = ' ';
            return new Token("<", pValList.get("<"));
        }
        if (next == '>') {
            next = (char) read.read();
            if (next == '=') {
                gen.push(">=");
                next = ' ';
                return new Token(">=", pValList.get(">="));
            }
            gen.push(">");
            next = ' ';
            return new Token(">", pValList.get(">"));
        }
        if (next == '$') {
            //done reading the file
            return new Token("$", 0);
        }
        if (next == '\'') {
            next = (char) read.read();
            if(dec){
                v = next+"";
            }
            Token t = new Token("" + next, 24);
            gen.push("" + next);
            next = (char) read.read();
            return t;
        }
        if (next == '(') {
            if (dec) {
                size = true;
            }
            Token t = new Token("(", 39);
            next = ' ';
            return t;
        }
        if (next == ')') {
            if (size) {
                size = false;
            }
            Token t = new Token(")", 40);
            next = ' ';
            return t;
        }
        if (next == '+') {
            gen.push("+");
        }
        if (next == '-') {
            gen.push("-");
        }
        if (next == '*') {
            gen.push("*");
        }
        if (next == '/') {
            gen.push("/");
        }
        if(next == '='){
            gen.push("=");
        }
        char temp = next;
        next = ' ';
        //return any other remaining things
        //if the next character is not in the list of words, it should be an id
        if (temp == '\uffff') {
            return new Token("EOF", 41);
        }
        //this is for single character identifiers
        if (pValList.get("" + temp + "") == null) {
            return new Token("" + temp, 1);
        }
        //the next character is in the list, return its value as well
        return new Token("" + temp, pValList.get("" + temp));
    }

    /**
     * Closes readers and writers
     */
    public void closeStreams() {
        try {
            read.close();
            write.close();
        } catch (IOException ex) {
            System.err.println("Error closing reader/writer.");
            ex.printStackTrace(System.err);
        }
    }

    /**
     * Accessor for the line number
     *
     * @return the current line number
     */
    public int getLine() {
        return ptr;
    }
    
    /**
     * Check if the word is of a type reserved word
     * @param type the string to check
     * @return true if the string is a reserved word of a type
     */
    public boolean isType(String type){
        if(type.compareTo("CHAR") == 0){
            return true;
        }
        else if(type.compareTo("INT") == 0){
            return true;
        }
        else if(type.compareTo("SMALLINT") == 0){
            return true;
        }
        else if(type.compareTo("POSITIVE") == 0){
            return true;
        }
        else if(type.compareTo("BOOLEAN") == 0){
            return true;
        }
        else if(type.compareTo("NUMBER") == 0){
            return true;
        }
        return false;
    }
    
    /**
     * Method to get the symbol table
     * @return the symbol table the scanner is using
     */
    public SymbolTable getST(){
        return st;
    }

    /**
     * Populate the parse value list
     */
    private void popValList() {
        pValList.put("$", 0);
        pValList.put("id", 1);
        pValList.put("DECLARE", 2);
        pValList.put(";", 3);
        pValList.put(":=", 4);
        pValList.put("BOOLEAN", 5);
        pValList.put("CHAR", 6);
        pValList.put("num", 7);
        pValList.put(",", 8);
        pValList.put("NUMBER", 9);
        pValList.put("INT", 10);
        pValList.put("SMALLINT", 11);
        pValList.put("POSITIVE", 12);
        pValList.put("BEGIN", 13);
        pValList.put("END", 14);
        pValList.put("NULL", 15);
        pValList.put("DBMS_OUTPUT.PUT_LINE", 16);
        pValList.put("DBMS_OUTPUT.PUT", 17);
        pValList.put("DBMS_OUTPUT.NEW_LINE", 18);
        pValList.put("&", 19);
        pValList.put("IF", 20);
        pValList.put("THEN", 21);
        pValList.put("WHILE", 22);
        pValList.put("LOOP", 23);
        pValList.put("schar", 24);
        pValList.put("TRUE", 25);
        pValList.put("FALSE", 26);
        pValList.put("NOT", 27);
        pValList.put(">", 28);
        pValList.put(">=", 29);
        pValList.put("=", 30);
        pValList.put("<=", 31);
        pValList.put("<", 32);
        pValList.put("<>", 33);
        pValList.put("+", 34);
        pValList.put("-", 35);
        pValList.put("*", 36);
        pValList.put("/", 37);
        pValList.put("MOD", 38);
        pValList.put("(", 39);
        pValList.put(")", 40);
        //not sure if need the last 4 from terminal list
        //the rest are the non terminals
        pValList.put("$accept", 100);
        pValList.put("block", 101);
        pValList.put("declarations", 102);
        pValList.put("decalre_rest", 103);
        pValList.put("default", 104);
        pValList.put("data_type", 105);
        pValList.put("Characters", 106);
        pValList.put("size", 107);
        pValList.put("size_option", 108);
        pValList.put("numbers", 109);
        pValList.put("compound_statement", 110);
        pValList.put("optional_statements", 111);
        pValList.put("statement_list", 112);
        pValList.put("statement", 113);
        pValList.put("lefthandside", 114);
        pValList.put("righthandside", 115);
        pValList.put("expression", 116);
        pValList.put("simple_expression", 117);
        pValList.put("term", 118);
        pValList.put("factor", 119);
        pValList.put("relop", 120);
        pValList.put("addop", 121);
        pValList.put("mulop", 122);
    }

    /**
     * This is the error class for reaching the end of file
     */
    class EndOfFileException extends Exception {

        public EndOfFileException() {
            super();
        }

        public EndOfFileException(String msg) {
            super(msg);
        }
    }

    /**
     * This is the error class for having an identifier being more than 20
     * characters
     */
    class MaxIDSizeError extends Exception {

        public MaxIDSizeError() {
            super();
        }

        public MaxIDSizeError(String msg) {
            super(msg);
        }
    }
}
