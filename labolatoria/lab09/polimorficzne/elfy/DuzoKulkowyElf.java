package a.Elfy;

import a.bombki.Bombka;
import a.bombki.DuzaKuloBombka;
import a.bombki.KuloBombka;

public class DuzoKulkowyElf extends Elf
{
    public DuzoKulkowyElf(String name, int age, Elf kolegaElf)
    {
        super(name, age, kolegaElf);
    }


    @Override
    public void wezBombke(Bombka bombka)
    {
        if(bombka instanceof DuzaKuloBombka)
        {
            if (bombki.size() < maxBombki) bombki.add(bombka);
            else
            {
                if (kolegaElf != null) kolegaElf.wezBombke(bombka);
                else System.out.println(getImie() + " nie ma kolegi elfa " + "'upuszcza' " + bombka.toString());
            }
        }
        else
        {
            if (kolegaElf != null) kolegaElf.wezBombke(bombka);
            else System.out.println(getImie() + " nie ma kolegi elfa " + "'upuszcza' " + bombka.toString());
        }
    }
}
