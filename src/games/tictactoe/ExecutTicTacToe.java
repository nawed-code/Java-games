package games.tictactoe;
import java.util.Scanner;




public class ExecutTicTacToe{
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Entrez le premier joueur :");
                String j1 = scanner.next();

                System.out.println("Entrez le deuxième joueur :");
                String j2 = scanner.next();
                TicTacToe play=null;
                String answer="";
                while (true){
                        System.out.println("Voulez-vous jouer avec ou sans indices ? oui / non ");
                        answer = scanner.next();
                        if (answer.equalsIgnoreCase("oui")) {
                                play = new TicTacToeWithHints(j1,j2);
                                break;
                        } 
                        else if (answer.equalsIgnoreCase("non")) {
                                play = new TicTacToe(j1,j2);
                                break;
                        } 
                        else{
                                System.out.println("Réponse invalide !");
                        }  
                }
                System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
                System.out.println("Nom du second joueur : "+play.getSecondPlayer());
                
        
        while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("C'est à "+play.getCurrentPlayer() +" de jouer");
                System.out.println("Votre coup : ");
                
                System.out.println(" - rangée ? ");
                while (!scanner.hasNextInt()){
                        System.out.println("Erreur : Entrez un entier");
                        scanner.next();
                        System.out.println(" - rangée ? ");
                }
                int numOfLine = scanner.nextInt(); 
                
                System.out.println(" - colonne ? ");
                while (!scanner.hasNextInt()){
                        System.out.println("Erreur : Entrez un entier");
                        scanner.next();
                        System.out.println(" - colonne ? ");
                }
                
                int numOfColumn = scanner.nextInt();
                if(!play.isValid(numOfLine , numOfColumn)){
			System.out.println("Invalid !");
			continue;
		}
                play.execute(numOfLine , numOfColumn);
               

        }
        
        System.out.println("Le jeu est terminé");
        System.out.println(play.situationToString());
        System.out.println("Le gagnant est : "+play.getWinner());
        scanner.close();
		
	}
	
}























