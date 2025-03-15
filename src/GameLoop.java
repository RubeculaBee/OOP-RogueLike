import java.util.Scanner;

public class GameLoop
{
    static Scanner input = new Scanner(System.in);
    static int iterations;

    public static void main(String[] args)
    {
        World testRoom = new World(18,9, Layout.EMPTY);
        testRoom.terrainUpdate();
        testRoom.addCreature(new Goblin(2,2,testRoom.player));

        while(true)
        {
            testRoom.creatureUpdate();
            testRoom.display();

            testRoom.player.setAction(input.nextLine());

            iterations++;
        }
    }
}