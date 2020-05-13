--------- MODULE exo3 --------
EXTENDS Integers,TLC,Sequences
CONSTANTS n
--------------------------------------------------------------

(*
-wfNext
--fair algorithm  palindrome  {
variables reverse=0, temp 
{
l0:temp:=n;
l1:while (temp/=0){
    l2:reverse:=10*reverse;
    l3:reverse:=reverse + (temp%10);
    l4:temp:=temp \div 10;
};
l5:if (n = reverse) {
    l6: print <<n,"is a palindrome number">>;
    }
   else {
    l8: print<<n,"is not a palindrome number">>;
    };
}
}
*)
\* BEGIN TRANSLATION - the hash of the PCal code: PCal-5e31b1b0de6880f9462ef79c735ef1d2
CONSTANT defaultInitValue
VARIABLES reverse, temp, pc

vars == << reverse, temp, pc >>

Init == (* Global variables *)
        /\ reverse = 0
        /\ temp = defaultInitValue
        /\ pc = "l0"

l0 == /\ pc = "l0"
      /\ temp' = n
      /\ pc' = "l1"
      /\ UNCHANGED reverse

l1 == /\ pc = "l1"
      /\ IF temp/=0
            THEN /\ pc' = "l2"
            ELSE /\ pc' = "l5"
      /\ UNCHANGED << reverse, temp >>

l2 == /\ pc = "l2"
      /\ reverse' = 10*reverse
      /\ pc' = "l3"
      /\ temp' = temp

l3 == /\ pc = "l3"
      /\ reverse' = reverse + (temp%10)
      /\ pc' = "l4"
      /\ temp' = temp

l4 == /\ pc = "l4"
      /\ temp' = (temp \div 10)
      /\ pc' = "l1"
      /\ UNCHANGED reverse

l5 == /\ pc = "l5"
      /\ IF n = reverse
            THEN /\ pc' = "l6"
            ELSE /\ pc' = "l8"
      /\ UNCHANGED << reverse, temp >>

l6 == /\ pc = "l6"
      /\ PrintT(<<n,"is a palindrome number">>)
      /\ pc' = "Done"
      /\ UNCHANGED << reverse, temp >>

l8 == /\ pc = "l8"
      /\ PrintT(<<n,"is not a palindrome number">>)
      /\ pc' = "Done"
      /\ UNCHANGED << reverse, temp >>

(* Allow infinite stuttering to prevent deadlock on termination. *)
Terminating == pc = "Done" /\ UNCHANGED vars

Next == l0 \/ l1 \/ l2 \/ l3 \/ l4 \/ l5 \/ l6 \/ l8
           \/ Terminating

Spec == /\ Init /\ [][Next]_vars
        /\ WF_vars(Next)

Termination == <>(pc = "Done")

\* END TRANSLATION - the hash of the generated TLA code (remove to silence divergence warnings): TLA-e93dfcd4483afb823cb3340c2a2ab570

RECURSIVE verifPalindrome(_,_), toArray(_)

toArray(nombre) == IF nombre = 0 THEN <<>> ELSE Append(toArray(nombre \div 10 ),nombre%10)

verifPalindrome(array,index) == IF index >= Len(array) \div 2 THEN TRUE ELSE array[index] = array[Len(array) - index + 1] /\ verifPalindrome(array,index+1)

partialCorrectness == <>(pc = "l6" /\ verifPalindrome(toArray(reverse),1)) \/ <>(pc = "l8" /\ \neg verifPalindrome(toArray(reverse),1))

==========================
