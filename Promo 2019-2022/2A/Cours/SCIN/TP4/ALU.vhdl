library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ALU is
port(
	a,b : in std_logic_vector(7 downto 0);
	mode : in std_logic_vector(2 downto 0);
	res : out std_logic_vector(7 downto 0));
end ALU;
--end;


architecture archAlu of ALU is

component ADD
port(
	a,b,cin : in std_logic;
	s,cout : out std_logic);
end component;

component SUB
port(
	a,b,cin : in std_logic;
	s,cout : out std_logic);
end component;


begin
process (mode) begin
	

	
end process;
end archAlu;