library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchCompteur is 
end;

architecture test of testbenchCompteur is 
	component Compteur8bits
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: inout std_logic_vector(7 downto 0)
	);
	end component;
  
signal clk: std_logic := '0';
signal reset: std_logic := '0';
signal preset: std_logic := '0';
signal d: std_logic_vector(7 downto 0) := (7 => '1', others => '0');
signal q: std_logic_vector(7 downto 0);

begin
	basculeMap: Compteur8bits port map (clk, reset, preset, d, q);
	
	clk<= not clk after 1 ns;
	reset <= not reset after 10 ns;
	preset <= not preset after 20 ns;
	process 
	begin
	
		wait for 400 ns;
	
		assert false report "Test terminé" severity failure;	
		
	end process;
	

end test;

