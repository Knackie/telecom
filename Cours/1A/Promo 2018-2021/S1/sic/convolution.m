x = [1 2 3 4];
y = [5 4 3 2 1];
convolution(x,y)
convolution_v2(x,y)


function[z] = convolution(x, y)
    lx = length(x);
    ly = length(y);
    lz = lx + ly - 1;
    
    z = zeros(1, lz);
    
    for n = 0:lz - 1
        for k = 0:lx - 1
            if n - k + 1 >= 1 && n - k + 1 <= ly
                z(n + 1) = z(n + 1) + x(k + 1) * y(n - k + 1);
            end
        end
    end
end


function[z] = convolution_v2(x, y)
    lx = length(x);
    ly = length(y);
    lz = lx + ly - 1;
    
    z = zeros(1, lz);
    
    X = fft(x, lz);
    Y = fft(y, lz);
    Z = X.*Y;
    z = ifft(Z);
end
