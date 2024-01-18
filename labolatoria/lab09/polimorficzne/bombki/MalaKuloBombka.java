package a.bombki;

public class MalaKuloBombka extends KuloBombka
{
    public MalaKuloBombka(String color, String pattern, int radius)
    {
        super(color, pattern, radius);
    }
    public String toString()
    {
        return "Mala " + super.toString();
    }

}
