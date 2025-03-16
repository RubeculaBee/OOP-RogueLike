import java.awt.Color;

public class Player extends Creature
{
    String action; // Stores the command input by the user

    Player(int x, int y)
    {
        //Player always has 100 health, @ as it's sprite, and it's colour is brown
        super(x, y, '@', 100, Color.ORANGE.darker());
        action = "";
    }

    void setAction(String action)
    {
        this.action = action.toLowerCase();
    }

    @Override
    void update()
    {
        // Each updated, the player does something based on action
        switch(this.action)
        {
            //If action is a 'w' 'a' 's' or 'd' then move in the corresponding direction
            case "w", "a", "s", "d" -> move(this.action);
        }
    }
}
