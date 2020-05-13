library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

-- == Question 2 ==
-- Il faut 3 comparateurs et 15 multiplexeurs

-- == Question 3 ==
-- Ce système peut fonctionner à 295.33 MHz au maximum

entity tri3valV3 is
	generic (size: integer:=4);
	port(
		clock, reset: in std_logic;
		inA, inB, inC: in std_logic_vector(size-1 downto 0);
		Max, Min, Med: out std_logic_vector(size-1 downto 0)
	);
end tri3valV3;

architecture arch of tri3valV3 is
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
	signal sigMax, sigMed, sigMin, sigTmp : std_logic_vector(size-1 downto 0);
	signal AinfB, AinfC, BinfC : boolean;

	begin	
		reg_A: registre port map(clock, reset, inA, sigA);
		reg_B: registre port map(clock, reset, inB, sigB);
		reg_C: registre port map(clock, reset, inC, sigC);
		reg_Max: registre port map(clock, reset, sigMax, Max);
		reg_Med: registre port map(clock, reset, sigMed, Med);
		reg_Min: registre port map(clock, reset, sigMin, Min);
	
		process(sigA, sigB, sigC)
		begin
			
			AinfB <= sigA < sigB;
			AinfC <= sigA < sigC;
			BinfC <= sigB < sigC;
			
			-- Traitement A
			if(AinfB and AinfC) then
				sigMin <= sigA;
			elsif(not AinfB and not AinfC) then
				sigMax <= sigA;
			else
				sigMed <= sigA;
			end if;
			
			-- Traitement B
			if(not AinfB and BinfC) then
				sigMin <= sigB;
			elsif(AinfB and not BinfC) then
				sigMax <= sigB;
			else
				sigMed <= sigB;
			end if;
			
			-- Traitement C
			if(not AinfC and not BinfC) then
				sigMin <= sigC;
			elsif(AinfC and BinfC) then
				sigMax <= sigC;
			else
				sigMed <= sigC;
			end if;
			
	end process;
end arch;