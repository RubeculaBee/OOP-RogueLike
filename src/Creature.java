public abstract class Creature extends GameObject
{
    private int health;
    private int prevX;
    private int prevY;

    Creature(int x, int y, char sprite, int health)
    {
        super(x, y, true, sprite);
        prevX = x;
        prevY = y;
        this.health = health;
    }

    int getHealth()
    {
        return health;
    }
    void setHealth(int health) {this.health = health;}

    int getPrevX(){return this.prevX;}
    int getPrevY(){return this.prevY;}

    void move(String direction)
    {
        switch (direction.toLowerCase())
        {
            case "up" ->
            {
                prevX = this.getX();
                prevY = this.getY();
                this.setPosition(this.getX(), this.getY()-1);
            }
            case "down" ->
            {
                prevX = this.getX();
                prevY = this.getY();
                this.setPosition(this.getX(), this.getY()+1);
            }
            case "left" ->
            {
                prevX = this.getX();
                prevY = this.getY();
                this.setPosition(this.getX()-1, this.getY());
            }
            case "right" ->
            {
                prevX = this.getX();
                prevY = this.getY();
                this.setPosition(this.getX()+1, this.getY());
            }
        }
    }
}
