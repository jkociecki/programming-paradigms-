package a.Elfy;

import a.Elfy.Elf;
import a.bombki.Bombka;
import a.bombki.GrzyboBombka;

public class GrzybnyElf extends Elf
{
    public GrzybnyElf(String name, int maxBombki)
    {
        super(name, maxBombki);
    }
    public GrzybnyElf(String name, int maxBombki, Elf kolegaElf)
    {
        super(name, maxBombki, kolegaElf);
    }

    protected boolean czyMoznaDodac(Bombka bombka)
    {
        return bombka instanceof GrzyboBombka;
    }

}
