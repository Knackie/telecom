library ieee;
use ieee.std_logic_1164.all;
entity DecodeurInstructionOutputLogic is
	port(
			c,z : in std_logic;
			ir : in std_logic_vector(7 downto 0);
			etat : in std_logic_vector(1 downto 0);
			jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_alu : out std_logic;
			aop : out std_logic_vector(2 downto 0)
	);
end DecodeurInstructionOutputLogic;
architecture arch of DecodeurInstructionOutputLogic is
begin 
	process(etat,ir,c,z) begin
		jump_pc <='0';	
		inc_pc <='0';
		ld_ir <='0';
		ld_ir_lsn <='0';
		writ <='0';
		en_alu <='0';
		aop <= "000";
		if etat = "00" then
			inc_pc<='1';
			ld_ir<='1';
			
		elsif etat = "01" then		
			if ir(7 downto 4) = "0100" then
				ld_ir_lsn <= '1';
			elsif ir(7 downto 4) = "0101" then
				ld_ir_lsn <= '1';
			elsif ir(7 downto 4) = "0110" then
				ld_ir_lsn <= '1';
			elsif ir(7 downto 4) = "0111" then
				ld_ir_lsn <= '1';
			end if;
		else 
			if ir(7 downto 4) = "0100" then
				en_alu <='1';
				aop<="001";
			elsif ir(7 downto 4) = "0001" then
				en_alu <='1';
				aop<="001";
			elsif ir(7 downto 4) = "0011" then
				writ<='1';
			elsif ir(7 downto 4) = "0101" then
				en_alu <='1';
				aop<="010";
			elsif ir(7 downto 4) = "0010" then
				en_alu <='1';
				aop<="010";
			elsif ir(7 downto 4) = "0110" then
				en_alu <='1';
				aop<="011";
			elsif ir(7 downto 4) = "0111" then
				en_alu<='1';
				aop <="100";
			elsif ir = "00000000" then
				en_alu <='1';
				aop <= "110";
			elsif ir = "00000001" then
				en_alu <='1';
				aop <= "101";
			elsif ir = "00000010" then
				inc_pc <= c;
			elsif ir = "00000011" then
				inc_pc <= z;
			elsif ir(7 downto 7) = "1" then
				jump_pc <='1';
			end if;
		end if;
	end process;
end arch;