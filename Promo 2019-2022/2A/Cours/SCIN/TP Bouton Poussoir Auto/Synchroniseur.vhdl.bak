library ieee;
use ieee.std_logic_1164.all;

entity basculeDV1 is
	port(
		clk: in std_logic;
		reset: in std_logic;
		d: in std_logic;
		q: out std_logic
	);
end basculeDV1;

architecture arch of basculeDV1 is
begin

	process(clk,reset)
	begin
		if (reset='1') then
			q <='0';
		elsif (clk'event and clk='1') then
			q <= d;
		end if;
	end process;

end arch;