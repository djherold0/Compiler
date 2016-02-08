/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

/**
 * This is the symbol class
 * @author Dan Herold
 * @version 2014.4.29
 */
public class Symbol {
    protected String type;
    protected String value;
    protected String iD;
    protected String size;
    
    /**
     * Constructor
     * @param name id
     */
    public Symbol(String name){
        iD = name;
        type = "unknown";
        value = "unknown";
        size = "unknown";
    }
    
    /**
     * Constructor
     * @param name id
     * @param type type
     */
    public Symbol(String name, String type) {
        this.iD = name;
        this.type = type;
        this.value = "unknown";
        size = "unknown";
    }
    
    /**
     * Constructor
     * @param name id
     * @param type type
     * @param value value
     */
    public Symbol(String name, String type, String value) {
        this.iD = name;
        this.type = type;
        this.value = value;
        size = "unknown";
    }
    
    /**
     * Constructor
     * @param name the id
     * @param type the type
     * @param value its value
     * @param size how big it is
     */
    public Symbol(String name, String type, String value, String size){
        iD = name;
        this.type = type;
        this.value = value;
        this.size = size;
    }
    
    /**
     * This is the equals() method
     * @param obj the object to compare to this
     * @return true if the ID's match, false if they do not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Token) {
            Token ob = (Token) obj;
            if (ob.getID().compareTo(iD) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
