---------------- MODULE exo1   --------------------
EXTENDS Naturals,TLC
CONSTANTS ROOTFORCE

VARIABLES 
        nb,sn,bm,bt,ba,root,msg,ack,tr,cnt,con
-----------------------------------------------------
NODES == {0,1,2,3,4,5,6}

election(i) ==
    /\ i \in NODES
    /\ nb[i]=sn[i]
        /\ root'=[root EXCEPT![i]= TRUE]
        /\ UNCHANGED <<nb,sn,bm,bt,ba,msg,ack,tr,cnt,con>>
-----------------------------------------------------


sending_msg(x,y) ==
    /\ x \notin bm
    /\ y \notin ba[x]
    /\ nb[x]=sn[x] \cup {y}
        /\ msg' = msg \cup {<<x,y>>}
    /\ bm' = bm \cup {x}
        /\ UNCHANGED <<nb,sn,bt,ba,root,ack,tr,cnt,con>>
-----------------------------------------------------
sending_ack(x,y) ==
    /\ <<x,y>> \in msg
    /\ x \notin ba[y]
    /\ y \notin bm
        /\ ba'=[ba EXCEPT![y]= @ \cup {x}]
    /\ ack' = ack \cup {<<x,y>>}
        /\ UNCHANGED <<nb,sn,bm,bt,root,msg,tr,cnt,con>>
-----------------------------------------------------

progress(x,y) ==
    /\ <<x,y>> \in ack
    /\ x \notin bt
        /\ tr'=tr \cup {<<x,y>>}
    /\ bt' = bt \cup {x} 
        /\ UNCHANGED <<nb,sn,bm,ba,root,msg,ack,cnt,con>>


rcv_cnf(x,y) == 
    /\ <<x,y>> \in tr
    /\ x \notin sn[y]
        /\ sn'=[sn EXCEPT![y]= @ \cup {x}]
        /\ UNCHANGED <<nb,bm,bt,ba,root,msg,ack,tr,cnt,con>>


decontention(x,y) ==
    /\ <<x,y>> \in cnt
    /\  <<y,x>> \in cnt
        /\ msg'=msg - cnt
        /\ bm'= bm - {x,y}
        /\ cnt'= {}
        /\ UNCHANGED <<nb,sn,bt,ba,root,ack,tr,con>>


contention(x,y) ==
    /\ con = 0
    /\ <<x,y>> \in msg
    /\ <<x,y>> \notin ack
    /\ x \notin ba[y]
    /\ y \in bm
        /\ cnt'=cnt\cup {<<x,y>>}
    /\ con'= 1
        /\ UNCHANGED <<nb,sn,bm,bt,ba,root,msg,ack,tr>>

solvecon(x,y) ==
    /\ con = 1
    /\ <<x,y>> \in msg
    /\ x \notin ba[y]
    /\ y \in bm
        /\ ba'=[ba EXCEPT![y]= @ \cup {x}]
    /\ ack' = ack \cup {<<x,y>>}
        /\ UNCHANGED <<nb,sn,bm,bt,root,msg,tr,cnt,con>>


---------------------------------------------------------
Init == 
    /\ nb = [i \in NODES  |-> IF i=0 THEN {1} ELSE IF i = 1 THEN  {0,2,3} ELSE IF i = 2 THEN  {1,4} ELSE IF i = 3 THEN  {1} ELSE IF i = 4 THEN  {2,6,5} ELSE IF i = 5 THEN  {4} ELSE {4}]
    /\ sn = [i \in NODES  |-> {}] 
    /\ bm ={}
    /\ bt ={}
    /\ ack ={}
    /\ ba = [i \in NODES  |-> {}] 
    /\ root = [i \in NODES  |-> FALSE]
    /\ msg ={}
    /\ cnt ={}
    /\ tr ={}
    /\ con = 0
Next == 
\/ \E i \in NODES: election(i)
\/ \E x,y \in NODES: sending_msg(x,y) 
\/ \E x,y \in NODES: sending_ack(x,y) 
\/ \E x,y \in NODES: progress(x,y) 
\/ \E x,y \in NODES: rcv_cnf(x,y) 
\/ \E x,y \in NODES: contention(x,y) 
\/ \E x,y \in NODES: decontention(x,y) 
\/ \E x,y \in NODES: solvecon(x,y) 
Un_leader_est_elu == <>(\E i \in NODES : root[i] = TRUE)

==================================================================
