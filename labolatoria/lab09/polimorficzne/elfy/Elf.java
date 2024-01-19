package a.Elfy;

import a.bombki.Bombka;

import java.util.LinkedList;

public abstract class Elf
{
    protected String imie;
    protected LinkedList<Bombka> bombki;
    protected int maxBombki;
    protected Elf kolegaElf;

    public Elf(String imie, int maxBombki)
    {
        this(imie, maxBombki, null);
    }

    public Elf(String imie, int maxBombki, Elf kolegaElf)
    {
        this.imie = imie;
        this.maxBombki = maxBombki;
        this.kolegaElf = kolegaElf;
        bombki = new LinkedList<Bombka>();
    }

    protected abstract boolean czyMoznaDodac(Bombka bombka);

    public void wezBombke(Bombka bombka)
    {
        if(czyMoznaDodac(bombka) && bombki.size() < maxBombki)
        {
            bombki.add(bombka);
            if(bombki.size() == maxBombki)
            {
                System.out.println(getImie() + " BIORE NOWE PUDELKO");
                bombki = new LinkedList<Bombka>();
            }
        }
        else
        {
            if (kolegaElf != null) kolegaElf.wezBombke(bombka);
            else System.out.println(getImie() + " nie ma kolegi elfa " + "'upuszcza' " + bombka.toString());
        }
    }
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
