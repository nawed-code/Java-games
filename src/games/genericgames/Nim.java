package games.genericgames;

import games.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe representant le jeu de Nim.
 *
 * Le jeu commence avec un certain nombre d'allumettes.
 * A chaque tour, le joueur courant retire entre une et un
 * nombre maximal d'allumettes autorise.
 * Le joueur qui retire la derniere allumette remporte la partie.
 *
 * Cette classe herite de AbstractGame et implemente les
 * fonctionnalites specifiques au jeu de Nim.
 */

public class Nim extends AbstractGame{
    //Comme AbstractGame implémente Game, toutes les classes qui héritent de AbstractGame sont aussi des Game.

    /**
     * Construit une nouvelle partie de Nim.
     *
     * @param taille le nombre initial d'allumettes
     * @param nbMaxAllumette le nombre maximal d'allumettes pouvant etre retirees a chaque tour
     * @param j1 le premier joueur
     * @param j2 le second joueur
     */

    protected  int n;
    protected int k;
    protected int currentAllumette;
    
    
    public Nim(int taille, int nbMaxAllumette, Player j1,Player j2){
        super(j1 , j2);
        this.n = taille;
        this.k = nbMaxAllumette;
        this.currentAllumette = taille;
        
    }

    // accesseurs 

    public int getInitialNbMatches(){
        /**
         * Retourne le nombre initial d'allumettes.
         *
         * @return le nombre initial d'allumettes
         */
        return this.n;
    }

    public int getCurrentNbMatches(){
        /**
         * Retourne le nombre actuel d'allumettes.
         *
         * @return le nombre actuel d'allumettes
         */
        return this.currentAllumette;
    }

    public int getMaxMatches() {
        /**
         * Retourne le nombre maximal d'allumettes pouvant etre retirees.
         *
         * @return le nombre maximal d'allumettes
         */
        return k;
    }

    // methodes 
    @Override 
    public String situationToString(){
        /**
         * Retourne une description de la situation courante.
         *
         * @return une chaine de caracteres decrivant la situation du jeu
         */

        return "Il reste "+this.currentAllumette+" allumettes";
    }

    //Une methode public peut etre appelee par n'importe qui.
    //Une methode protected est reservee :a la classe elle-meme et  aux classes qui heritent.

    // cette methode retire le nombre d allumette 
    @Override 
    protected void doExecute(int nbAllumette){
        /**
         * Execute le coup demande en retirant les allumettes.
         *
         * @param nbAllumette le nombre d'allumettes a retirer
         */

        if(!isValid(nbAllumette)){              // verifie le nombre d allumette que joueur retire 
            System.out.println("Coup invalid !");
            return ;
        } 
        this.currentAllumette -= nbAllumette;
    }  
    @Override 
    public boolean isValid(int nbMatches){
        /**
         * Indique si le coup est valide.
         *
         * @param nbMatches le nombre d'allumettes que le joueur souhaite retirer
         * @return true si le coup est valide, false sinon
         */
        return nbMatches > 0 && nbMatches <= this.k && nbMatches <= this.currentAllumette;

    }
    @Override 
    public boolean isOver(){
        /**
         * Indique si la partie est terminee.
         *
         * @return true si toutes les allumettes ont ete retirees, false sinon
         */
        return this.currentAllumette == 0;
    }

    @Override 
    public Player getWinner(){
        /**
         * Retourne le gagnant de la partie.
         *
         * @return le joueur gagnant si la partie est terminee, sinon null
         */
        if(this.isOver()){
            return super.currentPlayer;
        }
        return null;
    }

    @Override 
    public List<Integer> validMoves(){
        /**
         * Retourne la liste des coups valides pour le joueur courant.
         *
         * @return la liste des coups valides
         */
        
        List<Integer> moveList = new ArrayList<>(); 
        int taille;
        if(this.currentAllumette >= this.k){
            taille = this.k;
        }
        else{
            taille = this.currentAllumette;
        }
        for(int i=0; i <= taille -1; i++){
            moveList.add(i+1);
        }
        return moveList;
    }
    @Override 
    public String moveToString(int move){
        /**
        * Retourne une representation sous forme de chaine du coup donne.
        *
        * @param move le coup a convertir en chaine de caracteres
        * @return une chaine representant le coup
        */
        
        return "Retire "+move+" allumettes";
    }

    @Override 
    public Game copy(){
        /**
         * Retourne une copie de la partie dans son etat actuel.
         *
         * @return une nouvelle instance du jeu ayant le meme etat que la partie courante
         */

        Nim copyGame = new Nim(this.getInitialNbMatches(), this.getMaxMatches(), getFirstPlayer(), getSecondPlayer());
        copyGame.currentAllumette = this.getCurrentNbMatches();
        copyGame.currentPlayer = super.currentPlayer;
        return copyGame;

    }

}
