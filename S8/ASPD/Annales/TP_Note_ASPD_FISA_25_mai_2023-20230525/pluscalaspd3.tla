----------------------------- MODULE pluscalaspd3 -----------------------------
EXTENDS Integers, Sequences, TLC, FiniteSets
(*
--wf
--algorithm ex3{ 
variables x = 0, y = 2;


process (one = 1)
{
  A:
    x := x + 1;
  B: 
    y := y -1;  
  C:
    assert Q1;
};

process (two = 2)
{
  D:
    x := x - 1;
  E:
    y:=y+2;
   F:
    x:= x+2;   
  G:
    assert Q2;
};

}
end algorithm; 

*)



=====