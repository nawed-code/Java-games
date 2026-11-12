package games.genericgames;
import games.players.Player;


/**
 * Classe abstraite representant un jeu a deux joueurs.
 *
 * Cette classe implemente les fonctionnalites communes
 * a tous les jeux, comme la gestion des joueurs et
 * le changement de joueur apres chaque coup.
 * Les classes filles doivent definir la maniere
 * d'executer un coup en implementant la methode doExecute.
 */
public abstract class AbstractGame implements Game{

    /**
     * Construit une nouvelle partie avec deux joueurs.
     *
     * @param j1 le premier joueur
     * @param j2 le second joueur
     */

    protected  Player firstPlayer;
    protected Player secondPlayer;
    protected Player currentPlayer;

    public AbstractGame(Player j1, Player j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.currentPlayer = j1;

    }

    /**
     * Execute le coup specifique au jeu.
     *
     * Cette methode est implementee par les classes filles.
     *
     * @param n le coup a executer
    */
    protected abstract void doExecute(int n);


    /**
     * Execute un coup puis change le joueur courant.
     *
     * @param n le coup a executer
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
    @Override 
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * Retourne le premier joueur.
     *
     * @return le premier joueur
     */
    public Player getFirstPlayer(){
        return this.firstPlayer;
    } 

    /**
     * Retourne le second joueur.
     *
     * @return le second joueur
     */
    public Player getSecondPlayer(){
        return this.secondPlayer;
    }

}



