package b;

import java.util.LinkedList;

public class Elf
{
    LinkedList<Bombka> bombki;
    int maxBombki;
    Elf kolegaElf;
    String imie;
    Rodzaj rodzajElfa;

    int maxDuze;
    int maxMale;
    int duzeLicznik;
    int maleLicznik;

    Elf(String imie, int maxBombki, Rodzaj rodzajElfa)
    {

        this(imie, maxBombki, null, rodzajElfa);
    }

    Elf(String imie, int maxDuze, int maxMale, Rodzaj rodzajELfa, Elf kolegaElf)
    {
        this.imie = imie;
        this.maxDuze = maxDuze; this.duzeLicznik = maxDuze;
        this.maxMale = maxMale; this.maleLicznik = maxMale;
        this.rodzajElfa = rodzajELfa;
        this.kolegaElf = kolegaElf;
        bombki = new LinkedList<>();
    }

    Elf(String imie, int maxBombki, Elf kolegaElf, Rodzaj rodzajElfa)
    {
        this.imie = imie;
        this.maxBombki = maxBombki;
        this.kolegaElf = kolegaElf;
        this.rodzajElfa = rodzajElfa;
        bombki = new LinkedList<Bombka>();
    }

    public String toString()
    {
        String result = imie + ":\n";
        for (Bombka bombka : bombki)
        {
            result += bombka.toString() + "\n";
        }
        return result;
    }

    public void wezBombke(Bombka bombka)
    {
        if(rodzajElfa == Rodzaj.MIESZANY)
        {
           if(bombka.getRodzaj() == Rodzaj.MALA_KULA)
           {
               if(maleLicznik > 0)
               {
                   bombki.add(bombka);
                   maleLicznik--;
               }
               else if (kolegaElf != null) kolegaElf.wezBombke(bombka);
               else System.out.println(imie + " UPUSZCZA BOMBKE");
           }
           else if(bombka.getRodzaj() == Rodzaj.DUZA_KULA)
           {
               if (duzeLicznik > 0)
               {
                   bombki.add(bombka);
                   duzeLicznik--;
               }
               else if (kolegaElf != null) kolegaElf.wezBombke(bombka);
               else System.out.println(imie + " UPUSZCZA BOMBKE");
           }
           if(maleLicznik == 0 && duzeLicznik == 0)
           {
               maleLicznik = maxMale;
               duzeLicznik = maxDuze;
               bombki = new LinkedList<>();
               System.out.println(imie + " BIORE NOWE PUDELKO!");
           }

        }
        else if(bombka.getRodzaj() == rodzajElfa && bombki.size() < maxBombki)
        {
            bombki.add(bombka);
            if(bombki.size() == maxBombki)
            {
                System.out.println(imie + " BIORE NOWE PUDELKO!");
                bombki = new LinkedList<>();
            }
        }
        else
        {
            if(kolegaElf != null) kolegaElf.wezBombke(bombka);
            else System.out.println(imie + " nie ma kolegi elfa, 'UPUSZCZA' " + bombka.toString());
        }
    }
}
