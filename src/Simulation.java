import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    /* ATTRIBUTES */

    private Cell[][] world;
    private int day;

    /* METHODS */

    // later can add more customization
    /**
     * Constructor
     */
    public Simulation() {
        day = 1;
        world = new Cell[10][10];

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                world[i][j] = new Cell();
            }
        }

    }

    /**
     * Sets up the world with random placement of predators and prey
     */
    public void setWorld() {

        // declaring and intializaing variable
        int preyCount = 1;
        int predCount = 1;
        int row;
        int col;

        // placing a predator or prey
        while (preyCount + predCount > 0) {

            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);

            if (world[row][col].isEmpty() && (preyCount + predCount) % 2 == 0) {

                world[row][col].setOccupant(new Prey(row, col));
                preyCount--;

            } else if (world[row][col].isEmpty()) {
                world[row][col].setOccupant(new Predator(row, col));
                predCount--;
            }

        }

    }

    /**
     * Printing out the simulated world
     */

    public void printWorld() {
        // delcaring and intializing the print out
        String printedWorld = "\n";

        // iterating through the array and identifying the predator prey and empty
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {

                // github copilot suggested the instanceof when i got an error
                if (world[i][j].getOccupant() != null && world[i][j].getOccupant() instanceof Prey) {
                    printedWorld += "S  ";
                } else if (world[i][j].getOccupant() != null && world[i][j].getOccupant() instanceof Predator) {
                    printedWorld += "W  ";
                } else {
                    printedWorld += ".  ";
                }

            }

            // goes to the next line below
            printedWorld += "\n";
        }

        System.out.println(printedWorld);
    }

    // add ending logic in another method

    public void advanceDay() {

        String continueInput = "";
        Scanner input = new Scanner(System.in);

        ArrayList<Animal> animals = new ArrayList<>();

        while (!continueInput.equals("e"))
        {

            animals.clear(); // looked this up
            System.out.println("Day: " + day + ". Enter to continue, 'e' to exit");

            continueInput = input.nextLine();

            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    if (world[i][j].getOccupant() != (null))
                    {
                        if(!world[i][j].getOccupant().isAlive())
                        {
                            world[i][j].removeOccupant();
                        }
                        else
                        {
                            world[i][j].getOccupant().nextDay();
                            animals.add(world[i][j].getOccupant());
                        }

                    }

                }
            }



            for (int i = 0; i < animals.size(); i++)
            {

                 animals.get(i).move(world);

            }

            printWorld();
            day++;
        }

        System.out.println("You have exited the simulation.");

    }

}
