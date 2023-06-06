library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchBD8bits is 
end;

architecture test of testbenchBD8bits is 
	component basculeD8bits
	port(
		clk: in std_logic;
		reset: in std_logic;
		d: in std_logic_vector(7 downto 0);
		q: out std_logic_vector(7 downto 0)
	);
	end component;
  
signal clk: std_logic := '0';
signal reset: std_logic := '0';
signal d: unsigned(7 downto 0) := (others => '0');
signal q: std_logic_vector(7 downto 0);
signal k : integer := 0;
signal maxVal : unsigned(7 downto 0) := (others => '1');

begin
	basculeMap: basculeD8bits port map (clk, reset, std_logic_vector(d), q);
	
	clk<= not clk after 2 ns;
	reset <= not reset after 10 ns;
	process 
	begin
	
		wait for 4 ns;
	
		if(d = maxVal) then
			if k < 3 then
				k <= k + 1;
				d <= (others => '0');
			else
				assert false report "Test terminé" severity failure;	
			end if;
		else
			d <=  d + 1;
		end if;
		
	end process;
	

end test;

