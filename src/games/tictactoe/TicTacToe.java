package games.tictactoe;

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
    
    // ajoute des setters pour modifier la grille depuis l'extérieur
    public void setGrille(int lineNumber, int columnNumber , String motif){
        this.grille[lineNumber][columnNumber] = motif;
    }

    // ajoute des getters pour les nom de joueurs 
    public String getFirstPlayer(){
		return this.firstPlayer;
	}
	
	public String getSecondPlayer(){
		return this.secondPlayer;
	}

    // ajoute un getter pour grill
    public String[][] getGrille(){
        return this.grille;
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
            //System.out.println("Cette indice n'existe pas !");
            return false;
        }
        if(grille[lineNumber][columnNumber] != null){
            //System.out.println("Cette case n'est pas vide !");
            return false;
        }
        return true;
        
    }

    public String getWinner(){
		
		for (int i = 0; i < 3; i++) {
			if (wins(this.firstPlayer, i, 0, 0, 1) || wins(this.firstPlayer, 0, i, 1, 0)) {
				return this.firstPlayer;
			}
		}
        for (int i = 0; i < 3; i++) {
			if (wins(this.secondPlayer, i, 0, 0, 1) || wins(this.secondPlayer, 0, i, 1, 0)) {
				return this.secondPlayer;
			}
		}

		// Diagonales 
		if (wins(this.firstPlayer, 0, 0, 1, 1) || wins(this.firstPlayer, 0, 2, 1, -1)) {
			return this.firstPlayer;
		}
        if (wins(this.secondPlayer, 0, 0, 1, 1) || wins(this.secondPlayer, 0, 2, 1, -1)) {
			return this.secondPlayer;
		}
		// Personne n'a gagné
        //System.out.println("Match null !");
		return null;
		
    }

    public boolean wins(String player, int lineNumber,int columnNumber, int deltaRow, int deltaColumn){
        String motif="";
        if(this.firstPlayer.equals(player)){
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
    public String situationToString(){
		
		String plateau = "";
		for(int i=0; i < 3;i++){
			for(int j =0;j< 3;j++){
				if(this.grille[i][j] == null){
                    plateau +=".";
                }
                else{
                    plateau += this.grille[i][j];
                }
			
			}
			plateau +=System.lineSeparator();
			
		}
		return plateau;
	}
    
    
    
}
