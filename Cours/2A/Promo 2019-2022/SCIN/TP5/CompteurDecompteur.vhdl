library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity CompteurDecompteur is
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		sens : in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: inout std_logic_vector(7 downto 0)
	);
end CompteurDecompteur;

architecture arch of CompteurDecompteur is
begin

	process(clk,reset,preset)
	begin
		if (clk'event and clk='1') then
		
		
			if(preset='1') then
				q <= d;
			elsif (reset='1') then
				q <= (others => '0');
			elsif (enable = '1') then
				if(sens = '1') then
					q <= std_logic_vector(unsigned(q) + 1);
				else
					q <= std_logic_vector(unsigned(q) - 1);
				end if;
			end if;	
		
		end if;
	
	end process;

end arch;