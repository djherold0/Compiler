/* This is the grammar file for Bison */
/* Dan Herold, 2014.4.3 */

/* Prologue */
/*%{

%}*/

//Find out where to put this directive!
//%language 'Java'

/* Bison declarations */
%token EOP "$"
%token DECLARE 
%token id 
%token smcln ";"
%token assign ":="
%token BOOLEAN
%token CHAR
%token num
%token comma ","
%token NUMBER
%token INT
%token SMALLINT
%token POSITIVE
%token BEGIN
%token END
%token NULL
%token DBMS_OUTPUT.PUT_LINE
%token DBMS_OUTPUT.PUT
%token DBMS_OUTPUT.NEW_LINE
%token amp "&"
%token IF 
%token THEN 
%token WHILE 
%token LOOP 
%token schar //this is the single character 'c'
%token TRUE 
%token FALSE 
%token NOT 
%token GT ">"
%token GTE ">="
%token Eq "="
%token LTE "<="
%token LT "<"
%token NEq "<>"
%token plus "+"
%token minus "-"
%token mult "*"
%token div "/"
%token MOD
%token lparen "("
%token rparen ")"

/* Grammar rules */
%%
block: declarations compound_statement EOP
	;
declarations: DECLARE declare_rest
	| /* empty */
	;
declare_rest: id data_type default smcln declare_rest
	| /* empty */
	;
default: assign righthandside
	| /* empty */
	;
data_type: characters
	| numbers
	| BOOLEAN
	;
characters: CHAR
	;
size: num size_option
	| /* empty */
	;
size_option: comma num
	| /* empty */
	;
numbers: NUMBER lparen size rparen
	| INT lparen size rparen
	| SMALLINT lparen size rparen
	| POSITIVE lparen size rparen
	;
compound_statement: BEGIN optional_statements END smcln
	;
optional_statements: NULL smcln
	| statement_list
	;
statement_list: statement
	| statement_list smcln statement
	;
statement: lefthandside
	| compound_statement
	| DBMS_OUTPUT.PUT_LINE lparen id rparen
	| DBMS_OUTPUT.PUT lparen id rparen
	| DBMS_OUTPUT.NEW_LINE
	| amp id
	| IF expression THEN statement END IF
	| WHILE expression LOOP statement END LOOP
	;
lefthandside: id assign righthandside
	;
righthandside: expression
	| schar //single character 'c'
	;
expression: simple_expression
	| simple_expression relop simple_expression
	;
simple_expression: term
	| simple_expression addop term
	;
term: factor
	| term mulop factor
	;
factor: id
	| num
	| TRUE
	| FALSE
	| NULL
	| NOT factor
	;
relop: GT
	| GTE
	| Eq
	| LTE
	| LT
	| NEq
	;
addop: plus
	| minus
	;
mulop: mult
	| div
	| MOD
	;
%%

/* Epilogue */