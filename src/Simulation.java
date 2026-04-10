import util.java.Scanner;

public class Simulation {
    private Cell[][] world;
    private int day;

    // later can add more customization

    public Simulation() {
        day = 1;
        world = new Cell[10][10];
    }

    public void setWorld()
    {
        //add after animal
    }

    //add ending logic in another method

    public void advanceDay()
    {
        String continueInput;
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
            else if (continueInput.equals(null))
            {
                day++;
            }
        }

    }

    public void printWorld()
    {
        //add later
    }

}
