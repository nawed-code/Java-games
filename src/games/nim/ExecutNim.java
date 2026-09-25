import java.util.Scanner;


package nim;
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


        }


} 