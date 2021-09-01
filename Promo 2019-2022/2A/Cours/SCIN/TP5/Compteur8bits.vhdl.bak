library ieee;
use ieee.std_logic_1164.all;

entity basculeD8bits is
	port(
		clk: in std_logic;
		reset: in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: out std_logic_vector(7 downto 0)
	);
end basculeD8bits;

architecture arch of basculeD8bits is
begin

	process(clk,reset)
	begin
		if (reset='1') then
			q <="00000000";
		elsif (clk'event and clk='1') then
			q <= d;
		end if;
	end process;

end arch;