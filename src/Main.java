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
        testRoom.addWall(0,0,width-1,0);
        testRoom.addWall(0,1,0,height-1);
        testRoom.addWall(1,height-1,width-1,height-1);
        testRoom.addWall(width-1,1,width-1,height-1-1);

        testRoom.addWall(6,3,10,4);

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