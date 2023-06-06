library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity testbenchV3 is 
end;

architecture test of testbenchV3 is 
	component basculeDV3
	port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		d: in std_logic;
		q: out std_logic
	);
	end component;
  
signal clk: std_logic;
signal d: std_logic;
signal q: std_logic;
signal enable :std_logic;
signal tmp : unsigned(2 downto 0) := "000";
signal k : integer := 0;

begin
	basculeMap: basculeDV3 port map (clk => clk, reset => '0', preset => '0', enable => enable, d => d, q => q);
	
	process 
	begin
	
		wait for 1ns;
	
		clk <= tmp(0);
		enable <= tmp(2);
		d <= tmp(1);
	
		if(tmp = "111") then
			if k < 3 then
				k <= k + 1;
				tmp <= "000";
			else
				assert false report "Test terminé" severity failure;	
			end if;
		else
			tmp <=  tmp + 1;
		end if;
		
	end process;
	

end test;

