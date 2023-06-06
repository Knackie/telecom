% --- values
% ----------
f0 = 20;
fe = 100;
Te = 1/fe;
A = 1;
t = 0 : Te : 10;
x = A * sin(2 * pi * f0 * t);

% --- noise
% ----------
% generating a random value for each value of the sinusoid
noise = randn(size(sinusoid));            % white noise
noise = (noise - mean(noise))/std(noise); % creating white gaussian noise
noise = noise * sqrt(7);                  % noise's power =14 * pw = 14 * 1/2 = 7


% autocorrelation
% ----------
maxlag = 30;
[tx, ~] = xcorr(noise, 'unbiased', maxlag);
lag = -maxlag:maxlag;


% --- plots
% ----------
height = 1;
column = 2;

repr_sin = subplot(height, column, 1);
repr_autocorellation = subplot(height, column, 2);

% sinusoid
plot(repr_sin, t, x);
title(repr_sin, 'sinusoid');

% autocorrelation
plot(repr_autocorellation, lag, tx);
title(repr_autocorellation, 'autocorrelation');
