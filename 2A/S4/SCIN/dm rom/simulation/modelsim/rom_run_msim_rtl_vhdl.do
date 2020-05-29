transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/processeur.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/compteur_modulo.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/single_port_rom.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/multiplexeurnbits.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/alu4bitwith3bitop.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/registre.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/bascule.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/single_port_ram.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/registre2_4bits.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/decodeurinstruction.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/decodeurinstructionstatelogic.vhd}
vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/decodeurinstructionoutputlogic.vhd}

vcom -93 -work work {C:/Users/Knacki/telecom/2A/S4/SCIN/dm rom/Processeur_tb.vhd}

vsim -t 1ps -L altera -L lpm -L sgate -L altera_mf -L altera_lnsim -L cyclonev -L rtl_work -L work -voptargs="+acc"  processeur_tb

add wave *
view structure
view signals
run -all
