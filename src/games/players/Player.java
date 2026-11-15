package games.players;
import games.genericgames.Game;


/**
 * Represente un joueur capable de choisir un coup.
 */
public interface Player {

    /**
     * Choisit un coup a jouer.
     *
     * @param game jeu en cours
     * @return le coup choisi
     */
    public int chooseMove(Game game);

    
}