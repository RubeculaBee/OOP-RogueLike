import java.awt.Color;

public class Player extends Creature
{
    String action;

    Player(int x, int y)
    {
        //Player always has 100 health and @ as it's sprite
        super(x, y, '@', 100, Color.CYAN);
        action = "";
    }

    void setAction(String action)
    {
        this.action = action.toLowerCase();
    }

    @Override
    void update()
    {
        switch(this.action)
        {
            case "w", "a", "s", "d" -> move(this.action);
        }
    }
}
