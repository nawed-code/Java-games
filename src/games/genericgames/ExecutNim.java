package games.genericgames;
import java.util.Scanner;

import games.players.Human;
import  games.players.Player;

public class ExecutNim{

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez le premier joueur :");
            Player j1 = new Human(scanner.next(), scanner);

            System.out.println("Entrez le deuxieme joueur :");
            Player j2 = new Human(scanner.next(), scanner);  

            System.out.println("Entrez la taille initiale allumettes :");
            while (!scanner.hasNextInt()){
                System.out.println("Erreur : Entrez un entier :");
                scanner.next();     //vide le scanner
                System.out.println("Entrez la taille initiale allumettes :");
            }
            int nbInitialTaile  = scanner.nextInt();

            System.out.println("Entrez le nombre maximale d allumettes :");
            while (!scanner.hasNextInt()){
                System.out.println("Erreur : Entrez un entier :");
                scanner.next();
                System.out.println("Entrez le nombre maximale d allumettes :");
            }
            int nbMaxAllumette  = scanner.nextInt();

            Nim play = new Nim(nbInitialTaile , nbMaxAllumette , j1, j2);

            System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
            System.out.println("Nom du second joueur : "+play.getSecondPlayer());
            System.out.println("Nombre maximal : "+play.getMaxMatches());

            while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("le tour de "+play.getCurrentPlayer());
                int nbRetiree;
                do{
                    System.out.println("Combien retirez-vous ? ");
                    while (!scanner.hasNextInt()){
                        System.out.println("Erreur : Entrez un entier :");
                        scanner.next();
                        System.out.println("Combien retirez-vous ? ");
                    }
                    nbRetiree = scanner.nextInt();
                    if (!play.isValid(nbRetiree)){
                        System.out.println("Vous devez retirer entre 1 et "+ play.getMaxMatches() + " allumettes.");
                    
                    }

                }while(!play.isValid(nbRetiree));
                
                play.execute(nbRetiree);

            }
            System.out.println("Le jeu est termine");
            System.out.println("Le gagnant est : "+play.getWinner());
            scanner.close();

        }


} 
