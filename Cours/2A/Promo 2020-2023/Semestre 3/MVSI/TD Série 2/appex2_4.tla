-------------------------------- MODULE appex2_4 --------------------------------
EXTENDS Integers,TLC
VARIABLES  p
CONSTANTS input,output 

n == 10
nodes == 1..n
l == [i \in 1..n |-> IF i=1 THEN {4,5} ELSE
                     IF i=2 THEN {6,7,10} ELSE
                     IF i=4 THEN {7,8} ELSE
                     IF i=5 THEN {} ELSE
                     IF i=6 THEN {4} ELSE 
                     IF i = 7 THEN {5} ELSE
                     IF i = 8 THEN {5, 2} ELSE
                     {} 
                     ]

lab == [<<x,y>> \in (nodes \X nodes) |-> 
                     IF x=1 /\ y=1  THEN {<<1,2>>} ELSE
                     IF x=1 /\ y=2  THEN {<<1,1>>,<<1,3>>,<<2,2>>} ELSE
                     IF x=1 /\ y=3 THEN {<<1,2>>} ELSE
                     IF x=2 /\ y=2 THEN {<<1,2>>}
                     ELSE {}
                     
                     ]                    

Init == p = 1 
M(i) == /\ i \in l[p]
        /\ p'=i
Next == \E i \in 1..n: M(i)

Initlab == p = input
ML(q) == /\ q \in lab[p]
         /\ p'=q
Nextlab ==  \E q \in  nodes \X nodes : ML(q)

Sortie == p \notin output

===============================
=============================================================================
