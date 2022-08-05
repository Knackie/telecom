library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity comparateur is
port(
	a,b : in std_logic_vector(8 downto 0);
	inf, sup, egal : out std_logic);
end comparateur;
--end;




architecture archConc of comparateur is
begin
process (all) begin
	
	inf <= '0';
	sup <= '0';
	egal <= '0';
	
	if (unsigned(a) < unsigned(b)) then
		inf <= '1'; 
	elsif (unsigned(a) = unsigned(b)) then
		egal <= '1';
	elsif (unsigned(a) > unsigned(b)) then
		sup <= '1';
	end if;
	
end process;
end archConc;