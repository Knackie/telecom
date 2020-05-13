transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vcom -2008 -work work {/home/teddy/Documents/TNCY/SCIN/TNCY-2A-Projet-SCIN/registre.vhd}
vcom -2008 -work work {/home/teddy/Documents/TNCY/SCIN/TNCY-2A-Projet-SCIN/tri3valV2.vhd}

vcom -2008 -work work {/home/teddy/Documents/TNCY/SCIN/TNCY-2A-Projet-SCIN/tri3valV2_tb.vhd}

vsim -t 1ps -L altera -L lpm -L sgate -L altera_mf -L altera_lnsim -L cyclonev -L rtl_work -L work -voptargs="+acc"  tri3valV2_tb

add wave *
view structure
view signals
run -all
