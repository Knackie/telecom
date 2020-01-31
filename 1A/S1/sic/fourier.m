sfrect(20, 0.01, 0, 2 * pi);

function [x, t] = sfrect(N, Te, tdeb, tfin)
    t = tdeb:Te:tfin;

    x = zeros(size(t));
    X = zeros(N, length(t));

    for n = 1:N
        x = x + sin((2 * n - 1) * t) / (2 * n - 1);
        X(n, :) = x;
    end

    x = x * 4 / pi;
    X = X * 4 / pi;
    
    plot(t, x)
    mesh(X)
end

