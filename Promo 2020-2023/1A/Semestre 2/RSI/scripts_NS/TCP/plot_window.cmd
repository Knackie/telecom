#set terminal post eps color solid "Helvetica" 28
set terminal pdf 
set key right bottom
set grid xtics ytics

set output "courbes/cwnd.jpg"
set xlabel "temps"
set ylabel "cwnd"
plot "trace_file.tr" u 1:2 notitle with linespoints lw 2

