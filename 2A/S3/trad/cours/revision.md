## Domaine de nom 

C'est un ensemble de ce qui est désignable dans un contexte donné, par une méthode d'accès faisant usage de nom symbolique

## 0 de LR0

En LR 0, le 0 correspond au fait que l'on ai 0 unité lexicale d'avance.
Lors du choix de l'action a faire, reduction ou lecture, on a aucune unité lexicale d'avance pour prendre la decision

## Définition d'identification

Pour toute utlisation d'un identifiant, trouver  sa délacration correspondante ( précède l'étape de contrôle de typage )

## Que contient le compteur ordinal 

Il contient l'adresse de retour de la prochaine instruction

## Grammaire ambigue

Lorsqu'il est possible de faire 2 arbres à partir du meme mot

## Analyse Asa

On part des mots à analyser.
– On remplace itérativement des fragments du mot courant qui correspondent à des parties droites
de production par la partie gauche de cette production.

## Algo de constrution d'un item LR1 :

On construit cet automate en découvrant les états à partir de ceux déjà créés (comme lors de la déterminisation d'un automate fini)
●La construction s'arrête quand toutes les possibilités sont explorées
on augmente la grammaire sans mettre un $ en plus–l'item initial est S ::= • E , $–en faisant avancer les •

## Erreur sémantiques 

erreurs sémantiques **statiques** :

Vérifiable à la compilation, ex initialisation erronée, erreur de typage, appel de fonction avec la mauvaise signature.

erreurs sémantiques **dynamique** : 

Vérifiable à l'éxcecution, ex : disivion par 0, dépassement d'un tableau.

## Portée d'une déclaration 

c'est la **portion de code ou elle est définie**

## Définition de la visibiité d'une variable

la portion du programme où elle est utilisable. Les règles de visibilités déterminent à quelles définitions d'un idf une utilisation est susceptible de se rapporter.

## Définiton d'un bloc

Un bloc est une fonction, une procédure, un fichier, ou un boc sans nom. Les délacarations en général sont uniques dans un bloc.

## Définition ramasse miette (garbage collector)

Element permettant de libérer des espaces mémoire dans le tas lorsqu'ils deviennent inaccessibles. ( plus de pointeurs existant )

## A quoi servent les régions

Elle servent à trouver pour une variable l'unique déclaration correspondante

## Stucture d'un compilateur

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

## Combien existe-t-il de tableau ?

Il existe 3 types de tableaux : 

Les tableaux **statiques**

Tout est connu à la compilation et surtout sa taille

```var my_tab = int T[10];```

Les tableaux **dynamiques**

La taille est connue lors de l'exécution.

``` var n = read();
var my_tab = int T[n]; 
```

Les tableaux **flexibles**

La taille varie en cours d'exécution.

## 2 types de représentation des tableaux en mémoire

De manière contiguë

###### Tableaux 1D

`T = tableau [1..5] de entier`

```text
    | .... |
    +------+
    | T[5] |
    +------+
    | T[4] |
    +------+
    | T[3] |
    +------+
    | T[2] |
    +------+
    | T[1] |
    +------+  <-- @ d'implémentation
    | .... |
```

**@ d'implémentation:** adresse en mémoire à partir de laquelle on range les éléments du tableau

**@(T[i]):**

- Accès à l'élément n°`i`
- `@impl + (i - BI) * t` avec `t` = le nombre d'octets et `BI`/`BS` borne supérieure et borne inférieure
- `@impl - (BI * t) + (i * t)`

📝 _`@impl - (BI * t)` -> Adresse de `T[0]` aussi appelée **origine virtuelle**_

###### Tableaux 2D

Rangement **ligne par ligne**

```text
entier T[2..3, 2..5]
         <-->  <-->
  lignes _/      \_ colonnes
```

Se traduistant par:

```text
|       |       |       |       |
|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|
 \ \_ T[-2; 3]   \
  \               \_ T[0; 2]
   \_T[-2;2]  
```

Pour:

- `t` = le nombre d'octets
- `BI`/`BS` borne supérieure et borne inférieure
- `B_1` la borne pour les lignes
- `B_2` la borne pour les colonnes

