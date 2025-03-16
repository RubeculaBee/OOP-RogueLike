import java.awt.Color;

public class Goblin extends Creature
{
    Player target; // Stores a reference to the player, so the goblin can access it's location

    Goblin(int x, int y, Player target)
    {
        // Goblin always has 20 health, & as it's sprite, and it is dark green
        super(x, y, '&', 20, Color.GREEN.darker());
        this.target = target;
    }

    @Override
    void update()
    {
        // Every two game updates, the goblin chases the player
        if(GameLoop.iterations % 2 == 0)
            chase();
    }

    /* gets the horizontal and vertical distance to the target, then moves closer in whichever
       direction has higher magnitude. */
    private void chase()
    {
        int distanceX = getX() - this.target.getX();
        int distanceY = getY() - this.target.getY();

        if (Math.abs(distanceX) > Math.abs(distanceY))  // If distance on x-axis is greater
            if (distanceX > 0)                          //   if distance is positive (goblin is to the right of target)
                this.move("a");                 //     Move left
            else                                        //   If distance is negative (goblin is to the left of target)
                this.move("d");                 //     Move right
        else                                            // If distance on y-axis is the same or greater
            if (distanceY > 0)                          //   If distance is positive (goblin is below the target)
                this.move("w");                 //     Move up
            else                                        //   If distance is negative (goblin is above the target)
                this.move("s");                 //     Move down
    }
}
