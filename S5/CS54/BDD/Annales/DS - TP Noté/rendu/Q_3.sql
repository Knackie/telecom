SELECT column_name 
FROM information_schema."columns"
WHERE table_name = 'competition'
AND table_schema = 'public'
AND column_name NOT IN ( 
      SELECT column_name
      FROM information_schema.constraint_column_usage
      WHERE table_schema = 'public'
      AND table_name = 'competition'
);