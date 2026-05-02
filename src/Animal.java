public class Animal
{

    /* ATTRIBUTES */

    private int row;
    private int col;
    private int reproductionCoolDown;
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

    /* WILL GET MORE ATTENTION NEXT SPRINT */
    /**
     * moves the animal
     * @param world
     */
    public void move(Cell[][] world)
    {
        int newRow = returnNewRow(world);

        int newCol = returnNewCol(world);

            if(world[newRow][newCol].isEmpty()) //if the new place is empty set it there and update row and columm
            {
                world[this.getRow()][this.getCol()].removeOccupant();
                world[newRow][newCol].setOccupant(this);
                row = newRow;
                col = newCol;
            }


    }


    /**
     * just to clean up my move method, lots of if and else statements
     * @param world
     * @return newRow
     */
    public int returnNewRow (Cell[][] world)
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
        return newRow;
    }

    /**
     *just to clean up my move method, lots of if and else statements
     * @param world
     * @return newCol
     */
    public int returnNewCol(Cell[][] world)
    {
        int newCol = (int)(Math.random() *  ((col + 1) - (col - 1 ) + 1) + (col - 1) );
        if (newCol > world[0].length - 1)
        {
            newCol = world[0].length - 1;
        }
        else if (newCol < 0 )
        {
            newCol = 0;
        }

        return newCol;
    }



     /**
     * checks if the animal is alive
     * @return the status of alive
     */
    public boolean isAlive()
    {
        return energy > 0;
    }

    /**
     * subtracts energy after one day
     */
    public void nextDay()
    {
        energy -= 10;
    }

    public void reproductionEnergy()
    {
        energy -=20;
    }

    public void addEnergy(int added)
    {
        energy += added;
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

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setCol(int col)
    {
        this.col = col;

    }
    /**
     * checks the energy of the animal
     * @return energy
     */
    public int getEnergy()
    {
        return energy;
    }



}

