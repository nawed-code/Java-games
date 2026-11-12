package games.players;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import games.genericgames.Game;


public class Human implements Player {

    protected String name;
    protected Scanner scanner;
    public Human(String name, Scanner scan ){
        this.name = name;
        this.scanner = scan;
    }

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
    
}