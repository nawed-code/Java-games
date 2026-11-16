package games.genericgames;
import java.util.ArrayList;
import java.util.List;
import games.players.Player;
import games.players.Human;


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
    public TicTacToeWithHints(Player player1,Player player2){
        super(player1, player2);
    }

    // les mthodes 

    /**
     * Retourne les cases dangereuses.
     * Une case est consideree comme dangereuse si le joueur
     * adverse peut gagner en la jouant au prochain coup.
     *
     * @return la liste des cases dangereuses
     */
    public List<Integer> hints(){

        List<Integer> l = new ArrayList<>();
        // pour trouver le joeur adversaire 
        Player adversaire;
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
     * Le caractere '!' indique une case dangereuse et le caractere
     * '.' une case vide.
     *
     * @return une chaine de caracteres representant la grille
     */
    @Override 
    public String situationToString(){

        List<Integer> l = hints();
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
                    plateau = plateau+this.grille[i][j]+" ";
                }
			
			}
			plateau = plateau+" |"+System.lineSeparator();
			
		}
        plateau = plateau+"  - - -";
		return plateau;
	}

}
