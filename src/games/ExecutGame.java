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



    public static Player choosePlayer(String player,Scanner scanner, Random rand){  // j'utilise static car j'appelle cette methode avec main qui est static
        Player joueur=null;

        if(player.equalsIgnoreCase("Humain") ){
            System.out.println("Entrez le nom du joueur :");
            String name = scanner.next();
            joueur = new Human(name,scanner);
            
        }
        else if(player.equalsIgnoreCase("Aleatoire")){
            joueur = new RandomPlayer(rand);
            
        }
        return joueur;
        
    }

    public static AbstractGame chooseGame(String gameName,Scanner scanner,Player j1, Player j2){
        AbstractGame game =null;
        if(gameName.equalsIgnoreCase("Nim")){  

            System.out.println("Entrez la taille initiale allumettes :");
            int nbInitialTaile  = scanner.nextInt();

            System.out.println("Entrez le nombre maximale d allumettes :");
            int nbMaxAllumette  = scanner.nextInt();
            game = new Nim(nbInitialTaile , nbMaxAllumette , j1, j2);
            
        }
        if(gameName.equalsIgnoreCase("TicTacToe")){
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
        }
        return game;
    }



    public static void main(String[] args){

        Random rand = new Random(123);          // un objet alieatoire 
        Scanner scanner = new Scanner(System.in);
        AbstractGame game=null;
        String firstPlayerAnswer;
        String secondPlayerAnswer;
        Player j1=null;
        Player j2=null;


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     choisir le joueur     @@@@@@@@@@@@@@@@@@@@@@@@
        
        while (true) {
            System.out.println("Veuillez choisir le premier joueur !  Humain / aleatoire ?");
            firstPlayerAnswer= scanner.next();
            j1 = choosePlayer(firstPlayerAnswer,scanner,rand);
            if(j1!=null){
                break;
            }
            System.out.println("Réponse invalide !");
        }
            
        while (true) {
            System.out.println("Veuillez choisir le deuxieme joueur !  Humain / Aleatoire ?");
            secondPlayerAnswer = scanner.next();
            j2 = choosePlayer(secondPlayerAnswer,scanner,rand);
            if(j2!=null){
                break;
            }
            System.out.println("Réponse invalide !");
        }


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     choisir le jeu      @@@@@@@@@@@@@@@@@@@@@@@@
        while (true){
            
            System.out.println("Quel jeu voulez-vous jouer ?  Nim / TicTacToe");
            String gameName = scanner.next();
            game = chooseGame(gameName, scanner,j1,j2);
            if (game!=null) {
                break;                
            }
            System.out.println("Réponse invalide !");

        }
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();

    }
}