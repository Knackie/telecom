library ieee;
use ieee.std_logic_1164.all;
entity Multiplexeur is 
port(
     IN0,IN1,IN2,IN3, IN4: in  std_logic_vector(7 downto 0);
     Selecteur      : in  std_logic_vector(2 downto 0);
     Sortie         : out std_logic_vector(7 downto 0));
end Multiplexeur;

architecture ConcSelect of Multiplexeur is begin
process (Selecteur)
	begin
	if Selecteur = "001" then
		Sortie <= IN1;
	elsif Selecteur = "010" then
		Sortie <= IN2;
	elsif Selecteur = "011" then
		Sortie <= IN3;
	elsif Selecteur = "100" then
		Sortie <= IN4;
	else Sortie <= IN0;
	end if;
	end process;
end ConcSelect;
