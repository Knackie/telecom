create or replace PROCEDURE tableau_exp as
    type tableau is TABLE OF INTEGER INDEX BY BINARY_INTEGER;
    i NUMBER;
    t tableau;
    BEGIN
        FOR i IN 0..14 LOOP
            t(i) := i * 2;
        END LOOP;
        FOR i IN REVERSE 0..14 LOOP
            dbms_output.put_line(t(i));
        END LOOP;
    END;

SET SERVEROUTPUT ON;
EXEC tableau_exp;