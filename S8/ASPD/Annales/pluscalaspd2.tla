----------------------------- MODULE pluscalaspd2 -----------------------------
EXTENDS Integers, Sequences, TLC, FiniteSets
(*
--wf
--algorithm ex1{ 
variables x = 0;


process (one = 1)
{
  A:
    x := x + 1;
  B: 
    x := x +1;   
};

process (two = 2)
{
  C:
    x := x - 1;
  D:
    assert \ldots;
};

}
end algorithm; 

*)


====
