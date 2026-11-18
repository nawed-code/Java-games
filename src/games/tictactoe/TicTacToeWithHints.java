package games.tictactoe;
import java.util.ArrayList;


/**
 * Represente une variante de TicTacToe avec des indices.
 * Les indices indiquent les cases ou le joueur adverse
 * peut gagner au prochain coup.
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

    // les méthode 

    /**
     * Retourne les cases dangereuses.
     * Une case est consideree comme dangereuse si le joueur
     * adverse peut gagner en la jouant au prochain coup.
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
     * Retourne une representation de la grille.
     *
     * @return une chaine de caracteres representant la grille
     */
    public String situationToString(){

        ArrayList<Integer> l = hints();
		String[][] grille = getGrille();
		String plateau = "  0 1 2 "+System.lineSeparator();
		for(int i=0; i < 3;i++){
            plateau = plateau+i+" ";
			for(int j =0;j< 3;j++){
				if(grille[i][j] == null && l.contains(3*i+j)){
                    plateau +="! ";
                }
                else if(grille[i][j] == null){
                    plateau +=". ";
                }
                else{
                    plateau =plateau+ grille[i][j]+" ";
                }
			
			}
			plateau +=System.lineSeparator();
			
		}
		return plateau;
	}

}