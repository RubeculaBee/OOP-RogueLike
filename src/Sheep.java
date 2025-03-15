import java.awt.Color;

public class Sheep extends Creature
{
    Sheep(int x, int y)
    {
        super(x, y, 'm', 10, Color.LIGHT_GRAY);
    }

    @Override
    void update()
    {
        switch ((int) (Math.random()*8))
        {
            case 0 -> move("w");
            case 1 -> move("a");
            case 2 -> move("s");
            case 3 -> move("d");
            default -> {}
        }
    }
}
