CREATE OR REPLACE FUNCTION CHARGES (salaire INTEGER) RETURN INTEGER as
    BEGIN
        return 0.45 * salaire;
    END;

DECLARE
    t integer;
BEGIN
    t := CHARGES(100);
    dbms_output.put_line(t);
END;