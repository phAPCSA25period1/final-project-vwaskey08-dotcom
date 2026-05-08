import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

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

        JFrame frame = new JFrame();

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

            frame.setTitle("Simulation");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SimulationPanel panel = new SimulationPanel(sim.getWorld());
            frame.setVisible(true);
            frame.add(panel);

            Timer timer = new Timer(1000, new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {

                    sim.advanceDay();
                    panel.repaint();

                }

            });

            timer.start();

        }
        //customizable
        else if(whichSim.toLowerCase().equals("s"))
        {
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

            frame.setTitle("Simulation");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SimulationPanel panel = new SimulationPanel(sim.getWorld());
            frame.add(panel);
            frame.pack(); //claude recoomened
            frame.setVisible(true);
            //general loop for the simulation


            Timer timer = new Timer(1000, new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {

                    sim.advanceDay();
                    panel.repaint();

                }

            });

            timer.start();
        }



        input.close();
    }


}





//     public static void main(String[] args) throws Exception
//     {

//         //
//         JFrame frame = new JFrame();

//         SimulationPanel panel = new SimulationPanel(world);
//         frame.add(panel);
//         frame.setTitle("Simulation");
//         frame.setSize(100,100);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);

//         //create scanner object for user input
//         Scanner input = new Scanner(System.in);

//         //default or customizable simlation
//         System.out.println("Would you like to have a default ('d') simulation or set your own conditions ('s')?");
//         String whichSim = input.nextLine();

//         //default
//         if(whichSim.toLowerCase().equals("d"))
//         {
//             //creates the simulation object
//             Simulation sim = new Simulation();

//             //set up the world
//             sim.setWorld();

//             //intial print
//             sim.printWorld();

//             //general loop for the simulation
//             sim.advanceDay();

//         }
//         //customizable
//         else if(whichSim.toLowerCase().equals("s"))
//         {
//             System.out.println("How many rows? : ");
//             int rows = input.nextInt();

//             System.out.println("How many columns? : ");
//             int cols = input.nextInt();

//             System.out.println("How many sheep? : ");
//             int wolves = input.nextInt();

//             System.out.println("How many wolves? : ");
//             int sheep = input.nextInt();

//             //creates custom simulation object
//             Simulation sim = new Simulation(rows, cols, sheep, wolves);

//             //set up the world
//             sim.setWorld();

//             //initial print
//             sim.printWorld();

//             //general loop for the simulation
//             sim.advanceDay();
//         }



//     }
// }



//Make sure the wolves die without an energy source(sheep)
//Make better stats

