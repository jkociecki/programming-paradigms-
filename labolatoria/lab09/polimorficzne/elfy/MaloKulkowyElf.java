package a.Elfy;

import a.Elfy.Elf;
import a.bombki.Bombka;
import a.bombki.KuloBombka;
import a.bombki.MalaKuloBombka;

public class MaloKulkowyElf extends Elf
{
    public MaloKulkowyElf(String name, int maxBombki)
    {
        super(name, maxBombki);
    }
    public MaloKulkowyElf(String name, int age, Elf kolegaElf)
    {
        super(name, age, kolegaElf);
    }

    protected boolean czyMoznaDodac(Bombka bombka)
    {
        return bombka instanceof MalaKuloBombka;
    }

}
