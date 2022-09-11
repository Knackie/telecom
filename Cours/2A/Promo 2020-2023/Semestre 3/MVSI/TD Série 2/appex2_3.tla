-------------------------------- MODULE appex2_3 --------------------------------
EXTENDS Naturals,TLC,Integers
CONSTANTS x,min,max
VARIABLES  y,z,pc
D == min..max
ASSUME x \in D /\ x#1 /\ x#0
-----------------------------
diviseurs(n) == {  m \in 1..n :  n % m = 0}

start == pc="START" /\ y'=2 /\ pc'="g"  /\ UNCHANGED <<z>> 

case1 == 
    /\ pc="g" /\  y \geq x
    /\ z'=TRUE
    /\ pc'="HALT"
    /\ PrintT(y)
    /\  UNCHANGED <<y>> 

case2 == 
    /\ pc="g" /\  y  < x 
    /\ pc'="h"
    /\  UNCHANGED <<z,y>>

case21 == 
    /\ pc="h"  /\ (x % y = 0)
    /\ pc'="HALT"
    /\ z'=FALSE
    /\ PrintT(y)
    /\  UNCHANGED <<y>>

case22 ==
    /\ pc="h"  /\ (x % y # 0)
    /\ pc'="g"
    /\ y'=y+1
    /\  UNCHANGED <<z>>

eprint == 
    /\ pc="HALT"
    /\ PrintT(z)
    /\ PrintT(x)
    /\ UNCHANGED <<y,z,pc>>
    
Next == start  \/ case1 \/ case2 \/ case21 \/ case22 \/ UNCHANGED <<y,z,pc>> \/ eprint
    


Init  == y =0  /\ z = TRUE  /\  pc = "START"



Q1 == pc # "HALT"  (* c prned la valeur HALT *)
Q2 == pc ="HALT" => (z <=> (diviseurs(x)={1,x} /\ x#1))

Q == Q2


=============================================


