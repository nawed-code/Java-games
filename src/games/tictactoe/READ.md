# Tic-Tac-Toe (Morpion) en Java

## Description

Ce projet est une implémentation du célèbre jeu **Tic-Tac-Toe (Morpion)** réalisée en **Java** dans le cadre d'un projet universitaire sur la programmation orientée objet.

Deux joueurs jouent tour à tour sur une grille de **3 × 3**. Le premier joueur utilise la marque **X**, le second utilise **O**. Le premier à aligner trois marques horizontalement, verticalement ou en diagonale remporte la partie. Si toutes les cases sont remplies sans gagnant, la partie est déclarée nulle.

Le projet comprend également une version avec **indices (Hints)** qui indique au joueur courant les cases permettant à son adversaire de gagner immédiatement au tour suivant.

---

## Fonctionnalités

- Jeu de Morpion à deux joueurs
- Validation des coups
- Gestion automatique du joueur courant
- Détection du gagnant
- Détection d'un match nul
- Affichage de la grille dans le terminal
- Version avec indices (Hints)
- Tests automatiques fournis par l'enseignant

---

## Structure du projet

```
src/
└── games/
    └── tictactoe/
        ├── TicTacToe.java
        ├── TicTacToeWithHints.java
        ├── ExecutTicTacToe.java
        └── TicTacToeWithHintsTest.java
└── gamestests/
    └── tictactoe/
        ├── TicTacToeWithHintsTest.java
```

---

## Technologies

- Java
- Programmation Orientée Objet (POO)

---

## Concepts utilisés

Ce projet met en pratique plusieurs notions importantes de Java :

- Classes et objets
- Encapsulation
- Héritage (`extends`)
- Redéfinition de méthodes (Override)
- Polymorphisme
- Getters et Setters
- Tableaux à deux dimensions
- Collections (`ArrayList`)
- Tests unitaires

---

## Compilation

Compiler le projet :

```bash
javac -cp lib/gamestests.jar -d build src/games/tictactoe/*.java src/gamestests/tictactoe/*.java

```

---

## Exécution

Lancer le jeu :

```bash
java -cp build games.tictactoe.ExecutTicTacToe
```

---

## Tests

Le projet peut être vérifié à l'aide des tests fournis :

```bash
java -cp build:lib/gamestests.jar gamestests.tictactoe.TicTacToeWithHintsTest
```

Tous les tests doivent afficher :

```
All tests OK
```

---

## Auteur

Projet réalisé par **Nawedullah Kohanpoor L2 4B Informatique** dans le cadre d'un cours de Programmation Orientée Objet en Java.