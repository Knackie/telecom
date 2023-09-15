SELECT column_name
FROM information_schema.columns
WHERE table_schema = 'public'
AND column_default IS NOT NULL;