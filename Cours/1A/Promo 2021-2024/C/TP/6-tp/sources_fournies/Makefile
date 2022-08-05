CC=gcc
CFLAGS=-Wall -Werror -Wno-uninitialized -g -include my_memory.h

PROGRAMS=vecteur_testbase matrice_testbase matrice_lineaire_testbase \
         vecteur_testbornes matrice_testbornes matrice_lineaire_testbornes \
         vecteur_testdynamique matrice_testdynamique matrice_lineaire_testdynamique \
         memory_testcpy memory_testmove memory_testendianess

EXERCICES=matrice_lineaire.c matrice_lineaire_dynamique.c matrice.c matrice_lineaire_verif.c matrice_verif.c \
          vecteur.c matrice_dynamique.c vecteur_dynamique.c vecteur_verif.c memory_operations.c

DATAFILES=vecteur1.txt vecteur2.txt matrice1.txt matrice2.txt

TDP_FILES=teste_programme Makefile *.result $(DATAFILES) generer_vecteur generer_matrice \
          *test*.c *utils*.c *utils*.h vecteur*.h matrice*.h my_memory.h my_memory.c memory_operations.h

DIST_FILES=$(TDP_FILES) filtre

all: $(PROGRAMS) generer_vecteur generer_matrice

test: $(PROGRAMS)
	@echo;echo "*** TESTS ***";echo;\
	@for file in $^;\
	do echo -n "$$file : ";\
	   ./teste_programme $$file 2>/dev/null;\
	done

testsuite: $(PROGRAMS) $(DATAFILES)
	@for file in `echo $^ | grep -v txt`;\
	do ./$$file > $$file.result;\
	done

publish: $(EXERCICES) $(TDP_FILES)
	if [ ! -d TP5_sources_fournis ];then mkdir TP5_sources_fournis;fi
	for file in $(EXERCICES);do cat $$file | ./filtre SUJET >TP5_sources_fournis/$$file;done
	for file in $(TDP_FILES);do cp -p $$file TP5_sources_fournis;done
	@echo "=> Fichiers regénérés dans TP5_sources_fournis"
	rm ../../../depot_CSH/TP5/*
	cp TP5_sources_fournis/* ../../../depot_CSH/TP5/ 
	@echo "=> Depot prêt à être resynchronisé"
	tar czf TP5_sources_fournis.tgz TP5_sources_fournis 
	@echo "=> Archive refaite"

correction: $(EXERCICES)
	if [ ! -d Correction ];then mkdir Correction;fi
	for file in $^;do cat $$file | ./filtre SOLUTION >Correction/$$file;done

etudiants: fichiers correction
	if [ -d Etudiants ];then rm -r Etudiants;fi
	mkdir Etudiants
	mv TP5_sources_fournis Correction Etudiants
	cp TDP4.html *.gif Etudiants

%: %.o
	$(CC) -o $@ $^

%.o: %.c my_memory.h
	$(CC) $(CFLAGS) -c $<

utils_vecteur.o: utils_vecteur.c vecteur.h utils_vecteur.h
	$(CC) $(CFLAGS) -c -include vecteur.h utils_vecteur.c

utils_vecteur_dynamique.o: utils_vecteur.c vecteur_dynamique.h utils_vecteur.h
	$(CC) $(CFLAGS) -c -o $@ -include vecteur_dynamique.h utils_vecteur.c

utils_matrice.o: utils_matrice.c matrice.h utils_matrice.h
	$(CC) $(CFLAGS) -c -include matrice.h utils_matrice.c

utils_matrice_dynamique.o: utils_matrice.c matrice_dynamique.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_dynamique.h utils_matrice.c

utils_matrice_lineaire.o: utils_matrice.c matrice_lineaire.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_lineaire.h utils_matrice.c

utils_matrice_lineaire_dynamique.o: utils_matrice.c matrice_lineaire_dynamique.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_lineaire_dynamique.h utils_matrice.c

matrice_testbase.o: matrice_testbase.c matrice.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice.h matrice_testbase.c

matrice_testbornes.o: matrice_testbornes.c matrice.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice.h matrice_testbornes.c

matrice_testdynamique.o: matrice_testdynamique.c matrice_dynamique.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_dynamique.h matrice_testdynamique.c

matrice_lineaire_testbase.o: matrice_testbase.c matrice_lineaire.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_lineaire.h matrice_testbase.c

matrice_lineaire_testbornes.o: matrice_testbornes.c matrice_lineaire.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_lineaire.h matrice_testbornes.c

matrice_lineaire_testdynamique.o: matrice_testdynamique.c matrice_lineaire_dynamique.h utils_matrice.h
	$(CC) $(CFLAGS) -c -o $@ -include matrice_lineaire_dynamique.h matrice_testdynamique.c

my_memory.o: my_memory.c
	$(CC) -Wall -Werror -c $<

clean:
	rm -f *.o $(PROGRAMS) *.output generer_matrice generer_vecteur

distclean: clean
	rm -f $(DATAFILES)

dist: *.h *.c $(DIST_FILES)
	tar cvzf TDP4_Etudiants.tgz $?

# dependences
vecteur_testbase: vecteur.o utils_vecteur.o my_memory.o
vecteur_testbornes: vecteur_verif.o utils_vecteur.o my_memory.o
vecteur_testdynamique: vecteur_dynamique.o utils_vecteur_dynamique.o my_memory.o

vecteur_testbase.o: vecteur.h utils_vecteur.h
vecteur_testbornes.o: vecteur.h utils_vecteur.h
vecteur_testdynamique.o: vecteur_dynamique.h utils_vecteur.h

vecteur.o: vecteur.h
vecteur_verif.o: vecteur.h
vecteur_dynamique.o: vecteur_dynamique.h

matrice_testbase: matrice.o utils_matrice.o my_memory.o
matrice_testbornes: matrice_verif.o utils_matrice.o my_memory.o
matrice_testdynamique: matrice_dynamique.o utils_matrice_dynamique.o my_memory.o

matrice.o: matrice.h
matrice_verif.o: matrice.h
matrice_dynamique.o: matrice_dynamique.h

matrice_lineaire_testbase: matrice_lineaire.o utils_matrice_lineaire.o my_memory.o
matrice_lineaire_testbornes: matrice_lineaire_verif.o utils_matrice_lineaire.o my_memory.o
matrice_lineaire_testdynamique: matrice_lineaire_dynamique.o utils_matrice_lineaire_dynamique.o my_memory.o

matrice_lineaire.o: matrice_lineaire.h
matrice_lineaire_verif.o: matrice_lineaire.h
matrice_lineaire_dynamique.o: matrice_lineaire_dynamique.h

memory_testcpy: memory_testcpy.o memory_operations.o vecteur.o utils_vecteur.o my_memory.o
memory_testmove: memory_testmove.o memory_operations.o vecteur.o utils_vecteur.o my_memory.o
memory_testendianess: memory_testendianess.o memory_operations.o my_memory.o

memory_testcpy.o: vecteur.h memory_operations.h utils_vecteur.h
memory_testmove.o: vecteur.h memory_operations.h utils_vecteur.h
memory_testendianess.o: memory_operations.h

memory_operations.o: memory_operations.h

# Regenere les donnees et les fichiers resultats correspondants
vecteur1.txt vecteur2.txt: generer_vecteur
	./generer_vecteur 1000 > $@
	
matrice1.txt matrice2.txt: generer_matrice
	./generer_matrice 50 100 > $@
	

