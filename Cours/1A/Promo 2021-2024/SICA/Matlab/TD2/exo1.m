function x = exo1(nbh, pas, td, tf)
    
    % Construction de la fonction 
    t = td:pas:tf;
    x = zeros(size(t));

    for n = 1:nbh
        x = x+(sin((2*n-1)*t))/(2*n-1);
    end
    
    x = (4/pi)*x;

    % Représentation de la fonction
    figure;
    plot(t, x);
    grid;
    title('Onde carrée');
end


