library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity Compteur is
	port(
		clk: in std_logic;
		jump_PC: in std_logic;
		inc_PC : in std_logic;
		IR: in std_logic_vector(6 downto 0);
		Ad_ROM: inout std_logic_vector(6 downto 0)
	);
end Compteur;

architecture arch of Compteur is
begin

	process(clk, jump_PC, inc_PC)
	begin
		if (clk'event and clk='1') then
		
			if(inc_PC='1') then
				Ad_ROM <= std_logic_vector(unsigned(Ad_ROM) + 1);
			elsif (jump_PC='1') then
				Ad_ROM <= IR;
			else
				Ad_ROM <= Ad_ROM;
			end if;	
		
		end if;
	
	end process;

end arch;