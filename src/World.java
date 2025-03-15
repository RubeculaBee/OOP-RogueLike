import java.util.ArrayList;

public class World
{
    ArrayList<Creature> creatures; // A list of every creature in the world
    ArrayList<GameObject> terrain; // A list of every non-creature in the world
    GameObject[][][] tilemap; // A 3D array that stores each object at its (x,y) position, as well as its height .
    Player player; // The player, every world needs one.
    int width, height; // The width and height of the world

    final int TERRAIN_LAYER = 0;   // first layer of objects stores the terrain
    final int CREATURE_LAYER = 1; // second layer stores creatures

    World(int width, int height) // initialises a world with specified dimensions
    {
        this.width = width;
        this.height = height;
        this.tilemap = new GameObject[2][height][width];
        this.creatures = new ArrayList<>();
        this.terrain = new ArrayList<>();

        /* When the world is first created, creates a bunch of floor tiles equal to the number of
           spaces in the tilemap. Each floor tile's location is set to a unique place in teh tilemap */
        for(int row = 0; row < this.height; row++)
        {
            for(int col = 0; col < this.width; col++)
                this.terrain.add(new Floor(col, row));
        }

        // Creates a new player and adds them to the creatures list.
        /* When the world is initialised, the player position is set out of bounds
           Therefor, the player's position must be set manually to prevent crashing */
        this.player = new Player(-1,-1);
        this.creatures.add(this.player);
    }

    World(int width, int height, Layout preset) // initialises a world with specified dimensions and a preset layout
    {
        this.width = width;
        this.height = height;
        this.tilemap = new GameObject[2][height][width];
        this.creatures = new ArrayList<>();
        this.terrain = new ArrayList<>();

        for(int row = 0; row < this.height; row++)
        {
            for(int col = 0; col < this.width; col++)
                this.terrain.add(new Floor(col, row));
        }

        this.player = new Player(-1,-1);
        this.creatures.add(this.player);

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

                this.player.setPosition(width/2,height/2);
            }

            // Thick walls along the top and bottom, creating a single empty hallway in the middle
            case HALL_HORIZONTAL ->
            {
                this.addWall(0,0,width-1,(int)((height-1)/3.));
                this.addWall(0, (int)Math.ceil((height/3.)*2),width-1,height-1);

                this.player.setPosition(1,height/2);
            }

            // Thick walls along the left and right, creating a single empty hallway in the middle
            case HALL_VERTICAL ->
            {
                this.addWall(0,0,(int)((width-1)/3.),height-1);
                this.addWall((int)Math.ceil((width/3.)*2),0,width-1,height-1);

                this.player.setPosition(width/2,1);
            }

            /* Large blocks of wall in each corner, creating to hallways that extend from the left to the right, and
               from the top to the bottom, intersecting in the middle */
            case INTERSECTION ->
            {
                this.addWall(0,0, (int)((width-1)/3.), (int)((height-1)/3.));
                this.addWall((int)Math.ceil((width/3.)*2),0,width-1,(int)((height-1)/3.));
                this.addWall(0, (int)Math.ceil((height/3.)*2),(int)((width-1)/3.),height-1);
                this.addWall((int)Math.ceil((width/3.)*2),(int)Math.ceil((height/3.)*2),width-1,height-1);

                this.player.setPosition(1,height/2);
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
                this.terrain.add(new Wall(col, row));
        }
    }

    void addCreature(Creature creature)
    {
        this.creatures.add(creature);
    }

    // Updates the position of each non-creature object.
    // Non-creature objects don't move, so this should only be run when terrain is added
    void terrainUpdate()
    {
        for(GameObject object : this.terrain)
            this.tilemap[TERRAIN_LAYER][object.getY()][object.getX()] = object;
    }

    // Updates the position of each creature.
    // Should be called after each turn.
    void creatureUpdate()
    {
        for(Creature creature : this.creatures) //for each creature
        {
            creature.setPrevPosition();
            creature.update(); // Run the creatures update method

            //check if it's movement collided with anything (and revert it if it did)
            creature.checkCollision(this.tilemap[CREATURE_LAYER][creature.getY()][creature.getX()]);
            creature.checkCollision(this.tilemap[TERRAIN_LAYER][creature.getY()][creature.getX()]);

            //remove the creature from its previous position
            this.tilemap[CREATURE_LAYER][creature.getPrevY()][creature.getPrevX()] = null;
            //push the creature to the tilemap
            this.tilemap[CREATURE_LAYER][creature.getY()][creature.getX()] = creature;
        }
    }

    //Prints the tilemap to the screen
    void display()
    {
        for(int i = 0; i < this.tilemap[0].length; i++)
        {
            for (int j = 0; j < this.tilemap[0][i].length; j++)
                for (int k = this.tilemap.length - 1; k >= 0; k--)
                    if (this.tilemap[k][i][j] != null)
                    {
                        System.out.print(this.tilemap[k][i][j]);
                        break;
                    }
            System.out.print("\n");
        }
    }
}
