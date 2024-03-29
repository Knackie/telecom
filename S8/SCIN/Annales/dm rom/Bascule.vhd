library ieee;
use ieee.std_logic_1164.all;
entity Bascule is
	port(
		clk: in std_logic;
		enable: in std_logic;
		reset: in std_logic;
		preset: in std_logic;
		d: in std_logic;
		q: out std_logic
	);
end Bascule;
architecture arch of Bascule	 is
	begin
	process(clk,reset,d,enable,preset)
	begin
	if reset='1' then
		if enable='1' then
			q <= '0';
		end if;
	elsif preset='1' then
		q<= '1';
	elsif (enable = '1' and (clk'event and clk='1')) then
		q <= d;
	end if;
	end process;
end arch;