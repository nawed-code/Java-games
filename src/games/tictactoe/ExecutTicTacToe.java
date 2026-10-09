package games.tictactoe;
import java.util.Scanner;




public class ExecutTicTacToe{
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
                System.out.println("Voulez-vous jouer avec ou sans indices ? oui / non ");
                String answer = scanner.next();

		System.out.println("Entrez le premier joueur :");
                String j1 = scanner.next();

                System.out.println("Entrez le deuxième joueur :");
                String j2 = scanner.next();
                TicTacToe play;
                if (answer.equals("oui")) {
                        play = new TicTacToeWithHints(j1,j2);
                } else {
                        play = new TicTacToe(j1,j2);
                }
                System.out.println("Nom du premier joueur : "+play.getFirstPlayer());
                System.out.println("Nom du second joueur : "+play.getSecondPlayer());
                
        
        while(!play.isOver()){
                
                System.out.println(play.situationToString());
                System.out.println("C'est à "+play.getCurrentPlayer() +" de jouer");
                System.out.println("Votre coup : ");
                
                System.out.println(" - rangée ? ");
                String lineNum = scanner.next();
                int numOfLine = Integer.parseInt(lineNum); 
                
                
                System.out.println(" - colonne ? ");
                String columnNum = scanner.next();
                int numOfColumn = Integer.parseInt(columnNum);
                
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























