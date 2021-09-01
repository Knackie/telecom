library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;

entity CompteurDecompteur is
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		d: in std_logic_vector(3 downto 0);
		q: inout std_logic_vector(3 downto 0);
		c: out std_logic
	);
end CompteurDecompteur;

architecture arch of CompteurDecompteur is

	signal res : unsigned(3 downto 0);

begin

	process(clk,reset,preset,enable)
	begin
		if (rising_edge(clk)) then
		
			if(preset='1') then
				q <= d;
			elsif (reset='1') then
				q <= (others => '0');
			elsif (enable = '1') then
				res <= unsigned(q) + 1;
				
				if(res = "1010") then
					q <= "0000";
					c <= '1';
				else
					q <= std_logic_vector(res);
					c <= '0';
				end if;
			end if;	
		
		end if;
	
	end process;

end arch;