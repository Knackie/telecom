library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity tri3valV3_tb is
end tri3valV3_tb;

architecture arch of tri3valV3_tb is
	component tri3valV3 is
		generic (size: integer:=4);
		port(
			clock, reset: in std_logic;
			inA, inB, inC: in std_logic_vector(size-1 downto 0);
			Max, Min, Med: out std_logic_vector(size-1 downto 0)
		);
	end component;
	constant size : integer := 4;
	signal clk, reset : std_logic := '0';
	signal sigA, sigB, sigC : std_logic_vector(size-1 downto 0);
	signal sigMax, sigMed, sigMin : std_logic_vector(size-1 downto 0);

	begin	
		mapping: tri3valV3 port map(clk, reset, sigA, sigB, sigC, sigMax, sigMin, sigMed);
		clk <= not clk after 10ns;
		
		process
		begin
		
			-- Test A-B-C
			sigA <= "0000";
			sigB <= "0001";
			sigC <= "0010";
			wait for 100ns;
			
			-- Test A-C-B
			sigA <= "0001";
			sigB <= "1011";
			sigC <= "0110";
			wait for 100ns;
			
			-- Test B-A-C
			sigA <= "0100";
			sigB <= "0001";
			sigC <= "1010";
			wait for 100ns;
			
			-- Test B-C-A
			sigA <= "0010";
			sigB <= "0001";
			sigC <= "1110";
			wait for 100ns;
			
			-- Test C-A-B
			sigA <= "0011";
			sigB <= "0111";
			sigC <= "0000";
			wait for 100ns;
			
			-- Test C-B-A
			sigA <= "1111";
			sigB <= "0001";
			sigC <= "0000";
			wait for 100ns;
			
		end process;
		
		
end arch;