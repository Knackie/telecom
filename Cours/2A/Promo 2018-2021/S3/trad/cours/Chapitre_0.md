# Traduction

## Chapitre 0 – Introduction

### Qu'est ce qu'un compilateur ?

Un compilateur est un **logiciel qui traduit un programme**
écrit dans un langage de haut niveau **en instructions
executables**.

**/!\\** Ne pas confondre **compilateur** et **interpréteur** !

- Compilateur:
    - La cible est executable _une fois pour toutes_.

```text
Texte source
    └──> compilateur
            └──> éditeur de liens
                   └──> Programme cible
```

- Interpréteur:
    - Pas de programme cible;
    - Analyse _une instruction après l'autre_, puis execute
     _immédiatement_.

```text
Données           Programme source
    |                    |
    └──> Interpréteur <──┘
              |
   erreurs <──┴──> résultat
```

#### Structure d'un compilateur

```text
Programme source
 +--|------------------------------------------+
 |  └─> Lexeur (analyse lexicale)              |                    ┐
 |          |                                  | Souvent ensemble   |
 |          └─> Parser (analyse syntaxique)    |                    |
 +------------------|--------------------------+                    | FRONT
                  (AST)                                             |
                    └─> (analyse sémantique)                        |
                        |                                           |
                        └─> (AST) +- (TDS)                          ┘
                            |
                            └─> Génération de code intermédiaire    ┐
                                (code à trois adresses)             | COEUR (pas en PEL)
                                    |                               |
                                    └─> Optimisations               ┘
                                        |
                                        └─> Génération de code      ┐
                                            assembleur              |
                                            |                       | BACK
                                            └─> Optimisations       |
                                                |                   |
                                                └─> Cible           ┘
```

- Lexeur:
    - Automate à états;
    - Langage rationnel;
    - _Out:_ `token`.

- Parseur:
    - Automate à états / pile;
    - Langage algébrique;
    - _Out:_ `phrase`.

- AST:
    - _Abstract Synthax Tree_;
    - Arbre abstrait.

- TDS:
    - _Table Des Symboles_

### Quelques dates

**1954:**    FORTRAN       (1er compilateur +- 1950)    
**1959:**    COBOL         (orienté object, gestion)  
**1966:**    SIMULA        (classe et objet)    
**1971:**    PASCAL        "universel"  
**1972:**    C, PROLOG     
**1976:**    ADA  
**1982:**    C++           (C2 SIMULA)  
**1986:**    EIFFEL        (langage objet)  
**1991:**    JAVA
