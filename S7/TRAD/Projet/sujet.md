# Projet traduction 2022

L'objectif de ce projet est la réalisation d'un traducteur sur un sous ensemble du langage Rust, que nous appellerons __Mini Rust__. L'objectif sera d'écrire un analyseur lexical en utilisant Antlr, un analyseur sémantique et de réaliser la traduction du code __Mini Rust__ en langage C. 

Le projet pourras être réalisé dans le langage de votre choix. Cependant, nous vous conseillons de privilégier le langage Java ou Python 3.

Lors de ce projet, nous vous conseillons de vous comparer le plus souvent possible au compilateur rust pour détecter les erreurs dans votre travail.

## 1. Le langage Rust

Le langage rust est un langage bas niveau dont les objectifs sont des performances comparables au C et un haut niveau de sécurité du code. Toute la documentation du langage peut être trouvé en ligne.


## 2. Lexique 

Le langage est constitué des unité lexicales suivantes : 
* Les __nombres entiers__ qui contiennent au moins un chiffre 
* Les __chaines de caractères__ noté ```" CHAR* "``` où ```CHAR désigne n'importe quel caractère ASCII
* Les __identifiants__, qui commence par une lettre ou un ```_``` et qui peuvent contenir des lettres, des chiffres ou le caractère ```_```

Ainsi que les mots clefs du langage
```if``` ```else``` ```false``` ```true``` ```let``` ```mut``` ```fn``` ```return``` ```struct``` ```while```

Les whitespaces (```\n```, ``` ``` et ```\t```) en dehors des chaines de caractères doivent être ignorés.

Les commentaires sont définis de la façon suivante :
*  débutant par ```/*``` et terminant par ```*/```
*  débutant par ```//``` jusqu'à la fin de la ligne



## 3. Syntaxe 

La syntaxe du langage rust est proche de celle du langage C++ (pour ceux qui aiment la souffrance). Nous décrirons dans cette parties les différents éléments qui constituent le langage.


Nous adopterons la  conventions de représentation suivante : 
- une règle s'écrit sous la forme ```#nom_de_la_regle```
- On utilisera les notations d'Antlr (```+```,```*```,```?```)

### 3.1 Fichier et déclarations

Le fichier constitue la racine de votre code. Il est constitué d'un ensemble de déclarations terminés par le caractère spécial ```EOF```.

On peut déclarer les éléments suivants : 
* structure
* fonction 

Cela nous donne les règles de grammaires suivantes:

```
file :: #decl* EOF
decl :: #decl_function | #decl_struct 
 ```

### 3.2 Structures

Une structure est déclaré de la façon suivante : 

```rust 
struct nom_structure {
    nom_parametre_1 : type1,
    nom_parametre_2 : type2,
    ...   
}
```

ce qui nous donne la règle de grammaire suivante : 

```
decl_struct :: struct #IDF { ((#IDF):#type,)* }
```

### 3.3 Fonctions 

Une fonction est définie par la syntaxe suivante:
```rust 
fn nom_fonction(nom_argument_1:type1, mut nom_argument_2:type2 ...) -> type_retour {
    ... // instructions
}
```

Il est à noter que le type de retour de la fonction est optionnel. Dans le cas ou aucun type n'est précisé, on considère que le type de retour est ```()``` (void).

ce qui nous donne les règles de grammaire suivantes : 
```
decl_function : fn #IDF ((#argument,)*) -> #type #bloc
bloc : { #instr*}
argument: mut? #IDF : #type
```

On voit qu'un argument peut être précédé du mot ```mut```. Nous détaillerons dans la partie suivante sa signification.


### 3.4 Types

On considère qu'une valeur possède l'un des types suivant :
* i32 (le type entier de base)
* bool (le type booléen)
* Vec< _T_> (Un vecteur d'objets de type _T_)
* _T_ (Une structure définie de nom _T_)
* () (Une notation sans type (est équivalent au type __void__))
* &_T_ (Une référence sur un objet de type _T_)

Dans la syntaxe, on notera les types de la façon suivante : 
```
type : #IDF | Vec<#type> | & #type | & mut #type
```

La sémantique des types est détaillé dans la partie suivante.

### 3.5 Instruction
Une instruction est constituée des éléments suivants :
* Une expression suivie d'un point virgule 
```instr :: #expr ;```
* Un déclaration de variable ou de structure, qui commence par le mot clé ```let``` et est annoté par le type de la variable
```
let mut? #IDF:#type = #expr ;
let mut? #IDF:#type = #IDF {(#IDF : #expr,)};
 ```
* Une boucle while :
```
while #expr #bloc
```
* Un return :
```
return #expr?;
```
* Un bloc ifthenelse:
```
if #expr #bloc (else #bloc)?
```

### 3.6 Expressions

Les expressions sont constituées des opérations arithmétique et des appels sur les structures et les tableaux. Elles sont constitués des alternatives suivantes : 
* Les terminaux entier et booléens:
```
#INT | true | false
```
* les identifiants:
```
#IDF
```
* Les opérations binaire
```
#expr ( + | - | * | / | % | && | || | == | != | < | <= | > | >= ) #expr
```

* Les opérations unaires
```
( - | ! | * | & | & mut) #expr
```
* Les accès aux éléments d'une structure ou d'un tableau
```
#expr . #IDF
#expr [ #expr ]
```

* L'appel à la méthode ```len```
```
#expr . len()
```
* L'appel de fonction 
```
#IDF ( (#expr ,)*)
```
* la déclaration d'un vecteur
```
vec ! [ (#expr,)* ]
```
* l'appel a la fonction spéciale ```print```
```
print! (#STR)
```
* Un bloc 
```
#bloc
```
* Une expression entre parenthèses
```
( #expr )
```

On impose la priorité des opérateurs suivante (le plus prioritaire est le plus en bas) : 

| Opérateur                    |
|------------------------------|
| =                            |
| ||                           |
| &&                           |
| == != < <= > >=              |
| + -                          |
| * / %                        |
| ! *(unaire) -(unaire) & &mut |
| [ ]                          |
| .                            |
                         




## 4. Contrôle sémantique

### Sémantique des types 
Les contrôles sémantiques suivants sont attendus :
1. Cohérence des types entre les membres gauche et droit d'une opération. Par exemple :
- ```1+"3"``` est une expression invalide car on essaie de sommer deux éléments de type différents
- ```let a:i32 = true``` est invalide car on affecte un un booléen à une variable déclaré entière
- ```if (1) ...``` est invalide car le test dans une condition doit être un booléen
2. Cohérence entre la signature d'une fonction et son appel 
Prenons l'exemple suivant : 
```rust 
fn test(a:i32,b:Vec<i32>)->i32{
    return a * b[0];
}
```
Les appels suivants sont sémantiquement faux : 
- ```test()``` il n'y a pas le bon nombres d'arguments
- ```test("3",vec![1,2])``` les arguments n'ont pas le bon type
- ```test(vec![1,2],3)``` les arguments ne sont pas dans le bon ordre
- ```let c: bool = test(3,vec![1,2]);``` on affecte le retour de la fonction à une variable du mauvais type
3. Cohérence entre le type de retour de fonction déclaré et la valeur trouvé dans l'expression return
Par exemple :
```rust
fn test() -> i32 {
    return true;
}
``` 
est sémantiquement fausse, car le type de retour attendu ```i32```, diffère du type trouvé.

De même : 
```rust
fn test() -> i32 {
    print!("Hello World!");
}
```

est sémantiquement fausse car le type de retour attendu est ```i32``` et le type trouvé est ```()```.

4. Le programme doit contenir une fonction ```main```.





### Mutabilité

En rust, il existe une notion de mutabilité des variables qui indique si une variable peut être modifié ou non. Par exemple:
```rust
let x:i32;
let mut y:32;
```

Dans cette expression, la variable ```x``` ne peut pas être modifié alors que la valeur ```y``` peut l'être.

Pour les contrôles sémantiques de typage, on considère la rêgle suivante : " Une variable du type ``` mut T``` est une variable de type ```T```, mais l'inverse est faux.

Par exemple :
```rust
fn bad(a: mut i32){
    a = a +1;
}

fn main(){
    let a:i32=1;
    bad(a);
}
```
renvoie une erreur car la variable passé ```a``` passé en argument dans la fonction ```main``` possède un type incorrect. 

A l'inverse, le code :

```rust
fn good(a: i32){
    a = a +1;
}

fn main(){
    let mut a:i32=1;
    good(a);
}
```
ne renvoie pas d'erreur car le type ```mut i32``` peut être interprété comme le type ```i32```.

### Références sur les variables :


En __Mini Rust__, il est possible au même titre qu'en __C__ de déclarer une référence à une variable, noté : 
```rust 
let y:i32 =1;
let x:&i32 = &y;
```

Il est également possible de déclarer une référence mutable sur une variable:
```rust 
let mut y:i32 = 1;
let x: &mut i32 = &mut x;
```



Les références obéissent également au concept de typage des variables mutables, a savoir qu'il n'est pas possible de déclarer une référence mutable sur une variable non mutable. Le code suivant : 
```rust
fn main(){
    let y:i32=1;
    let x:&mut i32 = &mut y;
}
```

est donc invalide.

### Ressource et propriété des ressources 

Le principal avantage de rust par rapport à des langage comme le C est qu'il assure une forte sécurité quand à la gestion de la mémoire. Il n'y a en effet pas d'allocation mémoire explicite dans le langage rust. C'est le compilateur qui se charge d'allouer et de désallouer les variables.

Pour pouvoir le faire correctement (éviter les doubles free, les mallocs sur les variables déjà alloués, etc...), le compilateur utilise notion de propriété (_ownership_ en anglais) des ressources mémoires.


Dans la suite, nous allons définir une _ressource mémoire_ comme n'importe quelle valeur (tableau, structure ...) alloué dans le tas (par exemple par la fonction __malloc__ en C).

L'idée est que une ressource ne peut pas être _possédé_ par plusieurs variables en même temps. Par exemple, dans le code suivant : 
```rust
let v:Vec<i32> = vec![1,2,3];
```


On déclare un tableau de taille trois contenant les valeurs [1,2,3]. Il s'agit d'une ressource mémoire dont on assigne l'_ownership_ a la variable ```v```. 

Cette idée permet de désallouer intelligemment les ressources mémoires. La règle est la suivante : 
_" On désalloue les variables qui possèdent une ressource dans l'ordre inverse de leurs déclaration"_

La possession d'une ressource change dans les cas suivants :
* affection de la variable possédant la ressource à une autre variable ```let x=v```
* affectation de la variable possédant la ressource a une sous partie d'une structure ou d'un tableau ```t[1]=v``` , ```s.x = v```
* Passage en paramètre d'une fonction ```f(v)```
* Construction d'une structure ou d'un tableau ```let s:S = {a:v}```

Prenons l'exemple suivant:
```rust
fn f(v:Vec<i32>){
    print!(v[1]);
}

fn main(){
    let mut x = vec![vec![],vec![]]; 
    let v = vec![1,2,3];
    let w = v;

    x[0] = w;
    f(x[0]);

}
```
Dans le code suivant, la variable propriétaire de la ressource [1,2,3] est ```v``` a la seconde ligne de ```main```. Cette possession est transmise à ```w``` à la ligne suivante, puis à ```x``` encore à la ligne suivante. Enfin, le propriétaire final de cette ressource est l'appel à la fonction ```f``` à la dernière ligne de main.

Pour rust, c'est donc la fonction f qui doit désallouer le tableau [1,2,3] à la fin de son appel.

Nous pouvons donc noter qu'après l'appel de f(x[0]), il n'est plus possible d'utiliser la ressource [1,2,3] car il faut considérer qu'elle a été désalloué.

Le code suivant ne sont donc pas valide sémantiquement :
```rust

fn f(v:Vec<i32>){
    print!(v[1]);
}

fn main(){
    let mut x = vec![1,2,3];
    f(x);
    let y:Vec<i32> = x;
}
```

En effet, on essaie d'associer à y une ressource qui doit déjà avoir été supprimé. On dit que la ressource a été _déplacé_ et elle n'est donc plus accessible.

On préférera donc le passage d'argument alloué par référence : 

```rust
fn f(v:&Vec<i32>){
    print!(v[1]);
}

fn main(){
    let mut x:Vec<i32> = vec![1,2,3];
    f(&x);
    let y:Vec<i32> = x;
}
```

Ce code est exactement équivalent au premier mais valide sémantiquement. On dit qu'une référence _emprunte_ la variable (mais ne change pas son propriétaire).

Cela signifie cependant qu'il faut effectuer des contrôles supplémentaire sur les références.
1.  La portée d’une référence ne doit pas excéder celle du propriétaire de la ressource. Dans le code 
```rust 
fn main(){

    let mut y:i32 = 1;
    let mut x:&i32=&y;

    {
        let y:i32 = 3;
        x= &y;

    };
               
    let a:i32 = *x;

}
```

Il n'est pas possible d'utiliser la valeur référencer par x car elle est censé avoir été désalloué à la fin du bloc anonyme.





