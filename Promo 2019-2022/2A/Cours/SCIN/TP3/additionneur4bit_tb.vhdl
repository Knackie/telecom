library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity additionneur4bit_tb is 
end;

architecture test of additionneur4bit_tb is 
component additionneur4bit
port(
     a,b      : in  std_logic_vector(3 downto 0);
     cin      : in  std_logic;
     s        : out std_logic_vector(3 downto 0);
     cout     : out std_logic);
end component;
  
signal a_in, b_in, s_out : std_logic_vector(3 downto 0);
signal c_in, c_out : std_logic;

begin
	uut: additionneur4bit port map (a => a_in, b => b_in, cin => c_in ,s => s_out, cout => c_out);
   process
      --variable pour stimuler les entrées
      variable cntA,cntB : integer := 0;
   begin
	-- mettre en commentaire pour vérifier le fonctionnement de l'assert dans les boucles:
	c_in <= '0';
	
	-- test de toutes les combinaisons possibles
 	for cntA in 1 to 15 loop
	a_in <= std_logic_vector(to_unsigned(cntA,4));
		for cntB in 1 to 15 loop
		b_in <= std_logic_vector(to_unsigned(cntB,4));
		wait for 1 ns;
		assert ((c_out & s_out)=std_logic_vector(to_unsigned(cntA+cntB,5))) report "erreur de calcul:  A=" & integer'IMAGE(cntA) & "B=" & integer'IMAGE(cntB) & "S=" & integer'IMAGE(to_integer(unsigned(c_out & s_out))) severity failure;
		end loop;
	end loop;
	
	-- test avec une retenue d'entrée
	c_in <= '1';
	a_in <= "0001";
	b_in <= "0011";
	wait for 1 ns;
	assert ((c_out & s_out)="00101") report "erreur avec c_in!" severity failure; 
	assert false report "simulation termin�e"severity failure;
   end process;

end test;

