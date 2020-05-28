library ieee;
use ieee.std_logic_1164.all;
entity DecodeurInstructionetatLogic is
	port(
			c,z : in std_logic;
			entree_8 : in std_logic_vector(7 downto 0);
			etat : in std_logic_vector(1 downto 0);
			etat_suivant : out std_logic_vector(1 downto 0)
	);
end DecodeurInstructionetatLogic;
architecture arch of DecodeurInstructionetatLogic is
	
begin 
	process(etat) begin
		if etat = "00" then
			etat_suivant <="01";
		elsif etat = "01" then
			etat_suivant <= "10";
		else 
			etat_suivant <="00";
		end if;
	end process;
  
end arch;