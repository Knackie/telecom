------------------------------- MODULE work1 -------------------------------

EXTENDS Integers, TLC, Sequences
CONSTANTS nb_process
process == 1..nb_process

(*
--algorithm work1
    variables R = [Rto \in process |-> FALSE] ; MessageQueue = <<>>; Done = [Rto \in process |-> FALSE]
    
     fair process Q = nb_process+1
    variables tmp;
    begin Qp:
        while \neg \A P \in process : Done[P]  do
            TraiteMessage: 
                await Len(MessageQueue)>0;
                tmp := Head(MessageQueue);
                MessageQueue := Tail(MessageQueue);
                R[tmp] := TRUE;
            AttenteTerminaison: 
                await \neg R[tmp];
        end while;
    end process
    
    fair process P \in process
    begin
        SendMsg: 
            MessageQueue := Append(MessageQueue, self);
        Exec: 
            await R[self];
            R[self]:=FALSE;
            Done[self]:=TRUE;
    end process
    
    end algorithm; 
*)