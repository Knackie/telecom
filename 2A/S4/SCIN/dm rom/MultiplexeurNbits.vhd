library ieee;
use ieee.std_logic_1164.all;
entity MultiplexeurNbits is
	generic(
		TAILLE: natural := 8
	);
	port(
		IN0,IN1: in std_logic_vector(TAILLE-1 downto 0);
		Selecteur : in std_logic;
		Sortie : out std_logic_vector(TAILLE-1 downto 0)
	);
end MultiplexeurNbits;
architecture ArchIf of MultiplexeurNbits is begin

	process (Selecteur, IN0, IN1) begin
		if Selecteur = '0' then
			Sortie <= IN0;
		else
			Sortie <= IN1;
		end if;
	end process;

end ArchIf;