library ieee;
use ieee.std_logic_1164.all;
entity registre is
	generic (size : integer := 8);
	port(
		clk: in std_logic;
		d: in std_logic_vector(size-1 downto 0);
		reset: in std_logic;
		q: out std_logic_vector(size-1 downto 0)
	);
end registre;

architecture arch of registre is
	begin
		process(clk, reset)
		begin
			if (reset='1') then
				-- Reset asynchrone
				q <= (others => '0');
			elsif (clk'event and clk='1') then
				q <= d;
			end if;
	end process;
end arch;