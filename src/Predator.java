public class Predator extends Animal
{

    /* ATTRIBUTES */


    /**
     * Constructor
     * @param row
     * @param col
     */
    public Predator(int row, int col) {
        super(row, col);
    }

    @Override
    public void move(Cell[][] world)
    {
        if (this.getEnergy() > 50)
        {
             reproduce(world);
        }
        if(!hunt(world))
        {
            super.move(world);
        }

    }

    public boolean hunt(Cell[][] world)
    {
        for(int preyRow = this.getRow() - 1; preyRow <= this.getRow() + 1; preyRow++)
        {
            for(int preyCol = this.getCol() - 1; preyCol <= this.getCol() + 1; preyCol++)
            {

                //better way to check conditions?
                if(preyRow < 0 || preyCol < 0 || preyRow > world.length - 1 || (preyCol > world[0].length - 1))
                {
                    continue;
                }
                else if(world[preyRow][preyCol].getOccupant() instanceof Prey)
                {
                    world[preyRow][preyCol].removeOccupant();
                    this.addEnergy(20);
                    System.out.println("A Sheep has been eaten.");

                    return true;
                }

            }
        }

        return false;

    }

    public int reproduce(Cell[][] world)
    {

        //check first if there are neighbors around to reproduce,

        for(int mateRow = this.getRow() - 1; mateRow <= this.getRow() + 1; mateRow++)
        {
            for(int mateCol = this.getCol() - 1; mateCol <= this.getCol() + 1; mateCol++)
            {

                //better way to check conditions?
                if(mateCol < 0 || mateRow < 0 || mateRow > world.length - 1 || ( mateCol > world[0].length - 1))
                {
                    continue;
                }
                else if(world[mateRow][mateCol].getOccupant() instanceof Predator)
                {

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
                                world[babyRow][babyCol].setOccupant(new Predator(babyRow, babyCol));
                                this.reproductionEnergy();
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
}
