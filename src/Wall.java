import java.awt.Color;

public class Wall extends GameObject
{
    Wall(int x, int y)
    {
        // A wall always has collision and # as its sprite
        super(x, y, true, '#', Color.GRAY);
    }
}
