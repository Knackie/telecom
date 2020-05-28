library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity alu4bitWith3bitOp is
generic(N: integer:=4);
port(
    op1, op2 : in std_logic_vector(N-1 downto 0);
    en_alu : in std_logic;
    operator : in std_logic_vector(2 downto 0);
    c, z : out std_logic;
    AccU : out std_logic_vector(N-1 downto 0)
);
end; 

architecture arch of alu4bitWith3bitOp is
signal res : std_logic_vector(N downto 0);
begin 
    process(res)                                        
        begin
            if(en_alu = '1') then
                z <= '0';
                case operator is
                    when "001" =>    
                        res <= '0' & op1;
                    
                    when "010" =>    
                        res <= std_logic_vector(unsigned('0' & op1) + unsigned('0' & op2)); 
                    
                    when "011" =>    
                        res <= '0' & op1 xor op2;
                    
                    when "100" =>    
                        res <= '0' & op1 and op2;
                        if(res(3 downto 0) = "0000")then
                            z <= '1';
                        end if;
                    
                    when "101" =>        
                        res <= "1111";
                    
                    when "110" =>    
                        res <= "0000" ;
                    
                    when others =>    
                        res <= (others => '0');
                end case;
            end if;
        AccU <= res(N-1 downto 0);
        c <= res(N);
    end process;
end arch; 