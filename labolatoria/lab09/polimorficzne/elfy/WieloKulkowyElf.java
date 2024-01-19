package a.Elfy;

import a.bombki.Bombka;
import a.bombki.DuzaKuloBombka;
import a.bombki.KuloBombka;
import a.bombki.MalaKuloBombka;

import java.util.LinkedList;

public class WieloKulkowyElf extends Elf
{
    int maxDuzeBombkiLicznik;
    int maxMaleBombkiLicznik;
    int maxDuzeBombki;
    int maxMaleBombki;
    public WieloKulkowyElf(String name, int maxDuzeBombki, int maxMaleBombki)
    {
        super(name, 0);
        this.maxDuzeBombkiLicznik = maxDuzeBombki;
        this.maxMaleBombkiLicznik = maxMaleBombki;
        this.maxMaleBombki = maxMaleBombki;
        this.maxDuzeBombki = maxDuzeBombki;

    }

    public WieloKulkowyElf(String name, int maxDuzeBombki, int maxMaleBombki, Elf kolegaElf)
    {
        super(name, 0, kolegaElf);
        this.maxDuzeBombkiLicznik = maxDuzeBombki;
        this.maxMaleBombkiLicznik = maxMaleBombki;
        this.maxMaleBombki = maxMaleBombki;
        this.maxDuzeBombki = maxDuzeBombki;    }

    public boolean czyMoznaDodac(Bombka bombka)
    {
        return bombka instanceof KuloBombka;
    }

    @Override
    public void wezBombke(Bombka bombka)
    {
        if (czyMoznaDodac(bombka))
        {
            if(bombka instanceof DuzaKuloBombka && maxDuzeBombkiLicznik > 0)
            {
                bombki.add(bombka);
                maxDuzeBombkiLicznik--;
            }
            else if(bombka instanceof MalaKuloBombka && maxMaleBombkiLicznik > 0)
            {
                bombki.add(bombka);
                maxMaleBombkiLicznik--;
            }

            else if(kolegaElf != null)
            {
                kolegaElf.wezBombke(bombka);
            }
            else System.out.println("Nie ma miejsca na bombke");

            if(maxMaleBombkiLicznik == 0 && maxDuzeBombkiLicznik == 0)
            {
                System.out.println( imie + " BIORE NOWE PUDELKO");
                maxMaleBombkiLicznik = maxMaleBombki;
                maxDuzeBombkiLicznik = maxDuzeBombki;
                bombki = new LinkedList<>();
            }
        }
    }
}
