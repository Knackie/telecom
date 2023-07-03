-------------------------------- MODULE appex3_8 --------------------------------
EXTENDS Naturals, Integers
CONSTANTS x0
VARIABLES  x,pc
ASSUME x0 \in Nat 
typeInt(u) == u \in Int

---------------------------------------------------------------------
al0l1 ==
    /\ pc="l0"
    /\ pc'="l1"
    /\ 0<x
    /\ x' = x
al1l2 ==
    /\ pc="l1"
    /\ pc'="l2"
    /\ x'=x-1
  
al2l3 ==
    /\ pc="l2"
    /\ pc'="l3"
    /\ 0 \geq x
    /\ x'=x 
    
al2l1 ==
    /\ pc="l2"
    /\ pc'="l1"
    /\ 0  <  x
    /\ x'=x 
al0l3 ==
    /\ pc="l0"
    /\ pc'="l3"
    /\ 0 \geq x
    /\  x'=x 

 

---------------------    
Next == al0l1 \/ al1l2 \/ al2l3  \/ al0l3 \/ al2l1 \/ UNCHANGED <<x,pc>>
Init == pc="l0" /\ x=x0
----------------------
inv ==
    /\ typeInt(x) 
    /\ pc="l0" =>  x=x0 /\ x0 \in Nat
    /\ pc="l1" => 0 < x /\ x \leq x0 
    /\ pc="l2" => 0 \leq x  /\  x  < x0 
    /\ pc="l3" => x = 0 

safe ==  pc="l3" => x=0 

=============================================================================
\* Modification History
\* Last modified Thu Sep 24 18:00:06 CEST 2020 by mery
\* Created Wed Sep 09 18:19:08 CEST 2015 by mery
