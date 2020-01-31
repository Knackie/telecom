# Traduction

## II – Automate SLR(0)

Soit la grammaire `G'`:

```text
E' -> E
E  -> E + T
   -> T
T  -> T x F
   -> F
F  -> idf
```

Début de **l'automate LR(0) associé**:

![début automate lr0](./assets/lr0_debut.png)

On résoud le conflit:

- **Réduction** par `E' -> E`
- **Lecture** et changement d'état

En regardant si l'unité lexicale courante, ici `+`, (= celle présente
en tête du mot restant à analyser) était **dans l'ensemble des
_suivants_** du non-terminal **membre gauche** (`E'`) de la
**production** (`E' -> E`) uilisée pour la réduction.

Ici, `+ ∉ Suiv(E')`

**Donc ce n'est pas une action de réduction qu'il faut appliquer,
mais l'action de lecture avec changement d'état.**

### Table d'analyse SLR(1)

- Partie **transition**:
    - Identique à la table LR(0)
- Partie **action**:
    - Si `[S' -> S•] ∈ Ii`  
      alors `ACTION(i, $) = "OK"` (inchangé)
    - Si `[A -> α•aβ] ∈ Ii`  
      et si `TRANSITION(Ii, a) = Ij`  
      alors `ACTION(i, a) = dj` (inchangé)
    - Si `[A -> α•] ∈ Ii, A != S'`  
      alors `ACTION(i, a) = "réduire par A -> α"`  
      pour tout `a ∈ Suiv(A)`
    - Reste => Erreur

Si pas de conflit => Analyseur SLR(1)
