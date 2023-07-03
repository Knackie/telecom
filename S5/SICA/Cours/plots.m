% p(x) = x^3 - 8x^2 - 32x - 13
p = [1 -8 -32 -13];
% q(x) = 4x^2 + 3
q = [4 0 3];

% p(x).q(x)
convolution = conv(p, q)
% p(x)/q(x)
deconvolution = deconv(p, q)

% p(x) on [-5; 12] with a step of .01
step = .01;
interval = [-5:step:12];

% drawing result
plot(interval, polyval(p, interval));
