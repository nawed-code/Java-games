package factoredgames.AbstractGame;

abstract class AbstractGame{

    private String firstPlayer;
    private String secondPlayer;
    private String currentPlayer;

    public AbstractGame(String j1, String j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.currentPlayer = j1;

    }

    protected abstract void doExecute(int caseNumber);

    public void execute(int caseNumber){
        doExecute(caseNumber);
        if(this.firstPlayer.equals(this.getCurrentPlayer())){
            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.currentPlayer = this.firstPlayer;
        }
    }

    public Stirng getCurrentPlayer(){
        return this.currentPlayer;
    }

}



