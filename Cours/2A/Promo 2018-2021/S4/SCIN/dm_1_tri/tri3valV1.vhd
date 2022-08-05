library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

-- == Question 2 ==
-- Il faut 11 comparateurs et 11 multiplexeurs

-- == Question 3 ==
-- Ce système peut fonctionner à 176.65 MHz au maximum

entity tri3valV1 is
	generic (size: integer:=4);
	port(
		clock, reset: in std_logic;
		inA, inB, inC: in std_logic_vector(size-1 downto 0);
		Max, Min, Med: out std_logic_vector(size-1 downto 0)
	);
end tri3valV1;

architecture arch of tri3valV1 is
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
	signal sigMax, sigMed, sigMin : std_logic_vector(size-1 downto 0);

	begin	
		reg_A: registre port map(clock, reset, inA, sigA);
		reg_B: registre port map(clock, reset, inB, sigB);
		reg_C: registre port map(clock, reset, inC, sigC);
		reg_Max: registre port map(clock, reset, sigMax, Max);
		reg_Med: registre port map(clock, reset, sigMed, Med);
		reg_Min: registre port map(clock, reset, sigMin, Min);
	
		process(sigA, sigB, sigC)
		begin
			-- Sortie MAX
			if(sigA > sigB)then
				if(sigA > sigC) then
					sigMax <= sigA;
				else
					sigMax <= sigC;
				end if;
			else
				if(sigB > sigC) then
					sigMax <= sigB;
				else
					sigMax <= sigC;
				end if;
			end if;
			
			-- Sortie MIN
			if(sigA < sigB)then
				if(sigA < sigC) then
					sigMin <= sigA;
				else
					sigMin <= sigC;
				end if;
			else
				if(sigB < sigC) then
					sigMin <= sigB;
				else
					sigMin <= sigC;
				end if;
			end if;
			
			-- Sortie MED
			if(sigA > sigB)then
				if(sigA < sigC) then
					sigMed <= sigA;
				else
					if(sigB > sigC) then
						sigMed <= sigB;
					else
						sigMed <= sigC;
					end if;
				end if;
			else
				if(sigA > sigC) then
					sigMed <= sigA;
				else
					if(sigB > sigC) then
						sigMed <= sigC;
					else
						sigMed <= sigB;
					end if;
				end if;
			end if;
	end process;
end arch;