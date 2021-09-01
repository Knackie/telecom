-- Quartus Prime VHDL Template
-- Four-State Moore State Machine

-- A Moore machine's outputs are dependent only on the current state.
-- The output is written only when the state changes.  (State
-- transitions are synchronous.)

library ieee;
use ieee.std_logic_1164.all;

entity Moore is

	port(
		clk		: in	std_logic;
		strobe	: in	std_logic;
		reset	 	: in	std_logic;
		p1			: out	std_logic
	);

end entity;

architecture rtl of Moore is

	-- Build an enumerated type for the state machine
	type state_type is (zero, edge, one);

	-- Register to hold the current state
	signal state   : state_type;

begin

	-- Logic to advance to the next state
	process (clk, reset)
	begin
		if reset = '1' then
			state <= zero;
		elsif (rising_edge(clk)) then
			case state is
				when zero=>
					if strobe = '1' then
						state <= edge;
					else
						state <= zero;
					end if;
				when edge=>
					if strobe = '1' then
						state <= one;
					else
						state <= zero;
					end if;
				when one=>
					if strobe = '1' then
						state <= one;
					else
						state <= zero;
					end if;
			end case;
		end if;
	end process;

	-- Output depends solely on the current state
	process (state)
	begin
		case state is
			when edge =>
				p1 <= '1';
			when others =>
				p1 <= '0';
		end case;
	end process;

end rtl;

