package games.genericgames;



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

    public int getMaxMatches() {
        return k;
    }

    // methodes 

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
