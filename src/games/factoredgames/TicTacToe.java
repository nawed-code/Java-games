package games.factoredgames;

public class TicTacToe extends AbstractGame{

    private String[][] grille;
    public TicTacToe( String player1,String player2 ){
        super(player1, player2);
        this.grille = new String[3][3];
    }

    // accesseurs
    
    // ajoute des setters pour modifier la grille depuis l'extérieur
    public void setGrille(int lineNumber, int columnNumber , String motif){
        this.grille[lineNumber][columnNumber] = motif;
    }

    /* 
    // ajoute des getters pour les nom de joueurs 
    public String getFirstPlayer(){
		return super.firstPlayer;
	}
	
	public String getSecondPlayer(){
		return super.secondPlayer;
	}
    */

    // ajoute un getter pour grill
    public String[][] getGrille(){
        return this.grille;
    }

    @Override 
    public void execute(int caseNumber){
        if(caseNumber > 8 ){
            System.out.println("Cette case n'existe pas");
            return;
        }
        lineNumber = caseNumber / 3;
        columnNumber = caseNumber % 3; 
        if(super.firstPlayer.equals(super.getCurrentPlayer())){
            this.grille[lineNumber][columnNumber] = "x";
            super.currentPlayer = super.secondPlayer;
        }
        else{
            this.grille[lineNumber][columnNumber] = "o";
            super.currentPlayer = super.firstPlayer;
        }
    }

    public boolean isValid(int caseNumber){
        
        lineNumber = caseNumber / 3;
        columnNumber = caseNumber % 3; 
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
			if (wins(super.firstPlayer, i, 0, 0, 1) || wins(super.firstPlayer, 0, i, 1, 0)) {
				return super.firstPlayer;
			}
		}
        for (int i = 0; i < 3; i++) {
			if (wins(super.secondPlayer, i, 0, 0, 1) || wins(super.secondPlayer, 0, i, 1, 0)) {
				return super.secondPlayer;
			}
		}

		// Diagonales 
		if (wins(super.firstPlayer, 0, 0, 1, 1) || wins(super.firstPlayer, 0, 2, 1, -1)) {
			return this.firstPlayer;
		}
        if (wins(super.secondPlayer, 0, 0, 1, 1) || wins(super.secondPlayer, 0, 2, 1, -1)) {
			return super.secondPlayer;
		}
		// Personne n'a gagné
        //System.out.println("Match null !");
		return null;
		
    }

    public boolean wins(String player, int lineNumber,int columnNumber, int deltaRow, int deltaColumn){
        String motif="";
        if(super.firstPlayer.equals(player)){
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
