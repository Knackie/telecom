library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
entity Vhdl1_tb is 

end;
	
	architecture AluExo_tb of Vhdl1_tb is
	component Vhdl1
	generic (N : integer:=8);
	port(
		a,b : in std_logic_vector(N-1 downto 0);
		operande : in std_logic_vector(2 downto 0);
		s : out std_logic_vector(N-1 downto 0);
		cout : out std_logic);
	end component;
	signal a_tb, b_tb : std_logic_vector (7 downto 0);
	signal s_tb : std_logic_vector(7 downto 0);
	signal cout_tb : std_logic;
	signal operande_tb : std_logic_vector(2 downto 0);
	
	--signal exo_add, exo_sub, exo_and, exo_or, exo_xor : boolean;
	begin
	test : Vhdl1 generic map(8) port map (a_tb,b_tb,operande_tb,s_tb,cout_tb);
	process 
	begin 
	a_tb <="00000000";
	b_tb <="00000000";
	operande_tb <= "000"; wait for 20 ns; 
	operande_tb <= "001"; wait for 20 ns; 
	operande_tb <= "010"; wait for 20 ns; 
	operande_tb <= "011"; wait for 20 ns; 
	operande_tb <= "100"; wait for 20 ns; 
	end process;
	
	
	process
		variable error_status : boolean;
	begin 
	wait on 	operande_tb;
	wait for 100 ns;
	if (
		(a_tb = "00000000" and b_tb = "00000000" and operande_tb = "000" and cout_tb = '0') or
		(a_tb = "00000000" and b_tb = "00000000" and operande_tb = "001" and cout_tb = '0') or
		(a_tb = "00000000" and b_tb = "00000000" and operande_tb = "010" and cout_tb = '0') or
		(a_tb = "00000000" and b_tb = "00000000" and operande_tb = "011" and cout_tb = '0') or
		(a_tb = "00000000" and b_tb = "00000000" and operande_tb = "100" and cout_tb = '0')
		)
		then 
		error_status := false;
		else
		error_status := true;
		end if;
		--rapport d'erreur
		assert not error_status
			report "test failed!"
			severity error;
			end process;
			end AluExo_tb;
	