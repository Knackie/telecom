library ieee;
use ieee.std_logic_1164.all;
entity Multiplexeur2 is port(
	IN0,IN1,IN2,IN3: 	in std_logic_vector(7 downto 0);
	Selecteur : 		in std_logic_vector(1 downto 0);
	Sortie : 			out std_logic_vector(7 downto 0));
end Multiplexeur2;
	architecture ArchIf of Multiplexeur2 is begin
		process(Selecteur,IN0,IN1,IN2,IN3)
		--process(all) -VHDL 2008
		begin
			if Selecteur = "00" then
				Sortie <= IN0;
			elsif Selecteur = "01" then
				Sortie <= IN1;
			elsif Selecteur = "10" then
				Sortie <= IN2;
			elsif Selecteur = "11" then
				Sortie <= IN3;
			else
				Sortie <= (others => '0');
			end if;
		end process;
	end ArchIf;