public class Animal
{
    private int xPos;
    private int yPos;

    private int age;
    private int energy;

    private boolean alive;

    public Animal(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;

        alive = true;
        age = 1;
        energy = 100;

    }

    public String getPos()
    {
        return "(" + xPos +", " + yPos + ")";
    }

    public boolean isAlive()
    {
        return alive;
    }

    public int getEnergy()
    {
        return energy;
    }

    public int getAge()
    {
        return age;
    }

    public void move(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }


}

