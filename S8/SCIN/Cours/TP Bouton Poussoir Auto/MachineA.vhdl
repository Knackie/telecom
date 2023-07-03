-- Quartus Prime VHDL Template
-- Four-State Moore State Machine

-- A Moore machine's outputs are dependent only on the current state.
-- The output is written only when the state changes.  (State
-- transitions are synchronous.)

library ieee;
use ieee.std_logic_1164.all;

entity MachineA is

	port(
		clk		 	: in	std_logic;
		I, T, raz	: in	std_logic;
		L, D, V, F 	: out	std_logic
	);

end entity;

architecture rtl of MachineA is

	-- Build an enumerated type for the state machine
	type state_type is (sA, sB, sC, sD, sE);

	-- Register to hold the current state
	signal state   : state_type;

begin

	-- Logic to advance to the next state
	process (clk, raz)
	begin
		if raz = '1' then
			state <= sA;
		elsif (rising_edge(clk)) then
			case state is
				when sA=>
					if I = '1' then
						state <= sB;
					else
						state <= sA;
					end if;
				when sB=>
					state <= sC;
				when sC=>
					if I = '1' and T = '0' then
						state <= sC;
					elsif I = '1' and T = '1' then
						state <= sE;
					else
						state <= sD;
					end if;
				when sD =>
						state <= sA;
				when sE =>
					if I = '1' then
						state <= sE;
					else
						state <= sD;
					end if;
			end case;
		end if;
	end process;

	-- Output depends solely on the current state
	process (state)
	begin
		case state is
			when sA =>
				L <= '0';
				D <= '0';
				V <= '0';
				F <= '0';
			when sB =>
				L <= '1';
				D <= '1';
				V <= '0';
				F <= '0';
			when sC =>
				L <= '0';
				D <= '1';
				V <= '0';
				F <= '0';
			when sD =>
				L <= '0';
				D <= '0';
				V <= '0';
				F <= '1';
			when sE =>
				L <= '0';
				D <= '1';
				V <= '1';
				F <= '0';
		end case;
	end process;

end rtl;
