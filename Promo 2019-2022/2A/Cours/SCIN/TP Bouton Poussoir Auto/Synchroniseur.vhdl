library ieee;
use ieee.std_logic_1164.all;

entity Synchroniseur is
	port(
		clk: in std_logic;
		D: in std_logic;
		Q: out std_logic
	);
end Synchroniseur;

architecture arch of Synchroniseur is
begin

	process(clk)
	begin
		if (clk'event and clk='1') then
			Q <= D;
		end if;
	end process;

end arch;