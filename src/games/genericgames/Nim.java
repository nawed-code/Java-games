package games.genericgames;

import games.players.Player;

import java.util.ArrayList;
import java.util.List;

public class Nim extends AbstractGame{
    //Comme AbstractGame implémente Game, toutes les classes qui héritent de AbstractGame sont aussi des Game.

    private int n;
    private int k;
    private int currentAllumette;
    
    
    public Nim(int taille, int nbMaxAllumette, Player j1,Player j2){
        super(j1 , j2);
        this.n = taille;
        this.k = nbMaxAllumette;
        this.currentAllumette = taille;
        
    }

    // accesseurs 

    public int getInitialNbMatches(){
        return this.n;
    }

    public int getCurrentNbMatches(){
        return this.currentAllumette;
    }

    public int getMaxMatches() {
        return k;
    }

    // methodes 
    @Override 
    public String situationToString(){
        return "Il reste "+this.currentAllumette+" allumettes";
    }

    // cette methode retire le nombre d allumette 
    @Override 
    protected void doExecute(int nbAllumette){
        if(!isValid(nbAllumette)){              // verifie le nombre d allumette que joueur retire 
            System.out.println("Coup invalid !");
            return ;
        } 
        this.currentAllumette -= nbAllumette;
    }  
    @Override 
    public boolean isValid(int nbMatches){
        return nbMatches > 0 && nbMatches <= this.k && nbMatches <= this.currentAllumette;

    }
    @Override 
    public boolean isOver(){
        return this.currentAllumette == 0;
    }

    @Override 
    public Player getWinner(){
        if(this.isOver()){
            return super.currentPlayer;
        }
        return null;
    }

    @Override 
    public List<Integer> validMoves(){
        
        List<Integer> moveList = new ArrayList<>(); 
        if(this.currentAllumette >= this.k){
            
            for(int i=0; i <= this.k -1; i++){
                moveList.add(i+1);
            }
            return moveList;
        }
        else{
            
            for(int i=0; i <= this.currentAllumette -1; i++){
                moveList.add(i+1);
            }
            return moveList;
        }
    }

    public String moveToString(int move){
        /**
        * Retourne une representation sous forme de chaine du coup donne.
        *
        * @param move le coup a convertir en chaine de caracteres
        * @return une chaine representant le coup
        */
        
        return "Retire "+move+" allumettes";
    }
}
