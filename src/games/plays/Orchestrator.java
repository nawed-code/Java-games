package games.plays;
import games.genericgames.Game;
import games.players.Player;


/**
 * Gere le deroulement complet d une partie.
 * Cette classe fait jouer les joueurs jusqu a la fin du jeu.
 */
public class Orchestrator{
    /** Jeu gere par cet orchestrateur. */
    protected Game game;    //variable de type Game qui protegee
    
    /**
     * Construit un nouvel orchestrateur.
     *
     * @param g jeu a gerer
     */
    public Orchestrator(Game g){
        this.game = g;
    }


    /**
     * Lance et gere le deroulement de la partie.
     * Les joueurs jouent chacun leur tour jusqu a la fin du jeu.
     * Le gagnant est ensuite affiche.
     */
    public void play(){

        System.out.println("Le premier joueur est :"+game.getFirstPlayer());
        System.out.println("Le second joueur est :"+game.getSecondPlayer());

        while (!game.isOver()){
            System.out.println(game.situationToString());
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("Le tour de "+currentPlayer);
            int coupValide  = currentPlayer.chooseMove(game);
            game.execute(coupValide);
            System.out.println("Le joueur "+currentPlayer+" vient de jouer -> "+coupValide);

        }
        System.out.println("Le jeu est termine");
        System.out.println("Le gagnant est : "+game.getWinner());
    }

}