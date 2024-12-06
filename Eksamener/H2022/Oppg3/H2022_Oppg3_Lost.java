package Oppg3;

public class H2022_Oppg3_Lost {
    /**
     * Vi ønsker å lage et program som beregner store Fibonacci-tall, f.eks. fib(50). Du trenger ikke å tenke
     * på hvordan utregningen gjøres. Poenget er at utregningen kan ta litt tid (O(2^n)) hvis vi bruker en
     * enkel/naiv algoritme.
     *
     * For å ha en følelse av at programmet gjør noe mens beregningen foregår skal det skrives ut en prikk
     * hvert sekund så lenge utregningen foregår. Når beregningen er ferdig skal svaret skrives ut på
     * skjermen og programmet avslutte.
     *
     * Eksempel på beregning og utskrift av fib(48), som tok ca. 30 sekunder:
     *
     *      Beregner fib(48): .............................
     *      Svar: 4807526976
     *
     * Vi kan anta at vi har en metode long fib(int n) som vi kan gjøre et metodekall til for å få utført selve
     * beregningen. (Det er denne metoden som bruker lang tid.)
     *
     * Du skal skrive main(), som skal gjøre følgende:
     *       Tallet vi skal bruke i kjøringen (f.eks. 50) kan være en hardkodet konstant.
     *       Det skal opprettes og startes en tråd som gjør beregningen og skriver ut svaret.
     *       Det skal skrives ut en prikk hvert sekund så lenge den andre tråden isAlive() (som er en
     *         metode i Thread-klassen).
     *
     * For å få full score må løsningen ikke være unødvendig komplisert.
     */

    // Hjelpemetode for IDE validering
    public static long fib(int n) {
        if(n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        final int N = 48;

        Thread fibTraad = new Thread(() -> System.out.println("\nSvar: " + fib(N)));

        System.out.print("\rBeregner fib(" + N + "): ");
        fibTraad.start();

        while (fibTraad.isAlive()) {
            System.out.print(".");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException _) {}
        }
    }

}
