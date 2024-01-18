package a.Elfy;

import a.Elfy.Elf;
import a.bombki.Bombka;
import a.bombki.KuloBombka;
import a.bombki.MalaKuloBombka;

public class MaloKulkowyElf extends Elf
{
    public MaloKulkowyElf(String name, int age, Elf kolegaElf)
    {
        super(name, age, kolegaElf);
    }

    public void wezBombke(Bombka bombka)
    {
        if(bombka instanceof MalaKuloBombka)
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
