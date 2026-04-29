public class Predator extends Animal
{

    /* ATTRIBUTES */
    private int row;
    private int col;
    private int energy;


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
        if(!hunt(world))
        {
            super.move(world);
        }

    }

    public boolean hunt(Cell[][] world)
    {
        boolean eaten = false;

        int newRow = returnNewRow(world);
        int newCol = returnNewCol(world);
        // if the random spot has a prey
        if(world[newRow][newCol].getOccupant() instanceof Predator)
        {
            world[newRow][newCol].removeOccupant();
            world[newRow][newCol].setOccupant(this);
            row = newRow;
            col = newCol;

            energy += 10;

            eaten = true;
            System.out.println("One less sheep...");
        }

        return eaten;
    }
}
