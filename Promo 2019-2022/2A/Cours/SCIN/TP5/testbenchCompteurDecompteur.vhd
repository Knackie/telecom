library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchCompteurDecompteur is 
end;

architecture test of testbenchCompteurDecompteur is 
	component CompteurDecompteur
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		sens : in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: inout std_logic_vector(7 downto 0)
	);
	end component;
  
signal clk: std_logic := '0';
signal reset: std_logic := '0';
signal preset: std_logic := '0';
signal enable: std_logic := '0';
signal sens: std_logic := '0';
signal d: std_logic_vector(7 downto 0) := (7 => '1', others => '0');
signal q: std_logic_vector(7 downto 0) := (others => '0');

begin
	basculeMap: CompteurDecompteur port map (clk, reset, preset, enable, sens, d, q);
	
	clk<= not clk after 1 ns;
	reset <= not reset after 10 ns;
	preset <= not preset after 20 ns;
	enable <= not enable after 100 ns;
	sens <= not sens after 200 ns;
	
	process 
	begin
	
		wait for 400 ns;
	
		assert false report "Test terminé" severity failure;	
		
	end process;
	

end test;

