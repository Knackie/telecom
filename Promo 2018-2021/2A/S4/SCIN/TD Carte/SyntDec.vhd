library ieee;
use ieee.std_logic_1164.all;
entity SyntDec is
	port(
			inA : in std_logic_vector(3 downto 0);
			outS  : out std_logic_vector(6 downto 0)
	);
end SyntDec;
architecture arch of SyntDec is
--passage de l'entité PorteXor au testbench comme
	

begin 
	process (inA) begin
		if inA = "0000" then
		   outs <= "1000000";
		elsif inA = "0001" then
			outs <= "1111001";
		elsif inA = "0010" then
			outs <= "0100100";
		elsif inA = "0011" then
			outs <= "0110000";
		elsif inA = "0100" then
			outs <= "0011001";
		elsif inA = "0101" then
			outs <= "0010010";
		elsif inA = "0110" then
			outs <= "0000010";
		elsif inA = "0111" then
			outs <= "1111000";
		elsif inA = "1000" then
			outs <= "0000000";
		elsif inA = "1001" then
			outs <= "0010000";
		else
			outs <= "1111111";
		end if;
	end process;
end arch;