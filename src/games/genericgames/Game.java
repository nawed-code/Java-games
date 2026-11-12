package games.genericgames;
import games.players.Player;
import java.util.List;

/**
 * Interface representant un jeu a deux joueurs.
 *
 * Cette interface definit les methodes communes
 * que toutes les classes representant un jeu
 * doivent implementer.
 */

public interface Game {

    /**
     * Indique si un coup est valide.
     *
     * @param move le coup a verifier
     * @return true si le coup est valide, false sinon
     */
    public boolean isValid(int move);

    /**
     * Execute le coup donne.
     *
     * @param move le coup a executer
     */
    public void execute(int move);

    /**
     * Indique si la partie est terminee.
     *
     * @return true si la partie est terminee, false sinon
     */
    public boolean isOver();

    /**
     * Retourne le joueur gagnant.
     *
     * @return le joueur gagnant ou null si aucun joueur n'a gagne
     */
    public Player getWinner();

    /**
     * Retourne le joueur courant.
     *
     * @return le joueur courant
     */
    public Player getCurrentPlayer();

    /**
     * Retourne la liste des coups valides pour le joueur courant.
     *
     * @return la liste des coups valides
     */
    public List<Integer> validMoves();

    /**
     * Retourne une representation sous forme de chaine du coup donne.
     *
     * @param move le coup a convertir en chaine de caracteres
     * @return une chaine representant le coup
     */
    public String moveToString(int move);

    /**
     * Retourne une representation de la situation courante du jeu.
     *
     * @return une chaine representant la situation du jeu
     */
    public String situationToString();

    /**
     * Retourne une copie de la partie dans son etat actuel.
     *
     * @return une nouvelle instance du jeu ayant le meme etat que la partie courante
     */
    public Game copy();
    
}