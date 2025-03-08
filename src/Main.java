import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static String action;

    public static void main(String[] args)
    {
        World testRoom = new World(18,9, Layout.INTERSECTION);

        do
        {
            testRoom.update();
            testRoom.display();
            action = input.nextLine();

            testRoom.player.move(action);
        }
        while (!action.equals("exit"));
    }
}