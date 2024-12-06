package Oppg1;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class H2022_Oppg1_Lost {

    /** a)
     * Nedenfor ser du 5 ulike λ-uttrykk. Skriv en setning for hver av disse der de tilordnes en
     * variabel. Det vi er ute etter er datatypen til variablene, f.eks. om det er en
     * Consumer<String>, en Function<Integer, String>, etc. ..
     *
     *   a -> System.out.println(a) // der a er en String
     *      (a,b) -> a.compareTo(b) // der a og b er String-er
     *                   a -> a * a // der a er et heltall
     *                   a -> a > 0 // der a er et heltall
     *               (a,b) -> a + b // der a og b er heltall
     */

    Consumer<String> println = System.out::println; // a -> System.out.println(a)

    Comparator<String> compare = String::compareTo; // (a,b) -> a.compareTo(b)

    Function<Integer, Integer> squared = a -> a * a; //Alt1
    UnaryOperator<Integer> squared2 = a -> a * a; //Alt2

    Predicate<Integer> isInteger = a -> a > 0;

    BiFunction<Integer, Integer, Integer> sum = Integer::sum; // (a,b) -> a + b
    BinaryOperator<Integer> sum2 = Integer::sum; //Alt2

    //Notat, alternative løsninger bruker mer spesialiserte lambda utrykk, men har samme funksjon og resultat

    //-------------------------------------------------------------------------------------------------
    // b) Anta at du har metoden utplukk, metoden main og resultatet [3, 6, 9] av å kjøre main:

    public static List<Integer> liste = List.of(1,2,3,4,5,6,7,8,9);

    List<Integer> utplukk(List<Integer> liste, Predicate<Integer> b) {
        return liste.stream().filter(b).toList();
    }

    void foo() {
        List<Integer> resultat = utplukk(liste, b -> b % 3 == 0);
        System.out.println(resultat);
    }

    // Hva skal stå der det står ??? i parameterlisten (dvs. typen til den formelle parameteren b), og
    // hva skal stå der det står ??? i metodekallet (dvs. den aktuelle parameteren)?

    //-------------------------------------------------------------------------------------------------

    // Hjelpeklasse for å IDE validering
    class Bil {
        String skilt;
        String model;

        public Bil(String skilt, String model) {
            this.skilt = skilt;
            this.model = model;
        }
    }

    //I oppgave c) og d) skal du jobbe med en liste av biler, f.eks.:

    List<Bil> biler = List.of(
            new Bil("EK 12345", "Tesla model Y"),
            new Bil("EV 52345", "Tesla model Y"),
            new Bil("SV 12346", "Mazda 5"),
            new Bil("SU 24680", "Volvo 240"),
            new Bil("EL 24683", "Nissan Leaf"));

    /** c)
     * Bruk streams til å lage en ny liste av alle elbilene (de som har skilt som starter med 'E').
     * Leggsvaret inn i en variabel.
     */

    List<Bil> elbiler = biler.stream()
            .filter(b -> b.skilt.startsWith("E"))
            .collect(Collectors.toList());

    /** d)
     * Bruk streams til å skrive ut på skjermen (uten duplikater) alle modellnavn på elbilene, én linje
     * per bilmodell. Bruk gjerne svaret fra forrige spørsmål i løsningen.
     */

    void printModellnavn() {
         elbiler.stream()
                .map(b -> b.model)
                .distinct()
                .forEach(System.out::println);
    }


    //-------------------------------------------------------------------------------------------------

    // Hjelpeklasse for IDE validering
    class Kundedata {
        String fornavn;
        int forbruk;

        public Kundedata(String fornavn, int forbruk) {
            this.fornavn = fornavn;
            this.forbruk = forbruk;
        }
    }

    /*
     * I oppgave e), f) og g) skal du jobbe med beregning av strømregning for en liste med kunder. For
     * enkelhets skyld kan vi si at data om hver kunde kun er navn og forbruk (i kWh), men vi får tenke oss
     * at det også kunne ha vært andre data her. En liste kan f.eks. se slik ut:
     */

    List<Kundedata> kundeliste = List.of(
            new Kundedata("Arne", 1234),
            new Kundedata("Per", 2234),
            new Kundedata("Pål", 1000),
            new Kundedata("Emma", 4000),
            new Kundedata("Ine", 5234),
            new Kundedata("Tone", 1111));

    /** e)
     * Bruk streams til å beregne totalforbruket (i kWh) for alle kundene i kundelisten og legg svaret
     * inn i en variabel.
     */

    int totalForbruk = kundeliste.stream()
            .mapToInt(k -> k.forbruk)
            .sum();

    //Strømselskapet ønsker å se på ulike modeller for prising, og hvordan dette slår ut på selskapets inntekter.

    /** f)
     * Lag en metode beregnTotalInntekt(...) som tar inn en kundeliste og en funksjon for
     * prisberegning for en enkelt kunde, og som regner ut total inntekt med dette som input.
     */

    double bergenTotalInntekt(List<Kundedata> kundeliste, ToDoubleFunction<Kundedata> prisKalku) {
        return kundeliste.stream()
                .mapToDouble(prisKalku)
                .sum();
    }

    //NB! Hvis det er sikkert vanskeligt å kunne huske alle disse spesialisetre lambda utrykkene
    // Det er kanskje bedre å bruke Function over ToDoubleFunction, men da må man huske å bruke map og ikke mapToDouble
    // også må man bruke reduce() istedenfor sum() eller apply().sum()

    //Sjekk PDFen for mange alternative løsninger, jeg syns denne er mest elegant.

    /** g)
     * Vis hvordan beregnTotalInntekt(...) kan brukes med et eksempel der prisberegningen er en
     * flat sats på 1.50 kr per kWh. (Altså slik at f.eks. Pål får en regning på 1500,-
     */

    double totalInntekt = bergenTotalInntekt(kundeliste, k -> k.forbruk * 1.50);
}
