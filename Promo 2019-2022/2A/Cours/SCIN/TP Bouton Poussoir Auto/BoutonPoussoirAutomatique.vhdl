library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity BoutonPoussoirAutomatique is

port(
	KEY 	: in std_logic_vector(3 downto 0);
	HEX0, HEX1	: out std_logic_vector(6 downto 0);
	CLOCK_50 : in std_logic
	);
end;


architecture test of BoutonPoussoirAutomatique is 
	component CompteurBCD
	port(
		clk: in std_logic;
		raz: in std_logic;
		Ena : in std_logic;
		q: inout std_logic_vector(3 downto 0);
		cout: out std_logic
	);	
	end component;
	
	component DecodeurBCD
	port(
		entree 	: in std_logic_vector(3 downto 0);
		s 			: out std_logic_vector(6 downto 0)
	);
	end component;
	
	component Synchroniseur
	port(
		clk: in std_logic;
		D: in std_logic;
		Q: out std_logic
	);
	end component;
	
	component Multiplexeur
	port(
		  IN0,IN1	: in  std_logic;
		  Selecteur	: in  std_logic;
		  Sortie    : out std_logic
	);
	end component;
	
	component MachineB
	port(
		clk	: in	std_logic;
		E		: in	std_logic;
		raz 	: in	std_logic;
		S		: out	std_logic
	);
	end component;
	
	component CompteurSynchrone
	port(
		clk	: in std_logic;
		raz	: in std_logic;
		Valid : in std_logic;
		q		: inout std_logic_vector(26 downto 0);
		Qn, Qnk : out std_logic
	);
	end component;
	
	component MachineA
	port(
		clk		 	: in	std_logic;
		I, T, raz	: in	std_logic;
		L, D, V, F 	: out	std_logic
	);
	end component;
	

	--signal clk : std_logic := '0';
	signal Di, Un: std_logic_vector(3 downto 0);
	signal c1, c2 : std_logic; 
	signal cycles: unsigned(23 downto 0);
	signal enable: std_logic := '0';
	
	signal sIs : std_logic;
	signal L, D, V, F, T, E, S, Sortie : std_logic;
	signal q : std_logic_vector(26 downto 0);
	
begin

	--KEY 0 comptage, KEY 1 raz
	SynMap : Synchroniseur port map (CLOCK_50, not KEY(0), sIs);
	
	--Machine A (clk, I, T, raz, L, D, V, F)
	MAMap : MachineA port map (CLOCK_50, sIs, T, not KEY(1), L, D, V, F);

	--Compteur Synchrone (clk, raz, Valid, q, Qn, Qnk)
	CSMap : CompteurSynchrone port map (CLOCK_50, (not KEY(1) or F), D, q, T, E);
	
	--Machine B
	MBMap : MachineB port map (CLOCK_50, E, not KEY(1), S);
	
	--Multiplexeur
	MultiMap : Multiplexeur port map (L, S, V, Sortie);
	
	
	CDMap1: CompteurBCD port map (CLOCK_50, not KEY(0), enable, Un, c1);
	CDMap2: CompteurBCD port map (CLOCK_50, not KEY(0), (c1 and Sortie), Di, c2);

	decMap1: DecodeurBCD port map (Un, HEX0);
	decMap2: DecodeurBCD port map (Di, HEX1);


end test;

