library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity CompteurSynchrone is
	port(
		clk	: in std_logic;
		raz	: in std_logic;
		Valid : in std_logic;
		q		: inout std_logic_vector(26 downto 0);
		Qn, Qnk : out std_logic
	);
end CompteurSynchrone;

architecture arch of CompteurSynchrone is
begin

	process(clk,raz)
	begin
		if (clk'event and clk='1') then
		
			if (raz='1') then
				q <= (others => '0');
			else
				q <= std_logic_vector(unsigned(q) + 1);
			end if;	
			
			Qn <= q(26);
			Qnk <= q(21);
		
		end if;
	
	end process;

end arch;