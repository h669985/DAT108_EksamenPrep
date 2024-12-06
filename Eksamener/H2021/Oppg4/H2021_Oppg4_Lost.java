package Oppg4;

import javax.swing.*;

public class H2021_Oppg4_Lost {
    /*
     * Vi tar utgangspunkt i programmet under. Her bruker vi et stoppeklokke-objekt til å ta tiden, og vi
     * bruker JOptionPane til å starte og stoppe stoppeklokken.
     */

    // Hjelpeklasse for IDE validering
    public static class StopWatch {
        long elapsedTime;

        public StopWatch() {}

        public void start() {
            elapsedTime = System.currentTimeMillis();
        }

        public void stop() {
            elapsedTime = System.currentTimeMillis() - elapsedTime;
        }

        public String formatTime() {
            return System.currentTimeMillis() - elapsedTime + " milliseconds";
        }
    }

    public static class VisStoppeKlokkeTid extends Thread {
        private boolean showTime = true;
        private StopWatch stoppeklokke;

        public VisStoppeKlokkeTid(StopWatch stoppeklokke) {
            this.stoppeklokke = stoppeklokke;
        }

        public void stopp() {
            showTime = false;
        }

        @Override
        public void run() {
            while (showTime) {
                System.out.println("\rSluttid: " + stoppeklokke.formatTime());
                try {
                    sleep(10);
                } catch (InterruptedException _) {}
            }
        }
    }

    public static class StoppeklokkeMain {
        public static void main(String[] args) throws InterruptedException {
            StopWatch stoppeklokke = new StopWatch();

            VisStoppeKlokkeTid viseTidTraad = new VisStoppeKlokkeTid(stoppeklokke);

            JOptionPane.showConfirmDialog(null, "Start timer?");
            stoppeklokke.start();
            viseTidTraad.start();

            JOptionPane.showConfirmDialog(null, "Stop timer?");
            stoppeklokke.stop();

            viseTidTraad.stopp();
            viseTidTraad.join();

            System.out.println("\nSluttid: " + stoppeklokke.elapsedTime + " milliseconds");
        }

    }

    /*
     * Vi har lyst å fikse dette programmet slik at det i tillegg, mens stoppeklokken går, kontinuerlig (f.eks.
     * hvert 10. millisekund) viser tiden så langt. (NB! Dette må skje samtidig som vi venter på at bruker skal
     * stoppe tidtakingen.)
     *
     * Ved å bruke System.out.print("\r" + det som skal skrives ut) i en løkke kan vi skrive på samme linje i
     * konsollet om igjen og om igjen uten at vi hopper til neste linje. (Antar at "\r" (=return) hopper til
     * starten av linjen uten å hoppe ned slik "\n" (=newline) gjør.)
     *
     * Oppgave: Gjør de nødvendige endringer i programmet + lag evt. nye interfaces og klasser du trenger
     * for å få dette til. Tips: Det er sikkert lurt å lage en trådklasse.
     */
}