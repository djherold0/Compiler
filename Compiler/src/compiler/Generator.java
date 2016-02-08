/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This is the intermediate code generator class. It uses Quad to write to the
 * output file, but it fills a buffer until the code is fully parsed. Then, it
 * writes out all the code.
 *
 * @author Dan Herold
 * @version 2014.5.12
 */
public class Generator {

    //the line currently generating in the output file
    private int line;
    //the operands/values the parser is throwing at this
    private Stack<String> stack;
    //the list of lines that need backpatching
    private Stack<Integer> needPatch;
    //the list of lines that need loop patching
    private Stack<Integer> loopBack;
    //the list of all code to be generated for the source file
    private ArrayList<Quad> buffer;
    //the writer to actually write the file
    private BufferedWriter write;
    //the ops
    private String op1;
    private String op2;
    private String op3;
    //temp counter
    private int tempCtr;
    //symbol table
    private SymbolTable s;

    /**
     * The intermediate code generator
     *
     * @param fName the name of the file that is being processed (passed by
     * parser)
     */
    public Generator(String fName) {
        line = 0;
        tempCtr = 0;
        stack = new Stack<>();
        needPatch = new Stack<>();
        loopBack = new Stack<>();
        buffer = new ArrayList<>();
        try {
            write = new BufferedWriter(new FileWriter(new File("Mice/" + fName + ".asm")));
        } catch (IOException ie) {
            System.err.println("Error writing to generator file.");
            System.err.println(ie.getMessage());
        }
    }

    /**
     * Creates a new line and shoves it into the output buffer
     *
     * @param rule the rule to reduce by
     */
    public void reduce(int rule) {
        String cdt = "";
        String temp = "temp";
        switch (rule) {
            /**
             * This case is the code has been accepted, it needs a halt
             */
            case 0:
                //add halt to buffer
                buffer.add(new Quad("HLT", "", "", ""));
                //write contents of buffer
                write();
                break;
            /**
             * This case is for storing identifiers
             */
            case 4:
                op1 = stack.pop();
                op2 = null;
                op3 = stack.pop();
                if (op1.matches("[a-z]")) {
                    char c = op1.charAt(0);
                    int ic = (int) c;
                    op1 = String.valueOf(ic);
                } else if (op1.matches("TRUE")) {
                    op1 = "1";
                } else if (op1.matches("FALSE")) {
                    op1 = "0";
                }
                buffer.add(new Quad("STO", op1, op2, op3));
                line++;
                break;
            /**
             * This case is for output.put_line( id )
             */
            case 27:
                //this changes based on just single character or identifier
                //SYS #-2 is render number as ascii char
                op1 = "#-1";
                op2 = stack.pop();
                op3 = null;
                //this is print out something as a number
                buffer.add(new Quad("SYS", "#-1", op2, op3));
                line++;
                //now we must add the new line
                buffer.add(new Quad("SYS", "#0", "", ""));
                line++;
                break;
            /**
             * This case is for output.put ( id )
             */
            case 28:
                op1 = "#-1";
                op2 = stack.pop();
                op3 = null;
                buffer.add(new Quad("SYS", op1, op2, op3));
                line++;
                break;
            /**
             * This case is for output.new_line
             */
            case 29:
                op1 = "#0";
                op2 = null;
                op3 = null;
                buffer.add(new Quad("SYS", op1, op2, op3));
                line++;
                break;
            /**
             * This case is for & id
             */
            case 30:
                op1 = "#1";
                op2 = null;
                op3 = stack.pop();
                buffer.add(new Quad("SYS", op1, op2, op3));
                line++;
                break;
            /**
             * This case is for IF
             */
            case 31:
                backPatch(line);
                loopBack.pop();
                break;
            /**
             * This case is for WHILE
             */
            case 32:
                buffer.add(new Quad("JMP", null, null, "" + loopBack.pop()));
                line++;
                backPatch(line);
                break;
            /**
             * This case is for id := righthandside
             */
            case 33:
                tempCtr = 0;
                op1 = stack.pop();
                op2 = null;
                op3 = stack.pop();
                if (op1.matches("[a-z]")) {
                    char c = op1.charAt(0);
                    int ic = (int) c;
                    op1 = String.valueOf(ic);
                } else if (op1.matches("TRUE")) {
                    op1 = "1";
                } else if (op1.matches("FALSE")) {
                    op1 = "0";
                }
                buffer.add(new Quad("STO", op1, op2, op3));
                line++;
                break;
            /**
             * This case is for s_expr relop s_expr
             */
            case 37:
                loopBack.push(line);
                op3 = null;
                op2 = stack.pop();
                cdt = stack.pop();
                op1 = stack.pop();
                if (cdt.compareTo("<") == 0) {
                    cdt = "JLT";
                } else if (cdt.compareTo(">") == 0) {
                    cdt = "JGT";
                } else if (cdt.compareTo(">=") == 0) {
                    cdt = "JGE";
                } else if (cdt.compareTo("<=") == 0) {
                    cdt = "JLE";
                } else if (cdt.compareTo("<>") == 0) {
                    cdt = "JNE";
                } else if (cdt.compareTo("=") == 0) {
                    cdt = "JEQ";
                }
                int foo = line + 3;
                op3 = "" + foo;
                buffer.add(new Quad(cdt, op1, op2, op3));
                line++;
                buffer.add(new Quad("STO", "#0", null, "T"));
                line++;
                foo = line + 2;
                buffer.add(new Quad("JMP", null, null, foo + ""));
                line++;
                buffer.add(new Quad("STO", "#1", null, "T"));
                line++;
                buffer.add(new Quad("JNE", "#1", "T", null));
                needPatch.push(line);
                line++;
                break;
            /**
             * This case is for s_expr addop term
             */
            case 39:
                op2 = stack.pop();
                cdt = stack.pop();
                op1 = stack.pop();
                tempCtr++;
                if (cdt.compareTo("+") == 0) {
                    buffer.add(new Quad("ADD", op1, op2, "temp" + tempCtr));
                    line++;
                } else {
                    buffer.add(new Quad("SUB", op1, op2, "temp" + tempCtr));
                    line++;
                }
                stack.push("temp" + tempCtr);
                break;
            /**
             * This case is for term mulop factor
             */
            case 41:
                op2 = stack.pop();
                cdt = stack.pop();
                op1 = stack.pop();
                tempCtr++;
                if (cdt.compareTo("*") == 0) {
                    buffer.add(new Quad("MUL", op1, op2, "temp" + tempCtr));
                    line++;
                } else if (cdt.compareTo("/") == 0) {
                    buffer.add(new Quad("DIV", op1, op2, "temp" + tempCtr));
                    line++;
                } else if (cdt.compareTo("MOD") == 0) {
                    buffer.add(new Quad("MOD", op1, op2, "temp" + tempCtr));
                    line++;
                }
                stack.push("temp" + tempCtr);
                break;
        }
    }

    /**
     * This method is for the parser to push things into the generator stack
     *
     * @param thing The string to push into the stack
     */
    public void push(String thing) {
        stack.push(thing);
    }

    /**
     * The backpatch method
     *
     * @param li the current line number
     */
    public void backPatch(int li) {
        //the line that currently needs patching
        int patch = needPatch.pop();
        buffer.get(patch).setOp3("" + li);
    }

    /**
     * Write all the instructions in the buffer
     */
    public void write() {
        int i = 0;
        for (Quad q : buffer) {
            try {
                write.write(i++ + " " + q.toString());
                write.newLine();
            } catch (IOException ie) {
                System.err.println("Error while generating output file for the quad:");
                System.err.println(q.toString());
                break;
            }
        }
        try {
            write.close();
        } catch (IOException e) {
            System.err.println("Error closing writer...");
        }
    }
    
    public void setST(SymbolTable st){
        s = st;
    }
}
