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


    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@.  cette méthode choisit le joueur @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    /**
     * Cree un joueur selon le type choisi.
     *
     * Si le type est "Humain", la methode demande le nom du joueur
     * puis cree un joueur humain. Si le type est "Aleatoire",
     * la methode cree un joueur aleatoire.
     *
     * @param player le type de joueur a creer
     * @param scanner le scanner utilise pour lire les saisies de l utilisateur
     * @param rand le generateur de nombres aleatoires utilise pour le joueur aleatoire
     * @return le joueur cree, ou null si le type de joueur est invalide
     */
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
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@.  cette méthode choisit le jeu.  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    /**
     * Cree un jeu selon le choix de l utilisateur.
     *
     * Si le jeu choisi est Nim, la methode demande le nombre
     * initial d allumettes ainsi que le nombre maximal
     * d allumettes pouvant etre retirees a chaque tour.
     * Si le jeu choisi est TicTacToe, la methode demande
     * si les indices doivent etre actives ou non.
     *
     * @param gameName le nom du jeu a creer
     * @param scanner le scanner utilise pour lire les saisies de l utilisateur
     * @param j1 le premier joueur
     * @param j2 le deuxieme joueur
     * @return le jeu cree, ou null si le nom du jeu est invalide
     */
    public static AbstractGame chooseGame(String gameName,Scanner scanner,Player j1, Player j2){
        AbstractGame game =null;
        int nbInitialTaile;
        int nbMaxAllumette;
        if(gameName.equalsIgnoreCase("Nim")){  

            System.out.println("Entrez la taille initiale allumettes :");
            while(!scanner.hasNextInt()){    							// évite de planter si ce n'est pas en entier
				System.out.println("Erreur : Veuillez entrer un entier !");
				scanner.next();
				System.out.println("Entrez la taille initiale allumettes :");
							
			}
            nbInitialTaile  = scanner.nextInt();

            System.out.println("Entrez le nombre maximale d allumettes :");
            while(!scanner.hasNextInt()){    							// évite de planter si ce n'est pas en entier
				System.out.println("Erreur : Veuillez entrer un entier !");
				scanner.next();
				System.out.println("Entrez le nombre maximale d allumettes :");
							
			}
            nbMaxAllumette  = scanner.nextInt();
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