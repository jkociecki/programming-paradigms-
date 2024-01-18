package b;

import a.Elfy.DuzoKulkowyElf;
import a.Elfy.GrzybnyElf;
import a.Elfy.MaloKulkowyElf;
import a.Elfy.SopelkowyElf;
import a.bombki.DuzaKuloBombka;
import a.bombki.GrzyboBombka;
import a.bombki.MalaKuloBombka;
import a.bombki.SopelkoBombka;

import static b.RodzajBombki.*;

public class Main2
{
    public static void main(String[] args)
    {
        Elf elf1 = new Elf("Elf1", 2, null, DUZA_KULO_BOMBKA);
        Elf elf2 = new Elf("Elf2", 2, elf1 , MALA_KULO_BOMBKA);
        Elf elf3 = new Elf("Elf3", 2, elf2, SOPELKO_BOMBKA);
        Elf elf4 = new Elf("Elf4", 2, elf3, GRZYBO_BOMBKA);

        elf4.wezBombke(new Bombka(GRZYBO_BOMBKA,"czerwony",  "muchomor"));
        elf4.wezBombke(new Bombka(GRZYBO_BOMBKA,"brazowy",  "borowik"));
        elf4.wezBombke(new Bombka(GRZYBO_BOMBKA,"brazowy",  "kozlarz babka"));
        elf4.wezBombke(new Bombka(SOPELKO_BOMBKA, "zielony", "w paski"));
        elf4.wezBombke(new Bombka(SOPELKO_BOMBKA, "przezroczysty", "szklany"));
        elf4.wezBombke(new Bombka(SOPELKO_BOMBKA, "zielona", "po prostu zielona"));
        elf4.wezBombke(new Bombka(SOPELKO_BOMBKA, "bialo czerowny", "patriotyczny"));
        elf4.wezBombke(new Bombka(DUZA_KULO_BOMBKA, "czerwony",  "w paski"));
        elf4.wezBombke(new Bombka(DUZA_KULO_BOMBKA, "niebieska",  "w mikolaje"));
        elf4.wezBombke(new Bombka( MALA_KULO_BOMBKA, "pomaranczowa", "kropki"));
        elf4.wezBombke(new Bombka( MALA_KULO_BOMBKA,"granatowa", "gwiazdki"));
        elf1.wezBombke(new Bombka(MALA_KULO_BOMBKA, "zielony",  "w rekawiczki"));

        System.out.println();
        System.out.println("======== Stan Elfowych Pudelek ========");
        System.out.println(elf4.toString());
        System.out.println(elf3.toString());
        System.out.println(elf2.toString());
        System.out.println(elf1.toString());    }
}
