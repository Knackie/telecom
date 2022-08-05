library ieee;
use ieee.std_logic_1164.all;
entity Multiplexeur is 
port(
     IN0,IN1	: in  std_logic;
     Selecteur	: in  std_logic;
     Sortie    : out std_logic);
end Multiplexeur;

architecture ConcSelect of Multiplexeur is begin
process (Selecteur)
	begin
	if Selecteur = '1' then
		Sortie <= IN1;
	else 
		Sortie <= IN0;
	end if;
	end process;
end ConcSelect;
