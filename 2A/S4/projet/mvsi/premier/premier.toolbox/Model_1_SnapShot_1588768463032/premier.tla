------------------ MODULE premier -----------------

EXTENDS Integers,TLC
CONSTANTS n
--------------------------------------------------------------

(*
--algorithm  programmepremier {
variables i,count,c;
{
    l0:i:=3;
    l1: if(n>=1){
        l2:print <<"First ",n," prime number ">>;
        l3:print <<2>>;
    };
    l4: count:=2;
    l5: while(count<=n) {
        l6: c:=2;
        l7: while(c <= i-1){
            l8: if(i % c = 0) {
                l9: goto l11
            };
            l10: c:=c+1;
        };
        l11: if ( c = i ) {
           l12: print<<i>>; 
           l13: count:= count+1; 
        };
        l14: i:=i+1;
    };    
    }
}
}
*)

\* BEGIN TRANSLATION
CONSTANT defaultInitValue
VARIABLES i, count, c, pc

vars == << i, count, c, pc >>

Init == (* Global variables *)
        /\ i = defaultInitValue
        /\ count = defaultInitValue
        /\ c = defaultInitValue
        /\ pc = "l0"

l0 == /\ pc = "l0"
      /\ i' = 3
      /\ pc' = "l1"
      /\ UNCHANGED << count, c >>

l1 == /\ pc = "l1"
      /\ IF n>=1
            THEN /\ pc' = "l2"
            ELSE /\ pc' = "l4"
      /\ UNCHANGED << i, count, c >>

l2 == /\ pc = "l2"
      /\ PrintT(<<"First ",n," prime number ">>)
      /\ pc' = "l3"
      /\ UNCHANGED << i, count, c >>

l3 == /\ pc = "l3"
      /\ PrintT(<<2>>)
      /\ pc' = "l4"
      /\ UNCHANGED << i, count, c >>

l4 == /\ pc = "l4"
      /\ count' = 2
      /\ pc' = "l5"
      /\ UNCHANGED << i, c >>

l5 == /\ pc = "l5"
      /\ IF count<=n
            THEN /\ pc' = "l6"
            ELSE /\ pc' = "Done"
      /\ UNCHANGED << i, count, c >>

l6 == /\ pc = "l6"
      /\ c' = 2
      /\ pc' = "l7"
      /\ UNCHANGED << i, count >>

l7 == /\ pc = "l7"
      /\ IF c <= i-1
            THEN /\ pc' = "l8"
            ELSE /\ pc' = "l11"
      /\ UNCHANGED << i, count, c >>

l8 == /\ pc = "l8"
      /\ IF i % c = 0
            THEN /\ pc' = "l9"
            ELSE /\ pc' = "l10"
      /\ UNCHANGED << i, count, c >>

l9 == /\ pc = "l9"
      /\ pc' = "l11"
      /\ UNCHANGED << i, count, c >>

l10 == /\ pc = "l10"
       /\ c' = c+1
       /\ pc' = "l7"
       /\ UNCHANGED << i, count >>

l11 == /\ pc = "l11"
       /\ IF c = i
             THEN /\ pc' = "l12"
             ELSE /\ pc' = "l14"
       /\ UNCHANGED << i, count, c >>

l12 == /\ pc = "l12"
       /\ PrintT(<<i>>)
       /\ pc' = "l13"
       /\ UNCHANGED << i, count, c >>

l13 == /\ pc = "l13"
       /\ count' = count+1
       /\ pc' = "l14"
       /\ UNCHANGED << i, c >>

l14 == /\ pc = "l14"
       /\ i' = i+1
       /\ pc' = "l5"
       /\ UNCHANGED << count, c >>

Next == l0 \/ l1 \/ l2 \/ l3 \/ l4 \/ l5 \/ l6 \/ l7 \/ l8 \/ l9 \/ l10
           \/ l11 \/ l12 \/ l13 \/ l14
           \/ (* Disjunct to prevent deadlock on termination *)
              (pc = "Done" /\ UNCHANGED vars)

Spec == Init /\ [][Next]_vars

Termination == <>(pc = "Done")

\* END TRANSLATION

MAX == 32768  (* 16 bits *)
D == 0..MAX
(*  x \leq 32768 *)
DD(X) ==  ( X # defaultInitValue =>  X \in D)
init(X) ==  ( X # defaultInitValue)

Safety_absence ==  DD(i)  /\ DD(count) /\ DD(c)






============================================================
