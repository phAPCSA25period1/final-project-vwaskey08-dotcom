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

    /* WILL GET MORE ATTENTION NEXT SPRINT */
    /**
     * moves the animal
     * @param world
     */
    public void move(Cell[][] world)
    {
        int newRow = returnNewRow(world);

        int newCol = returnNewCol(world);



            //removes the animal from the cell



            if(world[newRow][newCol].isEmpty()) //if the new place is empty set it there and update row and columm
            {
                world[this.getRow()][this.getCol()].removeOccupant();
                world[newRow][newCol].setOccupant(this);
                row = newRow;
                col = newCol;
            }

            // else if(this.getClass() == world[newRow][newCol].getOccupant().getClass())
            // {
            //     //reproduce
            //     reproduce(world);

            // }


    }

    // /**
    //  * all the if and else stuff for reproduction
    //  * @param world
    //  * @param newRow
    //  * @param newCol
    //  */
    // public void reproduce(Cell[][] world, int newRow, int newCol)
    // {

    //     int babyRow = 0;
    //     int babyCol = 0;

    //     if (newRow > row)
    //     {
    //             babyRow = (int)(Math.random() * ((newRow+1) - (row - 1) + 1) + (row - 1));

    //         if (newCol > col)
    //         {

    //                 babyCol = (int)(Math.random() * ((newCol + 1) - (col - 1) + 1) + (col - 1));
    //         }
    //         else
    //         {

    //                 babyCol = (int)(Math.random() * ((col + 1) - (newCol - 1) + 1) + (newCol - 1));
    //         }
    //     }
    //     else
    //     {
    //             babyRow = (int)(Math.random() * ((row+1) - (newRow - 1) + 1) + (newRow - 1));

    //         if (newCol > col)
    //         {

    //                 babyCol = (int)(Math.random() * ((newCol + 1) - (col - 1) + 1) + (col - 1));
    //         }
    //         else
    //         {

    //                 babyCol = (int)(Math.random() * ((col + 1) - (newCol - 1) + 1) + (newCol - 1));
    //         }
    //     }

    //     if(world[babyRow][babyCol].isEmpty())
    //     {
    //         if(this instanceof Prey)
    //         {
    //             world[babyRow][babyCol].setOccupant(new Prey(babyRow, babyCol));
    //             System.out.println("New sheep!");

    //         }
    //         else
    //         {
    //             world[babyRow][babyCol].setOccupant(new Predator(babyRow, babyCol));
    //             System.out.println("New wolf!");
    //         }

    //     }
    // }

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



}

