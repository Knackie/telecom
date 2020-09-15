grammar projet;

options{
	output = AST;
	k=1;
}

tokens {
	ROOT;
	VARDECLISTE;
	FUNCDECLISTE;
	VARDECL;
	RANGELIST;
	RANGE;
	FUNCDECL;
	ARGLIST;
	REFARG;
	VALARG;
	BLOC;
	INSTR_IF;
	IF_COND;
	IF_THEN;
	IF_ELSE;
	INSTR_WHILE;
	WHILE_COND;
	WHILE_DO;
	INSTR_RETURN;
	INSTR_AFFECT;
	TAB_ACCESS;
	INSTR_FUNC_APPEL;
	INSTR_READ;
	INSTR_WRITE;
	CSTE_ENT;
	CSTE_STR;
	CSTE_BOOLEEN;
	IDF;
	EMPTY;
}

@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap<String,Integer>  memory = new HashMap<String,Integer>();
}

program	: 'program' ID vardeclist fundeclist instr -> ^(ID vardeclist fundeclist instr );

vardeclist
	: (vardecl)* -> ^(VARDECLISTE vardecl*);
vardecl
	: 'var' identlist ':' typename ';' -> ^(VARDECL typename identlist);
identlist
	: ID identlist2;
identlist2
	:
	| ','! identlist;
typename: atomtype
	| arraytype;

atomtype: 'void'
	| 'bool'
	| 'int';

arraytype
	: 'array' '[' rangelist ']' 'of' atomtype -> ^('array' atomtype rangelist);
rangelist
	:	 cste '..' cste (',' cste '..' cste )* -> ^(RANGELIST ^(RANGE cste cste)+   );
fundeclist 
	: (fundecl)* -> ^(FUNCDECLISTE fundecl*);
fundecl : 'function' ID '(' arglist ')' ':' atomtype vardeclist block -> ^(FUNCDECL ID arglist atomtype vardeclist block); 
arglist : -> ^(ARGLIST)
	| arg (',' arg)* -> ^(ARGLIST arg+);

arg : ID ':' typename  ->^(VALARG typename ID)
	| 'ref' ID ':' typename ->^(REFARG typename ID);

instr 	: 'if' expr 'then' instr ( options {greedy = true;}: 'else' instr)? -> ^(INSTR_IF ^(IF_COND expr) ^(IF_THEN instr) ^(IF_ELSE instr)?)
	| 'while' expr 'do' instr -> ^(INSTR_WHILE ^(WHILE_COND expr) ^(WHILE_DO instr))
	| 'return' expr? -> ^(INSTR_RETURN expr?)
	| block
	| ID ( 	
		( 
			lvalue '=' expr -> ^(INSTR_AFFECT ^(TAB_ACCESS ID lvalue) expr )   
			|  '=' expr -> ^(INSTR_AFFECT ^(IDF ID) expr) 
		)
		| '(' exprlist? ')' -> ^(INSTR_FUNC_APPEL ID exprlist?) 
	)
	| 'write' instr5 -> ^(INSTR_WRITE instr5)
	| 'read' ID (
		lvalue -> ^(INSTR_READ ^(TAB_ACCESS ID lvalue))
		| -> ^(INSTR_READ ID )
	);

instr5 	: ID (
		lvalue -> ^(TAB_ACCESS ID lvalue)
		| -> ^(IDF ID)
	)
	| cste;

sequence
	:	 instr sequence2 ;
sequence2
	:
	| ';'! sequence3;
sequence3
	:
	| sequence;
lvalue 	: 
	 '['! exprlist ']'!;
exprlist
	:	 expr exprlist2;
exprlist2
	:
	| ','! exprlist;
expr 	:	 expr_ou ;
exprlist3
	:
	| exprlist;

atom 	: INT  -> ^(CSTE_ENT INT)
	| BOOLEEN -> ^(CSTE_BOOLEEN BOOLEEN)
	| ID ( '['exprlist']' ->^(TAB_ACCESS ID exprlist)
		| '('exprlist3')' ->^(INSTR_FUNC_APPEL ID exprlist3)
		| ->^(IDF ID)) 
	| '('! expr ')'!;

expr_moins_unaire
	:	  ('-'^)* atom;
expr_puissance
	:	 expr_moins_unaire ('^'^ expr_moins_unaire)*;
expr_mult_div
	:	 expr_puissance (('*'^ expr_puissance) | ('/'^ expr_puissance))*;
expr_add_sous
	:	 expr_mult_div (('-'^ expr_mult_div) | ('+'^ expr_mult_div))*;
expr_comparaison
	:	 expr_add_sous(('>'^ expr_add_sous) | ('<'^ expr_add_sous) | ('<='^ expr_add_sous) | ('>='^ expr_add_sous) | ('=='^ expr_add_sous) | ('!='^ expr_add_sous))*;
expr_non
	:	 ('not'^)* expr_comparaison;
expr_et :	 expr_non ('and'^ expr_non)*;
expr_ou :	 expr_et ('or'^ expr_et)*;

block 	:	 '{' seq -> ^(BLOC seq);
seq 	:	 sequence '}'! | '}' -> ^(EMPTY);

cste 	:	 '-' INT -> ^(CSTE_ENT ^('-' INT))
	| 	 INT -> ^(CSTE_ENT INT)
	| BOOLEEN -> ^(CSTE_BOOLEEN BOOLEEN)
	| STRING -> ^(CSTE_STR STRING);

BOOLEEN : 'true'
	| 'false' 
    	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

WS  :   (' '|'\t')+ {$channel=HIDDEN;} ;
NEWLINE:'\r'? '\n' {$channel=HIDDEN;};



