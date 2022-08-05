library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;
entity compteur is
generic (TAILLE : integer := 8 );
port(
	din   : in  std_logic_vector(TAILLE-1 downto 0);
	clk   : in  std_logic;
	load  : in  std_logic;
	reset : in  std_logic;
	dout  : out std_logic_vector(TAILLE-1 downto 0));
end;
architecture behavior of compteur is begin
clk_proc:process(clk)
variable count:unsigned(TAILLE-1 downto 0) := (others=> ’0’);
begin
	if rising_edge(clk) then
		if reset = ’1’ then
			count := (others => ’0’);
		elsif load = ’1’ thencount := unsigned(din);
		else count := count + 1;
		end if;
	end if;
	dout <= std_logic_vector(count);
	end process clk_proc;
end behavior;