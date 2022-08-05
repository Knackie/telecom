library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity Compteur8bits is
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: inout std_logic_vector(7 downto 0)
	);
end Compteur8bits;

architecture arch of Compteur8bits is
begin

	process(clk,reset,preset)
	begin
		if (clk'event and clk='1') then
		
		
			if(preset='1') then
				q <= d;
			elsif (reset='1') then
				q <= (others => '0');
			else
				q <= std_logic_vector(unsigned(q) + 1);
			end if;	
		
		end if;
	
	end process;

end arch;