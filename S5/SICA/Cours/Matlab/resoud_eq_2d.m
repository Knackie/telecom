function [x1,x2]=resoud_eq_2d(a, b, c)
    % Cas d'erreur
    if a == 0
        erro('a doit etre non nul')
    end

    % Calcul du discriminant
    d = b^2-4*(a*c);
    
    % Calcul des racines
    x1 = (-b+sqrt(d))/(2*a);
    x2 = (-b-sqrt(d))/(2*a);
end


