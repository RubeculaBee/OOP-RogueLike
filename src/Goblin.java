public class Goblin extends Creature
{
    Player target;

    Goblin(int x, int y, Player target)
    {
        // Goblin always has 20 health and G as it's sprite
        super(x, y, 'G', 20);
        this.target = target;
    }

    @Override
    void update()
    {
        chase();
    }

    void chase()
    {
        int distanceX = getX() - this.target.getX();
        int distanceY = getY() - this.target.getY();

        if(Math.abs(distanceX) + Math.abs(distanceY) > 1)
        {
            if (Math.abs(distanceX) > Math.abs(distanceY))
                if (distanceX > 0)
                    this.move("a");
                else
                    this.move("d");
            else if (distanceY > 0)
                this.move("w");
            else
                this.move("s");
        }
    }
}
