package games.players;
import java.util.Random;
import games.genericgames.Game;
import java.util.List;

/**
 * Classe representant un joueur qui choisit ses coups aleatoirement.
 *
 * Cette classe implemente l'interface Player.
 * Le joueur selectionne un coup de maniere pseudo-aleatoire
 * parmi l'ensemble des coups valides disponibles dans la situation
 * courante du jeu.
 */
public class RandomPlayer implements Player{

    /**
     * Construit un nouveau joueur aleatoire.
     *
     * @param rdm le generateur de nombres aleatoires utilise pour choisir les coups
     */
    protected Random rdm;
    public RandomPlayer(Random n){
        this.rdm = n;
    }

    /**
     * Choisit un coup aleatoire parmi les coups valides du jeu.
     *
     * La methode selectionne un indice aleatoire dans la liste
     * des coups possibles puis retourne le coup correspondant.
     *
     * @param game le jeu dans lequel le joueur doit jouer
     * @return un coup valide choisi aleatoirement
     */
    @Override 
    public int chooseMove(Game game){
        List <Integer> l = game.validMoves();
        if(l.isEmpty()){                        // je vérifie la liste 
            throw new IllegalStateException("Aucun coup valide");
        }
        int tailleList = l.size();
        return l.get(rdm.nextInt(tailleList));
    }

    @Override 
    public String toString(){  
        
        //le hash code permettant en pratique de distinguer plusieurs éventuels joueurs aléa-toires.
        return "Joueur aléatoire n° " + this.hashCode();
    }

}