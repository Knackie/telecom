library ieee;
use ieee.std_logic_1164.all;
entity additionneur4bits is
port(
	a,b : in std_logic_vector(3 downto 0);
	cin : in std_logic;
	s : out std_logic_vector(3 downto 0);
	cout : out std_logic);
end additionneur4bits;
--end;




architecture archConc of additionneur4bits is

component additionneur
port(
	a,b,cin : in std_logic;
	s,cout : out std_logic);
end component;

signal retenu : std_logic_vector(2 downto 0);

begin
	
add0 : additionneur
	port map (a => a(0), b => b(0),  cin => cin, s => s(0), cout => retenu(0)); 
add1 : additionneur
	port map (a => a(1), b => b(1),  cin => retenu(0), s => s(1), cout => retenu(1));
add2 : additionneur
	port map (a => a(2), b => b(2),  cin => retenu(1), s => s(2), cout => retenu(2));
add3 : additionneur
	port map (a => a(3), b => b(3),  cin => retenu(2), s => s(3), cout => cout); 
	
end archConc;