/* Un exemple de programme écrit en LEAC */
 program essai
    var i, j: int;
    var maximum : int;
    var Tval : array[-3..3, 0..5] of int;
    
    function maxTAB (t: array[-3..3, 0..5] of int) : int 
        var i, j, max: int;
        { i = -3;
        j = 0;
        max = t[-3, 0];
        while i <= 3 do
            {while j <= 5 do
                { if t[i, j] > max then max = t[i, j];
                    j = j + 1
                    };
                i = i + 1
                };
            return max 
            }
        function theEnd () : void
        { write "that’s all !" }
        
{ /* début du programme principal */ 
    i = -3;
    j = 0;
    while i <= 3 do
        {while j <= 5 do
        {     read Tval[i, j];
            j = j + 1
        };
        i = i + 1
    };
    maximum = maxTAB(Tval);
    write maximum;
	theEnd()
}

