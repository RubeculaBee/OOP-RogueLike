public abstract class Creature extends GameObject
{
    private int health; // Creature dies when this attribute reaches 0
    private int prevX; // The X position of the creature before it moved
    private int prevY; // The Y position of the creature before it moved

    Creature(int x, int y, char sprite, int health)
    {
        // Creatures always have collision, but sprite varies
        super(x, y, true, sprite);
        this.prevX = x;
        this.prevY = y;
        this.health = health;
    }

    int getHealth()
    {
        return health;
    }

    int getPrevX(){return this.prevX;}
    int getPrevY(){return this.prevY;}

    void setPrevPosition()
    {
        this.prevX = this.getX();
        this.prevY = this.getY();
    }

    // Called everytime the world updates
    abstract void update();

    void checkCollision(GameObject object)
    {
        if(object != null && object.hasCollision)
            this.setPosition(this.getPrevX(), this.getPrevY());
    }

    // Moves the creature in one of 4 directions
    void move(String direction)
    {
        switch (direction.toLowerCase())
        {
            //Sets the creatures previous position to their current position, then changes their position
            case "w" -> this.setPosition(this.getX(), this.getY()-1);
            case "s" -> this.setPosition(this.getX(), this.getY()+1);
            case "a" -> this.setPosition(this.getX()-1, this.getY());
            case "d" -> this.setPosition(this.getX()+1, this.getY());
        }
    }
}
