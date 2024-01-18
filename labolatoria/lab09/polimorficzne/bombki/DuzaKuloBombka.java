package a.bombki;

public class DuzaKuloBombka extends KuloBombka
{
    public DuzaKuloBombka(String color, String pattern, int radius)
    {
        super(color, pattern, radius);
    }
    public String toString()
    {
        return "Duza " + super.toString();
    }
}
