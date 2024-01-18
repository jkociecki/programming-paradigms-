package a.Elfy;

import a.Elfy.Elf;
import a.bombki.Bombka;
import a.bombki.SopelkoBombka;

public class SopelkowyElf extends Elf
{
    public SopelkowyElf(String name, int maxBombki, Elf kolegaElf)
    {
        super(name, maxBombki, kolegaElf);
    }

    public void wezBombke(Bombka bombka)
    {
        if(bombka instanceof SopelkoBombka)
        {
            if(bombki.size() < maxBombki) bombki.add(bombka);
            else
            {
                if (kolegaElf != null) kolegaElf.wezBombke(bombka);
                else System.out.println
                        (getImie() + " nie ma kolegi elfa " + "'upuszcza' " + bombka.toString());
            }
        }
        else
        {
            if (kolegaElf != null) kolegaElf.wezBombke(bombka);
            else System.out.println
                    (getImie() + " nie ma kolegi elfa " + "'upuszcza' " + bombka.toString());
        }
    }

}
