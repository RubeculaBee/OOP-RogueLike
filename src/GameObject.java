public abstract class GameObject
{
    private int x; // Objects X position
    private int y; // Objects Y position
    boolean hasCollision; // Whether the object has collision (are creatures prevented from moving over this object or not)
    private char sprite; // What symbol to use when printing the object

    GameObject(int x, int y, boolean hasCollision, char sprite)
    {
        this.x = x;
        this.y = y;
        this.hasCollision = hasCollision;
        this.sprite = sprite;
    }

    int getX(){return this.x;}
    int getY(){return this.y;}
    void setPosition(int x, int y){this.x = x; this.y = y;}

    public String toString()
    {
        return String.valueOf(this.sprite);
    }
}
