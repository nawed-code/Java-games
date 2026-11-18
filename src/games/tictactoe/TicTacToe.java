package games.tictactoe;


/**
 * Represente une partie du jeu TicTacToe.
 * Deux joueurs jouent chacun leur tour en placant un symbole
 * sur une grille de 3 par 3.
 */
public class TicTacToe{

    private String firstPlayer;
    private String secondPlayer;
    private String[][] grille;
    private String currentPlayer;

    /**
     * Construit une nouvelle partie de TicTacToe.
     *
     * @param player1 premier joueur
     * @param player2 second joueur
     */
    public TicTacToe( String player1,String player2 ){
        this.firstPlayer = player1;
        this.secondPlayer= player2;
        this.grille = new String[3][3];
        this.currentPlayer = player1; 
    }

    // accesseurs

    /**
     * Retourne le joueur courant.
     *
     * @return le joueur courant
     */
    public String getCurrentPlayer(){
        return currentPlayer;
    }
    
    // ajoute des setters pour modifier la grille depuis l'extérieur

    /**
     * Modifie le contenu d une case de la grille.
     *
     * @param lineNumber numero de ligne
     * @param columnNumber numero de colonne
     * @param motif symbole a placer
     */
    public void setGrille(int lineNumber, int columnNumber , String motif){
        this.grille[lineNumber][columnNumber] = motif;
    }

    // ajoute des getters pour les nom de joueurs 

    /**
     * Retourne le premier joueur.
     *
     * @return le premier joueur
     */
    public String getFirstPlayer(){
		return this.firstPlayer;
	}
	
    /**
     * Retourne le second joueur.
     *
     * @return le second joueur
     */
	public String getSecondPlayer(){
		return this.secondPlayer;
	}

    // ajoute un getter pour grill
     /**
     * Retourne la grille du jeu.
     *
     * @return la grille
     */
    public String[][] getGrille(){
        return this.grille;
    }

    /**
     * Execute un coup en placant le symbole du joueur courant.
     *
     * @param lineNumber numero de ligne
     * @param columnNumber numero de colonne
     */
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

    /**
     * Indique si une case peut etre jouee.
     *
     * @param lineNumber numero de ligne
     * @param columnNumber numero de colonne
     * @return true si le coup est valide, false sinon
     */
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

    /**
     * Retourne le gagnant de la partie.
     *
     * @return le gagnant, ou null si aucun joueur n a gagne
     */
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

    /**
     * Indique si un joueur possede trois symboles alignes.
     *
     * @param player joueur a verifier
     * @param lineNumber ligne de depart
     * @param columnNumber colonne de depart
     * @param deltaRow deplacement en ligne
     * @param deltaColumn deplacement en colonne
     * @return true si le joueur gagne, false sinon
     */
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
    
    /**
     * Indique si la partie est terminee.
     *
     * @return true si la partie est terminee, false sinon
     */
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

     /**
     * Retourne une representation de la grille.
     *
     * @return une chaine de caracteres representant la grille
     */
    public String situationToString(){
		
		String plateau = "  0 1 2 "+System.lineSeparator();
		for(int i=0; i < 3;i++){
            plateau = plateau+i+" ";
			for(int j =0;j< 3;j++){
				if(this.grille[i][j] == null){
                    plateau +=". ";
                }
                else{
                    plateau = plateau+this.grille[i][j]+" ";
                }
			
			}
			plateau +=System.lineSeparator();
			
		}
		return plateau;
	}
    
    
    
}
