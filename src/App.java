
/* IMPORTS */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Main place to run the code
 *
 * @author Violet Waskey
 * @version 1.0
 */

public class App
{
    /* ATTRIBUTES */

    static Timer[] timerWrapper = new Timer[1]; //claude reccomened work around so the simulation stops when one pop equals zero


    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {



        /* OBJECT INTIALIZATIONS */

        //creates the JFrame to hold the panel
        JFrame frame = new JFrame();

        //create scanner object for user input
        Scanner input = new Scanner(System.in);



        /* MAIN CODE */


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

            //basic frame set up
            frameSetUp(frame, sim);

            //create the sim panel and adds it to the frame
            SimulationPanel panel = new SimulationPanel(sim.getWorld());
            frame.add(panel);
            frame.pack(); //claude recoomened
            frame.setVisible(true);

            //sets up the timer and then the loop within
            timerSetUp(panel, sim);

            //starts the timer
            timerWrapper[0].start();

        }
        //customizable
        else if(whichSim.toLowerCase().equals("s"))
        {
            //gets the user input for the custrom array
            System.out.println("How many rows? : ");
            int rows = input.nextInt();

            System.out.println("How many columns? : ");
            int cols = input.nextInt();

            System.out.println("How many sheep? : ");
            int sheep = input.nextInt();

            System.out.println("How many wolves? : ");
            int wolves = input.nextInt();

            //creates custom simulation object
            Simulation sim = new Simulation(rows, cols, sheep, wolves);

            //set up the world
            sim.setWorld();

            //frame set up
            frameSetUp(frame, sim);

            //creates the panel and then adds it to the frame
            SimulationPanel panel = new SimulationPanel(sim.getWorld());
            frame.add(panel);
            frame.pack(); //claude recoomened
            frame.setVisible(true);

            //general loop for the simulation within setting up the timer
            timerSetUp(panel, sim);

            //starts the timer
            timerWrapper[0].start();
        }

        //closes it to stop loss
        input.close();
    }

    /**
     * Just to make the code easier, sets up the base of the JFrame
     * @param frame
     * @param sim
     */
    public static void frameSetUp(JFrame frame, Simulation sim)
    {
        //just title, location in the middle, and then make sure the sim ends when you close the window
        frame.setTitle("Simulation");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    /**
     * Just to make the code easier to read, sets up the timer and loop
     * @param panel
     * @param sim
     */
    public static void timerSetUp(SimulationPanel panel, Simulation sim)
    {
        //creates the timer with a delay of 1 second (1000 milliseconds)
        timerWrapper[0] = new Timer(1000, new ActionListener()
        {
            //does the action every second
            @Override
            public void actionPerformed(ActionEvent e)
            {

                //normal advance day thing
                sim.advanceDay();

                //repaint is a built in method and lets the simulation change
                panel.repaint();

                //if any population gets to zero the simulation ends (maybe change?)
                if ((sim.getPredCount() == 0 && sim.getPreyCount() == 0) || (sim.getPredCount() == (sim.getRows() * sim.getCols()) || sim.getPreyCount() == (sim.getRows() * sim.getCols())))
                {

                    timerWrapper[0].stop();
                    System.out.println("Simulation has ended");

                }


            }

        });

    }


}



