library ieee;
use ieee.std_logic_1164.all;
entity Multiplexeur is 
port(
     IN0,IN1,IN2,IN3: in  std_logic_vector(7 downto 0);
     Selecteur      : in  std_logic_vector(1 downto 0);
     Sortie         : out std_logic_vector(7 downto 0));
end Multiplexeur;

architecture ConcSelect of Multiplexeur is 
begin
with Selecteur select
Sortie <= IN0 when "00", 
	  IN1 when "01",	
	  IN2 when "10", 
	  IN3 when "11", 
	  IN0 when others;
end ConcSelect;
