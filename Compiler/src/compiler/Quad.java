/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

/**
 * This is the Quad class for the Generator and code generation
 * @author Dan Herold
 * @version 2014.5.12
 */
public class Quad {
    
    private String opCode = null;
    private String op1 = null;
    private String op2 = null;
    private String op3 = null;
    
    /**
     * Constructor for the mini quad code
     * @param code the op code for mini (e.g. STO, HLT, etc.)
     * @param op1 operand 1
     * @param op2 operand 2
     * @param op3 operand 3
     */
    public Quad(String code, String op1, String op2, String op3){
        opCode = code;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
    }
    
    public void setOp3(String op){
        op3 = op;
    }
    
    /**
     * This is for writing strings to the file to put through mini and then mice
     * @return a string that is intermediate code for mini
     */
    public String toString(){
        if(op1 == null){
            op1 = "";
        }
        if(op2 == null){
            op2 = "";
        }
        if(op3 == null){
            op3 = "";
        }
        if(op1.matches("[0-9]+")){
            op1 = "#"+op1;
        }
        if(op2.matches("[0-9]+")){
            op2 = "#"+op2;
        }
        if(op3.matches("[0-9]+")){
            op3 = "#"+op3;
        }
        return opCode + " " + op1 + "," + op2 + "," + op3;
    }
}
