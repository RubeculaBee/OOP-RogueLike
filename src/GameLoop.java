import java.util.Scanner;

public class GameLoop
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        World testRoom = new World(18,9, Layout.INTERSECTION);
        testRoom.terrainUpdate();

        while(true)
        {
            testRoom.creatureUpdate();
            testRoom.display();

            testRoom.player.setAction(input.nextLine());
        }
    }
}