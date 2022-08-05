library ieee;
use ieee.std_logic_1164.all;
entity DecodeurInstruction is
	port(
			c,z : in std_logic;
			clk : in std_logic;
			ir : in std_logic_vector(7 downto 0);
			jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_ALU : out std_logic;
			aop : out std_logic_vector(2 downto 0)
	);
end DecodeurInstruction;
architecture arch of DecodeurInstruction is
	component DecodeurInstructionStateLogic is
		port(
				c,z : in std_logic;
				ir : in std_logic_vector(7 downto 0);
				etat : in std_logic_vector(1 downto 0);
				etat_suivant : out std_logic_vector(1 downto 0)
		);
	end component;
	component DecodeurInstructionOutputLogic is
		port(
			c,z : in std_logic;
			ir : in std_logic_vector(7 downto 0);
			etat : in std_logic_vector(1 downto 0);
			jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_alu : out std_logic;
			aop : out std_logic_vector(2 downto 0)
	);
	end component;
	component registre is
		generic(N: integer:=8);
		port(
				d: in std_logic_vector(N-1 downto 0);
				reset, clk : in std_logic;
				s : out std_logic_vector(N-1 downto 0)
		);
	end component;
	signal etat_suivant, etat : std_logic_vector(1 downto 0);
begin
	stateLogic : DecodeurInstructionStateLogic port map(c,z,ir, etat, etat_suivant);
	outputLogic : DecodeurInstructionOutputLogic port map(c,z,ir, etat, jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_ALU ,aop);
	stateReg : registre generic map (2) port map(d => etat_suivant, reset => '0', clk => clk, s => etat);
end arch;