package games.nim;
import java.util.Scanner;

public class ExecutNim{

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez le premier joueur :");
            String j1 = scanner.next();

            System.out.println("Entrez le deuxième joueur :");
            String j2 = scanner.next();   

            System.out.println("Entrez la taille initiale d'allumettes :");
            while (!scanner.hasNextInt()){
                System.out.println("Erreur : Entrez un entier !");
                scanner.next();
                System.out.println("Entrez la taille initiale d'allumettes :");
            }
            int nbInitialTaile = scanner.nextInt();

            System.out.println("Entrez le nombre maximale d'allumettes :");
            while (!scanner.hasNextInt()){
                System.out.println("Erreur : Entrez un entier !");
                scanner.next();
                System.out.println("Entrez le nombre maximale d'allumettes :");            }
            int nbMaxAllumette = scanner.nextInt();

            Nim play = new Nim(nbInitialTaile , nbMaxAllumette , j1, j2);

            System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
            System.out.println("Nom du second joueur : "+play.getSecondPlayer());
            System.out.println("Nombre maximal : "+play.getMaxMatches());

            while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("le tour de "+play.getCurrentPlayer());
                System.out.println("Combien retirez-vous ? ");
                while (!scanner.hasNextInt()){
                    System.out.println("Erreur : Entrez un entier !");
                    scanner.next();
                    System.out.println("Combien retirez-vous ? ");
                }
                int nbRetiree = scanner.nextInt();
                if (!play.isValid(nbRetiree)){
                    System.out.println("Coup invalide !");
                    continue;
                }
                play.removeMatches(nbRetiree);

            }
            System.out.println("Le jeu est terminé");
            System.out.println("Le gagnant est : "+play.getWinner());
            scanner.close();

        }


} 