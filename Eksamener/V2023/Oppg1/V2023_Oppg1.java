package Oppg1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class V2023_Oppg1 {
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

    // TODO -- a) besvarelse

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
        ### 1 ### kronologisk = ### 2 ###
        Collections.sort(eksamener, kronologisk);
        ### 3 ###
    }

    /*
     * Resultat av kjøring:
     *      Eksamen [emnekode=DAT107, dato=2023-05-15, antallOppmeldte=160]
     *      Eksamen [emnekode=DAT102, dato=2023-05-30, antallOppmeldte=150]
     *      Eksamen [emnekode=DAT108, dato=2023-06-06, antallOppmeldte=50]
     */

    // TODO -- b) besvarelse (fyll inn ovenfor)

    //----------------------------------------------------------------------------------------------------------------

    /** c)
     * Nedenfor ser du en metode fikse(), en metode main() der denne blir kalt, og resultatet av å
     * kjøre main(). Programmet "fikser" store og små bokstaver i en liste av strenger, slik at alle
     * strengene blir på formen "Aaaaa"
     */

    List<String> fikse(List<String> liste, ### 1 ### f) {
        return liste.stream().map(f).toList();
    }
    void foo_main() {
        List<String> liste = List.of("ola", "Per", "pÅL", "ESPEN");
        ### 1 ### navnefiks = ### 2 ###
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

    // TODO -- c) besvarelse (fyll inn ovenfor)

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

    // TODO -- d) besvarelse

    /** e)
     * Bruk streams til å skrive ut på skjermen (uten duplikater) alle emnekoder det er registrert
     * eksamen i, én linje per emne.
     */

    // TODO -- e) besvarelse

    /** f)
     * Bruk streams til å beregne gjennomsnittlig antall oppmeldte i alle DAT108-konteeksamener.
     * Bruk helst svaret fra d) i løsningen din. Kutt evt. desimaler slik at svaret blir et heltall. Legg
     * svaret inn i en variabel.
     */

    // TODO -- f) besvarelse

    //----------------------------------------------------------------------------------------------------------------
}


