# règle pour générer le .exe
codage : codage.o code1.o code2.o
	gcc -o codage codage.o code1.o code2.o -Wall

# règle pour générer object "codage.o"
codage.o : codage.c
	gcc -o codage.o -c codage.c

# règle pour générer object "code1.o"
code1.o : code1.c
	gcc -o code1.o -c code1.c

# règle pour générer object "code2.o"
code2.o : code2.c
	gcc -o code2.o -c code2.c