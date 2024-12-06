package Oppg1;

import java.time.LocalDate;
import java.util.function.Predicate;

public class V2022_Oppg1 {
    /** a)
     * Hva er datatypene til følgende uttrykk:
     *      i. a -> a.length()
     *      ii. (Integer a) -> String.valueOf(a)
     *      iii. a -> a.getDayOfWeek().equals(DayOfWeek.MONDAY)
     * Om mulig, vis også hvordan uttrykkene over kan omskrives til metodereferanser.
     */

    // TODO -- a) besvarelse

    //----------------------------------------------------------------------------------------------------------

    /** b)
     * Anta at vi har en liste av Person-objekter referert av liste-variabelen venner, og vi ønsker å få
     * skrevet dem ut sortert på et par ulike måter. Person-klassen ser du nedenfor.
     */

    public class Person {
        String fulltNavn;
        LocalDate fodtDato;

        public Person(String fulltNavn, LocalDate fodtDato) {
            this.fulltNavn = fulltNavn;
            this.fodtDato = fodtDato;
        }

        // + gettere, settere og toString
    }

    /*
     *      i. Skriv en main-metode som skriver listen ut sortert på navn, en person per linje.
     *      ii. Skriv en main-metode som skriver listen ut sortert etter når på året de har bursdag (året
     *          betyr ikke noe, kun når på året) TIPS: Siden året ikke skal være med i sammenligning kan
     *          dette settes til et fast år i sammenligningen ved å bruke LocalDate.withYear()-metoden.
     */

    // TODO -- b) besvarelse

    //-----------------------------------------------------------------------------------------------------------

    /** c)
     * Denne oppgaven går ut på å parse og summere sammen alle positive heltall i en tekst.
     * Vi kan f.eks. ha teksten "Per 6 32 Anne xyz Bergen 14" som skal gi svaret 52 (altså 6+32+14).
     * Det første steget kan være å dele opp teksten i tokens med t.split(" ").
     * Deretter er det å plukke ut det som er tall. Til dette har jeg definert et predikat som sier om en
     * tekst er et heltall. Dette forventes brukt i løsningen.
     */

    Predicate<String> erEtPositivtHeltall = t -> t.matches("^\\d+$");

    /*
     * Lag en main()-metode som tar utgangspunkt i en tekst (lagret i en String-variabel), og som ved
     * hjelp av tipsene over beregner summen av alle positive heltall i teksten. Bruk streams-APIet.
     * Svaret skal til slutt skrives ut på skjermen.
     */

    // TODO c) besvarelse

    //-----------------------------------------------------------------------------------------------------------

    /** d)
     *  Vi har laget en metode for å skrive ut en tabell av funksjonsverdier for kvadratfunksjonen f(x) = x^2:
     */

    public class Printer {
        public static void printTabellForKvadratfunksjon(
                double start, double stopp, double steg) {
            for (double x=start; x<=stopp; x+=steg) {
                double fx = x*x;
                System.out.printf("%8.3f%8.3f%n", x, fx);
            }
        }
    }

    // Bruken av denne kan f.eks. være slik:
    public static void foo_main(String... blablabla) {
        Printer.printTabellForKvadratfunksjon(1, 5, 1);
    }

    /*
     * Vi ønsker å lage en mer generell metode som skriver ut en tabell av funksjonsverdier for en
     * vilkårlig funksjon (f.eks. f(x) = sin(x), f(x) = log(x), osv..).
     *      i. Lag en metode tilsvarende den som er vist over slik at dette er mulig. Kall den nye
     *         metoden printTabellForFunksjon(...).
     *      ii. Bruk den nye generelle metoden fra i. i main-programmet i stedet for den gamle til å
     *          skrive ut kvadrattallene fra 1 til 5 som i eksemplet.
     */

    // TODO -- d) besvarelse
}
