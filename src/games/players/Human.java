package games.players;
import java.util.Scanner;
import java.util.List;

import games.genericgames.Game;


public class Human implements Player {

    protected String name;
    protected Scanner scanner;
    public Human(String name, Scanner scan ){
        this.name = name;
        this.scanner = scan;
    }

    /**
     * Choisit un coup pour le joueur humain.
     *
     * Cette methode affiche les coups valides possibles,
     * demande au joueur de saisir un coup via le Scanner,
     * et redemande une saisie tant que le coup choisi
     * n'est pas valide.
     *
     * @param game le jeu dans lequel le joueur doit effectuer un coup
     * @return le coup choisi par le joueur
     */
    @Override 
    public int chooseMove(Game game){
        int coupValide;
        List <Integer> l = game.validMoves();
        for(int i : l){
            System.out.println(game.moveToString(i));
        }
        do{
            System.out.println("Veuillez choisir un coup valide !");
                while(!scanner.hasNextInt()){    	
					System.out.println("Erreur : Veuillez entrer un nombre valide !");
					scanner.next();
						
				}
            coupValide = scanner.nextInt();
            if(l.contains(coupValide)){
                break;
            }
        }while(true);
        return coupValide;

    }

    /**
     * Retourne le nom du joueur.
     *
     * @return le nom du joueur
     */
    @Override 
    public String toString(){
        return this.name;
    }
    
}