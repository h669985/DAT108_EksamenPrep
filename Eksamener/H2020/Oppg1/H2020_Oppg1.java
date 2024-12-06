package Oppg1;

import java.util.Arrays;
import java.util.List;

public class H2020_Oppg1 {

    /** a)
     * a) Gitt lambdauttrykket s -> s.toLowerCase(). Skriv en setning der du tilordner dette til en
     * variabel. Husk å angi hvilken datatype variabelen er. Gi variabelen et passende navn.
     * Tenk deg så at du har en liste av navn (av typen List<String>). Skriv kode, der variabelen over
     * blir brukt, som gir utskrift med små bokstaver av alle navnene i listen, ett navn per linje.
     */

    //TODO -- a) besvarelse

    /** b)
     * Gitt lambdauttrykket tall -> tall % x == 0. Skriv en metode med x som parameter som
     * returnerer dette lambdauttrykket. Husk å få med returtype. Gi metoden et passende navn.
     * Tenk deg så at du har en liste av heltall (av typen List<Integer>). Skriv kode, der metoden
     * over blir brukt, som gir utskrift av alle tallene i listen som er delelige med 3, ett tall per linje.
     */

    //TODO -- b) besvarelse

    List<String> passordlisten = Arrays.asList(
            "qwerty","123","passord", "peace&love", "abc", "12345678", "admin",
            "tomee", "fotball", "hei på deg");
    List<String> tiMestVanligePassord = Arrays.asList(
            "123456","123456789", "qwerty", "password", "1234567", "12345678",
            "12345", "iloveyou", "111111", "123123");

    /** c)
     * Bruk streams til å lage en ny liste med de passordene i passordlisten som også finnes i
     * listen over tiMestVanligePassord. (Tips: List har en metode cointains()).
     */

    //TODO -- c) besvarelse

    /** d)
     * Bruk streams til å beregne hva som er gjennomsnittlig passordlengde for passordene i
     * passordlisten. (Tips: Vær litt obs på dette med Optional).
     */

    //TODO -- d) besvarelse
}
