package games.nim;


/**
 * Represente une partie du jeu Nim.
 * Les joueurs retirent chacun leur tour un nombre d allumettes.
 * Le joueur qui prend la derniere allumette gagne.
 */
public class Nim{

    private int n;
    private int k;
    private String firstPlayer;
    private String secondPlayer;
    private int currentAllumette;
    private String currentPlayer;
    
    /**
     * Construit une nouvelle partie de Nim.
     *
     * @param taille nombre initial d allumettes
     * @param nbMaxAllumette nombre maximum d allumettes pouvant etre retirees
     * @param j1 premier joueur
     * @param j2 second joueur
     */
    public Nim(int taille, int nbMaxAllumette, String j1,String j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.n = taille;
        this.k = nbMaxAllumette;
        this.currentAllumette = taille;
        this.currentPlayer = j1;
    }

    // accesseurs 

    /**
     * Retourne le nombre initial d allumettes.
     *
     * @return le nombre initial d allumettes
     */
    public int getInitialNbMatches(){
        return this.n;
    }

     /**
     * Retourne le nombre courant d allumettes.
     *
     * @return le nombre d allumettes restantes
     */
    public int getCurrentNbMatches(){
        return this.currentAllumette;
    }

    /**
     * Retourne le joueur courant.
     *
     * @return le joueur courant
     */
    public String getCurrentPlayer(){
        return this.currentPlayer;
    }

    // j'ajoute des getters pour que je puisse appeller mes attributs privés 


    /**
     * Retourne le premier joueur.
     *
     * @return le premier joueur
     */
    public String getFirstPlayer() {
    return firstPlayer;
    }

    /**
     * Retourne le second joueur.
     *
     * @return le second joueur
     */
    public String getSecondPlayer() {
        return secondPlayer;
    }

    /**
     * Retourne le nombre maximum d allumettes pouvant etre retirees.
     *
     * @return le nombre maximum d allumettes
     */
    public int getMaxMatches() {
        return k;
    }

    // methodes 

    /**
     * Retourne une description de la situation actuelle.
     *
     * @return une chaine de caracteres decrivant la situation
     */
    public String situationToString(){
        return "Il reste "+this.currentAllumette+" allumettes";
    }

    // cette méthode retire le nombre d'allumette et change le joueur
    /**
     * Retire des allumettes et passe au joueur suivant.
     *
     * @param nbAllumette nombre d allumettes a retirer
     */
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

    /**
     * Indique si un coup est valide.
     *
     * @param nbMatches nombre d allumettes a retirer
     * @return true si le coup est valide, false sinon
     */
    public boolean isValid(int nbMatches){
        return nbMatches > 0 && nbMatches <= this.k && nbMatches <= this.currentAllumette;

    }

    /**
     * Indique si la partie est terminee.
     *
     * @return true si la partie est terminee, false sinon
     */
    public boolean isOver(){
        return this.currentAllumette == 0;
    }

    /**
     * Retourne le gagnant de la partie.
     *
     * @return le gagnant, ou null si la partie n est pas terminee
     */
    public String getWinner(){
        if(this.isOver()){
            return this.currentPlayer;
        }
        return null;
    }
}