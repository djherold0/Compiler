/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 * The most simplest of code symbols, the token.
 *
 * @author Dan Herold
 * @version 2014.2.10
 */
public class Token {
    
    //TODO: this is too much shit for the token class,
    //all the token class needs is an identifying name
    //and a parse value (int) that the parser can recognize
    
    //TODO: make a symbol class that has the type, value, identifier, size
    //fields to put into the symbol table

    //the id of the token
    private String iD;
    //the parse value of the token
    private int pVal;

    /**
     * Constructor for token objects when given just an identifier
     *
     * @param name the name/identifier of the token
     */
    public Token(String name) {
        this.iD = name;
    }

    /**
     * Constructor for token objects when given identifier and type
     *
     * @param name
     * @param type
     */
    public Token(String name, int parseVal) {
        this.iD = name;
        pVal = parseVal;
    }
    
    /**
     * This is the accessor method for the parse value
     * @return the parse value
     */
    public int getP(){
        return pVal;
    }
    
    /**
     * This is just in case I need to change the parse value for some reason
     * @param derp the value to change the parse value to
     */
    public void changeP(int derp){
        pVal = derp;
    }

    /**
     * Mutator for the identifier of the token, just in case needed
     *
     * @param id The new identifier of the token
     */
    public void changeID(String id) {
        this.iD = id;
    }

    /**
     * Accessor method for the identifier of the token
     *
     * @return the identifier of the token
     */
    public String getID() {
        return iD;
    }


    /**
     * the toString method
     *
     * @return string representation of the token
     */
    @Override
    public String toString() {
        return "ID: " + iD + ", parse value: " + pVal;
    }
}
