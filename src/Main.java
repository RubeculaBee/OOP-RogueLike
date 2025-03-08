import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static String action;

    public static void main(String[] args)
    {
        int width = 20;
        int height = 8;

        World testRoom = new World(width,height);

        testRoom.player.setPosition(3,3);

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