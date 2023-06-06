------------------------------- MODULE appex3_10 -------------------------------
(* computing the maximum value of an array f *)

EXTENDS Naturals, TLC,Integers
CONSTANTS n,min,max
VARIABLES m,i,l
--------------------------------
f == [j \in 0..n-1 |-> n-j]
--------------------------------


Init == /\ i = 0
        /\ m = 0
        /\ l = "l0"
----------------------------------        
l0l1 == /\ l = "l0" 
        /\ m' = f[0]
        /\ i' = i
        /\ l'= "l1"
        
l1l2 == /\ l = "l1"
        /\ m' = m
        /\ i' = 1
        /\ l'= "l2"   
             
l2l3 == /\ l = "l2"
        /\ i < n
        /\ m' = m
        /\ i' = i
        /\ l'= "l3"
        
l2l8 == /\ l = "l2"
        /\ (i \geq n)
        /\ m' = m
        /\ i' = i
        /\ l'= "l8"
       
l3l4 == /\ l = "l3"
        /\ f[i] > m
        /\ m' = m
        /\ i' = i
        /\ l'= "l4"
        
l3l6 == /\ l = "l3"
        /\ (f[i] \leq m)
        /\ m' = m
        /\ i' = i
        /\ l'= "l6"
 
l4l5 == /\ l = "l4"
        /\ m' = f[i]
        /\ i' = i
        /\ l'= "l5"
        
l5l6 == /\ l = "l5"
        /\ m' = m
        /\ i' = i
        /\ l'= "l6"
        
l6l7 == /\ l = "l6"
        /\ m' = m
        /\ i' = i + 1
        /\ l'= "l7"
        
l7l3 == /\ l = "l7"
        /\ i < n 
        /\ m' = m
        /\ i' = i
        /\ l'= "l3"
 
 l7l8 == 
        /\ l = "l7"
        /\ i \geq n 
        /\ m' = m
        /\ i' = i
        /\ l'= "l8"
 
 
 
Next == \/ l0l1
        \/ l1l2
        \/ l2l3
        \/ l2l8
        \/ l3l4
        \/ l3l6
        \/ l4l5
        \/ l5l6
        \/ l6l7
        \/ l7l3
        \/ l7l8
        \/ UNCHANGED <<m,i,l>>
        
 inv ==
   /\ l \in {"l0","l1","l2","l3","l4","l5","l6","l7","l8"}
   /\ l="l0" => i \in Int /\ m \in Int
   /\ l="l1" => i \in Int /\ m=f[0]
   /\ l="l2" => i=1 /\ m=f[0]
   /\ l="l3" =>  i \in 1..n-1 /\ (\E j \in 0..i-1 : f[j]=m) /\ (\A k \in 0..i-1: f[k] \leq m) 
   /\ l="l4" =>  (i \in 1..n-1 /\ (\E j \in 0..i-1 : f[j]=m) /\ (\A k \in 0..i-1: f[k] \leq m) /\ (f[i] > m))
   /\ l="l5"  => i \in 1..n-1 /\ (\E j \in 0..i : f[j]=m) /\ (\A k \in 0..i: f[k] \leq m) 
   /\ l="l6" =>  i \in 1..n-1 /\ (\E j \in 0..i : f[j]=m) /\ (\A k \in 0..i: f[k] \leq m) 
   /\ l="l7" =>  i \in 2..n /\ (\E j \in 0..i-1 : f[j]=m) /\ (\A k \in 0..i-1: f[k] \leq m) 
   /\ l="l8" =>  i= n  /\ (\E j \in 0..n-1 : f[j]=m) /\ (\A k \in 0..n-1: f[k] \leq m) 
           

  zinf == min..max
  ninf == 0..max
  
runtimeerrors ==  m \in zinf /\ i \in zinf


=============================================================================

