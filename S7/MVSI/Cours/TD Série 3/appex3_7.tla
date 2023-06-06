-------------------------------- MODULE appex3_7 --------------------------------
EXTENDS Naturals, Integers
CONSTANTS a,b,z0
VARIABLES  x,y,z,pc
ASSUME a \in Nat /\ b \in Nat
typeInt(u) == u \in Int
maxi(u,v) == IF u < v THEN v ELSE u
---------------------------------------------------------------------
al0l1 ==
    /\ pc="l0"
    /\ pc'="l1"
    /\ x<y
    /\ z'=z /\ x'=x /\ y'=y
al1l2 ==
    /\ pc="l1"
    /\ pc'="l2"
    /\ z'=y
    /\ x'=x /\ y'=y
al2l5 ==
    /\ pc="l2"
    /\ pc'="l5"
    /\ z'=z /\ x'=x /\ y'=y
al0l3 ==
    /\ pc="l0"
    /\ pc'="l3"
    /\ x \geq y
    /\ z'=z /\ x'=x /\ y'=y
al3l4 ==
    /\ pc="l3"
    /\ pc'="l4"
    /\ z'=x
    /\ x'=x /\ y'=y
  al4l5 ==
    /\ pc="l4"
    /\ pc'="l5"
    /\ z'=z /\ x'=x /\ y'=y
---------------------    
Next == al0l1 \/ al1l2 \/ al2l5  \/ al0l3 \/ al3l4 \/ al4l5 \/ UNCHANGED <<x,y,z,pc>>
Init == pc="l0" /\ x=a /\ y =b /\ z = z0
----------------------
i ==
    /\ typeInt(x) /\ typeInt(y) /\ typeInt(z)
    /\ pc="l0" =>  x=a /\ y=b
    /\ pc="l1" => x<y /\ x=a /\ y=b
    /\ pc="l2" => x<y /\ x=a /\ y=b /\ z=b
    /\ pc="l3" => x \geq y /\ x=a /\ y=b
    /\ pc="l4" => x \geq y /\ x=a /\ y=b /\ z=a
    /\ pc="l5" => ( (a<b /\ z=b) \/ (a \geq b /\ z=a))
safe ==  pc="l5" =>  z = maxi(a,b)
safeab == x=a /\ y=b
=============================================================================
\* Modification History
\* Last modified Wed Sep 23 15:01:10 CEST 2020 by mery
\* Created Wed Sep 09 18:19:08 CEST 2015 by mery
