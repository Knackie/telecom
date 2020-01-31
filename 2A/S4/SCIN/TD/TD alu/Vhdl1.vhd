library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
entity Vhdl1 is 
generic (N : integer:=8);
port(
	a,b : in std_logic_vector(N-1 downto 0);
	operande : in std_logic_vector(2 downto 0);
	s : out std_logic_vector(N-1 downto 0);
	cout : out std_logic);
	end;
	
	architecture AluExo of Vhdl1 is
	signal res : std_logic_vector(N downto 0);
	begin
	with operande select res <=
	std_logic_vector(unsigned('0' & a)+unsigned('0' & b)) when "000",
	std_logic_vector(unsigned('0' & a)-unsigned('0' & b)) when "001",
	'0' & a and '0' & b when "010",
	'0' & a or '0' & b when "011",
	'0' & a xor '0' & b when "100",
	 (others => '0') when others;
	s <= res(N-1 downto 0);
	cout <= res(N);
	end AluExo;