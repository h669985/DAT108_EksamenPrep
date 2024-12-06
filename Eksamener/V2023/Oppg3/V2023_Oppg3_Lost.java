package Oppg3;

import javax.swing.*;
import java.util.Scanner;

public class V2023_Oppg3_Lost {

    //NB! Sjekk PDF for grafiske eksempler!

    /*
     * Vi ønsker å kontrollere en rulletekst som skal vises på en skjerm. Vi har en ferdiglaget klasse kalt
     * Banner som vi skal bruke i løsningen vår. Her er koden for å få et slikt Banner opp på skjermen.
     */

    Banner banner = new Banner("Heia Brann!");

    /**
     * Men vi ønsker at det skal rulle, og vi ønsker å kunne endre teksten mens det ruller. Banner har et par
     * ferdige metoder (setText() og repaint()) vi kan bruke i løsningen vår.
     */

    //Hjelpekode for å få IDEen til å ikke klage, koden er ikke kjørbar
    public static class Banner {
        String text;
        public Banner(String text) {
            this.text = text;
        }

        /** Setter ny tekst på banneret */
        public void setText(String text) {
            this.text = text;
        }

        /** Flytter teksten en pixel til venstre. Hvis teksten kommer til enden
         * tegnes den automatisk opp til høyre ved neste flytt. */
        public void repaint() {}
    }
    /**
     * Oppgaven din er å lage en trådklasse som inneholder et slikt banner, og som bruker det til å vise en
     * rullende tekst. For å få en grei animasjon kan du f.eks. vente 10 ms mellom hver repaint.
     *
     * Trådklassen bør gi (main) mulighet til å sette/endre teksten "i fart" ved å tilby en metode for dette.
     */

    /** a)
     * Lag trådklassen som beskrevet over. Kall den Rulletekst
     */

    public static class Rulletekst extends Thread {
        Banner banner;

        public Rulletekst(String text) {
            banner = new Banner(text);
        }

        private void setTekst(String text) {
            banner.setText(text);
        }

        @Override
        public void run() {
            while(true) {
                banner.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException _) {}
            }
        }
    }

    /** b)
     * Lag et lite main-program som bruker denne trådklassen til å få opp en rulletekst med "Heia
     * Brann!". Deretter har main en evig løkke som lar brukeren gi inn/endre tekst som "rulles".
     */

    public static void main(String[] args) {
       Rulletekst rulletekst = new Rulletekst("Heia Brann!");
        rulletekst.start();

        try (Scanner kbd = new Scanner(System.in)) {
            while (true) {
                System.out.print("Skriv inn ny tekst:");
                String nyTekst = kbd.nextLine();
                rulletekst.setTekst(nyTekst);
            }
        }
    }

}
