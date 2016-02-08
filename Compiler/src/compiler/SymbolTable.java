/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 * The symbol table for the compiler
 *
 * @author Dan Herold
 * @version 2014.2.10
 */
public class SymbolTable {

    //The bucket to hold tokens
    protected Symbol[] bucket;
    //the index in the bucket of the next place to insert a token
    private int index;

    /**
     * Creates the SymbolTable object with an array of 50 tokens initially
     */
    public SymbolTable() {
        //TODO: change the number in the initial array based on something
        bucket = new Symbol[50];
        index = 0;
    }

    /**
     * Creates a SymbolTable with size number of token spots in the bucket
     *
     * @param size the number of slots in the bucket for tokens
     */
    public SymbolTable(int size) {
        if (size <= 0) {
            System.err.println("Cannot create bucket of negative size or size of 0.");
        }
        bucket = new Symbol[size];
        index = 0;
    }

    /**
     * Insert token based on identifier
     *
     * @param id the identifier of the token to add
     */
    public void insert(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("Attempting to insert either empty string or null.");
            return;
        }
        if (contains(id)) {
            System.err.println("Symbol table already contains: " + id);
        } else {
            bucket[index++] = new Symbol(id);
        }
    }
    
    /**
     * 
     * @param tok 
     */
    public void insert(Symbol tok){
        
    }

    /**
     * Insert method when given an identifier and a type
     *
     * @param id the identifier to insert
     * @param type the type for the identifier
     */
    public void insert(String id, String type) {
        if (id.compareTo("") == 0 || type.compareTo("") == 0) {
            System.err.println("ID or type not set on insert(id,type).");
        }
        if (contains(id)) {
            System.err.println(id + " is already in the bucket.");
        } else {
            bucket[index++] = new Symbol(id, type);
        }
    }
    
    /**
     * Insert if id, type, and value are known
     * @param id the identifier
     * @param type the type of the symbol
     * @param val the vlue of the symbol
     */
    public void insert(String id, String type, String val){
        if (id.compareTo("") == 0 || type.compareTo("") == 0) {
            System.err.println("ID or type not set on insert(id,type,val).");
        }
        if (contains(id)) {
            System.err.println(id + " is already in the bucket.");
        } else {
            bucket[index++] = new Symbol(id, type, val);
        }
    }

    /**
     * Overloaded method to check for a string id instead of a token object
     *
     * @param id the name of the token to check for in the symbol table
     * @return true if a token has the id specified in the symbol table
     */
    public boolean contains(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to contains() was null or empty.");
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (bucket[i].iD.compareTo(id) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete a token based on its identifier
     *
     * @param id the identifier of the token to delete
     */
    public void delete(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("Attempted to delete a token with an empty ID.");
        } else {
            if (contains(id)) {
                int ind = indexOf(id);
                if (ind == -1) {
                    System.err.println("Symbol not found in bucket to delete.");
                    return;
                } else {
                    for (int i = ind; i < index; i++) {
                        bucket[i] = bucket[i + 1];
                    }
                    index--;
                }
            }
        }
    }

    /**
     * Find the index of a token in the bucket
     *
     * @param id the name of the token to find the index of
     * @return the index of the token in the bucket, or -1 if it is not in the
     * bucket
     */
    private int indexOf(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to indexOf() was null or empty.");
            return -1;
        }
        if (contains(id)) {
            for (int i = 0; i < index; i++) {
                if (bucket[i].iD.compareTo(id) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Accessor method for token attributes based on identifier
     *
     * @param id the identifier for the token to find attributes for
     * @return a string representation of the attributes of the token. NUll if
     * not in bucket
     */
    public String getAttrs(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to getAttrs() was null or empty.");
            return null;
        }
        if (contains(id)) {
            int ind = indexOf(id);
            String atr = bucket[ind].toString();
            return atr;
        }
        return null;
    }

    /**
     * Get the id of a token from the given id
     *
     * @param id the name of the token to check for
     * @return the identifier of the token
     */
    public String getID(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to getID() was null or empty.");
            return null;
        }
        if (contains(id)) {
            int ind = indexOf(id);
            return bucket[ind].iD;
        }
        return "The token, " + id + " is not in the bucket.";
    }

    /**
     * Get the type of the symbol in the table
     *
     * @param id the symbol to get the type of
     * @return the type of the symbol, as a string. Null if the token is not in
     * the bucket
     */
    public String getType(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to type was null or empty.");
            return null;
        }
        if (contains(id)) {
            int ind = indexOf(id);
            return bucket[ind].type;
        }
        return null;
    }

    /**
     * Get the value of a symbol
     *
     * @param id the symbol/token to get the value of
     * @return a string representation of the value, or null if not in bucket
     */
    public String getVal(String id) {
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to getVal() was null or empty.");
            return null;
        }
        if (contains(id)) {
            int ind = indexOf(id);
            return bucket[ind].value;
        }
        return null;
    }
    
    /**
     * Add a type to a symbol in the table
     * @param id the symbol to add a type to
     * @param type the type to set the symbol to
     */
    public void addType(String id, String type){
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to addType() was null or empty.");
            return;
        }
        if(contains(id)){
            int ind = indexOf(id);
            bucket[ind].type = type;
        }
    }
    
    /**
     * Add a value to an existing symbol in the table
     * @param id the symbol to modify the value
     * @param val the new value of the symbol
     */
    public void addVal(String id, String val){
        if (id.compareTo("") == 0 || id == null) {
            System.err.println("The ID passed to addVal() was null or empty.");
            return;
        }
        if(contains(id)){
            int ind = indexOf(id);
            bucket[ind].value = val;
        }
    }

    /**
     * The toString method for the symbol table
     *
     * @return string representation of the symbol table
     */
    @Override
    public String toString() {
        if (index == 0 || index < 0) {
            return "The symbol table is empty";
        } else {
            String ret = "Symbol Table: ";
            for (int i = 0; i < index; i++) {
                ret += bucket[i].toString();
                if (i == index - 1) {
                    ret += "//";
                } else {
                    ret += " -> ";
                }
            }
            return ret;
        }
    }
}
