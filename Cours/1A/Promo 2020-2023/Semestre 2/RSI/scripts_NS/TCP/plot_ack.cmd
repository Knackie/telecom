set terminal post eps color solid "Helvetica" 28
set key right bottom
set grid xtics ytics

set output "courbes/ack.eps"
set xlabel "temps"
set ylabel "Numero de sequence"
plot "seq.tr" u 1:2 title "seq" with dots lw 10, "ack.tr" u 1:2 title "ack" with dots lw 10

