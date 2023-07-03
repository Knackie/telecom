------------------- MODULE petri2023tla -----------------
EXTENDS Naturals,TLC
CONSTANTS  Places (* d\'esigne l'ensemble des places du r\'eseau de Petri  *)
          
VARIABLES  M  (*  la variable d'\'etat  indiquant o\`u se trouvent les jetons *) 
------------------------
ASSUME
   Places \subseteq {"p1", "p11","p12","p13", "p2", "p21", "p22", "p23", "p3", "p31", "p32", "p33", "p4", "p41", "p42", "p43"}
------------------------
l1 == 
    /\ M["p2"] >= 1 
    /\ M["p13"] >= 1
    /\ M' = [[[M EXCEPT!["p2"]=M["p2"]-1] EXCEPT!["p13"]=M["p13"]-1] EXCEPT!["p11"]=M["p11"]+1]
l2 == 
    /\ M["p3"] >= 1 
    /\ M["p23"] >= 1
    /\ M' = [[[M EXCEPT!["p3"]=M["p3"]-1] EXCEPT!["p23"]=M["p23"]-1] EXCEPT!["p21"]=M["p21"]+1]
l3 ==
    /\ M["p4"] >= 1 
    /\ M["p33"] >= 1
    /\ M' = [[[M EXCEPT!["p4"]=M["p4"]-1] EXCEPT!["p33"]=M["p33"]-1] EXCEPT!["p31"]=M["p31"]+1]
l4 ==
    /\ M["p1"] >= 1 
    /\ M["p43"] >= 1
    /\ M' = [[[M EXCEPT!["p1"]=M["p1"]-1] EXCEPT!["p43"]=M["p43"]-1] EXCEPT!["p41"]=M["p41"]+1]
r1 ==
    /\ M["p3"] >= 1 
    /\ M["p11"] >= 1
    /\ M' = [[[M EXCEPT!["p3"]=M["p3"]-1] EXCEPT!["p11"]=M["p11"]-1] EXCEPT!["p12"]=M["p12"]+1]
r2 ==
    /\ M["p4"] >= 1 
    /\ M["p21"] >= 1
    /\ M' = [[[M EXCEPT!["p4"]=M["p4"]-1] EXCEPT!["p21"]=M["p21"]-1] EXCEPT!["p22"]=M["p22"]+1]
r3 ==
    /\ M["p1"] >= 1 
    /\ M["p31"] >= 1
    /\ M' = [[[M EXCEPT!["p1"]=M["p1"]-1] EXCEPT!["p31"]=M["p31"]-1] EXCEPT!["p32"]=M["p32"]+1]
r4 ==
    /\ M["p2"] >= 1 
    /\ M["p41"] >= 1
    /\ M' = [[[M EXCEPT!["p2"]=M["p2"]-1] EXCEPT!["p41"]=M["p41"]-1] EXCEPT!["p42"]=M["p42"]+1]
b1 ==
    /\ M["p12"] >= 1 
    /\ M' = [[[[M EXCEPT!["p12"]=M["p12"]-1] EXCEPT!["p13"]=M["p13"]+1] EXCEPT!["p2"]=M["p2"]+1] EXCEPT!["p3"]=M["p3"]+1]
b2 ==
    /\ M["p22"] >= 1 
    /\ M' = [[[[M EXCEPT!["p22"]=M["p22"]-1] EXCEPT!["p23"]=M["p23"]+1] EXCEPT!["p3"]=M["p3"]+1] EXCEPT!["p4"]=M["p4"]+1]
b3 ==
    /\ M["p32"] >= 1 
    /\ M' = [[[[M EXCEPT!["p32"]=M["p32"]-1] EXCEPT!["p33"]=M["p33"]+1] EXCEPT!["p1"]=M["p1"]+1] EXCEPT!["p4"]=M["p4"]+1]
b4 ==
    /\ M["p42"] >= 1 
    /\ M' = [[[[M EXCEPT!["p42"]=M["p42"]-1] EXCEPT!["p43"]=M["p43"]+1] EXCEPT!["p1"]=M["p1"]+1] EXCEPT!["p2"]=M["p2"]+1]

Init ==  M = [p \in Places |-> IF p \in {"p1","p13", "p2", "p23", "p3", "p33", "p4", "p43"} THEN 1 ELSE 0 ]
Next == l1 \/ l2 \/ l3 \/ l4 \/ r1 \/ r2 \/ r3 \/ r4 \/ b1 \/ b2 \/ b3 \/ b4
    
=============================================================================




