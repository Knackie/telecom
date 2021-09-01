-- Quartus Prime VHDL Template
-- Four-State Mealy State Machine

-- A Mealy machine has p2s that depend on both the state and
-- the strobes.	When the strobes change, the p2s are updated
-- immediately, without waiting for a clock edge.  The p2s
-- can be written more than once per state or per clock cycle.

library ieee;
use ieee.std_logic_1164.all;

entity Mealy is

	port
	(
		clk		 : in	std_logic;
		strobe	 : in	std_logic;
		reset	 : in	std_logic;
		p2	 : out	std_logic
	);

end entity;

architecture rtl of Mealy is

	-- Build an enumerated type for the state machine
	type state_type is (zero, one);

	-- Register to hold the current state
	signal state : state_type;

begin

	process (clk, reset)
	begin

		if reset = '1' then
			state <= zero;

		elsif (rising_edge(clk)) then

			-- Determine the next state synchronously, based on
			-- the current state and the strobe
			case state is
				when zero=>
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

	-- Determine the p2 based only on the current state
	-- and the strobe (do not wait for a clock edge).
	process (state, strobe)
	begin
			case state is
				when zero=>
					if strobe = '1' and reset = '0' then
						p2 <= '1';
					else
						p2 <= '0';
					end if;
				when one=>
					p2 <= '0';
			end case;
	end process;

end rtl;
