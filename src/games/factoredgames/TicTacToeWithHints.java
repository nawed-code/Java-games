package games.factoredgames;
import java.util.ArrayList;


/**
 * Variante de TicTacToe qui affiche des indices.
 * Les indices correspondent aux cases ou le joueur adverse
 * pourrait gagner au prochain coup.
 */
public class TicTacToeWithHints extends TicTacToe{
    

    /**
     * Construit une nouvelle partie de TicTacToe avec indices.
     *
     * @param player1 premier joueur
     * @param player2 second joueur
     */
    public TicTacToeWithHints(String player1,String player2){
        super(player1, player2);
    }

    // les mthodes 

    /**
     * Retourne la liste des cases dangereuses.
     * Une case est dangereuse si le joueur adverse peut gagner
     * en la jouant au prochain coup.
     *
     * @return la liste des cases dangereuses
     */
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

    /**
     * Retourne une representation de la grille avec les indices.
     * Les cases marquees par "!" indiquent les coups dangereux.
     *
     * @return une chaine de caracteres representant la grille
     *         avec les indices
     */
    public String situationToString(){

        ArrayList<Integer> l = hints();
		String[][] grille = getGrille();
		String plateau = "  - - -" + System.lineSeparator();
		for(int i=0; i < 3;i++){
            plateau = plateau+"| ";
			for(int j =0;j< 3;j++){
				if(grille[i][j] == null && l.contains(3*i+j)){
                    plateau +="! ";
                }
                else if(grille[i][j] == null){
                    plateau =plateau+(3*i+j)+" ";
                }
                else{
                    plateau =plateau+ grille[i][j]+" ";
                }
			
			}
			plateau =plateau+" |"+System.lineSeparator();
			
		}
        plateau = plateau+"  - - -" + System.lineSeparator();
		return plateau;
	}

}