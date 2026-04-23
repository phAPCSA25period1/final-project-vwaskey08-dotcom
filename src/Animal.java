public class Animal
{

    /* ATTRIBUTES */

    private int row;
    private int col;

    private int age;
    private int energy;

    private boolean alive;


    /* METHODS */

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Animal(int row, int col)
    {
        this.row = row;
        this.col = col;

        alive = true;
        age = 1;
        energy = 100;

    }

     /**
     * checks if the animal is alive
     * @return the status of alive
     */
    public boolean isAlive()
    {
        return alive;
    }

    /* WILL GET MORE ATTENTION NEXT SPRINT */
    /**
     * moves the animal
     * @param xPos
     * @param yPos
     */
    public void move(Cell[][] world)
    {
        int surroundCol = (int)(Math.random() * (col + 1 - col - 1 + 1) + (col - 1));

        if (surroundCol > world.length)
        {
            surroundCol = world.length - 1;
        }

        int surroundRow = (int)(Math.random() * (row + 1 - row - 1 + 1) + (row - 1));
        if(surroundRow > world[0].length)
        {
            surroundRow = world[0].length - 1;
        }

        if(world[surroundCol][surroundRow].isEmpty())
        {

            col = surroundCol;
            row = surroundRow;

        }

    }


    /* GETTERS */

    /**
     * gets the positon of the animal
     * @return the postion
     */
    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }


    /**
     * checks the energy of the animal
     * @return energy
     */
    public int getEnergy()
    {
        return energy;
    }


    /**
     * gets the age of the animal
     * @return age
     */
    public int getAge()
    {
        return age;
    }


}

