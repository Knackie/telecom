-- Quartus Prime VHDL Template
-- Single-port RAM with single read/write address and initial contents	

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity RAM is

	generic 
	(
		DATA_WIDTH : natural := 4;
		ADDR_WIDTH : natural := 4
	);

	port 
	(
		clk	: in std_logic;
		Ad		: in unsigned((ADDR_WIDTH-1) downto 0);
		D		: in std_logic_vector((DATA_WIDTH-1) downto 0);
		we		: in std_logic := '1';
		q		: out std_logic_vector((DATA_WIDTH -1) downto 0)
	);

end RAM;

architecture rtl of RAM is

	-- Build a 2-D array type for the RAM
	subtype word_t is std_logic_vector((DATA_WIDTH-1) downto 0);
	type memory_t is array(2**ADDR_WIDTH-1 downto 0) of word_t;

	function init_ram
		return memory_t is 
		variable tmp : memory_t := (others => (others => '0'));
	begin 
		for Ad_pos in 0 to 2**ADDR_WIDTH - 1 loop 
			-- Initialize each address with the address itself
			tmp(Ad_pos) := std_logic_vector(to_unsigned(Ad_pos, DATA_WIDTH));
		end loop;
		return tmp;
	end init_ram;	 

	-- Declare the RAM signal and specify a default value.	Quartus Prime
	-- will create a memory initialization file (.mif) based on the 
	-- default value.
	signal ram : memory_t := init_ram;

	-- Register to hold the address 
	signal Ad_reg : natural range 0 to 2**ADDR_WIDTH-1;

begin

	process(clk)
	begin
	--if(rising_edge(clk)) then
		if(we = '1') then
			ram(to_integer(Ad)) <= D;
		end if;

		-- Register the address for reading
		Ad_reg <= to_integer(Ad);
	--end if;
	end process;

	q <= ram(Ad_reg);

end rtl;
