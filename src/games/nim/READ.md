# Jeu de Nim en Java

## Description

Ce projet est une implémentation du **jeu de Nim** en Java dans le cadre d'un TP de programmation orientée objet.

Le jeu oppose deux joueurs qui retirent à tour de rôle des allumettes d'un tas.

### Règles

- Le jeu commence avec un tas de **n** allumettes.
- À chaque tour, un joueur retire entre **1** et **k** allumettes.
- Le nombre retiré doit être inférieur ou égal au nombre d'allumettes restantes.
- Le joueur qui retire **la dernière allumette perd** la partie.

---

## Fonctionnalités

- Création d'une partie avec deux joueurs.
- Choix du nombre initial d'allumettes (**n**).
- Choix du nombre maximal d'allumettes pouvant être retirées (**k**).
- Vérification des coups valides.
- Gestion automatique du changement de joueur.
- Détection de la fin de la partie.
- Détermination du gagnant.
- Interface textuelle dans le terminal.

---

## Structure du projet

```
src/
└── games/
    nim/
    ├── Nim.java
    ├── ExecutNim.java
    └── NimTest.java
gamestests/
    nim/
    ├── NimTest.java
```

### Description des classes

- **Nim.java**
  - Représente une partie de jeu de Nim.
  - Contient la logique du jeu.

- **ExecutNim.java**
  - Contient la méthode `main`.
  - Permet aux joueurs de jouer dans le terminal.

- **NimTest.java**
  - Lance les tests fournis dans `gamestests.jar`.

---

## Compilation

Compiler le projet :

```bash
javac -cp lib/gamestests.jar -d build src/games/nim/*.java
```

---

## Exécution

Lancer le jeu :

```bash
java -cp build games.nim.ExecutNim
```

Lancer les tests :

```bash
java -cp build:lib/gamestests.jar gamestests.nim.NimTest
```

---

## Exemple d'exécution

```
Entrez le premier joueur :
Alice

Entrez le deuxième joueur :
Bob

Entrez la taille initiale d'allumettes :
13

Entrez le nombre maximal d'allumettes :
3

Il reste 13 allumettes.
Tour de Alice
Combien retirez-vous ?
2

Il reste 11 allumettes.
Tour de Bob
Combien retirez-vous ?
3

...

Le jeu est terminé.
Le gagnant est Bob.
```

---

## Technologies utilisées

- Java
- JDK 21
- Bibliothèque de tests `gamestests.jar`

---

## Auteur

Nawedullah Kohanpoor
Étudiant en informatique L2 4B