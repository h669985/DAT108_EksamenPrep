package Oppg1;

import java.util.List;

public class H2021_Oppg1 {


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

    // TODO -- a) besvarelse

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

    // TODO - b) besvarelse

    //c) Skriv en setning som lager en liste av alle boktitler som inneholder ordet Java

    // TODO - c) besvarelse

    //d) Skriv en setning som lager en liste av alle forfatterne uten duplikater

    // TODO - d) besvarelse

    /* e) Utvid d) med at forfatterne sorteres på etternavn ved å bruke Stream<T> sin
     * sorted(Comparator<? super T> comparator) der comparatoren er tilordnet en variabel kalt
     * paaEtternavn før bruk. Tips: s.substring(s.lastIndexOf(" ")) gir etternavnet for navnet s.
     */

    // TODO - e) besvarelse

}
