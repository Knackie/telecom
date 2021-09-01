library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchV1 is 
end;

architecture test of testbenchV1 is 
	component basculeDV1
	port(
		clk: in std_logic;
		reset: in std_logic;
		d: in std_logic;
		q: out std_logic
	);
	end component;
  
signal clk: std_logic;
signal reset: std_logic;
signal d: std_logic;
signal q: std_logic;
signal tmp : unsigned(2 downto 0) := "000";

begin
	basculeMap: basculeDV1 port map (clk => clk, reset => reset, d => d, q => q);
	
	process 
	begin
	
		wait for 1ns;
	
		clk <= tmp(0);
		reset <= tmp(2);
		d <= tmp(1);
	
		if(tmp = "111") then
			tmp <= "000";
		else
			tmp <=  tmp + 1;
		end if;
		
	end process;
	

end test;

