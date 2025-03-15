public class Goblin extends Creature implements Hostile
{
    GameObject target;

    Goblin(int x, int y)
    {
        // Goblin always has 20 health and G as it's sprite
        super(x, y, 'G', 20);
    }

    @Override
    void update()
    {
        int distanceX = getX() - this.target.getX();
        int distanceY = getY() - this.target.getY();

        if(Math.abs(distanceX) > Math.abs(distanceY))
            if(distanceX > 0)
                this.move("a");
            else
                this.move("d");
        else
            if(distanceY > 0)
                this.move("w");
            else
                this.move("s");
    }
}
