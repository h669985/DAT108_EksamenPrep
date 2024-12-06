package Oppg1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class H2021_Oppg1_Lost {

    // a) Tenk at du har en liste av hundenavn slik:
    List<String> hunder = List.of("Fido", "Buster", "Colin");

    /** Ved å bruke forEach(c)-metoden på listen med ulike parametere c kan du lage 3 ulike utskrifter, slik:
     *
     * Fido     *Fido*      odiF
     * Buster   *Buster*    retsuB
     * Colin    *Colin*     niloC
     *
     * Skriv de 3 ulike variantene av parameteren c og lagre dem i variablene printPlain,
     * printMedStjerner og printBaklengs. Husk å få med datatypen til variablene. Tips til baklengs:
     * new StringBuilder(s).reverse() vil snu strengen s
     */

    // Hjelpemetode for printBakengs
    public String baklengs(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    Consumer<String> printPlain = System.out::println;
    Consumer<String> printMedStjerner = s -> System.out.println("*" + s + "*");
    Consumer<String> printBaklengs = s -> System.out.println(baklengs(s));

    /**
     * Sensurnotater:
     * Selv om dette var tenkt som en enkel oppgave er det en del som har bommet /
     * misforstått, f.eks. brukt Function som mapper fra String til String.
     * Jeg synes selv at oppgaven er klar. Det står at den gjelder "forEach(c)-metoden på
     * listen" og at man skal lage de "3 ulike variantene av parameteren c" som gir de 3
     * ulike utskriftene.
     * forEach()-metoden er definert som forEach(Consumer<? super T> action). Parameteren
     * er altså av typen Consumer. I kurset har vi sett på mange eksempler med både
     * forEach() og med Consumer.
     */

    class Bok {
        public String tittel;
        public int aar;
        public List<String> forfattere; //Hver forfatter er en enkel String
        // ... konstruktører og metoder ...
        public Bok(String tittel, int aar, List<String> forfattere) {
            this.tittel = tittel;
            this.aar = aar;
            this.forfattere = forfattere;
        }
    }

    // Tenk så at vi f.eks. har en liste med bøker slik:
    List<Bok> boker = List.of(
            new Bok("Core Java Volume I", 2022,
                    List.of("Cay Horstmann")),
            new Bok("Effective Java", 2017,
                    List.of("Cay Horstmann")),
            new Bok("Head First Java", 2005,
                    List.of("Kathy Sierra", "Bert Bates")),
            new Bok("Java Concurrency in Practice", 2006,
                    List.of("Brian Goetz", "Tim Peierls", "Joshua Bloch"))
            );

    // Du skal nå løse noen oppgaver ved å bruke streams og lambda-uttrykk.
    //b) Skriv en setning som lager en ny liste av alle bøker som er utgitt i 2015 eller tidligere

    List<Bok> for2015Inklusiv = boker.stream()
            .filter(b -> b.aar <= 2015)
            .collect(Collectors.toList());

    //c) Skriv en setning som lager en liste av alle boktitler som inneholder ordet Java

    List<String> boktitlerMedJava = boker.stream()
            .map(b -> b.tittel)
            .filter(b -> b.contains("Java"))
            .collect(Collectors.toList());

    //d) Skriv en setning som lager en liste av alle forfatterne uten duplikater

    List<String> alleForfattere = boker.stream()
            .flatMap(b -> b.forfattere.stream())
            .distinct()
            .collect(Collectors.toList());
    // Siden vi har liste som inneholder liste, bruker vi flatmap for å få brytt opp sublister

    /* e) Utvid d) med at forfatterne sorteres på etternavn ved å bruke Stream<T> sin
     * sorted(Comparator<? super T> comparator) der comparatoren er tilordnet en variabel kalt
     * paaEtternavn før bruk. Tips: s.substring(s.lastIndexOf(" ")) gir etternavnet for navnet s.
     */

    // Hjelpemetode
    static String etternavn(String s) {
        return s.substring(s.lastIndexOf(" "));
    }

    Comparator<String> paaEtternavn = Comparator.comparing(H2021_Oppg1_Lost::etternavn);

    List<String> alleForfattereSortert = alleForfattere.stream()
            .sorted(paaEtternavn)
            .collect(Collectors.toList());
}
