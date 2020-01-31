# Traduction

## Représentation des objets en mémoire (à l'exécution)

### Types de base

- Entiers
- Réels
- Carctères
- etc.

-> Dépend de la machine (2, 4, 8 octets)

Lorsque l'on parle de **l'adresse de l'objet** cela revient à parler de **son adresse d'implémentation** (en hexa en mémoire).

⚠️ Pas besoin de réserver de place pour un type `void` qui ne renvoit par définition aucune valeur

### Les structures

Les structures contiennent **un nombre fixe de champs**.  

Dans le cas d'une `struct`, tous les champs figureront en mémoire. En revanche, `union` ne contiendra que l'un des type spécifiés:

```c
// 4 octets seront aloués
union
{
    int x;   // 2 octets
    float y; // 4 octets
}

// 6 octets seront aloués
struct
{
    int x;   // 2 octets
    float y; // 4 octets
}
```

Les champs sont rangés **de manière contigue** pour les structures. Exemple de réprésentation mémoire de la `struct`:

```text
    |       |
    +-------+
 y: |       |
    |       |
    +-------+
 x: |       |
    +-------+  <-- adresse d'implémentation
```

### Les chaines de caractères

Deux solutions pour savoir quand le **tableau de caractères** est fini:

- Chaine + marqueur de fin de chaine (ex: `\0` en C)
- Longueur de la chaine

### Les tableaux

Il existe trois types de tableaux.

#### Les tableaux statiques

Tout est connu à la compilation et **surtout sa taille**

```text
var my_tab = int T[10];
```

#### Les tableaux dynamiques

La taille est connue **lors de l'exécution**.

```text
var n = read();
var my_tab = int T[n];
```

#### Les tableaux flexibles

La taille varie en cours d'exécution.

📝 _Quelle que soit le tableau utilisé, le nombre de dimensions est connu_

#### Implémentation des tableaux

**(🚨 Possiblement à l'examen)**

Il existe deux manières de représenter les tableaux en mémoire:

- De manière contiguë
- Par indexations successives

##### De manière contiguë

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

Accès à l'élément `i` de la colonne `j`:

- `@T[i, j] = @impl + (i - BI1) * (BS2 - BI2 + 1) * t + (j - BI2) * t`
- `(i - BI1) * (BS2 - BI2 + 1)` => Toutes les lignes avant la ième
- `(j - BI2)` => Toutes les colonnes avant j

Soit `@impl - BI1(BS2 - BI2 + 1) * t - BI2 * t + i * (BS2 - BI2 + 1) * t + j * t`

Avec:

- `@impl - BI1(BS2 - BI2 + 1)` => **@origine virtuelle** (@ov)
- `BI2 * t + i * (BS2 - BI2 + 1)` => enjambées e1
- `j * t` => enjambées e2

**❔ Quand calculer ces différentes valeurs ?**

Pour un tableau _statique_:

- A **la compilation**
- Dans la **TDS**
- Calcul de `ei`
- Calcul de la somme: `Σ BIk · ek`
- Place nécessaire pour ranger le tableau en mémoire:   
  `nb elem * taille de l'elem (t)`

Pour un tableau _dynamique_:

- A **l'exécution**
- Dans la **pile**
- Calcul de `ei`
- Calcul de la somme: `Σ BIk · ek`
- Place nécessaire pour ranger le tableau en mémoire:   
`nb elem * t + 3 * n + @ov` avec `n` la dimension (et 3 pour la _borne inf_, la _borne sup_ et l'_enjambée_)

Pour un tableau _flexible_:

- A **l'exécution**, à chaque changement de taille
- Dans la **tas**
- Calcul de `ei`
- Calcul de la somme: `Σ BIk · ek`
- Place nécessaire pour ranger le tableau en mémoire:   
  `nb elem * t + 3 * n + @ov` avec `n` la dimension (et 3 pour la _borne inf_, la _borne sup_ et l'_enjambée_)
- ⚠️ Les éléments sont obligatoirement **dans le tas**

**Représentation du tableau statique:**

```text
                               +----------+
                             c |          |
                               +----------+        
                               |          |
f() {                          |          |
  int a;                     T |          |
  int T[BI1 BS1, BI2 BS2];     +----------+
  reel c;                    b |          |
  ...                          +----------+
}                              |   ....   |
                               |   Pile   |
```

**Représentationdu tableau dynamique:**

```text
                               +----------+
                               |  elem du | \ partie dynamique
                               |  tableau | / du tableau (peut aller dans le tas)
                     @impl ->  +----------+
                             c |          |
                               +----------+          
                               |   e1     |  \
                               |   BS1    |   |=> autant de fois que
                             T |   BI1    |  /    de dimension
                               +----------+       (partie statique
                               |   @ov    |        du tableau dynamique)
                               +----------+
                             a |          |
                               +----------+
                               |   ....   |
                               |   Pile   |
```

**Représentationdu tableau flexible:**

```text
                               +----------+
                             c |          |
                               +----------+        
                             T |          |
                    @impl ->   +----------+
                             b |          |
                               +----------+
                               |   ....   |
                               |   Pile   |

    => Les éléments sont **dans le tas**
```

##### Représentation ds tableaux par _indexations successives_

**Idée:**

- A chaque dimension correspond un index qui donne accès aux dimensions
  suivantes.
- L'accès à un elem se fait par une suite d'indirections

Exemple: `int T[1..4, 2..3]`, **en pile**

![repr index succ](./assets/repr_index_succ.png)
