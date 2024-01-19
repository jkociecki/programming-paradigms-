package a.Elfy;

import a.bombki.Bombka;
import a.bombki.DuzaKuloBombka;
import a.bombki.KuloBombka;

public class DuzoKulkowyElf extends Elf
{
    public DuzoKulkowyElf(String name, int maxBombki)
    {
        super(name, maxBombki);
    }
    public DuzoKulkowyElf(String name, int age, Elf kolegaElf)
    {
        super(name, age, kolegaElf);
    }
    protected boolean czyMoznaDodac(Bombka bombka)
    {
        return bombka instanceof KuloBombka;
    }
}
