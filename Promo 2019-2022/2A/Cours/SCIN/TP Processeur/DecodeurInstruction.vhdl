library ieee;
use ieee.std_logic_1164.all;

entity DecodeurInstruction is 
port(
	clk			: in std_logic;
   IR				: in  std_logic_vector(7 downto 0);
   C, Z		 	: in  std_logic;
   jump_PC, inc_PC, ld_IR, ld_IR_lsn, Swrite, en_Accu	: out std_logic;
	AOP			: out std_logic_vector(2 downto 0));
end DecodeurInstruction;

architecture arch of DecodeurInstruction is 

	
	-- Build an enumerated type for the state machine
	type state_type is (Fetch, Decode, Execute);

	-- Register to hold the current state
	signal state : state_type;

begin
	
process (clk)
begin

	if (rising_edge(clk)) then

		-- Determine the next state synchronously, based on
		-- the current state and the input
		case state is
			when Fetch=>
				state <= Decode;
			when Decode=>
				state <= Execute;
			when Execute=>
				state <= Fetch;
		end case;

	end if;
end process;
	

process (state)
begin
	
	if (clk'event and clk='1') then
	
	
		jump_PC <= '0';
		ld_IR_lsn <= '0';
		Swrite <= '0';
		AOP <= "000";
		inc_PC <= '0';
		ld_IR <= '0';
		en_Accu <= '0';
		
		if state = Fetch then
			ld_IR <= '1';
			inc_PC <= '1';
		elsif state = Decode then
			if IR(7 downto 4) = "0100" 
				or IR(7 downto 4) = "0101" 
				or IR(7 downto 4) = "0110" 
				or IR(7 downto 4) = "0111" then
				ld_IR_lsn <= '1';
			end if;
		elsif state = Execute then	
			if IR(7) = '1' then
				jump_PC <= '1';
			elsif IR(6 downto 4) = "100" then --load Rd
				ld_IR_lsn <= '1';
			elsif IR(6 downto 4) = "001" then --load #d
				ld_IR <= '1';
			elsif IR(6 downto 4) = "011" then --store Rd
				Swrite <= '1';
			elsif IR(6 downto 4) = "101" then --ADD Rd
				ld_IR_lsn <= '1';
				AOP <= "010";
				en_Accu <= '1';
			elsif IR(6 downto 4) = "010" then --ADD #d
				AOP <= "010";
				en_Accu <= '1';
			elsif IR(6 downto 4) = "110" then --XOR Rd
				ld_IR_lsn <= '1';
				AOP <= "011";
				en_Accu <= '1';
			elsif IR(6 downto 4) = "111" then --test Rd
				ld_IR_lsn <= '1';
				AOP <= "100";
				en_Accu <= '1';
			elsif IR(6 downto 4) = "000" then
				if IR(1 downto 0) = "00" then --clear_c
					AOP <= "110";
					en_Accu <= '1';
				elsif IR(1 downto 0) = "01" then --set_c
					AOP <= "101";
					en_Accu <= '1';
				elsif IR(1 downto 0) = "10" and C = '1'then --skip_c
					inc_PC <= '1';
				elsif IR(1 downto 0) = "11" and Z = '1' then --skip_z
					inc_PC <= '1';
				end if;
			end if;
		end if;
	end if;
		
		
end process;
end arch;
