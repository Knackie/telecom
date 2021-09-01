library ieee;
use ieee.std_logic_1164.all;

entity Registre is 
port(
	clk			: in std_logic;
   D1, D2		: in  std_logic_vector(3 downto 0);
   ld_IR_lsn, ld_IR : in  std_logic;
   IR1, IR2   	: out std_logic_vector(3 downto 0));
end Registre;

architecture ConcSelect of Registre is begin
process (clk)
begin
		
	if (clk'event and clk='1') then
		if ld_IR = '1' then
			IR1 <= D1;
			IR2 <= D2;
		elsif ld_IR_lsn = '1' then
			IR2 <= D2;
		end if;
	end if;
	
		
end process;
end ConcSelect;
