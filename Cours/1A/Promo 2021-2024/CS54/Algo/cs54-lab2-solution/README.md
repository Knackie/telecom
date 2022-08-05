# Lab #2 - Strings and Recursion Lab for CS54 2021-2022.

## Objectifs

**Objectifs principaux** 
- Réaliser une implémentation d'une chaîne récursive et quelques algorithmes classiques dessus ;

**Objectifs annexes**
- Utiliser la plateforme GitLab de l'école pour y déposer les réalisations.


Le sujet complet est disponible dans le fichier [02-tp-recursivite-enonce.pdf](./02-tp-recursivite-enonce.pdf)

## Quelques indications complémentaires

### Bonnes pratiques de développement

Vous veillerez à documenter/commenter le code Python que vous écrivez. Chaque fonction que vous définissez devrait être associée à commentaire pour préciser : le type et le sujet de chaque paramètre ; le type et la valeur de retour de la fonction ; les pré-conditions (et éventuellement post-conditions) de cette fonction.

Vous pouvez utiliser si vous le souhaitez :
- des [indications de types (*Type Hinting*)](https://docs.python.org/3/library/typing.html) () disponibles depuis Python 3.5+ (https://docs.python.org/3/library/typing.html) et définis dans la [PEP 484](https://www.python.org/dev/peps/pep-0484/). Ils vous permettent d'annoter des types à vos paramètres, valeur de retour ou encore variables.
- les [*docstrings* (PEP 257)*](https://www.python.org/dev/peps/pep-0257/)

L'hyperlien suivant pointe sur un article en ligne sur ces bonnes pratiques : 
https://www.codeflow.site/fr/article/documenting-python-code


### Gestion de versions (git)

Il vous est demandé :
- de *cloner* le dépôt présent sur la plateforme GitLab de l'école pour travailler en local sur votre machine personnelle ou une machine de l'école
- de *committer* chacune de vos versions de vos programmes et de *pousser* régulièrement ces commits sur la plateforme GitLab

Prenez l'habitude d'associer à vos commits des messages pertinents qui décrivent le contenu des modifications apportées par le commit.

### Tests unitaires (pytest)

Nous vous invitons fortement à écrire des tests unitaires permettant de valider la correction et la résilience de vos algorithmes et de leur implémentation.

Pour cela, vous utiliserez la libraire [pytest : https://docs.pytest.org/en/stable/](https://docs.pytest.org/en/stable/). 

Vous pouvez installer cette librairie dans votre environnement en exécutant la commande :
```bash
$ pip install -U pytest
```

Ensuite, pour exécuter vos tests (que vous écrirez dans des fichiers dénommés `xxx__test.py`), il vous suffit d'utiliser la commande :
```bash
$ pytest --verbose
```
