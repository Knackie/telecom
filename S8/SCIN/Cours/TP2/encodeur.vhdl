library ieee;
use ieee.std_logic_1164.all;
entity Encodeur is 
port(
     Entree : in std_logic_vector(2 downto 0);
     Sortie : out std_logic_vector(1 downto 0));
end Encodeur;

architecture ProCase of Encodeur is
   begin 
	with Entree select
		Sortie <= "11" when "1--",  
			"10" when "01-",
	      "01" when "001",
	      "00" when others;  
end ProCase;

