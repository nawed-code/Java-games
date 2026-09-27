package tictactoe;

public class TicTacToe{

    private String firstPlayer;
    private String secondPlayer;
    private String[][] grille;
    private String currentPlayer;

    public TicTacToe( String player1,String player2 ){
        this.firstPlayer = player1;
        this.secondPlayer= player2;
        this.grille = new String[3][3];
        this.currentPlayer = player1; 
    }

    // accesseurs
    public String getCurrentPlayer(){
        return currentPlayer;
    }

    public void execute(int lineNumber, int columnNumber){
        if(this.firstPlayer.equals(this.getCurrentPlayer())){
            this.grille[lineNumber][columnNumber] = "x";
            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.grille[lineNumber][columnNumber] = "o";
            this.currentPlayer = this.firstPlayer;
        }
    }

    public boolean isValid(int lineNumber,int columnNumber){
        if(lineNumber >= 3 || lineNumber < 0 || columnNumber >= 3 || columnNumber < 0){
            return false;
        }
        if(grille[lineNumber][columnNumber] != null){
            return false;
        }
        return true;
        
    }
}

