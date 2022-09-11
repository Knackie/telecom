grammar expr;


program : A COMPLETER ;

exp : INT (('+'|'-'|'*'|'/') INT)* ;



INT : ('0'..'9')+;

