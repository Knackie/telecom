library ieee;
use ieee.std_logic_1164.all;
entity Multiplexeur is 
port(
     IN0,IN1	: in  std_logic_vector(3 downto 0);
     ld_IR_lsn : in  std_logic;
     Sortie    : out std_logic_vector(3 downto 0));
end Multiplexeur;

architecture ConcSelect of Multiplexeur is begin
process (ld_IR_lsn)
	begin

	if ld_IR_lsn = '1' then
		Sortie <= IN1;
	else Sortie <= IN0;
	end if;
	
	end process;
end ConcSelect;
