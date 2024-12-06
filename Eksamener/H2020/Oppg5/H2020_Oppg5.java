package Oppg5;

public class H2020_Oppg5 {
    /* a)
     * Vi ønsker å legge inn en tråd i et program som gjør "bitcoin-mining" i bakgrunnen.
     *
     * "Bitcoin-mining" i denne sammenhengen betyr helt enkelt å gå gjennom en for-løkke for alle
     * positive (long) heltall, beregne en hash for hvert enkelt tall, og sjekke om verdien av hashen
     * starter med fem nullere, altså .startsWith("00000"). I så fall skal tallet og hashen
     * skrives ut på skjermen. F.eks. slik:
     *
     *      262997966 -> 00000PM477MtJDRsn+9RjMhPooy/l2F4Vj7a+WbbZ30=
     *
     * Du kan anta at du har en metode static String hashOf(long number) som utfører
     * selve hashingen av tallet.
     *
     * Tråden skal fortsette beregningene til alle tall t.o.m. Long.MAX_VALUE er gjennomløpt.
     *
     * Skriv en main-metode som oppretter og starter en tråd som gjør slik "bitcoin-mining". (Vi får
     * innbille oss at main også gjør andre ting etterpå, men det tenker vi ikke på her). TIPS: Lag en
     * hjelpemetode for selve logikken som skal utføres i tråden slik at run() kun trenger å kalle
     * denne metoden.
     */

    //TODO -- a) besvarelse

    //---------------------------------------------------------------------------------------------------------

    /* b)
     * Vi skal lage et lite program der flere tråder disponerer en felles "bankkonto". Bankkontoen
     * skal blokkere mot overtrekk, dvs. at tråder som ønsker å gjøre uttak som vil føre til negativ
     * saldo må vente til det er satt inn nok penger før uttaket blir gjennomført.
     *
     * Skriv en main-metode der det opprettes et Bankkonto-objekt og to tråder som gjør en del
     * innskudd og uttak på denne bankkontoen. Skriv også Bankkonto-klassen. (Du trenger ikke å
     * ha med kode for unntakshåndtering.)
     */

    // TODO -- b) besvarelse
}
