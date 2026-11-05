package games.factoredgames;



public class Nim extends AbstractGame{

    private int n;
    private int k;
    private int currentAllumette;
    
    
    public Nim(int taille, int nbMaxAllumette, String j1,String j2){
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
    // j'ajoute des getters pour que je puisse appeller mes attributs 

    /* 
    public String getFirstPlayer() {
    return super.firstPlayer;
    }
    public String getSecondPlayer() {
        return super.secondPlayer;
    }
    */

    public int getMaxMatches() {
        return k;
    }

    // methodes 

    public String situationToString(){
        return "Il reste "+this.currentAllumette+" allumettes";
    }

    // cette méthode retire le nombre d'allumette et change le joueur
    @Override 
    public void execute(int nbAllumette){
        if(!isValid(nbAllumette)){     // vérifie le nombre d'allumette que joueur retire 
            System.out.println("Coup invalid !");
        } 
        this.currentAllumette -= nbAllumette;
        if(super.currentPlayer.equals(super.firstPlayer)){
            super.currentPlayer = super.secondPlayer;
        }
        else{
            super.currentPlayer = super.firstPlayer;
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
            return super.currentPlayer;
        }
        return null;
    }
}