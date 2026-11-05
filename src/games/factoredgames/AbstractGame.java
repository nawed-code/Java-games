package games.factoredgames;

public abstract class AbstractGame{

    protected  String firstPlayer;
    protected String secondPlayer;
    protected String currentPlayer;

    public AbstractGame(String j1, String j2){
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

    public String getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getFirstPlayer(){
        return this.firstPlayer;
    } 

    public String getSecondPlayer(){
        return this.secondPlayer;
    }

}



