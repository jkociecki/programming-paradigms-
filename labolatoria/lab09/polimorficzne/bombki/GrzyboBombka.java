package a.bombki;

import a.bombki.Bombka;

public class GrzyboBombka extends Bombka
{
    boolean blaszkowaty;
    boolean czySmaczny;

    public GrzyboBombka(String color, String pattern, boolean czySmaczny, boolean blaszkowaty)
    {
        super(color, pattern);
        this.blaszkowaty = blaszkowaty;
        this.czySmaczny = czySmaczny;
    }

    public String toString()
    {
        return "Grzybo Bombka " +
                super.toString() +
                "czy blaszkowaty: " + blaszkowaty +
                "czy smaczny: " + czySmaczny;

    }
}
