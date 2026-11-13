package games.factoredgames;

/**
 * Represente une partie du jeu Nim.
 * Les joueurs retirent chacun leur tour un nombre d allumettes.
 * Le joueur qui prend la derniere allumette gagne.
 */
public class Nim extends AbstractGame {

    /** Nombre initial d allumettes. */
    private int n;

    /** Nombre maximum d allumettes pouvant etre retirees en un coup. */
    private int k;

    /** Nombre courant d allumettes restantes. */
    private int currentAllumette;

    /**
     * Construit une nouvelle partie de Nim.
     *
     * @param taille nombre initial d allumettes
     * @param nbMaxAllumette nombre maximum d allumettes pouvant etre retirees
     * @param j1 premier joueur
     * @param j2 second joueur
     */
    public Nim(int taille, int nbMaxAllumette, String j1, String j2) {
        super(j1, j2);
        this.n = taille;
        this.k = nbMaxAllumette;
        this.currentAllumette = taille;
    }

    /**
     * Retourne le nombre initial d allumettes.
     *
     * @return le nombre initial d allumettes
     */
    public int getInitialNbMatches() {
        return this.n;
    }

    /**
     * Retourne le nombre courant d allumettes.
     *
     * @return le nombre d allumettes restantes
     */
    public int getCurrentNbMatches() {
        return this.currentAllumette;
    }

    /**
     * Retourne le nombre maximum d allumettes pouvant etre retirees.
     *
     * @return le nombre maximum d allumettes
     */
    public int getMaxMatches() {
        return k;
    }

    /**
     * Retourne une description de la situation actuelle.
     *
     * @return une chaine de caracteres decrivant la situation
     */
    public String situationToString() {
        return "Il reste " + this.currentAllumette + " allumettes";
    }

    /**
     * Execute un coup en retirant des allumettes.
     *
     * @param nbAllumette nombre d allumettes a retirer
     */
    @Override
    protected void doExecute(int nbAllumette) {
        if (!isValid(nbAllumette)) {
            System.out.println("Coup invalid !");
            return;
        }
        this.currentAllumette -= nbAllumette;
    }

    /**
     * Indique si un coup est valide.
     *
     * @param nbMatches nombre d allumettes a retirer
     * @return true si le coup est valide, false sinon
     */
    public boolean isValid(int nbMatches) {
        return nbMatches > 0
            && nbMatches <= this.k
            && nbMatches <= this.currentAllumette;
    }

    /**
     * Indique si la partie est terminee.
     *
     * @return true si la partie est terminee, false sinon
     */
    public boolean isOver() {
        return this.currentAllumette == 0;
    }

    /**
     * Retourne le gagnant de la partie.
     *
     * @return le gagnant, ou null si la partie n est pas terminee
     */
    public String getWinner() {
        if (this.isOver()) {
            return super.currentPlayer;
        }
        return null;
    }
}