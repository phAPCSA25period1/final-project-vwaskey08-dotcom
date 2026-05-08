import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SimulationPanel extends JPanel
{

    /* ATTRIBUTES */
    private Cell[][] world;
    private int cellSize;


    //setsize customizable based on user input?
    /**
     * Constructor for simulation panel
     * @param world
     */
    public SimulationPanel(Cell[][] world)
    {
        this.world = world;
        cellSize = 50; //futz around with
        setPreferredSize(new Dimension(world[0].length * cellSize, world.length * cellSize));

    }

    //proteted reccomended by claude: this class and any subclass can access it
    @Override
    /**
     * Pants components
     * @param g
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < world.length; i++)
        {
            int y = (i*cellSize);

            for (int j = 0; j < world[0].length; j++)
            {
                int x = (j * cellSize);


                if(world[i][j].getOccupant() instanceof Predator)
                {
                       g.setColor(Color.RED);
                }
                else if(world[i][j].getOccupant() instanceof Prey)
                {
                    g.setColor(Color.WHITE);
                }
                else if(world[i][j].canEatPlant())
                {
                    g.setColor(Color.GREEN);
                }
                else
                {
                    g.setColor(new Color(139, 69, 19));
                }

                g.fillRect(x,y, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(x,y,cellSize, cellSize);
            }
        }
    }



}
