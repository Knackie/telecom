program test
    var res : int;

    function fact(n : int) : int
        var i, fact : int;
        { i = 1;
          fact = 1;
            while i <= n do
            {
                 fact = fact * i;
                 i = i + 1
            };
            return fact
        }            

{
    res = fact(3);
    write res
} 