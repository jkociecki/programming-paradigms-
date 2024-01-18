package a.bombki;

public abstract class Bombka
{
    protected String color;
    protected String pattern;

    Bombka(String color, String pattern) {
        this.pattern = pattern;
        this.color = color;
    }

    public String toString() {
        return "Pattern: " + pattern + " " +
                "Color: " + color + " ";
    }
}
