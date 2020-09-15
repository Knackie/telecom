------------------------------- MODULE projet -------------------------------
EXTENDS Integers,TLC,Sequences
CONSTANTS nb_process
process_x == 1..nb_process

(*
--algorithm work1
    variables R = [Rto \in process_x |-> FALSE] ; attente_message = <<>>; traitement_termine = [Rto \in process_x |-> FALSE]
    
    fair process Q = nb_process+1
    variables tmp;
    begin Qp:
        while \neg \A P \in process_x : traitement_termine[P]  do
            traitement_message: 
                await Len(attente_message)>0;
                tmp := Head(attente_message);
                attente_message := Tail(attente_message);
                R[tmp] := TRUE;
            attente_fin_traitement: 
                await \neg R[tmp];
        end while;
    end process
    
    fair process P \in process_x
    begin
        SendMsg: 
            attente_message := Append(attente_message, self);
        execution: 
            await R[self];
            R[self]:=FALSE;
            traitement_termine[self]:=TRUE;
    end process
    
    
end algorithm; 
*)

CONSTANT defaultInitValue
VARIABLES R, attente_message, traitement_termine, pc, tmp

vars == << R, attente_message, traitement_termine, pc, tmp >>

ProcSet == {nb_process+1} \cup (process_x)

Init == (* Global variables *)
        /\ R = [Rto \in process_x |-> FALSE]
        /\ attente_message = <<>>
        /\ traitement_termine = [Rto \in process_x |-> FALSE]
        (* Process Q *)
        /\ tmp = defaultInitValue
        /\ pc = [self \in ProcSet |-> CASE self = nb_process+1 -> "Qp"
                                        [] self \in process_x -> "SendMsg"]

Qp == /\ pc[nb_process+1] = "Qp"
      /\ IF \neg \A P \in process_x : traitement_termine[P]
            THEN /\ pc' = [pc EXCEPT ![nb_process+1] = "traitement_message"]
            ELSE /\ pc' = [pc EXCEPT ![nb_process+1] = "traitement_termine"]
      /\ UNCHANGED << R, attente_message, traitement_termine, tmp >>

traitement_message == /\ pc[nb_process+1] = "traitement_message"
                 /\ Len(attente_message)>0
                 /\ tmp' = Head(attente_message)
                 /\ attente_message' = Tail(attente_message)
                 /\ R' = [R EXCEPT ![tmp'] = TRUE]
                 /\ pc' = [pc EXCEPT ![nb_process+1] = "attente_fin_traitement"]
                 /\ traitement_termine' = traitement_termine

attente_fin_traitement == /\ pc[nb_process+1] = "attente_fin_traitement"
                      /\ \neg R[tmp]
                      /\ pc' = [pc EXCEPT ![nb_process+1] = "Qp"]
                      /\ UNCHANGED << R, attente_message, traitement_termine, tmp >>

Q == Qp \/ traitement_message \/ attente_fin_traitement

SendMsg(self) == /\ pc[self] = "SendMsg"
                 /\ attente_message' = Append(attente_message, self)
                 /\ pc' = [pc EXCEPT ![self] = "execution"]
                 /\ UNCHANGED << R, traitement_termine, tmp >>

execution(self) == /\ pc[self] = "execution"
              /\ R[self]
              /\ R' = [R EXCEPT ![self] = FALSE]
              /\ traitement_termine' = [traitement_termine EXCEPT ![self] = TRUE]
              /\ pc' = [pc EXCEPT ![self] = "traitement_termine"]
              /\ UNCHANGED << attente_message, tmp >>

P(self) == SendMsg(self) \/ execution(self)

(* Allow infinite stuttering to prevent deadlock on termination. *)
Terminating == /\ \A self \in ProcSet: pc[self] = "traitement_termine"
               /\ UNCHANGED vars

Next == Q
           \/ (\E self \in process_x: P(self))
           \/ Terminating

Spec == /\ Init /\ [][Next]_vars
        /\ WF_vars(Q)
        /\ \A self \in process_x : WF_vars(P(self))

Termination == <>(\A self \in ProcSet: pc[self] = "traitement_termine")


AllProcesstraitement_termine ==  <>(\A Pi \in process_x: traitement_termine[Pi])

NoMoreThanOneUseR == \neg (\E x,y \in process_x: x /= y /\ R[x] /\ R[y] )

=============================================================================

