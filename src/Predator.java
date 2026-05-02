/**
 * Predator extends the Animal class
 *
 * @author Violet Waskey
 * @version 1.0
 */
public class Predator extends Animal
{

    /* CONSTRUCTOR */

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Predator(int row, int col) {
        super(row, col);
    }

    /**
     * Overidden move
     * @param world
     */
    @Override
    public void move(Cell[][] world)
    {
        //must be at least 50 energy to reproduce
        if (this.getEnergy() > 50)
        {
             reproduce(world);
        }
        //if hunt has not suceeded
        if(!hunt(world))
        {
            super.move(world);
        }

    }

    /**
     * Hunt prey in neighboring cells
     *
     * @param world
     * @return wether hunt was sucessful and affects movement
     */
    public boolean hunt(Cell[][] world)
    {
        for(int preyRow = this.getRow() - 1; preyRow <= this.getRow() + 1; preyRow++)
        {
            for(int preyCol = this.getCol() - 1; preyCol <= this.getCol() + 1; preyCol++)
            {

                //make sure its not out of bounds
                if(preyRow < 0 || preyCol < 0 || preyRow > world.length - 1 || (preyCol > world[0].length - 1))
                {
                    continue;
                }
                else if(world[preyRow][preyCol].getOccupant() instanceof Prey)
                {
                    world[preyRow][preyCol].removeOccupant();
                    world[this.getRow()][this.getCol()].removeOccupant();
                    world[preyRow][preyCol].setOccupant(this);

                    this.addEnergy(20);
                    System.out.println("A Sheep has been eaten.");

                    return true;
                }

            }
        }

        return false;

    }

    //more efficent way to manage all these for loops and if else statements?
    /**
     * Manages reproduction
     * @param world
     * @return used just to exit loops
     */
    public int reproduce(Cell[][] world)
    {

        if(this.getReproductionCoolDown() == 0)
        {
            //check first if there are neighbors around to reproduce,
            for(int mateRow = this.getRow() - 1; mateRow <= this.getRow() + 1; mateRow++)
            {
                for(int mateCol = this.getCol() - 1; mateCol <= this.getCol() + 1; mateCol++)
                {

                    //makes sure its not out of bounds
                    if(mateCol < 0 || mateRow < 0 || mateRow > world.length - 1 || ( mateCol > world[0].length - 1))
                    {
                        continue;
                    }
                    else if(world[mateRow][mateCol].getOccupant() instanceof Predator)
                    {

                        //now set a place for the baby
                        for(int babyRow = this.getRow() - 1; babyRow <= this.getRow() + 1; babyRow++)
                        {
                            for(int babyCol = this.getCol() - 1; babyCol <= this.getCol() + 1; babyCol++)
                            {

                                //makes sure its not out of bounds
                                if(babyRow < 0 || babyCol < 0 || babyRow > world.length - 1 || (babyCol > world[0].length - 1))
                                {
                                    continue;
                                }
                                else if(world[babyRow][babyCol].isEmpty())
                                {
                                    world[babyRow][babyCol].setOccupant(new Predator(babyRow, babyCol));
                                    this.subtractEnergy(20);
                                    this.reproduce();

                                    world[mateRow][mateCol].getOccupant().subtractEnergy(20);
                                    world[mateRow][mateCol].getOccupant().reproduce();


                                    System.out.println("A Wolf has been born!");

                                    return 0;
                                }

                            }
                        }


                    }

                }
            }

            return 0;
        }
        return 0;

    }
}
