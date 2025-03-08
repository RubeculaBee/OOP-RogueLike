import java.util.ArrayList;

public class World
{
    ArrayList<GameObject> objects;
    GameObject[][] tilemap;
    Player player;
    int width, height;

    World(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.tilemap = new GameObject[height][width];
        this.objects = new ArrayList<>();

        for(int row = 0; row < this.height; row++)
        {
            for(int col = 0; col < this.width; col++)
                this.objects.add(new Floor(col, row));
        }

        this.player = new Player(-1,-1);
        this.objects.add(this.player);
    }

    void addWall(int startX, int startY, int endX, int endY)
    {
        for(int row = startY; row <= endY; row++)
        {
            for(int col = startX; col <= endX; col++)
                objects.add(new Wall(col, row));
        }
    }

    void update()
    {
        if(tilemap[player.getY()][player.getX()] != null && tilemap[player.getY()][player.getX()].hasCollision)
            player.setPosition(player.getPrevX(), player.getPrevY());

        for(GameObject object : objects)
            tilemap[object.getY()][object.getX()] = object;
    }

    void display()
    {
        for(GameObject[] row : tilemap)
        {
            for(GameObject object : row)
                System.out.print(object);

            System.out.print("\n");
        }
    }
}
