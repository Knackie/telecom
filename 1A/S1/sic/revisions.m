% --- a)
% instructions
N = 64;
k = 0:N-1;
Te = 1 / 128;  % => fe = 128

x = sin(2 * pi * 20 * k * Te);
% sin(2 * pi * f * t) => frequency = 20 Hz (t = k * Te)

plot(k, x)

% Théorème de Shanon: fe doit être au moins 2x plus grand que la fréquence
% ici freq = 20 Hz et fe = 128, soit 128 > 2 * 20. Le théorème d'échantillonnage est donc
% respecté

% --- b)
X = fft(x);
% non-zero values only:
% X = fftshift(x);
magX = abs(X);
plot(k, magX), title('module de la TF'), xlabel('k'), grid
% alt: 
% stem(k, magX), title('module de la TF'), xlabel('k'), grid
% => l'aspect du signal est donc deux Diracs

% pour un tracé en Hz
f = (0:N-1) / (N * Te);
plot(f, magX), title('module de la TF'), xlabel('f'), grid
% alt: 
% stem(f, magX), title('module de la TF'), xlabel('f'), grid


% --- c)
Y = fftshift(X);
magY = abs(Y);
f = (-N/2:(N/2) - 1) / (N * Te);
plot(f, magY);

% pour faire apparaitre un probleme: si une sin plus petites, les lobes
% de la sin principale peuvent masquer ceux de la sin secondaire
% absorbée:
x = sin(2 * pi * 20 * k * Te) + 0.05 * sin(2 * pi * 35 * k * Te);
% apparente:
% x = sin(2 * pi * 20 * k * Te) + 2 * sin(2 * pi * 35 * k * Te);

% affichage du sinus cardinal
nfft = 2048;
% zero padding
% x = [x zeros(1, nfft - N)];
% X = fftshift(abs(fft(x)));

% pour rendre visible la sinusoide plus petite
% (commenter aussi le zero padding):
X = fftshift(abs(fft(x.* hamming(N)', nfft)));

f = (-nfft/2:(nfft/2) - 1) / (nfft * Te);
plot(f, X);


% --- g)
N = 32;
nfft = 2048;

% raw
X_bartlett = bartlett(N);
X_blackman = blackman(N);
X_kaiser = kaiser(N);
X_chebwin = chebwin(N);

f = (-nfft/2:(nfft/2) - 1) / (nfft * Te);

semilogy([X_bartlett, X_blackman, X_kaiser, X_chebwin]);
legend('bartlett', 'blackman', 'kaiser', 'chebychev');

% fft
X_bartlett = fftshift(abs(fft(bartlett(N), nfft)));
X_blackman = fftshift(abs(fft(blackman(N), nfft)));
X_kaiser = fftshift(abs(fft(kaiser(N), nfft)));
X_chebwin = fftshift(abs(fft(chebwin(N), nfft)));

semilogy([X_bartlett, X_blackman, X_kaiser, X_chebwin]);
legend('bartlett', 'blackman', 'kaiser', 'chebychev');
