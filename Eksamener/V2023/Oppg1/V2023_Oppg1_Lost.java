package Oppg1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class V2023_Oppg1_Lost {
    /** a)
     * Nedenfor ser du 5 ulike λ-uttrykk, et par uttrykt som metodereferanse. Skriv én setning for
     * hver av disse der de tilordnes en variabel. Det vi er ute etter er datatypen til variablene, f.eks.
     * om det er en Consumer<String>, en Function<Integer, String>, etc. ..
     *
     *      h -> h >= 0 && h <= 59 // der h er et heltall
     *      b -> !b                // der b er en boolsk verdi
     *      s -> s.startsWith("A") // der s er en string
     *      String::length
     *      System.out::println    // Her er det flere muligheter. Velg én.
     */

    // a.i
    Predicate<Integer> mellom_0_og_59_inklusiv = h -> h >= 0 && h <= 59;

    // a.ii
    Predicate<Boolean> not = b -> !b;
    // Notat, kansje du har tenkt deg at predicate er bare en test på en input, siden det er ofte slik vi bruker den
    // Men det som faktisk skjer ar at vi transformerer inputen "<T>" til en Boolean via et lambda utrykk!
    // Så vi kan faktsik gi en Boolean på input og gi motsatt på output!

    // a.iii
    Predicate<String> begynnerMedA = s -> s.startsWith("A");

    // a.iv
    Function<String, Integer> lenght = String::length;

    // a.v
    Consumer<String> println = System.out::println; // Trenger ikke å være string

    // Man kan se at man kan faktisk bruke Function<T, U> i mange av disse tilfellene, men det blir mindre lesbart

    //----------------------------------------------------------------------------------------------------------------

    /** b)
     * Nå skal vi se på en liste av eksamensobjekter. En eksamen har emnekode, dato (LocalDate)
     * og antallOppmeldte. Vi ønsker å sortere listen kronologisk (dvs. sortert etter
     * eksamensdato), og deretter skrive den ut på skjermen. Det er 3 punkter i løsningen
     * (nummerert i koden), som mangler, og som du må svare på:
     *      1. Hva er datatypen til komparatoren kronologisk, som blir 2. parameter i sort(...)?
     *      2. Skriv kode for denne komparatoren som vil gi kronologisk sortering.
     *      3. Skriv kode for utskriften, én eksamen per linje. Anta at Eksamen har en toString().
     * Du får ikke bruke løkke!
     */

    //Hjelpeklasse for IDE validering
    static class Eksamen {
        String emnekode;
        LocalDate dato;
        int antallOppmeldte;

        public Eksamen(String emnekode, LocalDate dato, int antallOppmeldte) {
            this.emnekode = emnekode;
            this.dato = dato;
            this.antallOppmeldte = antallOppmeldte;
        }
    }

    public static void main(String[] args) {
        List<Eksamen> eksamener = Arrays.asList(
                new Eksamen("DAT102", LocalDate.of(2023, Month.MAY, 30), 150),
                new Eksamen("DAT107", LocalDate.of(2023, Month.MAY, 15), 160),
                new Eksamen("DAT108", LocalDate.of(2023, Month.JUNE, 6), 50)
        );
        Comparator<Eksamen> kronologisk = Comparator.comparing(a -> a.dato); // (a, b) -> a.dato.compareTo(b.dato)
        Collections.sort(eksamener, kronologisk);
        eksamener.forEach(System.out::println); // implissit toString() blir brukt og vi trenger ikke stream() før forEach() her
    }

    /*
     * Resultat av kjøring:
     *      Eksamen [emnekode=DAT107, dato=2023-05-15, antallOppmeldte=160]
     *      Eksamen [emnekode=DAT102, dato=2023-05-30, antallOppmeldte=150]
     *      Eksamen [emnekode=DAT108, dato=2023-06-06, antallOppmeldte=50]
     */

    //----------------------------------------------------------------------------------------------------------------

    /** c)
     * Nedenfor ser du en metode fikse(), en metode main() der denne blir kalt, og resultatet av å
     * kjøre main(). Programmet "fikser" store og små bokstaver i en liste av strenger, slik at alle
     * strengene blir på formen "Aaaaa"
     */

    List<String> fikse(List<String> liste, Function<String, String> f) {
        return liste.stream().map(f).toList();
    }
    void foo_main() {
        List<String> liste = List.of("ola", "Per", "pÅL", "ESPEN");
        Function<String, String> navnefiks = s -> s.substring(0, 1).toUpperCase()
                                                + s.substring(1).toLowerCase();
        List<String> resultat = fikse(liste, navnefiks);
        System.out.println(resultat);
    }

    /*
     * Resultat av kjøring:
     *      [Ola, Per, Pål, Espen]
     *
     *      1. Hva skal stå der det står ### 1 ### (dvs. typen til parameteren f, som er det samme
     *         som typen til variabelen navnefiks i main)?
     *
     *      2. Hva skal stå der det står ### 2 ### (dvs. definisjonen av navnefiks)? Tips:
     *         s.substring(0,1) gir første bokstav i en streng, og s.substring(1, s.length()) gir resten
     *         av strengen. Disse kan brukes i løsningen.)
     */

    //----------------------------------------------------------------------------------------------------------------

    /**
     * I oppgavene d)-f) skal vi jobbe litt mer med listen av eksamener fra b
     */

    List<Eksamen> eksamener = Arrays.asList(
            new Eksamen("DAT102", LocalDate.of(2023, Month.MAY, 30), 150),
            new Eksamen("DAT107", LocalDate.of(2023, Month.MAY, 15), 160),
            new Eksamen("DAT108", LocalDate.of(2023, Month.JUNE, 6), 50)
            // ... Du kan anta at denne listen har over 100 elementer ...
    );

    /** d)
     * Bruk streams til å lage en ny liste av alle eksamenene i DAT108 som er i juni (Month.JUNE) ,
     * dvs. alle DAT108-konteeksamener. Legg svaret inn i en variabel.
     */

    Predicate<Eksamen> dat108Juni = e -> e.emnekode.equals("DAT108")
                                      && e.dato.getMonth().equals(Month.JUNE);
    List<Eksamen> dat108JuniEksamener = eksamener.stream()
            .filter(dat108Juni)
            .toList();

    /** e)
     * Bruk streams til å skrive ut på skjermen (uten duplikater) alle emnekoder det er registrert
     * eksamen i, én linje per emne.
     */

    void foo() {
        eksamener.stream()
                .map(e -> e.emnekode) // map(Eksamen::getEmnekode), e -> e.getEmnekode() hvis classen Eksamen ikke var synlig her
                .distinct()
                .forEach(System.out::println);
    }

    /** f)
     * Bruk streams til å beregne gjennomsnittlig antall oppmeldte i alle DAT108-konteeksamener.
     * Bruk helst svaret fra d) i løsningen din. Kutt evt. desimaler slik at svaret blir et heltall. Legg
     * svaret inn i en variabel.
     */

    double sumDesimal = eksamener.stream()
            .mapToInt(e -> e.antallOppmeldte)
            .average()
            .orElse(0.0);

    int sum = (int) Math.round(sumDesimal);

    // Tror nok at sensor ikke bryr seg om å runde opp, så du kan droppe det og heller kaste til int direkte
    // Da fjernes bare desimalen så det blir rundet ned


    //----------------------------------------------------------------------------------------------------------------
}


