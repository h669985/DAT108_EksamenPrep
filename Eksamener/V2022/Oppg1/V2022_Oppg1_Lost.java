package Oppg1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class V2022_Oppg1_Lost {
    /** a)
     * Hva er datatypene til følgende uttrykk:
     *      i. a -> a.length()
     *      ii. (Integer a) -> String.valueOf(a)
     *      iii. a -> a.getDayOfWeek().equals(DayOfWeek.MONDAY)
     * Om mulig, vis også hvordan uttrykkene over kan omskrives til metodereferanser.
     */

    /**
     * a.i: a -> a.lenght() har en variablen T som input og gir oss en Integer på output, så det er en Function<T, Integer>
     *     men I java så er det kun string som har .lenght() metoden så vi får Function<String, Integer>
     *
     * a.ii: (Integer a) -> String.valueOf(a) ser ut som en Integer til String Funksjon så vi får Function<Integer, String>
     *
     * a.iii: a -> a.getDayOfWeek().equals(DayOfWeek.MONDAY) tar en variabel T på input og utfører en equals metode
     *        så vi har en Predicate<T> her. Vi ser at a bruker metoden getDayOfWeek() som indikerer at vi bruker
     *        LocalTimeDate eller LocalDate så vi ender opp med Predicate<LocalDate>
     */

    // NB! I lamba funksjoner så bruker vi ALDRI primitive datatyper som int, boolean, double osv.
    //     Bruk ALLTID objektinstanser av primitive datatyper; Integer istedenfor int etc

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
    List<Person> personListe = List.of( //Hjelpeliste for IDE validering
            new Person("Per Daske", LocalDate.of(1998, 12, 8)),
            new Person("Karl Hagen", LocalDate.of(1997, 11, 18)),
            new Person("Helle Fjell", LocalDate.of(1999, 3, 25)),
            new Person("Janne Banne", LocalDate.of(2001, 5, 3))
    );

    //b.i og b.ii
    Consumer<Person> println = p -> System.out.println(p.toString());

    // b.i
    //Unngår public static pga IDE validering
     void goo_main(String[] args) {
        Comparator<Person> byName = Comparator.comparing(p -> p.fulltNavn); // (p1, p2) -> p1.fulltNavn.compareTo(p2.fulltNavn)
        personListe.stream()
                .sorted(byName)
                .forEach(println);
        // Viktig notat: ender opp med en jævla sexy og lesbar stream og vi viser forståelse av både consumer og comparator :)
    }

    // b.ii
    //Unngår public static pga IDE validering
    void boo_main(String[] args) {
         Comparator<Person> byTimeOfYear = Comparator.comparing(p -> p.fodtDato.withYear(2000));
        personListe.stream()
                .sorted(byTimeOfYear)
                .forEach(println);
    }

    //NB! Unngå bruk av map() siden det omformer Person til String
    //    Også ikke bruke .sort istedenfor .stream.sorted, da viser du ikke din kunnskap om streams

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

    void joo_main(String[] args) {
        String tekst = "Per 6 32 Anne xyz Bergen 14";
        int sum = Stream.of(tekst.split(" "))
                .filter(erEtPositivtHeltall)
                .mapToInt(Integer::parseInt) // Integer::valueOf er også brukbar
                .sum();
        System.out.println(sum);
    }

    // Notat: Du kan bruke Arrays.stream(...) eller List.of(...).stream() istedenfor Stream.of(...)
    //        Det er også flere alternative løsninger som for eks map().reduce() hvis du ikke husker mapToInt

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

    // d.i
    public class GeneralisedPrinter {
        public static void printTabellForFunksjon(
                double start, double stopp, double steg, DoubleFunction<Double> funksjon) {
            for (double x=start; x<=stopp; x+=steg) {
                double fx = funksjon.apply(x);
                System.out.printf("%8.3f%8.3f%n", x, fx);
            }
        }

        // Alternativ løsning:
        public static void printTabellForFunksjon2(
                double start, double stopp, double steg, DoubleFunction<Double> funksjon) {
            // Kan også forenkles til en iterate med tre argumenter: iterate(start, x -> x<=stopp, x -> x+steg)
            Stream.iterate(start, x -> x + steg).takeWhile(x -> x <= stopp)
                    .forEach(x -> System.out.printf("%8.3f%8.3f%n", x, funksjon.apply(x)));
        }

    }

    // Notat: Function<Double, Double> er det samme som DoulbeFunction<Double>

    // d.ii
    public static void doo_main(String... blablabla) {
        GeneralisedPrinter.printTabellForFunksjon(1, 5, 1, x -> x*x);
    }


}
