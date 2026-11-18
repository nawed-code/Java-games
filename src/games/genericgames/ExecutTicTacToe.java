package games.genericgames;
import java.util.Scanner;
import games.players.Human;
import games.players.Player;


public class ExecutTicTacToe{
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

                System.out.println("Entrez le premier joueur :");
                Player j1 = new Human(scanner.next(),scanner);

                System.out.println("Entrez le deuxieme joueur :");
                Player j2 = new Human(scanner.next(),scanner);
                
                String answer;
                TicTacToe play;
                while(true){

                        System.out.println("Voulez-vous jouer avec ou sans indices ? oui / non ");
                        answer = scanner.next();

                        if(answer.equals("oui")){
                                play = new TicTacToeWithHints(j1,j2);
                                break;
                        }
                        else if(answer.equals("non")){
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
                System.out.println("C'est a "+play.getCurrentPlayer() +" de jouer");
                System.out.println("Votre coup : ");
                int numOfCase;
                do{
                        System.out.println(" - Entrer le numero de la case ? ");
                        while(!scanner.hasNextInt()){    							// évite de planter si ce n'est pas en entier
							System.out.println("Erreur : Veuillez entrer un entier !");
							scanner.next();
							System.out.println(" - Entrer le numero de la case ? ");
							
						}
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























