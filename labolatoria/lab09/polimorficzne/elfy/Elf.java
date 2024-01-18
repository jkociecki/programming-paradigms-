package a.Elfy;

import a.bombki.Bombka;

import java.util.LinkedList;

public abstract class Elf
{
    protected String imie;
    protected LinkedList<Bombka> bombki;
    protected int maxBombki;
    protected Elf kolegaElf;

    public Elf(String imie, int maxBombki, Elf kolegaElf)
    {
        this.imie = imie;
        this.maxBombki = maxBombki;
        bombki = new LinkedList<Bombka>();
        this.kolegaElf = kolegaElf;
    }

    public abstract void wezBombke(Bombka bombka);

    public String toString()
    {
        String result = imie + ":\n";
        for (Bombka bombka : bombki)
        {
            result += bombka.toString() + "\n";
        }
        return result;
    }

    public String getImie()
    {
        return imie;
    }
}
