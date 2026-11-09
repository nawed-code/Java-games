package games.genericgames;

import games.players.Player;

public abstract class AbstractGame implements Game{

    protected  Player firstPlayer;
    protected Player secondPlayer;
    protected Player currentPlayer;

    public AbstractGame(Player j1, Player j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.currentPlayer = j1;

    }

    protected abstract void doExecute(int n);

    public void execute(int n){
        doExecute(n);
        if(this.firstPlayer.equals(this.getCurrentPlayer())){
            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.currentPlayer = this.firstPlayer;
        }
    }
    @Override 
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public Player getFirstPlayer(){
        return this.firstPlayer;
    } 

    public Player getSecondPlayer(){
        return this.secondPlayer;
    }

}



