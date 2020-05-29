library ieee;
use ieee.std_logic_1164.all;
entity registre2_4bits is
	port(
		d_faible, d_fort : in std_logic_vector(3 downto 0);
		clk, ld_ir_lsn, ld_ir : in std_logic;
		ir_faible, ir_fort : out std_logic_vector(3 downto 0)
	);
end registre2_4bits;
architecture arch of registre2_4bits is
	component registre is
		generic(N: integer:=8);
		port(
				d: in std_logic_vector(N-1 downto 0);
				reset, clk, enable : in std_logic;
				s : out std_logic_vector(N-1 downto 0)
		);
	end component;
	signal tmp : std_logic;
begin 
	tmp <= ld_ir_lsn or ld_ir;
	regFort : registre
		generic map(
			N =>4
			
		)
		port map(
			d => d_fort,
			reset => '0',
			clk => clk,
			s => ir_fort,
			enable => ld_ir
			);
	regFaible : registre
		generic map(
			N =>4
		)
		port map(
			d => d_faible,
			reset => '0',
			clk => clk,
			s => ir_faible,
			enable => tmp
		);
end arch;