-------------------------------- MODULE appex1_1 --------------------------------
(* modules de base importables *)
EXTENDS Naturals, Integers, TLC 
----------------------------------------------------------------------------
CONSTANTS max,maxint,minint
----------------------------------------------------------------------------
VARIABLES  np
-----------------------------------------------------------------------------
(*  tentative 1 *)
entrer == np'=np +1
sortir == np'=np-1
next == entrer \/ sortir
init == np=0
-----------------------------------------------------------------------------
(* tentative 2 *)
entrer2 == np<max /\ np'=np+1 
next2 ==  entrer2  \/  sortir
-----------------------------------------------------------------------------
(* tentative 3 *)
sortir2 == np>0 /\ np'=np-1 
next3 ==  entrer2  \/  sortir2
------------------
Safety1 == np \in Int
Safety2 == np \leq max 
Safety3 == np \geq 0
question1 ==  np # 6 
rte == minint \leq np /\ np \leq maxint
Safety ==  Safety1 /\ Safety2 /\ Safety3

==============================