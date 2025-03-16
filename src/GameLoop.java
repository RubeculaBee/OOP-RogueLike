import java.util.Scanner;

public class GameLoop
{
    static Scanner input = new Scanner(System.in);
    static int iterations;

    public static void main(String[] args)
    {
        World testRoom = new World(18,9, Layout.EMPTY);
        testRoom.terrainUpdate();

        // disgusting code
        for(int i = 0; i < 4; i++)
            testRoom.addCreature(switch((int)(Math.random()*2))
            {
                case 0 -> new Goblin( ((int)(Math.random()*(testRoom.width-2))+1), ((int)(Math.random()*(testRoom.height-2))+1), testRoom.player);
                default -> new Sheep( ((int)(Math.random()*(testRoom.width-2))+1), ((int)(Math.random()*(testRoom.height-2))+1) );
            });

        while(true)
        {
            testRoom.creatureUpdate();
            testRoom.display();

            testRoom.player.setAction(input.nextLine());

            iterations++;
        }
    }
}