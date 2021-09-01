library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity Connecteur is

port(
	SW 	: in std_logic_vector(9 downto 0);
	LEDR 	: out std_logic_vector(3 downto 0)
	);
end;

architecture test of Connecteur is 
	component ALU
port(
	a,b 			: in std_logic_vector(3 downto 0);
	Selecteur 	: in std_logic_vector(1 downto 0);
	Sortie 		: out std_logic_vector(3 downto 0)
	);
	end component;


begin
	aluMap: ALU port map (a => SW(3 downto 0), b=> SW(7 downto 4), Selecteur => SW(9 downto 8), Sortie => LEDR(3 downto 0));
	

end test;

