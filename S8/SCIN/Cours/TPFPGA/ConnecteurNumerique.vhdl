library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ConnecteurNumerique is

port(
	SW 	: in std_logic_vector(9 downto 0);
	HEX0, HEX1, HEX2, HEX3, HEX4, HEX5 	: out std_logic_vector(6 downto 0)
	);
end;

architecture test of ConnecteurNumerique is 
	component ALUNumerique
port(
	a,b 			: in std_logic_vector(3 downto 0);
	Selecteur 	: in std_logic_vector(1 downto 0);
	s1, s2 		: out std_logic_vector(6 downto 0)
	);
	end component;
	
	component Decodeur
port(
	entree 	: in std_logic_vector(3 downto 0);
	s1, s2 	: out std_logic_vector(6 downto 0)
	);
	end component;


begin
	aluMap: ALUNumerique port map (a => SW(3 downto 0), b=> SW(7 downto 4), Selecteur => SW(9 downto 8), s1 => HEX1, s2 => HEX0 );
	decMap1: Decodeur port map (SW(3 downto 0), HEX3, HEX2);
	decMap2: Decodeur port map (SW(7 downto 4), HEX5, HEX4);

end test;

