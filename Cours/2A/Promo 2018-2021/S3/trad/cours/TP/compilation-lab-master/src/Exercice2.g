grammar Exercice2;
@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap<String,Integer>  memory = new HashMap<String,Integer>();
}


prog:  a;

NIL 	:	'nil' -> ^('nil');
INT :   '0'..'9'+;
v 	:	(INT | NIL) -> ^(INT | NIL);
a 	:	PremV=v |  '(' PremA=a PremX=x -> ^(PremV | '(' PremA PremX) ;
x 	:	'.' PremA=a ')'  | PremS=s ')' -> ^('.' PremA ')' | PremS ')');
s 	:	',' PremA=a s | -> ^((',' PremA)* | );

NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {$channel=HIDDEN;} ;