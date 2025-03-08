import java.util.ArrayList;

public class World
{
    ArrayList<GameObject> objects; // A list of every object in the world
    GameObject[][] tilemap; // A 2D array that stores each object at its position.
    Player player; // The player, every world needs one.
    int width, height; // The width and height of the world

    World(int width, int height) // initialises a world with specified dimensions
    {
        this.width = width;
        this.height = height;
        this.tilemap = new GameObject[height][width];
        this.objects = new ArrayList<>();

        /* When the world is first created, creates a bunch of floor tiles equal to the number of
           spaces in the tilemap. Each floor tile's location is set to a unique place in teh tilemap */
        for(int row = 0; row < this.height; row++)
        {
            for(int col = 0; col < this.width; col++)
                this.objects.add(new Floor(col, row));
        }

        // Creates a new player and adds them to the object list.
        /* When the world is initialised, the player position is set out of bounds
           Therefor, the player's position must be set manually to prevent crashing */
        this.player = new Player(-1,-1);
        this.objects.add(this.player);
    }

    World(int width, int height, Layout preset) // initialises a world with specified dimensions and a preset layout
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

        this.initPreset(preset);
    }

    // Adds walls to create the specified layout
    private void initPreset(Layout preset)
    {
        switch(preset)
        {
            //Walls surround the perimeter, otherwise nothing else
            case EMPTY ->
            {
                this.addWall(0,0,width-1,0);
                this.addWall(0,1,0,height-1);
                this.addWall(1,height-1,width-1,height-1);
                this.addWall(width-1,1,width-1,height-1-1);
            }

            // Thick walls along the top and bottom, creating a single empty hallway in the middle
            case HORIZONTAL_HALL ->
            {
                this.addWall(0,0,width-1,(int)((height-1)/3.));
                this.addWall(0, (int)Math.ceil((height/3.)*2),width-1,height-1);
            }

            // Thick walls along the left and right, creating a single empty hallway in the middle
            case VERTICAL_HALL ->
            {
                this.addWall(0,0,(int)((width-1)/3.),height-1);
                this.addWall((int)Math.ceil((width/3.)*2),0,width-1,height-1);
            }

            /* Large blocks of wall in each corner, creating to hallways that extend from the left to the right, and
               from the top to the bottom, intersecting in the middle */
            case INTERSECTION ->
            {
                this.addWall(0,0, (int)((width-1)/3.), (int)((height-1)/3.));
                this.addWall((int)Math.ceil((width/3.)*2),0,width-1,(int)((height-1)/3.));
                this.addWall(0, (int)Math.ceil((height/3.)*2),(int)((width-1)/3.),height-1);
                this.addWall((int)Math.ceil((width/3.)*2),(int)Math.ceil((height/3.)*2),width-1,height-1);
            }
        }
    }

    // Adds an amount of wall tiles to the object list, with positions between the start and end point
    /* (effectively draws a filled rectangle of Walls with the start position as the top-left corner and
       the end position as the bottom-right corner */
    void addWall(int startX, int startY, int endX, int endY)
    {
        for(int row = startY; row <= endY; row++)
        {
            for(int col = startX; col <= endX; col++)
                this.objects.add(new Wall(col, row));
        }
    }

    // Adds each object in the object list to the tilemap at their position
    void update()
    {
        // If the player's position would place the player onto an object with collision, it is first put back to its previous position
        /* Only runs collision check if the object exists, because otherwise it could crash trying to check
           the collision of an object that does not exist */
        if(this.tilemap[this.player.getY()][this.player.getX()] != null && this.tilemap[this.player.getY()][this.player.getX()].hasCollision)
            this.player.setPosition(this.player.getPrevX(), this.player.getPrevY());

        /* Objects are placed in the order they exist in the object list, thus objects later in the list will
           replace, and in a sense be "drawn over" objects earlier in the list. The first objects in the list will
           always be floor tiles, followed by the player, as they are added when the world is initialised */
        for(GameObject object : this.objects)
            this.tilemap[object.getY()][object.getX()] = object;
    }

    //Prints the tilemap to the screen
    void display()
    {
        for(GameObject[] row : this.tilemap)
        {
            for(GameObject object : row)
                System.out.print(object);

            System.out.print("\n");
        }
    }
}
