package Oppg1;

import java.util.List;

public class H2022_Oppg1 {

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

    // TODO -- a) besvarelse

    //-------------------------------------------------------------------------------------------------
    // b) Anta at du har metoden utplukk, metoden main og resultatet [3, 6, 9] av å kjøre main:

    List<Integer> utplukk(List<Integer> liste, ??? b) {
        return liste.stream().filter(b).toList();
    }

    void main(...) {
        List<Integer> liste = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> resultat = utplukk(liste, ???);
        System.out.println(resultat);
    }

    // Hva skal stå der det står ??? i parameterlisten (dvs. typen til den formelle parameteren b), og
    // hva skal stå der det står ??? i metodekallet (dvs. den aktuelle parameteren)?

    // TODO -- b) besvarelse

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

    // TODO -- c) besvarelse

    /** d)
     * Bruk streams til å skrive ut på skjermen (uten duplikater) alle modellnavn på elbilene, én linje
     * per bilmodell. Bruk gjerne svaret fra forrige spørsmål i løsningen.
     */

    // TODO -- d) besvarelse

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

    // TODO -- e) besvarelse

    //Strømselskapet ønsker å se på ulike modeller for prising, og hvordan dette slår ut på selskapets inntekter.

    /** f)
     * Lag en metode beregnTotalInntekt(...) som tar inn en kundeliste og en funksjon for
     * prisberegning for en enkelt kunde, og som regner ut total inntekt med dette som input.
     */

    // TODO -- f) besvarelse

    /** g)
     * Vis hvordan beregnTotalInntekt(...) kan brukes med et eksempel der prisberegningen er en
     * flat sats på 1.50 kr per kWh. (Altså slik at f.eks. Pål får en regning på 1500,-
     */

    // TODO -- g) besvarelse
}
