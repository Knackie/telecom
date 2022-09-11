-------------------------------- MODULE appex2_2 --------------------------------
EXTENDS Naturals,TLC,Integers
CONSTANTS x,min,max
VARIABLES  y1,y2,z,pc
D == min..max
ASSUME x \in D
----------------------------

start == pc="START" /\ y1'=x /\ y2'=1/\ pc'="LOOP"  /\ UNCHANGED <<z>>

case1 == 
    /\ pc="LOOP" /\  y1  \leq 100 
    /\ y1'=y1+11 /\ y2'=y2+1 
    /\  UNCHANGED <<z,pc>> 

case2 == 
    /\ pc="LOOP" /\  y1  > 100 
    /\ pc'="h"
    /\  UNCHANGED <<z,y1,y2>>
case21 == 
    /\ pc="h"  /\ y2#1
    /\ y1'=y1-10 /\ y2'=y2-1
    /\ pc'="LOOP" 
    /\  UNCHANGED <<z>>

case22 ==
    /\ pc="h" /\ y2=1
    /\ z'=y1-10 /\ pc'="HALT"
    /\ UNCHANGED <<y1,y2>>
    
    
ePrint == pc="HALT" /\ PrintT(z)/\ UNCHANGED <<y1,y2,z,pc>>

-----------
Next == start  \/ case1 \/ case2 \/ case21 \/ case22 \/ UNCHANGED <<y1,y2,z,pc>> \/ ePrint
init1 == y1 \in Int /\ y2 \in Int /\ z \in Int /\ pc = "START"
Init  == y1 =0  /\ y2 = 0  /\ z =0  /\ pc = "START"

Q1 == pc#"HALT"  (* c prned la valeur HALT *)
Q2 == pc="HALT" => z=IF x>100 THEN x-10 ELSE 91

Qy1 == min \leq y1 /\ y1 \leq max 
Qef == y1 \in D  /\ y2 \in D /\ z \in D 
Question == Q2 /\ Qef


=============================================


