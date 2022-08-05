---------------- MODULE appq42  --------------------
EXTENDS Naturals,TLC
CONSTANTS ROOTFORCE
-----------------------------------------------------
VARIABLES 
        nb,sn,bm,bt,ba,root,msg,ack,tr,cnt
-----------------------------------------------------
NODES == 
-----------------------------------------------------
election(i) ==
	/\ i \in NODES
	/\ nb[i]=sn[i]
    /\ root'=[root EXCEPT![i]= TRUE]
    /\ UNCHANGED <<nb,sn,bm,bt,ba,msg,ack,tr,cnt>>
-----------------------------------------------------
sending_msg(x,y) ==
	/\ x \notin bm
	/\ y \notin ba[x]
	/\ nb[x]=sn[x] \cup {y}
        /\ msg' = msg \cup {<<x,y>>}
	/\ bm' = bm \cup {x}
        /\ UNCHANGED <<nb,sn,bt,ba,root,ack,tr,cnt>>
-----------------------------------------------------
sending_ack(x,y) ==
	/\ <<x,y>> \in msg
	/\ x \notin ba[y]
	/\ y \notin bm
        /\ ba'=[ba EXCEPT![y]= @ \cup {x}]
	/\ ack' = ack \cup {<<x,y>>}
        /\ UNCHANGED <<nb,sn,bm,bt,root,msg,tr,cnt>>
-----------------------------------------------------
progress(x,y) ==
	/\ <<x,y>> \in ack
	/\ x \notin bt
        /\ tr'=tr \cup {<<x,y>>} 
	/\ bt' = bt \cup {x} 
        /\ UNCHANGED <<nb,sn,bm,ba,root,msg,ack,cnt>>
-----------------------------------------------------
rcv_cnf(x,y) == 
	/\ <<x,y>> \in tr
	/\ x \notin sn[y]
        /\ sn'=[sn EXCEPT![y]= @ \cup {x}]
        /\ UNCHANGED <<nb,bm,bt,ba,root,msg,ack,tr,cnt>>
-----------------------------------------------------
decontention(x,y) ==
	/\ <<x,y>> \in cnt
	/\  <<y,x>> \in cnt
        /\ msg'=msg \  cnt
        /\ bm'= bm \  {x,y}
        /\ cnt'= {}
        /\ UNCHANGED <<nb,sn,bt,ba,root,ack,tr>>
contention(x,y) ==
	/\ <<x,y>> \in msg
	/\ <<x,y>> \notin ack
	/\ x \notin ba[y]
	/\ y \in bm
    /\ cnt'=cnt\cup {<<x,y>>}
    /\ UNCHANGED <<nb,sn,bm,bt,ba,root,msg,ack,tr>>
    
---------------------------------------------------------
Init == 
	/\ nb =
	/\ sn = [i \in NODES  |-> {}] 
	/\ bm ={}
	/\ bt ={}
	/\ ack ={}
	/\ ba = [i \in NODES  |-> {}] 
	/\ root = [i \in NODES  |-> FALSE]
	/\ msg ={}
	/\ cnt ={}
	/\ tr ={}

Next == 
\/ \E i \in NODES: election(i)
\/ \E x,y \in NODES: sending_msg(x,y) 
\/ \E x,y \in NODES: sending_ack(x,y) 
\/ \E x,y \in NODES: progress(x,y) 
\/ \E x,y \in NODES: rcv_cnf(x,y) 
\/ \E x,y \in NODES: contention(x,y) 
\/ \E x,y \in NODES: decontention(x,y) 


==================================================================

