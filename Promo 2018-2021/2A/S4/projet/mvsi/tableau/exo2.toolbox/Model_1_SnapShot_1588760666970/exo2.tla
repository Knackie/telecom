-------------------------------- MODULE exo2 --------------------------------

EXTENDS Integers, TLC, Sequences, Naturals

CONSTANT arrayCP

(*
#include <stdio .h>

int main() 
{
    int array[100], n, c, d, position, swap;
    printf("Enter number of elements\n"); scanf("%d", &n);
    printf("Enter %d integers\n", n);
    for (c = 0; c < n; c++) scanf("%d", &array[c]); 
    for (c = 0; c < (n − 1); c++) {
        position = c;
        for (d = c + 1; d < n; d++) 
        {
            if (array[position] > array[d]) position = d; 
        }
        if (position != c) 
        {
            swap = array[c]; array[c] = array[position];
            array[position] = swap;
        }
    }
    printf("Sorted list in ascending order:\n");
    for (c = 0; c < n; c++) printf("%d\n", array[c]);
    return 0;
}
*)

(*
--fair algorithm projet_ex2{
    variables c; d; position; swap; array;
    {
        l1: c:=1;
        l2: print c;
        l55: array :=arrayCP;
        l3: while(c<Len(array)) {
            l4: position:=c;
            l5: d:=c+1;
            l6: while(d<Len(array)+1){
                l7: if(array[position] >array[d]){
                    l8: position:=d;
                };
                l6inc: d:=d+1;
            };
            l9: if(position /= c){
                l10: swap := array[c];
                l11: array[c] := array[position]; 
                l12: array[position] := swap;
            };
       
            l3inc: c:=c+1;
        };
    }
}

*)
\* BEGIN TRANSLATION - the hash of the PCal code: PCal-148dc21b17d22fa4018aeb13b0956c66
CONSTANT defaultInitValue
VARIABLES c, d, position, swap, array, pc

vars == << c, d, position, swap, array, pc >>

Init == (* Global variables *)
        /\ c = defaultInitValue
        /\ d = defaultInitValue
        /\ position = defaultInitValue
        /\ swap = defaultInitValue
        /\ array = defaultInitValue
        /\ pc = "l1"

l1 == /\ pc = "l1"
      /\ c' = 1
      /\ pc' = "l2"
      /\ UNCHANGED << d, position, swap, array >>

l2 == /\ pc = "l2"
      /\ PrintT(c)
      /\ pc' = "l55"
      /\ UNCHANGED << c, d, position, swap, array >>

l55 == /\ pc = "l55"
       /\ array' = arrayCP
       /\ pc' = "l3"
       /\ UNCHANGED << c, d, position, swap >>

l3 == /\ pc = "l3"
      /\ IF c<Len(array)
            THEN /\ pc' = "l4"
            ELSE /\ pc' = "Done"
      /\ UNCHANGED << c, d, position, swap, array >>

l4 == /\ pc = "l4"
      /\ position' = c
      /\ pc' = "l5"
      /\ UNCHANGED << c, d, swap, array >>

l5 == /\ pc = "l5"
      /\ d' = c+1
      /\ pc' = "l6"
      /\ UNCHANGED << c, position, swap, array >>

l6 == /\ pc = "l6"
      /\ IF d<Len(array)+1
            THEN /\ pc' = "l7"
            ELSE /\ pc' = "l9"
      /\ UNCHANGED << c, d, position, swap, array >>

l7 == /\ pc = "l7"
      /\ IF array[position] >array[d]
            THEN /\ pc' = "l8"
            ELSE /\ pc' = "l6inc"
      /\ UNCHANGED << c, d, position, swap, array >>

l8 == /\ pc = "l8"
      /\ position' = d
      /\ pc' = "l6inc"
      /\ UNCHANGED << c, d, swap, array >>

l6inc == /\ pc = "l6inc"
         /\ d' = d+1
         /\ pc' = "l6"
         /\ UNCHANGED << c, position, swap, array >>

l9 == /\ pc = "l9"
      /\ IF position /= c
            THEN /\ pc' = "l10"
            ELSE /\ pc' = "l3inc"
      /\ UNCHANGED << c, d, position, swap, array >>

l10 == /\ pc = "l10"
       /\ swap' = array[c]
       /\ pc' = "l11"
       /\ UNCHANGED << c, d, position, array >>

l11 == /\ pc = "l11"
       /\ array' = [array EXCEPT ![c] = array[position]]
       /\ pc' = "l12"
       /\ UNCHANGED << c, d, position, swap >>

l12 == /\ pc = "l12"
       /\ array' = [array EXCEPT ![position] = swap]
       /\ pc' = "l3inc"
       /\ UNCHANGED << c, d, position, swap >>

l3inc == /\ pc = "l3inc"
         /\ c' = c+1
         /\ pc' = "l3"
         /\ UNCHANGED << d, position, swap, array >>

(* Allow infinite stuttering to prevent deadlock on termination. *)
Terminating == pc = "Done" /\ UNCHANGED vars

Next == l1 \/ l2 \/ l55 \/ l3 \/ l4 \/ l5 \/ l6 \/ l7 \/ l8 \/ l6inc \/ l9
           \/ l10 \/ l11 \/ l12 \/ l3inc
           \/ Terminating

Spec == /\ Init /\ [][Next]_vars
        /\ WF_vars(Next)

Termination == <>(pc = "Done")

\* END TRANSLATION - the hash of the generated TLA code (remove to silence divergence warnings): TLA-42887e5f4310d2ad2f21a44dc72f33f9

RECURSIVE ArrayOrderedFromIndex(_,_)

ArrayOrderedFromIndex( A, index) == IF index = Len(A) THEN TRUE
                              ELSE A[index] <= A[index+1] /\ ArrayOrderedFromIndex(A,index+1)

partial_correctness == <>(pc = "Done" /\ ArrayOrderedFromIndex(array,1)) 



=============================================================================
\* Modification History
\* Last modified Wed May 06 12:24:21 CEST 2020 by Antoine
\* Created Tue Jan 14 11:11:05 CET 2020 by Antoine
