package nim;
import java.util.Scanner;

public class Nim{

    private int n;
    private int k;
    private String firstPlayer;
    private String secondPlayer;
    private int currentAllumette;
    private String currentPlayer;
    
    public Nim(int taille, int nbMaxAllumette, String j1,String j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.n = taille;
        this.k = nbMaxAllumette;
        this.currentAllumette = taille;
        this.currentPlayer = j1;
    }

    // accesseurs 

    public int getInitialNbMatches(){
        return this.n;
    }

    public int getCurrentNbMatches(){
        return this.currentAllumette;
    }

    public String getCurrentPlayer(){
        return this.currentPlayer;
    }

    // j'ajoute des getters pour que je puisse appeller mes attributs privés 

    public String getFirstPlayer() {
    return firstPlayer;
    }
    public String getSecondPlayer() {
        return secondPlayer;
    }
    public int getMaxMatches() {
        return k;
    }

    // methodes 

    public String situationToString(){
        return "Il reste "+this.currentAllumette+" allumettes";
    }

    // cette méthode retire le nombre d'allumette et change le joueur
    public void removeMatches(int nbAllumette){
        if(!isValid(nbAllumette)){     // vérifie le nombre d'allumette que joueur retire 
            System.out.println("Coup invalid !");
        } 
        this.currentAllumette -= nbAllumette;
        if(this.currentPlayer.equals(this.firstPlayer)){
            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.currentPlayer = this.firstPlayer;
        }
        
    }

    public boolean isValid(int nbMatches){
        return nbMatches > 0 && nbMatches <= this.k && nbMatches <= this.currentAllumette;

    }

    public boolean isOver(){
        return this.currentAllumette == 0;
    }

    public String getWinner(){
        if(this.isOver()){
            return this.currentPlayer;
        }
        return null;
    }
}