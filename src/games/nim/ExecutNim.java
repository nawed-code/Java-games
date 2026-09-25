package nim;
import java.util.Scanner;

public class ExecutNim{

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez le premier joueur :");
            String j1 = scanner.next();

            System.out.println("Entrez le deuxième joueur :");
            String j2 = scanner.next();   

            System.out.println("Entrez la taille initiale d'allumettes :");
            String initialTaile  = scanner.next();
            int nbInitialTaile = Integer.parseInt(initialTaile);

            System.out.println("Entrez le nombre maximale d'allumettes :");
            String maxAllumette  = scanner.next();
            int nbMaxAllumette = Integer.parseInt(maxAllumette);

            Nim play = new Nim(nbInitialTaile , nbMaxAllumette , j1, j2);

            System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
            System.out.println("Nom du second joueur : "+play.getSecondPlayer());
            System.out.println("Nombre maximal : "+play.getMaxMatches());

            while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("le tour de "+play.getCurrentPlayer());
                System.out.println("Combien retirez-vous ? ");
                String retireAllumete = scanner.next();
                int nbRetiree = Integer.parseInt(retireAllumete);
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