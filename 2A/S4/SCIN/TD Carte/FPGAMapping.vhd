library ieee;
use ieee.std_logic_1164.all;
entity FPGAMapping is
	port(
			SW : in std_logic_vector(9 downto 0);
			HEX0 : out std_logic_vector(6 downto 0);
			HEX2 : out std_logic_vector(6 downto 0);
			HEX3 : out std_logic_vector(6 downto 0);
			HEX5 : out std_logic_vector(6 downto 0);
			LEDR : out std_logic_vector(9 downto 0)
	);
end FPGAMapping;
architecture arch of FPGAMapping is
--passage de l'entité PorteXor au testbench comme
	component ALU is
		generic(N: integer:=4);
	port(
			inA, inB : in std_logic_vector(N-1 downto 0);
			inCin : in std_logic;
			consigne : in std_logic_vector(2 downto 0);
			outS  : out std_logic_vector(N-1 downto 0);
			outC : out std_logic
	);
	end component;
	
	component SyntHex is
		port(
				inA : in std_logic_vector(3 downto 0);
				outS  : out std_logic_vector(6 downto 0)
		);
	end component;
	
	signal resultat : std_logic_vector(3 downto 0);
	signal retenue : std_logic_vector(3 downto 0) := (others => '0');
	
begin 
	mapping : ALU generic map(4) port map(SW(7 downto 4),SW(3 downto 0),'0',(0 => SW(9), 1 => SW(8),2 => '0'),resultat, retenue(0));
	
	
	
	droite : SyntHex port map(SW(3 downto 0),HEX0);

	gauche : SyntHex port map(SW(7 downto 4),HEX5);
	
	milieu1  : SyntHex port map(resultat,HEX2);
	milieu2 : SyntHex port map(retenue,HEX3);
	
end arch;