# Traduction

## Arbres abstraits / TDS / Contrôles sémantiques

```text
                 (Passe 1)
_______         ____________                      (Passe 2)
texte  \       | Analyse    |                    ____________
source  | ---> |            | ----------------> | Analyse    |
_______/       | Lex | Synt | (Arbre abstrait   | Sémantique |
               |_____|______|   + TDS)          |____________|
                                                    |
    +-----------------------------------------------+
    |          (Arbre abstrait décoré ou TDS)
    V
 ___________
| Génération |         _____
| de code    |        /     \
| + optis    |  ---> | Cible |
|____________|        \_____/
  (Passe 3)
```

### Analyse sémantique

- Vérifie que le texte source -> AST est conforme
  à un _ensemble de règles_ de _construction des programmes_,
  définies par le _manuel de référence_ du langage.

Il existe deux catégories d'erreurs sémantiques.

- **statiques**:
  - "vérifiables" à la compilation
  - ex:
    - Initialisation erronnée
    - Appel de fonctions avec la mauvaise signature
    - Erreur de typage
- **dynamiques**:
  - "vérifiables" à l'éxécution
  - ex:
      - Division par 0
      - Allocation mémoire
      - Dépassement d'un tableau
      - etc.

La **portée** d'une déclaration est **la portion de code où elle est définie**.

La **visibilité** d'une variable: la portion du programme où elle est utilisable. Les _règles de visibilités_ déterminent à quelles définitions d'un idf une utilisation est susceptible de se rapporter.

Un **bloc** est:

- Une fonction
- Une procédure
- Un fichier (en C)
- Un bloc sans nom `{ ... }`

En général, les déclarations sont uniques dans un bloc.

Un **espace de noms** (précisé dans le manuel de référence du langage) est
un ensemble de ce qui est désignable dans un contexte donné par une méthode d'accès faisant usage de noms symboliques.

**Identification**

- => Pour toute utilisation d'un idf, trouver sa déclaration correspondante
- Précède l'étape de contrôle de typage

#### Comment représenter la correspondance utilisation idf/déclaration idf ?

Il existe **trois manières**:

- A la sortie de l'ASD, un **AST complet**
- AST des **instructions** + début de TDS => une TDS / bloc
  - Première idée des infos à mettre dans la TDS:
    - Le **nom** de la variable
    - Son **type**
    - Sa **nature**

#### Informations à mettre dans la TDS

- Nom de l'idf
- Type
- Nature de l'idf:
  - Var
  - Param (+ mode de passage)
  - Tableau (bornes, dimensions)
  - Déplacement


**A quoi sert le déplacement dans la TDS ?** -> Pour accéder au bon endroit dans la mémoire où est sotckée la variable (et donc pour la génération de code).

L'arbre abstrait des déclatations construit une TDS par bloc. La partie _déclaration_ de l'AST _devient inutile_ pour la génération de code.

#### Comment réaliser l'étape d'identification ?

J'associe l'utilisation d'un idf à **une unique déclaration**

**A quoi servent les régions ?** -> A trouver pour une variable l'unique déclaration correspondante (si plusieurs mais dans différents blocs, il s'agira de la première rencontrée).

Exemple:

![exemple tds](./assets/regions_tds.png)

#### Fin du 2eme passage

Sortie:

1. AST
2. +- TDS
3. Identification
4. AST décoré avec la TDS
