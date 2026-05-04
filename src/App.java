import java.util.Scanner;

/**
 * Main method to run the code
 *
 * @author Violet Waskey
 * @version 1.0
 */

public class App
{
    public static void main(String[] args) throws Exception
    {
        //create scanner object for user input
        Scanner input = new Scanner(System.in);

        //default or customizable simlation
        System.out.println("Would you like to have a default ('d') simulation or set your own conditions ('s')?");
        String whichSim = input.nextLine();

        //default
        if(whichSim.toLowerCase().equals("d"))
        {
            //creates the simulation object
            Simulation sim = new Simulation();

            //set up the world
            sim.setWorld();

            //intial print
            sim.printWorld();

            //general loop for the simulation
            sim.advanceDay();

        }
        //customizable
        else if(whichSim.toLowerCase().equals("s"))
        {
            System.out.println("How many rows? : ");
            int rows = input.nextInt();

            System.out.println("How many columns? : ");
            int cols = input.nextInt();

            System.out.println("How many wolves? : ");
            int wolves = input.nextInt();

            System.out.println("How many sheep? : ");
            int sheep = input.nextInt();

            //creates custom simulation object
            Simulation sim = new Simulation(rows, cols, sheep, wolves);

            //set up the world
            sim.setWorld();

            //initial print
            sim.printWorld();

            //general loop for the simulation
            sim.advanceDay();
        }



    }
}



//Make sure the wolves die without an energy source(sheep)
//Make better stats

