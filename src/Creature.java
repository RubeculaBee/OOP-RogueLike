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

    // Moves the creature in one of 4 directions
    void move(String direction)
    {
        switch (direction.toLowerCase())
        {
            //Sets the creatures previous position to their current position, then changes their position
            case "up" ->
            {
                this.prevX = this.getX();
                this.prevY = this.getY();
                this.setPosition(this.getX(), this.getY()-1);
            }
            case "down" ->
            {
                this.prevX = this.getX();
                this.prevY = this.getY();
                this.setPosition(this.getX(), this.getY()+1);
            }
            case "left" ->
            {
                this.prevX = this.getX();
                this.prevY = this.getY();
                this.setPosition(this.getX()-1, this.getY());
            }
            case "right" ->
            {
                this.prevX = this.getX();
                this.prevY = this.getY();
                this.setPosition(this.getX()+1, this.getY());
            }
        }
    }
}
