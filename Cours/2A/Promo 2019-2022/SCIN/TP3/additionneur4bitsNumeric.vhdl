library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity additionneur4bitsNumeric is
port(
	a,b : in std_logic_vector(3 downto 0);
	cin : in std_logic;
	s : out std_logic_vector(3 downto 0);
	cout : out std_logic);
end additionneur4bitsNumeric;
--end;




architecture archConc of additionneur4bitsNumeric is

	signal a_in, b_in, s_out : unsigned(4 downto 0);
	signal cin_nat : natural range 0 to 1;

begin
	
	cin_nat <= 1 when cin = '1' else 0;
	a_in <= '0' & unsigned(a);
	b_in <= '0' & unsigned(b);

	s_out <= a_in + b_in + cin_nat;
 
	s <= std_logic_vector(s_out(3 downto 0));
	cout <= s_out(4);


end archConc;