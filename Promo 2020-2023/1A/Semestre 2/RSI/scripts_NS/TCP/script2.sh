ns tahoe.tcl
awk '{if (($1=="+")&&($3=="0")&&($5=="tcp")) print $2, $11}' out.tr > seq.tr
awk '{if (($1=="+")&&($4=="0")&&($5=="ack")) print $2, $11}' out.tr > ack.tr
gnuplot < plot_tahoe.cmd
