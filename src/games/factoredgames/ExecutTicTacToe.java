package games.factoredgames;
import java.util.Scanner;
public class ExecutTicTacToe{
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
                System.out.println("Voulez-vous jouer avec ou sans indices ? oui / non ");
                String answer = scanner.next();
                TicTacToe play;
                
                if (answer.equals("oui")) {
                        play = new TicTacToeWithHints(j1,j2);
                }
                else if (answer.equals("non")) {
                        play = new TicTacToe(j1, j2);                        
                }
                
                else {
                        
                }

		System.out.println("Entrez le premier joueur :");
                String j1 = scanner.next();

                System.out.println("Entrez le deuxieme joueur :");
                String j2 = scanner.next();

                System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
                System.out.println("Nom du second joueur : "+play.getSecondPlayer());
                
        while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("C'est a "+play.getCurrentPlayer() +" de jouer");
                System.out.println("Votre coup : ");
                int numOfCase;
                do{
                        System.out.println(" - Entrer le numero de la case ? ");
                        numOfCase = scanner.nextInt();
                        
                        if(!play.isValid(numOfCase)){
                                System.out.println("Le numeros de case est invalide !");
                        }
                        
                }while(!play.isValid(numOfCase));
                play.execute(numOfCase);

        }
        
        System.out.println("Le jeu est termine");
        System.out.println(play.situationToString());
        System.out.println("Le gagnant est : "+play.getWinner());
        scanner.close();
		
	}
	
}























