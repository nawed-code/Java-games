package games.genericgames;

import java.util.ArrayList;
import java.util.List;

import games.players.Player;

public class TicTacToe extends AbstractGame{

    private String[][] grille;
    public TicTacToe( String player1,String player2 ){
        super(player1, player2);
        this.grille = new String[3][3];
    }

    // accesseurs
    
    // ajoute des setters pour modifier la grille depuis l exterieur
    public void setGrille(int lineNumber, int columnNumber , String motif){
        this.grille[lineNumber][columnNumber] = motif;
    }

    // ajoute un getter pour grill
    public String[][] getGrille(){
        return this.grille;
    }

    @Override 
    public void doExecute(int caseNumber){
        if(!isValid(caseNumber) ){                // verifie le numero de case 
            System.out.println("Coup invalide !");
            return;
        }
        int lineNumber = caseNumber / 3;
        int columnNumber = caseNumber % 3; 
        if(getFirstPlayer().equals(getCurrentPlayer())){
            this.grille[lineNumber][columnNumber] = "x";
        }
        else{
            this.grille[lineNumber][columnNumber] = "o";
            
        }
    }
    @Override 
    public boolean isValid(int caseNumber){
        
        int lineNumber = caseNumber / 3;
        int columnNumber = caseNumber % 3; 
        if(lineNumber >= 3 || lineNumber < 0 || columnNumber >= 3 || columnNumber < 0){
            //System.out.println("Cette indice n existe pas !");
            return false;
        }
        if(grille[lineNumber][columnNumber] != null){
            //System.out.println("Cette case n est pas vide !");
            return false;
        }
        return true;
        
    }
    @Override 
    public Player getWinner(){
		
		for (int i = 0; i < 3; i++) {
			if (wins(getFirstPlayer(), i, 0, 0, 1) || wins(getFirstPlayer(), 0, i, 1, 0)) {
				return getFirstPlayer();
			}
		}
        for (int i = 0; i < 3; i++) {
			if (wins(getSecondPlayer(), i, 0, 0, 1) || wins(getSecondPlayer(), 0, i, 1, 0)) {
				return getSecondPlayer();
			}
		}

		// Diagonales 
		if (wins(getFirstPlayer(), 0, 0, 1, 1) || wins(getFirstPlayer(), 0, 2, 1, -1)) {
			return getFirstPlayer();
		}
        if (wins(getSecondPlayer(), 0, 0, 1, 1) || wins(getSecondPlayer(), 0, 2, 1, -1)) {
			return getSecondPlayer();
		}
		// Personne n a gagne
        //System.out.println("Match null !");
		return null;
		
    }

    public boolean wins(String player, int lineNumber,int columnNumber, int deltaRow, int deltaColumn){
        String motif="";
        if(getFirstPlayer().equals(player)){
            motif = "x";
        }
        else{
            motif ="o";
        }
        return  
			this.grille[lineNumber][columnNumber] != null &&
			this.grille[lineNumber][columnNumber].equals(motif) &&
            this.grille[lineNumber + deltaRow][columnNumber+deltaColumn] != null &&
            this.grille[lineNumber + deltaRow][columnNumber+deltaColumn].equals(motif) &&
            this.grille[lineNumber+ (2*deltaRow)][columnNumber+ (2*deltaColumn)] != null &&
            this.grille[lineNumber+ (2*deltaRow)][columnNumber+ (2*deltaColumn)].equals(motif);

    }
    
    @Override 
    public boolean isOver(){
		
		if(this.getWinner() != null){
			return true;
		}
		for(int i=0; i < 3;i++){
			for(int j =0;j< 3;j++){
				if(this.grille[i][j] == null){   // au moins une case est vide 
					return false;
				}
			}
		}
		return true;
		
	}
    @Override 
    public String situationToString(){
		
		String plateau = "  - - -" + System.lineSeparator();
		for(int i=0; i < 3;i++){
            plateau = plateau+"| ";
			for(int j =0;j< 3;j++){
				if(this.grille[i][j] == null){
                    plateau =plateau+(3*i+j)+" ";
                }
                else{
                    plateau = plateau+this.grille[i][j]+" ";
                }
			
			}
			plateau = plateau+" |"+System.lineSeparator();
			
		}
        plateau = plateau+"  - - -";
		return plateau;
	}
    
    @Override 
    public List<Integer> validMoves(){
        List<Integer> moveList = new ArrayList<>();
        for(int i=0;i< 3;i++){
            for(int j=0;j<3; j++){
                if(this.grille[i][j] == null){
                    moveList.add(3*i+j);
                }
            }
        }
        return moveList;
    }

    @Override 
    public String moveToString(int move){
        return "Le joueur joue la case "+move;
    }

    @Override 
    public Game copy(){
        TicTacToe copyGame = new TicTacToe(getFirstPlayer() , getSecondPlayer());
        
    }
    
    
    
}
