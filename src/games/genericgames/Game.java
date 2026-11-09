package games.genericgames;

import games.players.Player;
import java.util.List;

public interface Game {


    public boolean isValid(int move);

    public void execute(int move);

    public boolean isOver();

    public Player getWinner();

    public Player getCurrentPlayer();

    public List<Integer> validMoves();
    
}