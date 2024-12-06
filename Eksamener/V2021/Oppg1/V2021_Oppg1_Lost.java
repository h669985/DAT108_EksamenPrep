package Oppg1;

import java.util.List;
import java.util.function.Supplier;

public class V2021_Oppg1_Lost {

    /**
     * Vi har definert et interface med en metode som tar inn en streng og returnerer en annen streng,
     * f.eks. som returnerer en endret utgave av den som kom inn:
     */

    @FunctionalInterface
    interface Stringfunksjon {
        String anvend(String inn);
    }

    // Vi ønsker å lage en metode for å skrive ut tekst formatert, slik:

    /**
     * Metoden endrer på strengen som kommer inn v.hj.a. Stringfunksjon format,
     * og skriver deretter resultatet ut på skjermen (med System.out.print).
     */
    private static void skrivUtFormatert(String inn, Stringfunksjon format) {
        System.out.println(format.anvend(inn));
    }

    // a) Skriv koden som mangler i kodelistingen over.

    /** b)
     * Skriv en main-metode som bruker skrivUtFormatert() til å skrive ut en tekst (som du velger
     * selv) med
     *      i. Kun store bokstaver, eks. (Java) -> JAVA
     *      ii. Innrammet, eks. (Java) -> [Java]
     *      iii. Med blank mellom hvert tegn -> J a v a
     * Bruk lambda-uttrykk til å representere Stringfunksjon-objektene, og tilordne dem helst til
     * variabler med gode navn før de brukes.
     */

    public static void main(String[] args) {
        String inn = "Java";

        Stringfunksjon tilStorBokstav = String::toUpperCase; // s -> s.toUpperCase()
        skrivUtFormatert(inn, tilStorBokstav);

        Stringfunksjon innrammet = s -> "[" + s + "]";
        skrivUtFormatert(inn, innrammet);

        Stringfunksjon luftig = s -> s.replaceAll("", " ");
        skrivUtFormatert(inn, luftig);
    }

    /** c)
     * Skriv en metode kombiner(...) som tar inn to Stringfunksjon-er og returnerer en
     * Stringfunksjon som gir en kombinasjon av de som puttes inn. F.eks. kan dette brukes til å gi
     * en utskrift som er en kombinasjon av store bokstaver og blanke mellom hver tegn (J A V A).
     */

    Stringfunksjon kombiner(Stringfunksjon f1, Stringfunksjon f2) {
        return s -> f2.anvend(f1.anvend(s));
    }

    /** d)
     * Anta nå at du har en liste spraakliste som inneholder navn på en del programmeringsspråk.
     * Skriv kode som gir en utskrift av disse språkene, bortover på én linje, innrammet (ref. b.ii).
     * Eks: [Java][C#][Haskell][Rust]. Dette skal gjøres på to ulike måter:
     *      i. Ved å bruke streams-APIet, men uten å bruke skrivUtFormatert()
     *      ii. Ved å bruke skrivUtFormatert() (så enkelt som du klarer)
     */

    List<String> kodeSpraak = List.of("Java", "C#", "Haskell", "Rust");

    void foo() {
        Stringfunksjon innrammet = s -> "[" + s + "]";
        kodeSpraak.stream()
                .map(innrammet::anvend)
                .forEach(System.out::print);
    }

    // skrivUtFormatert har new line bygget inn, så vi får ikke alt på samme linje
    void goo() {
        Stringfunksjon innrammet = s -> "[" + s + "]";
        kodeSpraak.forEach(s -> skrivUtFormatert(s, innrammet));
    }
}
