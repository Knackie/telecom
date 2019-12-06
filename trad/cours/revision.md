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

