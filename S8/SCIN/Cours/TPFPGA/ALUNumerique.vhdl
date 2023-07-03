library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
use ieee.std_logic_unsigned.all;

entity ALUNumerique is
port(
	a,b 			: in std_logic_vector(3 downto 0);
	Selecteur 	: in std_logic_vector(1 downto 0);
	s1, s2 		: out std_logic_vector(6 downto 0)
	);
end ALUNumerique;
--end;


architecture archAlu of ALUNumerique is

component Decodeur
port(
	entree 	: in std_logic_vector(3 downto 0);
	s1, s2 	: out std_logic_vector(6 downto 0)
	);
	end component;

	signal res : std_logic_vector(4 downto 0);
	signal Sortie : std_logic_vector(3 downto 0);
	

begin

	
	decMap: Decodeur port map (Sortie, s1, s2);

process (all) begin



	if Selecteur = "11" then
		res <= ('0' & a) + ('0' & b);
		Sortie <= res(3 downto 0);
	elsif Selecteur = "00" then
		Sortie <= a AND b;
	elsif Selecteur = "01" then
		Sortie <= a OR b;
	else Sortie <= a XOR b;
	end if;
	
end process;
end archAlu;