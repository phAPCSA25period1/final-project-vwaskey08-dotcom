import java.util.ArrayList;
import java.util.Collections;

/**
 * Predator extends the Animal class
 *
 * @author Violet Waskey
 * @version 1.0
 */
public class Predator extends Animal
{

    //the wolves never win, there is a problem in my logic OMG THE WOLVES WIN
    //make better ending logic
    //make a better ending summation

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
        if (this.getEnergy() > 40)
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
     * checks if the animal is alive
     * @return the status of alive
     */
    @Override
    public boolean isAlive()
    {
        if(this.getAge() < 15)
        {
            return super.isAlive();
        }
        else
        {
             return false;
        }




    }
//maybe wider raidus for move to look for sheep
//everyone keeps moving to the top left

    /**
     * Hunt prey in neighboring cells
     *
     * @param world
     * @return wether hunt was sucessful and affects movement
     */
    public boolean hunt(Cell[][] world)
    {
        ArrayList<Animal> potentialPrey = new ArrayList<>();


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

                    potentialPrey.add(world[preyRow][preyCol].getOccupant());


                }

            }
        }

        //so I noticed that the movement kept going to the top left because it would check that
        //index first, so I asked for tips to randomize movement better and I got suggested
        //creating an arraylist and using shuffle, so then its more accurately random
        if(potentialPrey.size() >= 1)
        {

            Collections.shuffle(potentialPrey);

            world[potentialPrey.get(0).getRow()][potentialPrey.get(0).getCol()].removeOccupant();
            world[this.getRow()][this.getCol()].removeOccupant();
            world[potentialPrey.get(0).getRow()][potentialPrey.get(0).getCol()].setOccupant(this);
            this.setCol(potentialPrey.get(0).getCol());
            this.setRow(potentialPrey.get(0).getRow());

            this.addEnergy(40);
            System.out.println("A Sheep has been eaten.");


            return true;
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

        ArrayList<Animal> potentialMates = new ArrayList<>();

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

                        //add to arraylist here
                        potentialMates.add(world[mateRow][mateCol].getOccupant());

                    }

                }
            }

            //add arraylist thing here

            if(potentialMates.size() >= 1)
            {

                Collections.shuffle(potentialMates);

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
                            //add arraylist here

                            world[babyRow][babyCol].setOccupant(new Predator(babyRow, babyCol));
                            this.subtractEnergy(30);
                            this.reproduceEnergy();

                            world[potentialMates.get(0).getRow()][potentialMates.get(0).getCol()].getOccupant().subtractEnergy(30);
                            world[potentialMates.get(0).getRow()][potentialMates.get(0).getCol()].getOccupant().reproduce();


                            System.out.println("A Wolf has been born!");

                            return 0;

                        }

                    }
                }



            }


        }
        return 0;

    }
}
