## Generated SDC file "Projet.out.sdc"

## Copyright (C) 1991-2013 Altera Corporation
## Your use of Altera Corporation's design tools, logic functions 
## and other software and tools, and its AMPP partner logic 
## functions, and any output files from any of the foregoing 
## (including device programming or simulation files), and any 
## associated documentation or information are expressly subject 
## to the terms and conditions of the Altera Program License 
## Subscription Agreement, Altera MegaCore Function License 
## Agreement, or other applicable license agreement, including, 
## without limitation, that your use is for the sole purpose of 
## programming logic devices manufactured by Altera and sold by 
## Altera or its authorized distributors.  Please refer to the 
## applicable agreement for further details.


## VENDOR  "Altera"
## PROGRAM "Quartus II"
## VERSION "Version 13.0.1 Build 232 06/12/2013 Service Pack 1 SJ Web Edition"

## DATE    "Thu Mar 21 22:40:23 2019"

##
## DEVICE  "5CSEMA6F31C6"
##


#**************************************************************
# Time Information
#**************************************************************

set_time_format -unit ns -decimal_places 3



#**************************************************************
# Create Clock
#**************************************************************

create_clock -name {myclock} -period 2.000 -waveform { 0.000 1.000 } [get_ports {clock}]


#**************************************************************
# Create Generated Clock
#**************************************************************



#**************************************************************
# Set Clock Latency
#**************************************************************



#**************************************************************
# Set Clock Uncertainty
#**************************************************************

set_clock_uncertainty -rise_from [get_clocks {myclock}] -rise_to [get_clocks {myclock}] -setup 0.100  
set_clock_uncertainty -rise_from [get_clocks {myclock}] -rise_to [get_clocks {myclock}] -hold 0.060  
set_clock_uncertainty -rise_from [get_clocks {myclock}] -fall_to [get_clocks {myclock}] -setup 0.100  
set_clock_uncertainty -rise_from [get_clocks {myclock}] -fall_to [get_clocks {myclock}] -hold 0.060  
set_clock_uncertainty -fall_from [get_clocks {myclock}] -rise_to [get_clocks {myclock}] -setup 0.100  
set_clock_uncertainty -fall_from [get_clocks {myclock}] -rise_to [get_clocks {myclock}] -hold 0.060  
set_clock_uncertainty -fall_from [get_clocks {myclock}] -fall_to [get_clocks {myclock}] -setup 0.100  
set_clock_uncertainty -fall_from [get_clocks {myclock}] -fall_to [get_clocks {myclock}] -hold 0.060  


#**************************************************************
# Set Input Delay
#**************************************************************



#**************************************************************
# Set Output Delay
#**************************************************************



#**************************************************************
# Set Clock Groups
#**************************************************************



#**************************************************************
# Set False Path
#**************************************************************



#**************************************************************
# Set Multicycle Path
#**************************************************************



#**************************************************************
# Set Maximum Delay
#**************************************************************



#**************************************************************
# Set Minimum Delay
#**************************************************************



#**************************************************************
# Set Input Transition
#**************************************************************

