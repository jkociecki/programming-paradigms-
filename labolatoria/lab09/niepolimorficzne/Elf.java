package b;

import java.util.LinkedList;
import java.util.List;

public class Elf
{
    LinkedList<Bombka> bombki;
    int maxBombki;
    Elf kolegaElf;
    String imie;
    RodzajBombki rodzajElfa;

    Elf(String imie, int maxBombki, Elf kolegaElf, RodzajBombki rodzajElfa)
    {
        this.imie = imie;
        this.maxBombki = maxBombki;
        this.kolegaElf = kolegaElf;
        this.rodzajElfa = rodzajElfa;
        bombki = new LinkedList<Bombka>();
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

    public void wezBombke(Bombka bombka)
    {
        if(bombka.getRodzaj() == rodzajElfa)
        {
            if(bombki.size() < maxBombki) bombki.add(bombka);
            else
            {
                if(kolegaElf != null) kolegaElf.wezBombke(bombka);
                else System.out.println(imie + " nie ma kolegi elfa, 'UPUSZCZA' " + bombka.toString());
            }
        }
        else
        {
            if(kolegaElf != null) kolegaElf.wezBombke(bombka);
            else System.out.println(imie + " nie ma kolegi elfa, 'UPUSZCZA' " + bombka.toString());
        }
    }
}
