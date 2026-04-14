public class Cell
{
    //later add plant stuff if time

    private boolean hasAnimal;
    private Animal animal;

    public Cell()
    {
        hasAnimal = false;
        animal = null;
    }

    public boolean isEmpty()
    {
        return !hasAnimal;
    }

    public Animal getOccupant()
    {

        return animal;
    }

    public void setOccupant(Animal animal)
    {
        this.animal = animal;
        hasAnimal = true;
    }

    public void removeOccupant()
    {
        animal = null;
        hasAnimal = false;
    }


}
