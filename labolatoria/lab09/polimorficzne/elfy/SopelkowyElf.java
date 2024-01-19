package a.Elfy;

import a.Elfy.Elf;
import a.bombki.Bombka;
import a.bombki.SopelkoBombka;

public class SopelkowyElf extends Elf
{
    public SopelkowyElf(String name, int maxBombki)
    {
        super(name, maxBombki);
    }
    public SopelkowyElf(String name, int maxBombki, Elf kolegaElf)
    {
        super(name, maxBombki, kolegaElf);
    }

    protected boolean czyMoznaDodac(Bombka bombka)
    {
        return bombka instanceof SopelkoBombka;
    }

}
