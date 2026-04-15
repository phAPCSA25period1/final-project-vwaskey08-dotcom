public class Animal
{
    /*
    TO DO:

    Do i actually need the x and y position? idk yet we'll see ig

    */

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

     /**
     * checks if the animal is alive
     * @return the status of alive
     */
    public boolean isAlive()
    {
        return alive;
    }

    /* WILL GET MORE ATTENTION NEXT SPRINT */
    /**
     * moves the animal
     * @param xPos
     * @param yPos
     */
    public void move(int row, int col)
    {
        this.row = row;
        this.col = col;
    }


        /* GETTERS */

    /**
     * gets the positon of the animal
     * @return the postion
     */
    public String getPos()
    {
        return "(" + row +", " + col + ")";
    }


    /**
     * checks the energy of the animal
     * @return energy
     */
    public int getEnergy()
    {
        return energy;
    }


    /**
     * gets the age of the animal
     * @return age
     */
    public int getAge()
    {
        return age;
    }


}

