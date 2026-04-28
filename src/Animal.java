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

        int newRow = (int)(Math.random() *  ((row + 1) - (row - 1 ) + 1) + (row - 1) );
        if (newRow > world.length - 1)
        {
            newRow = world.length - 1;
        }
        else if (newRow < 0)
        {
            newRow = 0;
        }

        int newCol = (int)(Math.random() *  ((col + 1) - (col - 1 ) + 1) + (col - 1) );
        if (newCol > world[0].length - 1)
        {
            newCol = world[0].length - 1;
        }
        else if (newCol < 0 )
        {
            newCol = 0;
        }

        if(this != null)
        {

            world[this.getRow()][this.getCol()].removeOccupant();
            if(world[newRow][newCol].getOccupant() == null)
            {
                world[newRow][newCol].setOccupant(this);
                row = newRow;
                col = newCol;
            }
            else
            {
                world[this.getRow()][this.getCol()].setOccupant(this);
            }

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

