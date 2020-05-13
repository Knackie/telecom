library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

-- == Question 2 ==
-- Il faut 3 comparateurs et 42 multiplexeurs

-- == Question 3 ==
-- Ce système peut fonctionner à 197.98 MHz au maximum

entity tri3valV2 is
	generic (size: integer:=4);
	port(
		clock, reset: in std_logic;
		inA, inB, inC: in std_logic_vector(size-1 downto 0);
		Max, Min, Med: out std_logic_vector(size-1 downto 0)
	);
end tri3valV2;

architecture arch of tri3valV2 is
	component registre is
		generic (size: integer := 4);
		port(
			clk: in std_logic;
			reset: in std_logic;
			d: in std_logic_vector(size-1 downto 0);
			q: out std_logic_vector(size-1 downto 0)
		);
	end component;
	signal sigA, sigB, sigC : std_logic_vector(size-1 downto 0);
	signal sigMax, sigMed, sigMin, maxAB, minAB : std_logic_vector(size-1 downto 0);

	begin	
		reg_A: registre port map(clock, reset, inA, sigA);
		reg_B: registre port map(clock, reset, inB, sigB);
		reg_C: registre port map(clock, reset, inC, sigC);
		reg_Max: registre port map(clock, reset, sigMax, Max);
		reg_Med: registre port map(clock, reset, sigMed, Med);
		reg_Min: registre port map(clock, reset, sigMin, Min);
	
		process(sigA, sigB, sigC)
		begin
			-- MAX(A,B) / MIN(A,B)
			if(sigA > sigB)then
				maxAB <= sigA;
				minAB <= sigB;
			else
				maxAB <= sigB;
				minAB <= sigA;
			end if;
			
			-- Sorties
			if(minAB > sigC)then
				sigMax <= maxAB;
				sigMin <= sigC;
				sigMed <= minAB;
			elsif (sigMax < sigC) then
				sigMax <= sigC;
				sigMin <= minAB;
				sigMed <= maxAB;
			else
				sigMax <= minAB;
				sigMax <= maxAB;
				sigMed <= sigC;
			end if;
	end process;
end arch;