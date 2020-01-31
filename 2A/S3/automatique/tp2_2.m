T1 = 3;
T2 = 2;
s = tf('s');
sys = 2 / ((1+s*T1) * (1+ s* T2));
sys2 = (2 * (s + 1)) / (s^2 + 0.2 * s + 1);
sys3 = (sys * sys2) / (1 + sys * sys2);

zero(sys);
zero(sys2);
zero(sys3);
disp('Les poles de sys sont : ');
pole(sys)
pause(1);
disp('Les poles de sys2 sont : ');
pole(sys2)
pause(1);
disp('Les poles de sys3 sont : ');
pole(sys3)
pause(1);
pzmap(sys,sys2,minreal(sys3));
figure
step(sys3)
