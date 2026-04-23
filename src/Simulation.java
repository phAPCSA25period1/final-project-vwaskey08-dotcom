import java.util.Scanner;

public class Simulation
{
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

        for(int i = 0; i < world.length; i ++)
        {
            for (int j = 0; j < world[0].length; j++)
            {
                world[i][j] = new Cell();
            }
        }

    }


    /**
     * Sets up the world with random placement of predators and prey
     */
    public void setWorld()
    {

        //declaring and intializaing variable
        int preyCount = 1;
        int predCount = 1;
        int row;
        int col;

        //placing a predator or prey
        while (preyCount + predCount > 0) {

            row = (int) (Math.random() * 10);
            col = (int) (Math.random() * 10);

            if (world[row][col].isEmpty() && (preyCount + predCount) % 2 == 0)
            {

                world[row][col].setOccupant(new Prey(row, col));
                preyCount--;

            }
            else if (world[row][col].isEmpty())
            {
                world[row][col].setOccupant(new Predator(row, col));
                predCount--;
            }

        }

    }

    /**
     * Printing out the simulated world
     */

    public void printWorld()
    {
        //delcaring and intializing the print out
        String printedWorld = "\n";

        //iterating through the array and identifying the predator prey and empty
        for (int i = 0; i < world.length; i++)
        {
            for (int j = 0; j < world[0].length; j++)
            {

                // github copilot suggested the instanceof when i got an error
                if (world[i][j].getOccupant()!= null && world[i][j].getOccupant() instanceof Prey)
                {
                    printedWorld += "S  ";
                }
                else if (world[i][j].getOccupant()!= null && world[i][j].getOccupant() instanceof Predator)
                {
                    printedWorld += "W  ";
                }
                else
                {
                    printedWorld += ".  ";
                }

            }

            //goes to the next line below
            printedWorld += "\n";
        }

        System.out.println(printedWorld);
    }



    // add ending logic in another method

    public void advanceDay() {

        String continueInput = "";
        Scanner input = new Scanner(System.in);

        while (continueInput != "e")
        {
            System.out.println("Day: " + day + ". Enter to continue, 'e' to exit");

            continueInput = input.nextLine();

            if (continueInput.equals("e"))
            {

                System.out.println("You have exited the simulation.");
                break;

            }

            movingAnimals();
        }



    }

    public void movingAnimals()
    {
        //this makes sure that everysingle animal moves in the world
        for (Cell[] arr : world)
            {
                for(Cell cell : arr)
                {
                    if (cell.getOccupant() != null)
                    {
                        System.out.println("The animal at " + cell.getOccupant().getCol() + cell.getOccupant().getRow());
                         cell.getOccupant().move(world);
                         System.out.println("Has moved to" + cell.getOccupant().getCol() + cell.getOccupant().getRow());

                    }

                }
            }

            Cell[][] tempCells = world;

            for (int i = 0; i < world.length; i ++)
            {
                for(int j = 0; j < world[0].length; j ++)
                {
                    if(tempCells[i][j].getOccupant() != null)
                    {

                        //check each real row and real column position in the temporary array
                        //then set the old position to empty
                        //the set the real value of the world

                        int tempCol = tempCells[i][j].getOccupant().getCol();
                        int tempRow = tempCells[i][j].getOccupant().getRow();

                        world[tempCol][tempRow].removeOccupant();
                        System.out.println("An animal has been removed from row: " + tempRow + " column: " + tempCol);


                        world[tempCol][tempRow].setOccupant(tempCells[i][j].getOccupant());
                       System.out.println("An animal has been added to row: " + tempRow + " column: " + tempCol);

                    }

                }
            }

    }

}
