import java.util.ArrayList;
import java.util.Collections;

/**
 * Prey extends the Animal class
 *
 * @author Violet Waskey
 * @version 1.0
 */
public class Prey extends Animal
{

    /* CONSTRUCTOR */

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Prey(int row, int col) {

        super(row, col);
    }

    /**
     * Overriden move method
     * @param world
     */
    @Override
    public void move(Cell[][] world)
    {
        // must have enought energy to reproduce
        if(this.getEnergy() > 50)
        {
              reproduce(world);
        }

        // if can't find a suitable place to eat plants, move randomly
        if(!feed(world))
        {
            super.move(world);
        }

    }

      /**
     * checks if the animal is alive
     * @return the status of alive
     */
    @Override
    public boolean isAlive()
    {
        if (this.getAge() < 12 && this.getEnergy() > 0)
        {
            return super.isAlive();
        }
        else
        {
             return false;
        }

    }

    /**
     * Eats
     * @param world
     * @return whether moved to eat
     */
    public boolean feed(Cell[][] world)
    {


        if(world[this.getRow()][this.getCol()].canEatPlant())
        {
            world[this.getRow()][this.getCol()].eatPlant();
            this.addEnergy(20);


            return true;

        }
        else
        {
//STILL NEED TO EDIT
            for(int plantRow = this.getRow() - 1; plantRow <= this.getRow() + 1; plantRow++)
            {
                for(int plantCol = this.getCol() - 1; plantCol <= this.getCol() + 1; plantCol++)
                {


                    //makes sure in bounds
                    if(plantCol < 0 || plantRow < 0 || plantRow > world.length - 1 || ( plantCol > world[0].length - 1))
                    {
                        continue;
                    }
                    else if(world[plantRow][plantCol].canEatPlant() && world[plantRow][plantCol].isEmpty())
                    {
                        world[plantRow][plantCol].setOccupant(this);
                        //set col and row
                        world[this.getRow()][this.getCol()].removeOccupant();

                        this.setRow(plantRow);
                        this.setCol(plantCol);

                        world[this.getRow()][this.getCol()].eatPlant();
                        this.addEnergy(20);

                        return true;
                    }

                }

            }
            return false;

            }

    }

    /**
     * Reproduce
     * @param world
     * @return just to exit
     */
    public int reproduce(Cell[][] world)
    {
        ArrayList<Animal> potentialMates = new ArrayList<>();

        //makes sure cooldown has finished
        if(this.getReproductionCoolDown() == 0 && this.getEnergy() > 20)
        {

            for(int mateRow = this.getRow() - 1; mateRow <= this.getRow() + 1; mateRow++)
            {
                for(int mateCol = this.getCol() - 1; mateCol <= this.getCol() + 1; mateCol++)
                {

                    //better way to check conditions?
                    if(mateCol < 0 || mateRow < 0 || mateRow > world.length - 1 || ( mateCol > world[0].length - 1))
                    {
                        continue;
                    }
                    else if(world[mateRow][mateCol].getOccupant() instanceof Prey)
                    {

                        potentialMates.add(world[mateRow][mateCol].getOccupant());


                    }

                }

            }

            if(potentialMates.size() >= 1)
            {
                Collections.shuffle(potentialMates);

                for(int babyRow = this.getRow() - 1; babyRow <= this.getRow() + 1; babyRow++)
                        {
                            for(int babyCol = this.getCol() - 1; babyCol <= this.getCol() + 1; babyCol++)
                            {

                                //better way to check conditions?
                                if(babyRow < 0 || babyCol < 0 || babyRow > world.length - 1 || (babyCol > world[0].length - 1))
                                {
                                    continue;
                                }
                                else if(world[babyRow][babyCol].isEmpty())
                                {
                                    world[babyRow][babyCol].setOccupant(new Prey(babyRow, babyCol));
                                    this.subtractEnergy(30);
                                    this.reproduceEnergy();
                                    world[potentialMates.get(0).getRow()][potentialMates.get(0).getCol()].getOccupant().subtractEnergy(30);
                                    world[potentialMates.get(0).getRow()][potentialMates.get(0).getCol()].getOccupant().reproduceEnergy();

                                    System.out.println("A Sheep has been born!");
                                    return 0;

                                }

                            }

                        }


            }


        }

        return 0;

    }

}

