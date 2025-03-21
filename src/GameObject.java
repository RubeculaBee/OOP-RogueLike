import java.awt.Color;

public abstract class GameObject
{
    private int x;         // Objects X position
    private int y;         // Objects Y position
    boolean hasCollision;  // Whether the object has collision (are creatures prevented from moving over this object or not)
    private char sprite;   // What symbol to use when printing the object
    private Color color;   // What colour to use when printing the object

    GameObject(int x, int y, boolean hasCollision, char sprite, Color color)
    {
        this.x = x;
        this.y = y;
        this.hasCollision = hasCollision;
        this.sprite = sprite;
        this.color = color;
    }

    int getX(){return this.x;}
    int getY(){return this.y;}
    void setPosition(int x, int y){this.x = x; this.y = y;}

    // Returns the objects symbol, wrapped in ANSI escape codes that set the print colour to the creatures colour
    @Override
    public String toString()
    {
        return String.format("\033[38;2;%d;%d;%dm%s\033[0m", this.color.getRed(), this.color.getGreen(), this.color.getBlue(), this.sprite);
    }
}
