package games.factoredgames;


/**
 * Classe abstraite representant un jeu a deux joueurs.
 * Elle gere les joueurs et le changement de tour.
 */
public abstract class AbstractGame{

    protected  String firstPlayer;
    protected String secondPlayer;
    protected String currentPlayer;

    /**
     * Construit un nouveau jeu.
     *
     * @param j1 premier joueur
     * @param j2 second joueur
     */
    public AbstractGame(String j1, String j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.currentPlayer = j1;

    }

    /**
     * Execute le coup specifique au jeu.
     *
     * @param n coup a executer
     */
    protected abstract void doExecute(int n);


     /**
     * Execute un coup puis passe au joueur suivant.
     *
     * @param n coup a executer
     */
    public void execute(int n){
        doExecute(n);
        if(this.firstPlayer.equals(this.getCurrentPlayer())){
            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.currentPlayer = this.firstPlayer;
        }
    }

    /**
     * Retourne le joueur courant.
     *
     * @return le joueur courant
     */
    public String getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * Retourne le premier joueur.
     *
     * @return le premier joueur
     */
    public String getFirstPlayer(){
        return this.firstPlayer;
    } 

    /**
     * Retourne le second joueur.
     *
     * @return le second joueur
     */
    public String getSecondPlayer(){
        return this.secondPlayer;
    }

}



