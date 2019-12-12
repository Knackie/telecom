disp(resoud_eq_2d(1, 0, 1));
disp(resoud_eq_2d(0, 0, 1));

function [x1, x2] = resoud_eq_2d(a, b, c) 
    % search for roots of ax^2+bx+c = 0
    if a == 0
        error("a must be different than 0");
    end
    
    delta = b^2 - 4 * a * c;
    x1 = (-b + sqrt(delta))/(2 * a);
    x2 = (-b - sqrt(delta))/(2 * a);
end
