public abstract class GameObject
{
    private int x;
    private int y;
    boolean hasCollision;
    private char sprite;

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
