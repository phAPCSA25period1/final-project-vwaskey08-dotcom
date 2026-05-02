public class Prey extends Animal
{
    /* ATTRIBUTES */

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Prey(int row, int col) {

        super(row, col);
    }

    @Override
    public void move(Cell[][] world)
    {
        if(this.getEnergy() > 50 && !feed(world))
        {
              reproduce(world);
        }
        super.move(world);

    }

    public boolean feed(Cell[][] world)
    {

        if(world[this.getRow()][this.getCol()].hasPlant())
        {
            world[this.getRow()][this.getCol()].eatPlant();
            this.addEnergy(10);

            return false;

        }
        else
        {


            for(int plantRow = this.getRow() - 1; plantRow <= this.getRow() + 1; plantRow++)
            {
                for(int plantCol = this.getCol() - 1; plantCol <= this.getCol() + 1; plantCol++)
                {

                    //better way to check conditions?
                    if(plantCol < 0 || plantRow < 0 || plantRow > world.length - 1 || ( plantCol > world[0].length - 1))
                    {
                        continue;
                    }
                    else if(world[plantRow][plantCol].hasPlant() && world[plantRow][plantCol].isEmpty())
                    {
                        world[plantRow][plantCol].setOccupant(this);
                        //set col and row
                        world[this.getRow()][this.getCol()].removeOccupant();

                        this.setRow(plantRow);
                        this.setCol(plantCol);

                        return true;
                    }

                }

            }
            return false;

            }

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
                                world[babyRow][babyCol].setOccupant(new Prey(babyRow, babyCol));
                                this.reproductionEnergy();

                                System.out.println("A Sheep has been born!");

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

