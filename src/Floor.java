import java.awt.Color;

public class Floor extends GameObject
{
    Floor(int x, int y)
    {
        // Floor tiles never have collision and have . as their sprite
        super(x, y, false, '.', Color.DARK_GRAY);
    }
}
