public class Prey extends Animal
{
    /* ATTRIBUTES */
    private int row;
    private int col;

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Prey(int row, int col) {
        super(row, col);
    }

    public Animal reproduce(Cell[][] world)
    {
        for(int babyRow = row - 1; babyRow <= row + 1; babyRow++)
        {
            for(int babyCol = col - 1; babyCol <= col + 1; babyCol++)
            {

                //better way to check conditions?
                if(babyRow < 0 || babyCol < 0 || babyRow > world.length - 1 || (babyCol > world[0].length - 1))
                {
                    continue;
                }
                else if(world[babyRow][babyCol].isEmpty())
                {
                    world[babyRow][babyCol].setOccupant(new Prey(babyRow, babyCol));

                    return world[babyRow][babyCol].getOccupant();
                }

            }
        }

        return null;
    }

}

