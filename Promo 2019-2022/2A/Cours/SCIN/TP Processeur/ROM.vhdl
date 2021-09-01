-- Quartus Prime VHDL Template
-- Single-Port ROM

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ROM is

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

end entity;

architecture rtl of ROM is

	-- Build a 2-D array type for the ROM
	subtype word_t is std_logic_vector((DATA_WIDTH-1) downto 0);
	type memory_t is array(2**ADDR_WIDTH-1 downto 0) of word_t;

	function init_rom
		return memory_t is 
		variable tmp : memory_t := (others => (others => '0'));
	begin 
		for Ad_pos in 0 to 2**ADDR_WIDTH - 1 loop 
			-- Initialize each Adess with the Adess itself
			tmp(Ad_pos) := std_logic_vector(to_unsigned(Ad_pos, DATA_WIDTH));
		end loop;
		return tmp;
	end init_rom;	 

	-- Declare the ROM signal and specify a default value.	Quartus Prime
	-- will create a memory initialization file (.mif) based on the 
	-- default value.
	signal rom : memory_t := init_rom;

begin

	process(clk)
	begin
	--if(rising_edge(clk)) then
		Data <= rom(to_integer(Ad));
	--end if;
	end process;

end rtl;
