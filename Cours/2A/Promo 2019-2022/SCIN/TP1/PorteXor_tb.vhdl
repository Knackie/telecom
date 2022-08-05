library ieee;
use ieee.std_logic_1164.all;

entity PorteXor_tb is
end PorteXor_tb;

architecture tb of PorteXor_tb is
   --passage de l'entité PorteXor au testbench comme composant
   component PorteXor is	
   port( A, B : in std_logic;
            S : out std_logic);
   end component;

   signal  inA, inB, outS : std_logic;
begin
   --relier les signaux du testbench aux ports de PorteXor
   mapping: PorteXor port map(inA, inB, outS);

   process
      --variable pour les erreurs
      variable errCnt : integer := 0;
   begin
      --TEST 1
      inA <= '0';
      inB <= '0';
      wait for 15 ns;
      assert(outS = '0')  report "Error 1"  severity error;
      if(outS /= '0') then
         errCnt := errCnt + 1;
      end if;

      --TEST 2
      inA <= '0';
      inB <= '1';
      wait for 15 ns;
      assert(outS = '1')  report "Error 2"  severity error;
      if(outS /= '1') then
         errCnt := errCnt + 1;
      end if;

      --TEST 3
      inA <= '1';
      inB <= '1';
      wait for 15 ns;
      assert(outS = '0')  report "Error 3"  severity error;
      if(outS /= '0') then
         errCnt := errCnt + 1;
      end if;

      -------------- RESUME -------------
      if(errCnt = 0) then
         assert false report "OK!"	severity note;
      else
         assert true report "KO!"	severity error;
     end if;

   end process;
end tb;

