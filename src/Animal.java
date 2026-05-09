//accidentally made them immortal, gotta fix that

/**
 * Creates the basic Animal with basic methods and constructors
 *
 * @author Violet Waskey
 * @version 1.0
 */
public class Animal
{

    /* ATTRIBUTES */

    private int row;
    private int col;
    private int reproductionCoolDown;
    private int energy;
    private int age;



    /* CONSTRUCTOR */

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Animal(int row, int col)
    {
        this.row = row;
        this.col = col;
        age = 0;
        reproductionCoolDown = 0;
        energy = 100;

    }


    /* METHODS */


    /**
     * moves the animal
     * @param world
     */
    public void move(Cell[][] world)
    {

        //the random new row and new column

        int newRow = genRandCoor(world, row, world.length);
        int newCol = genRandCoor(world, col, world[0].length);

        //if the new place is empty set it there and update row and columm
        if(world[newRow][newCol].isEmpty())
        {

            //removes from old cell
            world[this.getRow()][this.getCol()].removeOccupant();

            //sets to new cell
            world[newRow][newCol].setOccupant(this);

            //updates coordinates
            row = newRow;
            col = newCol;
        }



    }

    /**
     * just to clean up my move method, lots of if and else statements
     * @param world
     * @return newRow
     */
    public int genRandCoor (Cell[][] world, int start, int endBound)
    {

        int randCoor = (int)(Math.random() *  ((start + 1) - (start - 1 ) + 1) + (start - 1) );
        if (randCoor > endBound- 1)
        {
            randCoor = endBound- 1;
        }
        else if (randCoor < 0)
        {
            randCoor = 0;
        }
        return randCoor;
    }


    /**
     * subtracts energy after one day and manages reproduction cooldown
     */
    public void nextDay()
    {
        energy -= 10;
        nextDayReproductionCoolDown();
        age ++;
    }

    /**
     * manages reproduction cool down
     */
    public void nextDayReproductionCoolDown()
    {
        if(reproductionCoolDown <= 0)
        {
            reproductionCoolDown = 0;
        }
        else
        {
            reproductionCoolDown --;
        }

    }

    /**
     * Managing subtracting energy
     * @param subtracted
     */
    public void subtractEnergy(int subtracted)
    {
        energy -= subtracted;
    }

    /**
     * Managing adding energy
     * @param added
     */
    public void addEnergy(int added)
    {
        energy += added;
    }

    /**
     * Sets reproduction cooldown
     */
    public void reproduceEnergy()
    {
        reproductionCoolDown = 3;
    }


    /* GETTERS */

    /**
     * gets the reproduction cool down
     * @return reproductionCoolDown
     */
    public int getReproductionCoolDown()
    {

        return reproductionCoolDown;
    }


    /**
     * checks the energy of the animal
     * @return energy
     */
    public int getEnergy()
    {
        return energy;
    }

    public boolean isAlive()
    {
        return energy > 0;
    }


    /**
     * gets the row of the animal
     * @return the row
     */
    public int getRow()
    {
        return row;
    }

    /**
     * gets the column of the animal
     * @return the row
     */
    public int getCol()
    {
        return col;
    }

    /**
     * gets the age of the animal
     * @return the age
     */
    public int getAge()
    {
        return age;
    }


    /* SETTERS */

    /**
     * sets row
     * @param row
     */
    public void setRow(int row)
    {
        this.row = row;
    }

    /**
     * set colum
     * @param col
     */
    public void setCol(int col)
    {
        this.col = col;

    }

}

