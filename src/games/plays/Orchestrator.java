package games.plays;
import games.genericgames.Game;
import games.players.Player;



public class Orchestrator{

    protected Game game;
    
    public Orchestrator(Game g){
        this.game = g;
    }

    public void play(){

        while (!game.isOver()){
            System.out.println(game.situationToString());
            Player currentPlayer = game.getCurrentPlayer();
            int coupValide  = currentPlayer.chooseMove(game);
            game.execute(coupValide);

        }
        System.out.println("Le jeu est termine");
        System.out.println("Le gagnant est : "+game.getWinner());
    }

}