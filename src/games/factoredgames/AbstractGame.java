package factoredgames.AbstractGame;

public class AbstractGame{

    private String firstPlayer;
    private String secondPlayer;
    private String currentPlayer;

    public AbstractGame(String j1, String j2){
        this.firstPlayer = j1;
        this.secondPlayer = j2;
        this.currentPlayer = j1;

    }

    protected void doExecute(int caseNumber){
        if(caseNumber > 8 ){
            System.out.println("Cette case n'existe pas");
            return;
        }
        lineNumber = caseNumber / 3;
        columnNumber = caseNumber % 3; 
        if(this.firstPlayer.equals(this.currentPlayer())){
            this.grille[lineNumber][columnNumber] = "x";
        }
        else{
            this.grille[lineNumber][columnNumber] = "o";
            
        }
    }
}



