
/* IMPORTS */
import java.util.ArrayList;

/**
 * This class manages the overall simulation aspects
 *
 * @author Violet Waskey
 * @version 1.0
 */
public class Simulation {



    /* ATTRIBUTES */

    private final Cell[][] world;
    private int day;
    private int preyCount;
    private int predCount;
    private final int rows;
    private final int cols;
    private ArrayList<Animal> animals;




    /* CONSTRUCTORS */

    /**
     * Constructor
     */
    public Simulation() {

        day = 1;
        world = new Cell[10][10];
        preyCount = 5;
        predCount = 5;
        cols = 10;
        rows = 10;
        animals = new ArrayList<>();


        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                world[i][j] = new Cell();
            }
        }

    }

    /**
     * Custonmizable Constructor
     * @param rows
     * @param cols
     * @param preyCount
     * @param predCount
     */
    public Simulation(int rows, int cols, int preyCount, int predCount)
    {

        day = 1;
        world = new Cell[rows][cols];
        this.cols = cols;
        this.rows = rows;
        this.preyCount = preyCount;
        this.predCount = predCount;

        for (int i = 0; i < world.length; i++)
        {
            for (int j =0; j < world[0].length; j ++)
            {
                world[i][j] = new Cell();
            }
        }

    }





    /* METHODS */


    /**
     * Sets up the world with random placement of predators and prey
     */
    public void setWorld() {

        // declaring and intializaing variables

        int row;
        int col;

        // placing a predator or prey
        while (preyCount + predCount > 0) {

            //creates the random column and row
            row = (int) (Math.random() * rows);
            col = (int) (Math.random() * cols);

            //checks if the total number is positive or negative
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
     * Printing out the simulated world information
     * Should i do some method encapsulation?
     */
    public void printWorldInfo()
    {

        System.out.println("Number of Sheep: " + preyCount);
        System.out.println("Number of Wolves: " + predCount);


    }

    /**
     * Advancing the day through manaing printing and other daily updates
     */
    public void advanceDay()
    {

        //reset the arrayList (looked up this method, super useful)
        animals.clear();

        //iterate through every index finding the animals and managing the plants
        for (int i = 0; i < world.length; i++)
        {
            for (int j = 0; j < world[0].length; j++) {

                //managing plants, growing if can and managing the cooldwon
                world[i][j].nextDay();


                //identifying the animals, removing the dead ones and adding the live ones to the array list
                if (world[i][j].getOccupant() != (null))
                {
                    if(!world[i][j].getOccupant().isAlive())
                    {
                        world[i][j].removeOccupant();
                    }
                    else
                    {
                        animals.add(world[i][j].getOccupant());
                    }

                }

            }
        }

        predCount = 0;
        preyCount =0;
        //now going through the array list and managing movement and other daily things
        for (int i = 0; i < animals.size(); i++)
        {

            if(animals.get(i) instanceof Predator)
            {
                predCount++;
            }
            else
            {
                preyCount++;
            }

            animals.get(i).move(world);
            animals.get(i).nextDay();


        }

        day++;
        printWorldInfo();



    }



    /* METHODS */



    /**
     * gets number of prey
     * @return preyCount
     */
    public int getPreyCount()
    {
        return preyCount;
    }

    /**
     * gets number of predators
     * @return predCount
     */
    public int getPredCount()
    {
        return predCount;
    }

    /**
     * gets day
     * @return day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * gets world
     * @return world
     */
    public Cell[][] getWorld()
    {
        return world;
    }



}
// //imports
// import java.util.ArrayList;
// import java.util.Scanner;

// /**
//  * This class manages the overall simulation aspects
//  *
//  * @author Violet Waskey
//  * @version 1.0
//  */
// public class Simulation {



//     /* ATTRIBUTES */

//     private Cell[][] world;
//     private int day;
//     private int preyCount;
//     private int predCount;
//     private int rows;
//     private int cols;



//     /* CONSTRUCTORS */

//     /**
//      * Constructor
//      */
//     public Simulation() {

//         day = 1;
//         world = new Cell[10][10];
//         preyCount = 5;
//         predCount = 5;
//         cols = 10;
//         rows = 10;

//         for (int i = 0; i < world.length; i++) {
//             for (int j = 0; j < world[0].length; j++) {
//                 world[i][j] = new Cell();
//             }
//         }

//     }

//     /**
//      * Custonmizable Constructor
//      * @param rows
//      * @param cols
//      * @param preyCount
//      * @param predCount
//      */
//     public Simulation(int rows, int cols, int preyCount, int predCount)
//     {

//         day = 1;
//         world = new Cell[rows][cols];
//         this.cols = cols;
//         this.rows = rows;
//         this.preyCount = preyCount;
//         this.predCount = predCount;

//         for (int i = 0; i < world.length; i++)
//         {
//             for (int j =0; j < world[0].length; j ++)
//             {
//                 world[i][j] = new Cell();
//             }
//         }

//     }





//     /* METHODS */


//     public Cell[][] getWorld()
//     {
//         return world;
//     }

//     /**
//      * Sets up the world with random placement of predators and prey
//      */
//     public void setWorld() {

//         // declaring and intializaing variables

//         int row;
//         int col;

//         // placing a predator or prey
//         while (preyCount + predCount > 0) {

//             //creates the random column and row
//             row = (int) (Math.random() * rows);
//             col = (int) (Math.random() * cols);

//             //checks if the total number is positive or negative
//             if (world[row][col].isEmpty() && (preyCount + predCount) % 2 == 0) {

//                 world[row][col].setOccupant(new Prey(row, col));
//                 preyCount--;

//             } else if (world[row][col].isEmpty()) {
//                 world[row][col].setOccupant(new Predator(row, col));
//                 predCount--;
//             }

//         }

//     }

//     /**
//      * Printing out the simulated world
//      */
//     public void printWorld() {

//         int numSheep = 0;
//         int numWolves = 0;


//         // delcaring and intializing the print out
//         String printedWorld = "\n";

//         // iterating through the array and identifying the predator prey and empty
//         for (int i = 0; i < world.length; i++) {
//             for (int j = 0; j < world[0].length; j++) {

//                 // github copilot suggested the instanceof when i got an error
//                 if (world[i][j].getOccupant() != null && world[i][j].getOccupant() instanceof Prey)
//                 {
//                     printedWorld += "S  ";
//                     numSheep ++;

//                 }
//                 else if (world[i][j].getOccupant() != null && world[i][j].getOccupant() instanceof Predator)
//                 {
//                     printedWorld += "W  ";
//                     numWolves++;

//                 }
//                 else if(world[i][j].canEatPlant())
//                 {
//                     printedWorld += ":  ";
//                 }
//                 else
//                 {
//                     printedWorld += ".  ";
//                 }

//             }

//             // goes to the next line below
//             printedWorld += "\n";
//         }

//         System.out.println(printedWorld);
//         System.out.println("Number of Sheep: " + numSheep);
//         System.out.println("Number of Wolves: " + numWolves);

//     }

//     // add ending logic in another method

//     /**
//      * Advancing the day through manaing printing and other daily updates
//      */
//     public void advanceDay() {

//         //initializing variable for user input
//         String continueInput = "";
//         Scanner input = new Scanner(System.in);

//         //create arrayList for the animals
//         ArrayList<Animal> animals = new ArrayList<>();

//         //while the user wants to continue with the simulation
//         while (!continueInput.equals("e"))
//         {

//             //reset the arrayList (looked up this method, super useful)
//             animals.clear();

//             //gets the user input to continue the sim
//             System.out.println("Day: " + day + ". Enter to continue, 'e' to exit");
//             continueInput = input.nextLine();


//             //iterate through every index finding the animals and managing the plants
//             for (int i = 0; i < world.length; i++) {
//                 for (int j = 0; j < world[0].length; j++) {

//                     //managing plants, growing if can and managing the cooldwon
//                     world[i][j].nextDay();


//                     //identifying the animals, removing the dead ones and adding the live ones to the array list
//                     if (world[i][j].getOccupant() != (null))
//                     {
//                         if(!world[i][j].getOccupant().isAlive())
//                         {
//                             world[i][j].removeOccupant();
//                         }
//                         else
//                         {
//                             world[i][j].getOccupant().nextDay();
//                             animals.add(world[i][j].getOccupant());
//                         }

//                     }

//                 }
//             }

//             //now going through the array list and managing movement and other daily things
//             for (int i = 0; i < animals.size(); i++)
//             {

//                  animals.get(i).move(world);
//                  animals.get(i).nextDay();


//             }

//             //print out world and incrementing day
//             printWorld();
//             day++;
//         }

//         System.out.println("You have exited the simulation.");

//     }

// }
