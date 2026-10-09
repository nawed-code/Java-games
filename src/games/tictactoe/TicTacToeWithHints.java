package tictactoe;
import java.util.ArrayList;
import tictactoe.TicTacToe;

public class TicTacToeWithHints extends TicTacToe{
    
    public TicTacToeWithHints(String player1,String player2){
        super(player1, player2);
    }

    // les méthode 
    public ArrayList<Integer> hints(){

        ArrayList<Integer> l = new ArrayList<>();
        // pour trouver le joeur adversaire 
        String adversaire;
        String markAdversaire="";
        if(getCurrentPlayer().equals(getFirstPlayer())){
            adversaire = getSecondPlayer();
            markAdversaire ="o";
        }
        else{
            adversaire = getFirstPlayer();
            markAdversaire="x";
        }
        String[][] grille = getGrille();
        for(int i=0;i<3;i++){
            for(int j=0;j<3 ; j++){
                if(grille[i][j] == null){
                    setGrille(i, j, markAdversaire);
                    if(adversaire.equals(getWinner())){
                        l.add(3*i+j);
                        
                    }
                    setGrille(i, j, null);
                }
            }
        }
        return l;

    }
}