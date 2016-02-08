/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

/**
 * This is the table that holds the grammar in numeric form
 * @author Dan Herold
 * @version 2014.4.13
 */
public final class GrammarTable {
    public static final int[][] grammar = {
        {100, 101, 41}, //$accept : block $end
        {101, 102, 110, 0},//block: declarations compound_statement $
        {102, 2, 103},//decalarations: DECLARE declare_rest
        {102},//|empty
        {103, 1, 105, 104, 3, 103},//declare_rest: id data_type default ; declare_rest
        {103},//|empty
        {104, 4, 115},//default: := righthandside
        {104},//|empty
        {105, 106},//data_type: characters
        {105, 109},//|numbers
        {105, 5},//|boolean
        {106, 6},//characters: CHAR
        {107, 7, 108},//size: num size_option
        {107},//|empty
        {108, 8, 7},//size_option: , num
        {108},//|empty
        {109, 9, 39, 107, 40},//numbers: NUMBER ( size )
        {109, 10, 39, 107, 40},//|INT ( size )
        {109, 11, 39, 107, 40},//|SMALLINT ( size )
        {109, 12, 39, 107, 40},//|POSITIVE ( size )
        {110, 13, 111, 14, 3},//compound_statement: BEGIN optional_statements END ;
        {111, 15, 3},//optional_statement: NULL ;
        {111, 112},//|statement_list
        {112, 113},//statement_list: statement
        {112, 112, 3, 113},//|statement_list ; statement
        {113, 114},//statement: lefthandside
        {113, 110},//|compound_statement
        {113, 16, 39, 1, 40},//|DBMS_OUTPUT.PUT_LINE ( id )
        {113, 17, 39, 1, 40},//|DBMS_OUTPUT.PUT ( id )
        {113, 18},//|DBMS_OUTPUT.NEW_LINE
        {113, 19, 1},//|& id
        {113, 20, 116, 21, 113, 14, 20},//|IF expression THEN statement END IF
        {113, 22, 116, 23, 113, 14, 23},//|WHILE expression LOOP statement END LOOP
        {114, 1, 4, 115},//lefthandside: id := righthandside
        {115, 116},//righthandside: expression
        {115, 24},//|schar             //('c')
        {116, 117},//expression: simple_expression
        {116, 117, 120, 117},//|simple_expression relop simple_expression
        {117, 118},//simple_expression: term
        {117, 117, 121, 118},//|simple_expression addop term
        {118, 119},//term: factor
        {118, 118, 122, 119},//|term mulop factor
        {119, 1},//factor: id
        {119, 7},//|num
        {119, 25},//|TRUE
        {119, 26},//|FALSE
        {119, 15},//|NULL
        {119, 27, 119},//|NOT factor
        {120, 28},//relop: >
        {120, 29},//|>=
        {120, 30},//|=
        {120, 31},//|<=
        {120, 32},//|<
        {120, 33},//|<>
        {121, 34},//addop: +
        {121, 35},//|-
        {122, 36},//mulop: *
        {122, 37},//|/
        {122, 38},//|MOD
    };
    
    public static int[] getRule(int num){
        return grammar[num];
    }
}
