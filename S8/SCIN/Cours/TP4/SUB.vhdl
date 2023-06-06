library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity SUB is
port(
a,b : in std_logic_vector(7 downto 0);
cin : in std_logic;
s : out std_logic_vector(7 downto 0);
cout : out std_logic);
end;

architecture archSUB of SUB is

	signal s_int : unsigned (8 downto 0);
	signal cin_vector: std_logic_vector (0 downto 0);

begin
	
	cin_vector(0) <= cin;
	s_int <= unsigned('0' & a) + unsigned(not('0' & b)) + unsigned("00000000" & cin_vector);
	--s_int <= resize(unsigned(a),5) + resize(unsigned(b),5) + resize(unsigned(cin_vector),5);
	s <= std_logic_vector(s_int(7 downto 0));
	cout <= s_int(8);

end archSUB;