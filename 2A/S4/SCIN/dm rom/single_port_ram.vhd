library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity single_port_ram is
	generic(
		DATA_WIDTH : natural := 4;
		ADDR_WIDTH : natural := 4
	);
	port(
		clk		: in std_logic;
		addr	: in std_logic_vector((ADDR_WIDTH-1) downto 0);
		data	: in std_logic_vector((DATA_WIDTH-1) downto 0);
		we		: in std_logic := '1';
		q		: out std_logic_vector((DATA_WIDTH -1) downto 0)
	);

end single_port_ram;

architecture rtl of single_port_ram is
	subtype word_t is std_logic_vector((DATA_WIDTH-1) downto 0);
	type memory_t is array(2**ADDR_WIDTH-1 downto 0) of word_t;
	function init_ram
		return memory_t is 
		variable tmp : memory_t := (others => (others => '0'));
	begin 
		tmp(0):= x"F";
		tmp(1):= x"8";
		tmp(2):= x"2";
		tmp(3):= x"7";
		tmp(4):= x"0";
		tmp(5):= x"0";
		tmp(6):= x"0";
		tmp(7):= x"0";
		return tmp;
	end init_ram;	 	
	signal ram : memory_t := init_ram;
	signal addr_reg : natural range 0 to 2**ADDR_WIDTH-1;

begin
	process(clk)
	begin
	if(rising_edge(clk)) then
		if(we = '1') then
			ram(to_integer(unsigned(addr))) <= data;
		end if;	
	end if;
	end process;

	q <= ram(to_integer(unsigned(addr)));

end rtl;
