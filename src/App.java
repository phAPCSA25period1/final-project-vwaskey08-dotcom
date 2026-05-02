/**
 * Main method to run the code
 * 
 * @author Violet Waskey
 * @version 1.0
 */
public class App {
    public static void main(String[] args) throws Exception {

        //creates the simulation object
        Simulation sim = new Simulation();

        //set up the world
        sim.setWorld();

        //intial print
        sim.printWorld();

        //general loop for the simulation
        sim.advanceDay();
    }
}
