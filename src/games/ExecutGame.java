package games;

import games.genericgames.TicTacToe;
import games.genericgames.TicTacToeWithHints;
import java.util.Random;
import java.util.Scanner;
import games.genericgames.Nim;
import games.players.Human;
import games.players.Player;
import games.players.RandomPlayer;
import games.plays.Orchestrator;

public class ExecutGame{

    public static void main(String[] args){

        
        Random rand = new Random(123);          // un objet alieatoire 
        Scanner scanner = new Scanner(System.in);
        AbstractGame game=null;
        String firstPlayerAnswer;
        String secondPlayerAnswer;
        Player j1=null;
        Player j2=null;
        while(true){

            System.out.println("Veuillez choisir le premier joueur !  Humain / aleatoire ?");
            firstPlayerAnswer = scanner.next();

            if(firstPlayerAnswer.equalsIgnoreCase("Humain") ){
                System.out.println("Entrez le premier joueur :");
                j1 = new Human(scanner.next(),scanner);

                while (true){
                    System.out.println("Veuillez choisir le deuxieme joueur !  Humain / Aleatoire ?");
                    secondPlayerAnswer = scanner.next();
                    if(secondPlayerAnswer.equalsIgnoreCase("Humain")){
                        System.out.println("Entrez le deuxieme joueur :");
                        j2 = new Human(scanner.next(),scanner); 
                        break;
                    }
                    else if(secondPlayerAnswer.equalsIgnoreCase("Aleatoire")){
                    j2 = new RandomPlayer(rand); 
                    break;
                    }
                    else{
                        System.out.println("Réponse invalide !");
                    }
                }
                break;

            }

            else if(firstPlayerAnswer.equalsIgnoreCase("Aleatoire")){
                j1 = new RandomPlayer(rand);

                while (true) {
                    System.out.println("Veuillez choisir le deuxieme joueur !  Humain / aleatoire ?");
                    secondPlayerAnswer = scanner.next();
                    if(secondPlayerAnswer.equalsIgnoreCase("Humain")){
                        System.out.println("Entrez le deuxieme joueur :");
                        j2 = new Human(scanner.next(),scanner); 
                        break;
                    }
                    else if(secondPlayerAnswer.equalsIgnoreCase("Aleatoire")){
                    j2 = new RandomPlayer(rand); 
                    break;
                    }
                    else{
                        System.out.println("Réponse invalide !");
                    }
                
                }
                break;

            }
            else{
                System.out.println("Réponse invalide !");
            }
        }

        while (true){

            System.out.println("Quel jeu voulez-vous jouer ?  Nim / TicTacToe");
            String gameName = scanner.next();

            if(gameName.equals("Nim") || gameName.equals("nim")){  

                System.out.println("Entrez la taille initiale allumettes :");
                int nbInitialTaile  = scanner.nextInt();

                System.out.println("Entrez le nombre maximale d allumettes :");
                int nbMaxAllumette  = scanner.nextInt();
                game = new Nim(nbInitialTaile , nbMaxAllumette , j1, j2);
                break;
            }
            else if(gameName.equals("TicTacToe") || gameName.equals("tictactoe")){
                String answer;
                while(true){

                    System.out.println("Voulez-vous jouer avec ou sans indices ? oui / non ");
                    answer = scanner.next();

                    if(answer.equals("oui")){
                        game = new TicTacToeWithHints(j1,j2);
                        break;
                    }
                    else if(answer.equals("non")){
                        game = new TicTacToe(j1,j2);
                        break;
                    }
                    else{
                            System.out.println("Réponse invalide !");
                    }
                }
                break;
            }
            else{
                System.out.println("Réponse invalide !");
            }
        }

        
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();

    }
}