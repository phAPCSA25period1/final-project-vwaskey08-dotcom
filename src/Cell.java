public class Cell
{

    /* ATTRIBUTES */
    private boolean hasAnimal;
    private Animal animal;
    private boolean hasPlant;
    private int plantStatus;


    /* METHODS */

    /**
     * Constructor for cell
     */
    public Cell()
    {
        hasAnimal = false;
        animal = null;
        hasPlant = true;
        plantStatus = 5;

    }


    /* PLANT METHODS */

    /**
     * Checks whether a spot has a plant
     * @return whether the spot has a plant
     */
    public boolean hasPlant()
    {
        if(plantStatus > 0)
        {
            return hasPlant;
        }
        else
        {
            hasPlant = false;
            return hasPlant;
        }

    }

    public void removePlant()
    {
        hasPlant = false;
    }

    public void eatPlant()
    {
        plantStatus --;
    }

    public void growPlant()
    {
        plantStatus ++;
    }


    /* ANIMAL METHODS */

     /**
     * Checks if a spot is empty
     * @return whether the spot has an animal
     */
    public boolean isEmpty()
    {
        return !hasAnimal;
    }

    /**
     * Gets the occupant
     * @return animal
     */
    public Animal getOccupant()
    {

        return animal;
    }

    /**
     * Sets the cell to an animal and turns hasAnimal to true
     * @param animal
     */
    public void setOccupant(Animal animal)
    {
        this.animal = animal;
        hasAnimal = true;
    }

    /**
     * Removes the occupant of the cell
     */
    public void removeOccupant()
    {
        animal = null;
        hasAnimal = false;
    }


}
