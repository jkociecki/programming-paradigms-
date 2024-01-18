package a;

import a.Elfy.DuzoKulkowyElf;
import a.Elfy.GrzybnyElf;
import a.Elfy.MaloKulkowyElf;
import a.Elfy.SopelkowyElf;
import a.bombki.*;

public class Main1
{
    public static void main(String[] args)
    {
        DuzoKulkowyElf elf1 = new DuzoKulkowyElf("Elf1", 2, null);
        MaloKulkowyElf elf2 = new MaloKulkowyElf("Elf2", 2, elf1);
        SopelkowyElf elf3 = new SopelkowyElf("Elf3", 2, elf2);
        GrzybnyElf elf4 = new GrzybnyElf("Elf4", 2, elf3);

        elf4.wezBombke(new GrzyboBombka("czerwony",  "muchomor", true, true));
        elf4.wezBombke(new GrzyboBombka("brazowy",  "borowik", true, false));
        elf4.wezBombke(new GrzyboBombka("brazowy",  "kozlarz babka", true, false));
        elf4.wezBombke(new SopelkoBombka("niebieski", "w paski", 10));
        elf4.wezBombke(new SopelkoBombka("przezroczysty", "szklany", 70));
        elf4.wezBombke(new SopelkoBombka("zielony", "po prostu zielona", 70));
        elf4.wezBombke(new SopelkoBombka("bialo czerowny", "patriotyczny", 75));
        elf4.wezBombke(new DuzaKuloBombka("czerwony",  "w paski", 15));
        elf4.wezBombke(new DuzaKuloBombka("niebieska",  "w mikolaje", 20));
        elf4.wezBombke(new MalaKuloBombka("czerwony",  "w kropki", 5));
        elf4.wezBombke(new MalaKuloBombka("zielony",  "w gwiazdki", 5));
        elf1.wezBombke(new MalaKuloBombka("zielony",  "w gwiazdki", 5));

        System.out.println();
        System.out.println("======== Stan Elfowych Pudelek ========");
        System.out.println(elf4.toString());
        System.out.println(elf3.toString());
        System.out.println(elf2.toString());
        System.out.println(elf1.toString());
    }
}
