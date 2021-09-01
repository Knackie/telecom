library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity Processeur is
end;


architecture test of Processeur is 
	
	--Multiplexeur
	component Multiplexeur
	port(
     IN0,IN1	: in  std_logic_vector(3 downto 0);
     ld_IR_lsn : in  std_logic;
     Sortie    : out std_logic_vector(3 downto 0));
	end component;
	
	--Compteur
	component Compteur
	port(
		clk: in std_logic;
		jump_PC: in std_logic;
		inc_PC : in std_logic;
		IR: in std_logic_vector(6 downto 0);
		Ad_ROM: inout std_logic_vector(6 downto 0)
	);
	end component;
	
	--RAM 
	component RAM
	generic 
	(
		DATA_WIDTH : natural := 4;
		ADDR_WIDTH : natural := 4
	);
	port (
		clk	: in std_logic;
		Ad		: in unsigned((ADDR_WIDTH-1) downto 0);
		D		: in std_logic_vector((DATA_WIDTH-1) downto 0);
		we		: in std_logic := '1';
		q		: out std_logic_vector((DATA_WIDTH -1) downto 0)
	);
	end component;
	
	--ROM
	component ROM
	generic 
	(
		DATA_WIDTH : natural := 8;
		ADDR_WIDTH : natural := 7
	);
	port 
	(
		clk	: in std_logic;
		Ad		: in unsigned((ADDR_WIDTH-1) downto 0);
		Data	: out std_logic_vector((DATA_WIDTH -1) downto 0)
	);
	end component;
	
	--Decodeur
	component DecodeurInstruction
	port(
		clk			: in std_logic;
		IR				: in  std_logic_vector(7 downto 0);
		C, Z		 	: in  std_logic;
		jump_PC, inc_PC, ld_IR, ld_IR_lsn, Swrite, en_Accu	: out std_logic;
		AOP			: out std_logic_vector(2 downto 0));
	end component;
	
	--Registre
	component Registre
	port(
		clk			: in std_logic;
		D1, D2		: in  std_logic_vector(3 downto 0);
		ld_IR_lsn, ld_IR : in  std_logic;
		IR1, IR2   	: out std_logic_vector(3 downto 0));
	end component;
	
	--ALU
	component ALU
	generic(
		size : integer := 4
	);
	port(
		Op1,Op2 : in std_logic_vector(size-1 downto 0);
		AOP : in std_logic_vector(2 downto 0);
		clk, en_ACCU : in std_logic;
		ACCU : out std_logic_vector(size-1 downto 0);
		C, Z : out std_logic);
	end component;
	
	
	--Liste des signaux
	signal D, SRom, IR	:  std_logic_vector(7 downto 0);
	signal Ad_Rom :  std_logic_vector(6 downto 0);
	signal C, Z	: std_logic;
	signal jump_PC, inc_PC, ld_IR, ld_IR_lsn, Swrite, en_Accu	: std_logic;
	signal AOP : std_logic_vector(2 downto 0);
	signal Op1, Op2, ACCU, SRam :  std_logic_vector(3 downto 0);
	signal clk : std_logic := '0';
	
begin

	--clk, IR, C, Z, jump_PC, inc_PC, ld_IR, ld_IR_lsn, Swrite, en_Accu, AOP
	DecMap : DecodeurInstruction port map (clk, IR, C, Z, jump_PC, inc_PC, ld_IR, ld_IR_lsn, Swrite, en_Accu, AOP);
	
	--Op1, Op2, AOP, clk, en_ACCU, ACCU, C, Z
	AluMap : ALU port map (Op1, Op2, AOP, clk, en_ACCU, ACCU, C, Z);
	
	--clk, Ad, D, we, q
	RAMMap : RAM port map (clk, unsigned(IR(3 downto 0)), ACCU, Swrite, SRam);
	
	--clk, Ad, Data
	ROMMap : ROM port map (clk, unsigned(Ad_Rom), SRom);
	
	--clk, D1, D2, ld_IR_lsn, ld_IR, IR1, IR2
	RegMap : Registre port map (clk, D(7 downto 4), D(3 downto 0), ld_IR_lsn, ld_IR,  IR(7 downto 4), IR(3 downto 0));
	
	--IN0, IN1, ld_IR_lsn, Sortie
	MulMap : Multiplexeur port map (SRom(3 downto 0), SRam, ld_IR_lsn, D(3 downto 0));
	
	--clk, jump_pc, inc_pc, IR, Ad_Rom
	ComMap : Compteur port map (clk, jump_pc, inc_pc, IR(6 downto 0), Ad_Rom);	
	
	clk<= not clk after 2 ns;

end test;

