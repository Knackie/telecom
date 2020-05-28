library ieee;
use ieee.std_logic_1164.all;
entity Processeur_tb is

end Processeur_tb;
architecture tb of Processeur_tb is
	component Processeur is
	port(
		clk : in std_logic
	);
	end component;
	signal inclk : std_logic :='0';
begin
	mapping: Processeur port map(inclk);
	inclk <= not inclk after 1 ns;
		
end tb;
