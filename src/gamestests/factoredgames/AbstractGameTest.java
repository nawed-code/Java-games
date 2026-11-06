package gamestests.factoredgames;
import gamestests.factoredgames.AbstractGameTests;



public class AbstractGameTest{

    public static void main(String[] args){

        boolean ok = true;
        AbstractGameTests abstractGameTester = new AbstractGameTests();
        ok = ok && abstractGameTester.testGetCurrentPlayer();
        ok = ok && abstractGameTester.testExecute();
        System.out.println(ok ? "All tests OK" : "At least one test KO");
        
    }
}
