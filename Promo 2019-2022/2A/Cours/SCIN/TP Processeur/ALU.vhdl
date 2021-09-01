library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
use ieee.std_logic_unsigned.all;

entity ALU is
generic(
	size : integer := 4
);
port(
	Op1,Op2 : in std_logic_vector(size-1 downto 0);
	AOP : in std_logic_vector(2 downto 0);
	clk, en_ACCU : in std_logic;
	ACCU : out std_logic_vector(size-1 downto 0);
	C, Z : out std_logic);
end ALU;
--end;


architecture archAlur of ALU is

	signal res : std_logic_vector(size downto 0);


begin
process (clk) begin

	if (clk'event and clk='1') then
		C <= '0';
		Z <= '0';
		if en_ACCU = '1' then
			
			if AOP = "001" then
				ACCU <= Op1;
			elsif AOP = "010" then
				res <= ('0' & Op1) + ('0' & Op2);
				ACCU <= res(size-1 downto 0);
				C <= res(size);
			elsif AOP = "011" then
				ACCU <= Op1 XOR Op2;
			elsif AOP = "100" then
				ACCU <= Op1 AND Op2;
			elsif AOP = "101" then
				C <= '1';
			else C <= '0';
			end if;
		end if;
	end if;
	
end process;
end archAlur;