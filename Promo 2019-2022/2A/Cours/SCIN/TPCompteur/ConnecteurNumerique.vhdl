library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ConnecteurNumerique is

port(
	KEY 	: in std_logic_vector(3 downto 0);
	HEX0, HEX1, HEX2, HEX3, HEX4, HEX5 	: out std_logic_vector(6 downto 0);
	LEDR 	: out std_logic_vector(9 downto 0);
	CLOCK_50 : in std_logic
	);
end;

architecture test of ConnecteurNumerique is 
	component CompteurDecompteur
port(
		clk: in std_logic;
		reset: in std_logic;
		preset : in std_logic;
		enable : in std_logic;
		d: in std_logic_vector(3 downto 0);
		q: inout std_logic_vector(3 downto 0);
		c: out std_logic
	);	end component;
	
	component Decodeur
port(
	entree 	: in std_logic_vector(3 downto 0);
	s		 	: out std_logic_vector(6 downto 0)
	);
	end component;

	--signal clk : std_logic := '0';
	signal a1, a2, a3, a4, a5, a6: std_logic_vector(3 downto 0);
	signal c1, c2, c3, c4, c5 : std_logic; 
	signal cycles: unsigned(23 downto 0);
	signal enable: std_logic := '0';
	
begin

	CDMap1: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), enable, "0010", a1, c1);
	CDMap2: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), c1, "0010", a2, c2);
	--CDMap3: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), c2, "0010", a3, c3);
	--CDMap4: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), c3, "0010", a4, c4);
	--CDMap5: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), c4, "0010", a5, c5);
	--CDMap6: CompteurDecompteur port map (CLOCK_50, not KEY(0), not KEY(1), c5, "0010", a6, LEDR(8));
	decMap1: Decodeur port map (a1, HEX0);
	decMap2: Decodeur port map (a2, HEX1);
	--decMap3: Decodeur port map (a3, HEX2);
	--decMap4: Decodeur port map (a4, HEX3);
	--decMap5: Decodeur port map (a5, HEX4);
	--decMap6: Decodeur port map (a6, HEX5);

	
	process(all)
	begin
	
		if rising_edge(CLOCK_50) then
		
			LEDR(3) <= c1;
			LEDR(4) <= c2;
			--LEDR(5) <= c3;
			--LEDR(6) <= c4;
			--LEDR(7) <= c5;
				
			if(KEY(2) and KEY(0) and KEY(1))then
				cycles <= to_unsigned(to_integer(cycles)+1, 24);
				if to_integer(cycles) = 5000000 then
					cycles <= to_unsigned(0, 24);
					enable <= '1';
				else
					enable <= '0';
				end if;
			end if;
		end if;
		
	end process;
	
end test;

