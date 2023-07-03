library ieee;
use ieee.std_logic_1164.all;

entity basculeDV3 is
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		d: in std_logic;
		q: out std_logic
	);
end basculeDV3;

architecture arch of basculeDV3 is
begin

	process(clk, reset, preset)
	begin
		if (reset='1') then
			q <='0';
		elsif (preset='1') then
			q <= '1';
		elsif (clk'event and clk='1' and enable = '1') then
			q <= d;
		end if;
	end process;

end arch;