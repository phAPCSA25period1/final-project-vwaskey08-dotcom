
/**
 * Manages the individual Cells of the simulation, both Animals and Plants
 */
public class Cell
{

    /* ATTRIBUTES */
    private boolean hasAnimal;
    private Animal animal;
    private boolean canEatPlant;
    private int plantStatus;
    private int plantGrowthCoolDown;


    /* CONSTRUCTOR */

    /**
     * Constructor for cell
     */
    public Cell()
    {
        hasAnimal = false;
        animal = null;
        canEatPlant = true;
        plantStatus = 3;
        plantGrowthCoolDown = 3;

    }


    /* METHODS */


    /* PLANT METHODS */

    /**
     * Eats part of a plant, if possible, begins coolDown
     */
    public void eatPlant()
    {
        if(canEatPlant())
        {
            plantStatus--;
            plantGrowthCoolDown = 3;
        }
    }

    /**
     * Checks whether a spot has a plant
     * @return whether the spot has a plant
     */
    public boolean canEatPlant()
    {
        if(plantStatus > 0)
        {
            return canEatPlant;
        }
        else
        {
            canEatPlant = false;
            return canEatPlant;
        }

    }

    /**
     * Plant activites over one day
     */
    public void nextDay()
    {
        if(plantGrowthCoolDown >= 0)
        {
            plantGrowthCoolDown--;
        }
        else
        {
            plantStatus ++;
        }

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



/*EXTRA METHODS UNUSED*/

// public int getPlantStatus()
    // {
    //     return plantStatus;
    // }




    // public void setPlantGrowthCoolDown()
    // {
    //     plantGrowthCoolDown = 3;
    // }



    // public void growPlant()
    // {
    //     if (plantGrowthCoolDown == 0)
    //     {
    //          plantStatus ++;
    //     }

    // }


    // public void removePlant()
    // {
    //     hasPlant = false;
    // }

