library ieee;
use ieee.std_logic_1164.all;
use IEEE.numeric_std.all;
entity Processeur is
	port(
		clk : in std_logic
	);
end Processeur;
architecture arch of Processeur is
	component MultiplexeurNbits is
	generic(
		taille: natural := 8
	);
	port(
		IN0,IN1: in std_logic_vector(taille-1 downto 0);
		Selecteur : in std_logic;
		Sortie : out std_logic_vector(taille-1 downto 0)
	);
	end component;
	
	component single_port_rom is
		generic
		(
			DATA_WIDTH : natural := 8;
			ADDR_WIDTH : natural := 8
		);
		port
		(
			clk : in std_logic;
			addr : in std_logic_vector((ADDR_WIDTH -1) downto 0);
			q : out std_logic_vector((DATA_WIDTH -1) downto 0)
		);
	end  component;
	
	component compteur_modulo is
		generic (
		taille : integer := 4;
		modulo : integer := 10 
		);
	port(
		clk : in std_logic;
		load : in std_logic;
		reset : in std_logic;
		enable : in std_logic;
		preset : in std_logic_vector(taille-1 downto 0);
		dout : out std_logic_vector(taille-1 downto 0);
		TC : out std_logic
	);
	end component;
	
	component alu4bitWith3bitOp is
generic(N: integer:=4);
port(
    op1, op2 : in std_logic_vector(N-1 downto 0);
    en_alu : in std_logic;
    operator : in std_logic_vector(2 downto 0);
    c, z : out std_logic;
    AccU : out std_logic_vector(N-1 downto 0)
);
end component;
	
	component Registre is
	generic(n: integer:=8);
	port(
			d: in std_logic_vector(n-1 downto 0);
			reset, clk : in std_logic;
			enable : in std_logic :='1';
			s : out std_logic_vector(n-1 downto 0)
	);
	end component;
	
	component single_port_ram is

		generic 
		(
			DATA_WIDTH : natural := 8;
			ADDR_WIDTH : natural := 6
		);

		port 
		(
			clk		: in std_logic;
			addr	: in std_logic_vector((ADDR_WIDTH-1) downto 0);
			data	: in std_logic_vector((DATA_WIDTH-1) downto 0);
			we		: in std_logic := '1';
			q		: out std_logic_vector((DATA_WIDTH -1) downto 0)
		);

	end component;
	
	component registre2_4bits is
		port(
		d_faible, d_fort : in std_logic_vector(3 downto 0);
		clk, ld_ir_lsn, ld_ir : in std_logic;
		ir_faible, ir_fort : out std_logic_vector(3 downto 0)
		);
	end component;
	
	component DecodeurInstruction is
		port(
			c,z : in std_logic;
			clk : in std_logic;
			ir : in std_logic_vector(7 downto 0);
			jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_ALU : out std_logic;
			aop : out std_logic_vector(2 downto 0)
	);
	end component;
		
	signal jump_pc,inc_pc,ld_ir,ld_ir_lsn,writ,en_ALU,C,Cb,Z,Zb,enableC,enableACCU,enableZ : std_logic;
	signal AOP : std_logic_vector(2 downto 0);
	signal Ram, ACCU,ACCUb, Mout : std_logic_vector(3 downto 0);
	signal ad_Rom : std_logic_vector(6 downto 0);
	signal Rom  : std_logic_vector(7 downto 0);
	signal IR : std_logic_vector(7 downto 0) := (others =>'0');
	signal int_ad_Rom, int_ir_3_0 : integer;
begin 
	enableC <= '1' when en_ALU = '1' and ((AOP = "101" or AOP = "110") or AOP = "010" ) else '0';
	enableZ <= '1' when en_ALU = '1' and AOP = "100" else '0';
	enableACCU <= '1' when en_ALU = '1' and not ((AOP = "101" or AOP = "110") or AOP = "100")  else '0';
	int_ad_Rom <= to_integer(unsigned(ad_Rom));
	int_ir_3_0 <= to_integer(unsigned(IR(3 downto 0)));
	compteur_binaire : compteur_modulo
		generic map (
			taille =>7,
			modulo =>128
			)
		port map(
			clk => clk,
			load => jump_pc,
			reset => '0',
			enable => inc_PC,
			preset => IR(6 downto 0),
			dout =>ad_Rom
		);
		
	romData : single_port_rom
		generic map(
			DATA_WIDTH => 8,
			ADDR_WIDTH => 7
		)
		port map(
			clk => clk,
			addr => ad_Rom,
			q => Rom
		);
		
	multiRomRam : MultiplexeurNbits
		generic map(
			taille =>4
		)
		port map(
			IN0 => Rom(3 downto 0),
			IN1 => Ram,
			Selecteur => ld_ir_lsn,
			Sortie => Mout
		);

	Alui : alu4bitWith3bitOp
		generic map(
			N => 4
			)
		port map(
				op1 => IR(3 downto 0), 
				op2 => ACCU,
				en_alu =>  '0',
				operator => AOP,
				AccU  => ACCUb,
				c => Cb,
				z => Zb
		);
		
	regC : Registre
		generic map(
			N =>1
		)
		port map(
			d(0) => Cb,
			reset => '0',
			clk => clk,
			enable => enableC,
			s(0) => C
		);
	
	regZ : Registre
		generic map(
			N =>1
		)
		port map(
			d(0) => Zb,
			reset => '0',
			clk => clk,
			enable => enableZ,
			s(0) => Z
		);
		
	regACCU : Registre
		generic map(
			N =>4
		)
		port map(
			d => ACCUb,
			reset => '0',
			clk => clk,
			enable => enableACCU,
			s => ACCU
		);
	RamData : single_port_ram
		generic map(
			DATA_WIDTH => 4,
			ADDR_WIDTH => 4
		)
		port map(
			clk => clk,
			addr => IR(3 downto 0),
			data => ACCU,
			we	=> writ,
			q => Ram
		);
	registreInst : registre2_4bits
		port map(
			d_faible => Mout, 
			d_fort => Rom(7 downto 4),
			clk => clk, 
			ld_ir_lsn => ld_IR_lsn, 
			ld_ir => ld_IR,
			ir_faible => IR(3 downto 0),
			ir_fort => IR(7 downto 4)
		);
	decodeur : DecodeurInstruction 
		port map(
			C => C,
			Z => Z,
			clk => clk,
			ir =>IR,
			jump_pc => jump_pc,
			inc_pc => inc_pc,
			ld_ir => ld_ir,
			ld_ir_lsn => ld_ir_lsn,
			writ => writ,
			en_ALU => en_ALU,
			AOP => AOP
		);
		
	
end arch;