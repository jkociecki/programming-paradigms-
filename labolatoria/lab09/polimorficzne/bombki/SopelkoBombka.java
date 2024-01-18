package a.bombki;

import a.bombki.Bombka;

public class SopelkoBombka extends Bombka
{
    private final int wysokosc;
    public SopelkoBombka(String color, String pattern, int height)
    {
        super(color, pattern);
        this.wysokosc = height;
    }

    public String toString()
    {
        return "Icicle Bauble " +
                super.toString() +
                "Height: " + wysokosc;
    }
}
