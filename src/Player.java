public class Player extends Creature
{

    Player(int x, int y)
    {
        //Player always has 100 health and @ as it's sprite
        super(x, y, '@', 100);
    }

    void doAction(String action)
    {
        switch(action)
        {
            case "w", "a", "s", "d" -> move(action);
        }
    }
}
