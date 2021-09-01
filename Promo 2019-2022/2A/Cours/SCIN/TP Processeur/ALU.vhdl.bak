library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
use ieee.std_logic_unsigned.all;

entity ALUR is
generic(
	size : integer := 4
);
port(
	a,b : in std_logic_vector(size-1 downto 0);
	Selecteur : in std_logic_vector(2 downto 0);
	Sortie : out std_logic_vector(size-1 downto 0);
	cout : out std_logic);
end ALUR;
--end;


architecture archAlur of ALUR is

	signal res : std_logic_vector(size downto 0);


begin
process (all) begin

	cout <= '0';
	if Selecteur = "001" then
		res <= ('0' & a) + ('0' & b);
		Sortie <= res(size-1 downto 0);
		cout <= res(size);
	elsif Selecteur = "010" then
		res <= ('0' & a) - b;
		Sortie <= res(size-1 downto 0);
		cout <= res(size);
	elsif Selecteur = "011" then
		Sortie <= a AND b;
	elsif Selecteur = "100" then
		Sortie <= a OR b;
	else Sortie <= a XOR b;
	end if;
	
end process;
end archAlur;