# Traduction

## III Analyseur LR(1) et LALR(1)

Soit:

```text
    ┌
Ii: | A -> B•aDa
    | D -> B•
    | ...
    └
...
    ┌
Ij: | A -> Ba•D
    | ...
    └
```

Si on lit `a`:

- Avancer et changer d'état
- Réduire par `D -> B` car `a ∈ Suiv(D)`

**=> CONFLIT**

### Solution

On va ajouter une information supplémentaire dans les items.

Un item devient: `A -> α•aβ, a`:

- Ceci est un item de LR(1)
- où `A -> αβ ∈ G`
- où `a ∈ T ∪ $`
- `a` est le symbole de prévision, le contexte

### Définition

Construction des **items dans LR(1)**:

- `G'` augmentée
- Item LR(1) = une production avec un `•` et un contexte
- Fermeture (pour un état I et I' = Ferm(I)):
    - Placer tous les items de I dans I'
    - Si `[A -> d•Bβ, a] ∈ I`  
      Si `B -> γ ∈ G`  
      Si `b ∈ Prem(βa)`  
      Alors:
      - itérer le processus
      - Ajouter `B -> •γ, b` à fermerture(I) Si pas déjà présent

### Construire l'automate LR(1) à partir d'items LR(1)

```text
┌
| S' -> S
| S  -> CC
| C  -> aC
|    -> d
└
```

![EN ATTENTE DU SCHEMA](analyseur_chapitre_5.)

#### Analyseur LR(1)

Construction de la table idem à SLR(1) **sauf** pour les états
de réduction.  
-> **Si** `[A -> α; a] ∈ Ii, A ≠ S'`
   **Alors** `Action(Ii, a) = "réduction de A -> α"`

#### Table LR(1)

**Pas de conflits** -> L'analyseur est LR(1)

|| a | d | $ | S | C | S' |
|-:|:-:|:-:|:-:|:-:|:-:|:-:|
| I0 | d3| d4|| 1| 2||
| 1 ||| OK ||||
| 2 | d6 | d7 ||| 5 ||
| 3 | d3 | d4 ||| 8 ||
| 4 | r3 | r3 |||||
| 5 ||| r1 ||||
| 6 | d6 | d7 ||| 9 ||
| 7 ||| r3 ||||
| 8 | r2 | r2 |||||
| 9 ||| r2 ||||

### Conflit lecture/réduction

En cas de conflit lecture/réduction, **deux solutions** existent:

1. Transformer la grammaire
2. Résoudre les conflits en utilisant les **précédences** (priorités). Par exemple, `*` a une précédence plus forte que `+`
