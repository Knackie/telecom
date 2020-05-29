library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;
entity compteur_modulo is
	generic (
		taille : integer := 4;
		modulo : integer := 10 
		);
	port(
		clk : in std_logic;
		load : in std_logic;
		reset : in std_logic;
		enable : in std_logic;
		preset : in std_logic_vector(taille-1 downto 0);
		dout : out std_logic_vector(taille-1 downto 0);
		TC : out std_logic
	);
end;
architecture behavior of compteur_modulo is begin
	clk_proc:process(clk)
	variable count:unsigned(taille-1 downto 0) := (others => '0');
	begin
		if rising_edge(clk) then
			if reset = '1' then
				count := (others=>'0');
			elsif load = '0' then
				TC <= '0';
				if enable = '1' then
					count := count + 1;
					if count = modulo then
						count := (others => '0');
						TC <= '1';
					end if;
				end if;
			else
				count := unsigned(preset);
			end if;
		end if;
		dout <= std_logic_vector(count);
	end process clk_proc;
end behavior;
