import java.util.Scanner;

public class GameLoop
{
    static Scanner input = new Scanner(System.in);
    static String action;

    public static void main(String[] args)
    {
        World testRoom = new World(18,9, Layout.INTERSECTION);
        testRoom.terrainUpdate();


        do
        {
            testRoom.creatureUpdate();
            testRoom.display();

            action = input.nextLine().toLowerCase();
            testRoom.player.doAction(action);
        }
        while (!action.equals("exit"));
    }
}