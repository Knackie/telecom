% Premier script
function y=script1(t)    
    x = [1;2];
    A = [cos(t) -sin(t); sin(t) cos(t)];    
    y = A * x;
end
