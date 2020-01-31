# Traduction

## Gestion dynamique de la mémoire à l'exécution

```text
+---------+
| zone    |
| code    |
+---------+
| zone    |
| des     |
| données |
+---------+
```

La _zone de données_ contient:

- Des objets _statiques_:
  - Créés au début du programme
  - Ne "bougent" plus
- Des objets _dynamiques_ gérés de manière "automatique":
  - Attachés aux fonctions et procédures
  - Ne changent pas de place dans l'environnement de la fonction
  - Ex: variables locales, paramètres, etc.
- Des objets _dynamiques_ créés de façon explicite:
  - Créés à la demande
  - Rangé **dans le tas**
  - Peuvent être déplacés (ex: ramasse miettes)

**🚨 Question potentielle:** Le compteur ordinal contient
l'adresse de retour de la prochaine instruction

A la fin d'une fonction, il faut revenir à la prochaine instruction
hors fonction. Il faut donc **sauvegarder l'adresse de retour**

Lors du passage de paramètre, c'est **l'appelant qui empile
les paramètres** et non l'appelé.

A la fin d'exécution d'une fonction, **on dépile `SP`** (sommet de
pile) jusqu'à l'adresse de retour. Il faut aussi remettre à jour
la base. Pour cela, il faut **sauvegarder la base de l'appelant**
avant d'executer l'appelé (cette sauvegarde est appelée
_chainage dynamique_).

## Rappels

- Environnement => alloué _dynamiquement_ **en pile** à chaque
  appel de fonction/procédure. A chaque sortie d'un appel,
  **on libère la place**.
- L'@ d'une variable (en pile) n'est pas fixe: on utilise un
  mécanisme d'adressage basé:

```text
  @var = base de l'env courant + déplacement
         \__________________/    \_________/
               DYNAMIQUE           STATIQUE
                                    (TDS)
```

- ➕ Avantage de cette gestion de mémoire: **recursivité possible**
- ➖ Inconvénient: prévoir cette gestion dans le code généré

📝 _Le tas est organisé en deux parties: l'ensemble des valeurs
référencées par la pile et le reste. Ainsi on a une grande zone
occupée et une grande zone libre._

📝_**Paramètre formel:** paramètre qui est dans la définition;
**Paramètre effectif:** paramètre qui est dans l'appel._

Soit le pseudocode:

```text
f(int x, y) { ... }

main() {
    int a= 3, b = 4;
    f(a, b);
    a = 3;
}
```

Traduction en mémoire:

```text
code_main:
    empiler a, b (et maj SP)
    JSR (code_f)
    dépiler params (maj SP)
    MOVE #3, @a

code_f:
    sauvegarde avec base
    instruction de f
    RTS
```

## Accès aux objets (variables) **non-locaux**

```text
programme PP                | -> n° de région 1 | n° d'imbrication 1      
    A: entier               |
                            |
    Procedure R()           | -> n° de région 2 | n° d'imbrication 2
        A, D: entier        |
        P()                 |
                            |
    Procedure P()           | -> n° de région 3 | n° d'imbrication 2
        B: entier           |
        Procedure Q()       | -> n° de région 4 | n° d'imbrication 3
            C: entier       |
            A = 1; B = 2    |
            C = 3           |
        Q()                 |
                            |
    R()                     |
```

Pile associée (sans numéro d'imbrication):

![pile](./assets/pile.png)

Pile associée (avec numéro d'imbrication)

![pile](./assets/pile_imbr.png)

=> Pour trouver la variable `A`.

Ainsi en Q(): `A = 1` on a A qui a un numéro de région 1 et numéro
d'imbrication 1. On a Q() qui a comme numéro d'imbrication 3.
On fait donc: `3 - 1` => **2 chainages statiques à parcourir**.

On a donc deux chainages statiques à parcourir,
on remonte les deux, et on fait `base + déplacement`.

📝 _**Chainage statique:** contient la base de l'environnement
du bloc de déclaration_
📝 _**Chainage dynamique:** contient la (???)_
📝 _Il y a toujours trois adresses: `@ retour`, `ch statique`,
`ch dynamique`_

### Résumé

- A chaque bloc est attaché un n° d'imbrication. (calculé et rangé
  dans la TDS)
- **Retrouver la base du bloc** d'une déclaration =
  - Les règles de portée garantissent que:
    - Si `I` est déclarée dans le bloc `X` d'imbrication `Nx`
    - Si `I` est visible dans le bloc `Y` d'imbrication `Ny`
      (alors `Nx` <= `Ny`; si égalité `I` est une variable locale)
  - **Il faut "remonter" `Ny - Nx` chainages** statiques depuis le
    bloc courant en pile

### Comment mettre en place ce chainage statique ?

Supposons que:

- L'appelant est un bloc d'imbrication `Nx`
- L'appelé est un bloc d'imbrication `Ny`


- Le chainage statique du bloc appelé doit désigner le (dernier)
bloc d'imbrication de numéro `Nz = Ny - 1`
- Depuis l'appelant, on trouve le bloc d'imbrication `Nz = Ny - 1`
  en parcourant `Nx - Nz` chainages statiques

=> Il faut parcourir `Nx - (Ny - 1) = Nx - Ny + 1` chainages
statiques pour trouver **le** chainage statique de l'appelé.

📝 _C'est **l'appelant qui calcule** le chainage statique, mais
**l'appelé qui le met en place**_
