package games.factoredgames;


/**
 * Represente une partie de TicTacToe.
 * Deux joueurs jouent chacun leur tour en placant un symbole
 * sur une grille de 3 par 3.
 */
public class TicTacToe extends AbstractGame{

    /**
     * Construit une nouvelle partie de TicTacToe.
     *
     * @param player1 premier joueur
     * @param player2 second joueur
     */
    private String[][] grille;
    public TicTacToe( String player1,String player2 ){
        super(player1, player2);
        this.grille = new String[3][3];
    }

    // accesseurs
    
    // ajoute des setters pour modifier la grille depuis l exterieur

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
     * @param caseNumber numero de la case a jouer
     */
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

    /**
     * Indique si une case peut etre jouee.
     *
     * @param caseNumber numero de la case
     * @return true si le coup est valide, false sinon
     */
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

    /**
     * Retourne le gagnant de la partie.
     *
     * @return le gagnant, ou null si aucun joueur n a gagne
     */
    public String getWinner(){
		
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
    
    
    
}
