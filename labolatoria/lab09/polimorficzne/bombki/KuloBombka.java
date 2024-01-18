package a.bombki;

import a.bombki.Bombka;

public abstract class KuloBombka extends Bombka
{
    protected int radius;
    KuloBombka(String color, String pattern, int radius)
    {
        super(color, pattern);
        this.radius = radius;
    }
    public String toString()
    {
        return  " Kulo Bombka " +
                super.toString() +
                "Radius: " + radius + " ";
    }
}
