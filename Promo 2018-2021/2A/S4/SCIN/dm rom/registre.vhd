library ieee;
use ieee.std_logic_1164.all;
entity registre is
	generic(n: integer:=8);
	port(
			d: in std_logic_vector(n-1 downto 0);
			reset, clk : in std_logic;
			enable : in std_logic :='1';
			s : out std_logic_vector(n-1 downto 0)
	);
end registre;
architecture arch of registre is
	component bascule is
		port(
			clk: in std_logic;
			enable: in std_logic;
			reset: in std_logic;
			preset: in std_logic;
			d: in std_logic;
			q: out std_logic
		);
	end component;
begin 
	gen : for i in 0 to n-1 generate
      u: bascule port map(clk,enable,reset,'0',d(i),s(i));
	end generate gen;
  
end arch;