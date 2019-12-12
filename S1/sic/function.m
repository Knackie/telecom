prompt = 'Specify an angle: ';
val = input(prompt);

disp(evaluate(val));

function [res] = evaluate(n)
    x = [1 ; 2];
    A = [
        cos(n) -sin(n)
        sin(n) cos(n)
    ];

    res = A * x;
end
