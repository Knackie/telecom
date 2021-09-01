library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity CompteurBCD is
	port(
		clk: in std_logic;
		raz: in std_logic;
		Ena : in std_logic;
		q: inout std_logic_vector(3 downto 0);
		cout: out std_logic
	);
end CompteurBCD;

architecture arch of CompteurBCD is

	signal res : unsigned(3 downto 0);

begin

	process(clk,raz,Ena)
	begin
		if (rising_edge(clk)) then

			if (raz='1') then
				q <= (others => '0');
			elsif (Ena = '1') then
				res <= unsigned(q) + 1;
				
				if(res = "1010") then
					q <= "0000";
					Cout <= '1';
				else
					q <= std_logic_vector(res);
					Cout <= '0';
				end if;
			end if;	
		
		end if;
	
	end process;

end arch;