library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
entity single_port_rom is
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
end entity;
architecture rtl of single_port_rom is
	subtype word_t is std_logic_vector((DATA_WIDTH-1) downto 0);
	
	type memory_t is array(2**ADDR_WIDTH-1 downto 0) of word_t;
	
	function init_rom
		return memory_t is
		variable tmp : memory_t := (others => (others => '0'));
		begin
		tmp(0):= x"00"; 
		tmp(1):= x"40"; 
		tmp(2):= x"52"; 
		tmp(3):= x"34"; 
		tmp(4):= x"41"; 
		tmp(5):= x"53"; 
		tmp(6):= x"35"; 
		tmp(7):= x"87"; 
		return tmp;
	end init_rom;
	signal rom : memory_t := init_rom;
	begin
	
	q <= rom(to_integer(unsigned(addr)));
end rtl;