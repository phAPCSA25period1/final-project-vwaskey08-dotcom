public class Simulation {
    private Cell[][] world;
    private int day;

    // later can add more customization

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

    public void setWorld() {
        int preyCount = 25;
        int predCount = 25;
        int randRow;
        int randCol;

        while (preyCount + predCount > 0) {
            randRow = (int) (Math.random() * (10 ));
            randCol = (int) (Math.random() * (10 ));

            if (world[randRow][randCol].isEmpty() && (preyCount + predCount) % 2 == 0) {
                world[randRow][randCol].setOccupant(new Prey(randCol, randRow));
                preyCount--;

            }
            else if (world[randRow][randCol].isEmpty())
            {
                world[randRow][randCol].setOccupant(new Predator(randCol, randRow));
                predCount--;
            }

        }

    }

    // add ending logic in another method

    // public void advanceDay() {
    //     String continueInput;
    //     Scanner input = new Scanner(System.in);

    //     while (continueInput != "e") {
    //         System.out.println("Day: " + day + ". Enter to continue, 'e' to exit");

    //         continueInput = input.nextLine();

    //         if (continueInput.equals("e")) {
    //             System.out.println("You have exited the simulation.");
    //             break;
    //         } else if (continueInput.equals(null)) {
    //             day++;
    //         }
    //     }

    // }

    public void printWorld()
    {
        String printedWorld = "";

        for (int i = 0; i < world.length; i++)
        {
            for (int j = 0; j < world[0].length; j++)
            {

                // github copilot suggested this, ive never seen instance of before
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

            printedWorld += "\n";
        }

        System.out.println(printedWorld);
    }

}
