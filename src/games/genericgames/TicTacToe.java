package games.genericgames;

import java.util.ArrayList;
import java.util.List;

import games.players.Player;


/**
 * Classe representant le jeu du TicTacToe.
 *
 * Cette classe herite de AbstractGame et implemente les
 * fonctionnalites propres au jeu du TicTacToe.
 * Les joueurs jouent chacun leur tour en placant leur
 * symbole sur une case libre du plateau.
 * Le premier joueur qui aligne trois symboles gagne la partie.
 */
public class TicTacToe extends AbstractGame{


    /**
     * Construit une nouvelle partie de TicTacToe.
     *
     * @param player1 le premier joueur
     * @param player2 le second joueur
     */

    protected String[][] grille;
    public TicTacToe( Player player1,Player player2 ){
        super(player1, player2);
        this.grille = new String[3][3];
    }

    // accesseurs
    
    // ajoute des setters pour modifier la grille depuis l exterieur

    /**
     * Modifie le contenu d'une case de la grille.
     *
     * @param lineNumber le numero de la ligne
     * @param columnNumber le numero de la colonne
     * @param motif le symbole a placer dans la case
     */

    public void setGrille(int lineNumber, int columnNumber , String motif){
        this.grille[lineNumber][columnNumber] = motif;
    }

    // ajoute un getter pour grill

    /**
     * Retourne la grille du jeu.
     *
     * @return la grille du jeu
     */
    public String[][] getGrille(){
        return this.grille;
    }

    /**
     * doExecute un coup en placant le symbole du joueur courant
     * dans la case demandee.
     *
     * @param caseNumber le numero de la case a jouer
     */
    @Override 
    protected void doExecute(int caseNumber){
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
     * Indique si le coup est valide.
     *
     * @param caseNumber le numero de la case a verifier
     * @return true si le coup est valide, false sinon
     */
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

    /**
     * Retourne le joueur gagnant.
     *
     * @return le joueur gagnant ou null si aucun joueur n'a gagne
     */
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

    /**
     * Indique si un joueur possede un alignement gagnant.
     *
     * @param player le joueur a verifier
     * @param lineNumber la ligne de depart
     * @param columnNumber la colonne de depart
     * @param deltaRow le deplacement en ligne
     * @param deltaColumn le deplacement en colonne
     * @return true si le joueur gagne, false sinon
     */
    public boolean wins(Player player, int lineNumber,int columnNumber, int deltaRow, int deltaColumn){
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

    /**
     * Retourne une representation de la situation courante du jeu.
     *
     * @return une chaine representant le plateau
     */
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
    
    /**
     * Retourne la liste des coups valides.
     *
     * @return la liste des cases libres
     */
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

    /**
     * Retourne une representation sous forme de chaine du coup donne.
     *
     * @param move le coup a convertir en chaine de caracteres
     * @return une chaine representant le coup
     */
    @Override 
    public String moveToString(int move){
        return "Le joueur joue la case "+move;
    }

    /**
     * Retourne une copie de la partie dans son etat actuel.
     *
     * @return une nouvelle instance du jeu ayant le meme etat que la partie courante
     */
    @Override 
    public Game copy(){
        TicTacToe copyGame = new TicTacToe(getFirstPlayer() , getSecondPlayer());
        copyGame.currentPlayer = getCurrentPlayer();
        String [][]copyGrille = new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                copyGrille[i][j] = this.grille[i][j];
            }
        }
        copyGame.grille = copyGrille;
        return copyGame;        
    }
    
    
    
}
