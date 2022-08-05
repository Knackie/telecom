library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity ALUR_tb is 
end;

architecture test of ALUR_tb is 
	component ALUR
	generic(
		size : integer := 5
	);
	port(
		a,b : in std_logic_vector(size-1 downto 0);
		Selecteur : in std_logic_vector(2 downto 0);
		Sortie : out std_logic_vector(size-1 downto 0);
		cout : out std_logic);
	end component;
  
signal a_in, b_in : integer range 0 to 31;
signal s_in : integer range 1 to 5;
signal s_out : std_logic_vector(4 downto 0);
signal c_out : std_logic;

begin
	aluMap: ALUR generic map(size => 5) port map (a => std_logic_vector(to_unsigned(a_in, 5)), b => std_logic_vector(to_unsigned(b_in, 5)), Selecteur => std_logic_vector(to_unsigned(s_in, 3)), Sortie => s_out, cout => c_out);

	
	process 
	begin
	
		wait for 1ns;
	
		if(a_in = 31) then
			a_in <= 0;
			if(b_in = 31) then
				b_in <= 0;
				if(s_in = 5) then
					s_in <= 1;
				else
					s_in <= s_in + 1;
				end if;
			else
				b_in <= b_in + 1;
			end if;
		else
			a_in <= a_in + 1;
		end if;
	
	end process;
	

end test;

