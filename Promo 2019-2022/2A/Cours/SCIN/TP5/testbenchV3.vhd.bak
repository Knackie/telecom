library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchV2 is 
end;

architecture test of testbenchV2 is 
	component basculeDV2
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		d: in std_logic;
		q: out std_logic
	);
	end component;
  
signal clk: std_logic;
signal reset: std_logic;
signal preset : std_logic;
signal d: std_logic;
signal q: std_logic;
signal tmp : unsigned(3 downto 0) := "0000";

begin
	basculeMap: basculeDV2 port map (clk => clk, reset => reset, preset => preset, d => d, q => q);
	
	process 
	begin
	
		wait for 1ns;
	
		clk <= tmp(0);
		reset <= tmp(2);
		d <= tmp(1);
		preset <= tmp(3);
	
		if(tmp = "1111") then
			tmp <= "0000";
		else
			tmp <=  tmp + 1;
		end if;
		
	end process;
	

end test;

