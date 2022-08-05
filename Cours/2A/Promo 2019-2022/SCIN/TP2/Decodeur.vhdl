library ieee;
use ieee.std_logic_1164.all;

entity Decodeur is
port(
	Entree: in std_logic_vector(1 downto 0);
	Sortie : out std_logic_vector(3 downto 0));
end Decodeur;

architecture ConcSelect of Decodeur is begin
process (Entree)
	begin
	case Entree is
		when "00" => Sortie <= "0001";
		when "01" => Sortie <= "0010";
		when "10" => Sortie <= "0100";
		when "11" => Sortie <= "1000";
	end case;
	end process;
end ConcSelect;