package b;

public class Bombka
{
    private RodzajBombki rodzaj;
    private String kolor;
    private String wzor;

    public Bombka(RodzajBombki rodzaj, String kolor, String wzor)
    {
        this.rodzaj = rodzaj;
        this.kolor = kolor;
        this.wzor = wzor;
    }

    public RodzajBombki getRodzaj()
    {
        return rodzaj;
    }

    public String toString()
    {
        return "Rodzaj: " + rodzaj + " " +
                "Kolor: " + kolor + " " +
                "Wzor: " + wzor + " ";
    }
}
