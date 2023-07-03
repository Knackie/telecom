------------------- MODULE examen2019q1 -----------------
EXTENDS Naturals,TLC
CONSTANTS  Places (* d\'esigne l'ensemble des places du r\'eseau de Petri  *)
          
VARIABLES  M  (*  la variable d'\'etat  indiquant o\`u se trouvent les jetons *) 
------------------------
ASSUME
   Places \subseteq {"p11","p12","p13", ...}
------------------------
l1 ==
r1 ==
b1 == 
......

Init ==  M = [p \in Places |-> IF p \in {"p1","p2","p3","p4"} THEN 1 ELSE IF .... ]
Next == l1 \/ r1    \/ b1  .....
    

=============================================================================

`



