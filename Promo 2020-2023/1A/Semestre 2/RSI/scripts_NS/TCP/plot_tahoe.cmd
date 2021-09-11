set terminal post eps color solid "Helvetica" 28
set key right bottom
set grid xtics ytics

set output "courbes/cwnd_tahoe.eps"
set xlabel "temps"
set ylabel "cwnd"
plot "trace_file.tr" u 1:2 notitle with linespoints lw 2


set output "courbes/ack_tahoe.eps"
set xlabel "temps"
set ylabel "Numero de sequence"
plot "seq.tr" u 1:2 title "seq" with dots lw 10, "ack.tr" u 1:2 title "ack" with dots lw 10

