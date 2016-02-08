/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;
import java.util.TreeSet;

/**
 * This is the parser/driver for the parser
 *
 * @author Dan Herold
 * @version 2014.4.13
 */
public class Parser {

    //the stack
    //state will be the 2nd thing pushed, the first thing popped
    //input will be the first thing pushed, the 2nd thing popped
    private Stack<Integer> stack;
    //the lexical analyzer
    private CScanner scanner;
    //lookahead token
    private Token look;
    //symbol table
    SymbolTable sTable;
    //the list of reserved words
    private TreeSet<String> reserved = new TreeSet<String>();
    private BufferedReader read;
    private ParseTable pTable;
    private int curState;
    //flag for DECLARE section
    private boolean dec;
    //code generator
    private Generator gen;

    public Parser(String fName) {
        //create reserved word list
        createReserveList();
        gen = new Generator(fName);
        try {
            scanner = new CScanner(fName, gen);
            read = new BufferedReader(new FileReader(fName + ".txt"));
        } catch (compiler.CScanner.EndOfFileException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException fe) {
            System.err.println(fe.getMessage());
            fe.printStackTrace();
        }
        gen.setST(scanner.getST());
        stack = new Stack();
        stack = new Stack();
        //end of stack
        stack.push(50);
        //start state
        stack.push(0);
        curState = 0;
    }

    /**
     * This is the shift implementation
     *
     * @param state the next state
     * @param input the token
     */
    private void shift(int state, int input) {
        stack.push(input);
        stack.push(state);
    }

    /**
     * This is the reduce implementation
     *
     * @param rule the rule to reduce by
     */
    private void reduce(int rule) throws SyntaxError {
        //get the rule number to reduce by
        int num = Math.abs(rule);
        //this section is for generating code
        if(num == 27 || num == 28 || num == 29 || num == 30 || num == 31 
                || num == 32 || num == 33 || num == 37 || num == 39 
                || num == 41){
            gen.reduce(num);
        }
        //popping empty from the stack, just push
        if (GrammarTable.grammar[num].length != 1) {
            //start popping and matching stuff
            int input = 0;
            for (int i = GrammarTable.grammar[num].length - 1; i > 0; i--) {
                stack.pop();
                input = stack.pop();
                if (GrammarTable.grammar[num][i] == input) {
                    continue;
                } else {
                    throw new SyntaxError("Syntax error in source file on line "
                        +scanner.getLine());
                }
            }
        }
        //push the LHS
        curState = stack.peek();
        //push the left hand side
        stack.push(GrammarTable.getRule(num)[0]);
        curState = pTable.getNextState(curState, GrammarTable.getRule(num)[0]);
        stack.push(curState);
    }

    class SyntaxError extends Exception {

        public SyntaxError() {
            super();
        }

        public SyntaxError(String msg) {
            super(msg);
        }
    }

    /**
     * Parse the input file
     *
     * @return true if the input is a part of the language, false if it is not
     */
    public boolean parse() {
        pTable = new ParseTable();
        boolean notFound = true;
        curState = stack.peek();
        Token next = null;
        int nextState;
        String name = "";
        try {
            while (notFound) {
                next = scanner.scan();
                nextState = pTable.getNextState(curState, next.getP());
                if (nextState == 9999) {
                    System.err.println("Error in parsing on line "+scanner.getLine());
                    return false;
                } //next state is negative, reduce
                else if (nextState < 0) {
                    while (nextState < 0) {
                        reduce(nextState);
                        nextState = pTable.getNextState(curState, next.getP());
                    }
                    shift(nextState, next.getP());
                    curState = nextState;
                } //next state is positive and not a goto, shift
                else if (nextState > 0) {//took out && nextState < 100
                    shift(nextState, next.getP());
                    curState = nextState;
                } //next state is accept (only happens in state 6)
                if (nextState == 6) {
                    gen.reduce(0);
                    return true;
                }
                if(curState == 9999){
                    System.err.println("Error state reached while parsing.");
                    System.err.println("Error on line: "+ scanner.getLine());
                    return false;
                }
            }
        } catch (java.io.IOException ie) {
            ie.printStackTrace();
        } catch (SyntaxError ex) {
            System.err.println("Syntax Error on line "+scanner.getLine()+" while parsing.");
            return false;
        }catch(compiler.CScanner.MaxIDSizeError me){
            System.err.println(me.getMessage());
            return false;
        }
        return false;
    }

    /**
     * Create a list of reserved words
     */
    public void createReserveList() {
        reserved.add("DECLARE");
        reserved.add("BOOLEAN");
        reserved.add("CHAR");
        reserved.add("NUMBER");
        reserved.add("INT");
        reserved.add("SMALLINT");
        reserved.add("POSITIVE");
        reserved.add("BEGIN");
        reserved.add("END");
        reserved.add("NULL");
        reserved.add("DBMS_OUTPUT.PUT_LINE");
        reserved.add("DBMS_OUTPUT.PUT");
        reserved.add("DBMS_OUTPUT.NEW_LINE");
        reserved.add("IF");
        reserved.add("THEN");
        reserved.add("FALSE");
        reserved.add("WHILE");
        reserved.add("LOOP");
        reserved.add("TRUE");
        reserved.add("NOT");
    }
}
