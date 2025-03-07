public abstract class Creature extends GameObject
{
    private int health;


    Creature(int x, int y, char sprite, int health)
    {
        super(x, y, true, sprite);
        this.health = health;
    }

    int getHealth()
    {
        return health;
    }
    void setHealth(int health) {this.health = health;    }

    void move(String direction)
    {
        switch (direction.toLowerCase())
        {
            case "up" ->
            {
                this.setPosition(this.getX(), this.getY()-1);
            }
            case "down" ->
            {
                this.setPosition(this.getX(), this.getY()+1);
            }
            case "left" ->
            {
                this.setPosition(this.getX()-1, this.getY());
            }
            case "right" ->
            {
                this.setPosition(this.getX()+1, this.getY());
            }
        }
    }
}
