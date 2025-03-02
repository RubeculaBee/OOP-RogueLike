public abstract class Creature extends GameObject
{
    private int health;
    boolean upValid;
    boolean downValid;
    boolean leftValid;
    boolean rightValid;

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
                if (upValid)
                    this.setPosition(this.getX(), this.getY()-1);
            }
            case "down" ->
            {
                if (downValid)
                    this.setPosition(this.getX(), this.getY()+1);
            }
            case "left" ->
            {
                if (leftValid)
                    this.setPosition(this.getX()-1, this.getY());
            }
            case "right" ->
            {
                if (rightValid)
                    this.setPosition(this.getX()+1, this.getY());
            }
        }
    }
}
