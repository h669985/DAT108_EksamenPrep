package Oppg5;


public class V2021_Oppg5 {
    /*
     * Du skal lage et lite program som starter opp to tråder i tillegg til main-tråden, avslutter de på
     * kontrollert måte, og avslutter main når de to trådene er ferdige.
     * Strukturen til main() ser slik ut:
     */

    public static void main(String[] args) throws InterruptedException {
        // Her opprettes og startes en tråd som går i en løkke og skriver ut
        // en melding på skjermen ca. hvert sekund helt til tråden avsluttes
        // på kontrollert måte.
        // TODO -- a)

        // Her opprettes og startes en tråd som viser frem en JOptionPane meldings-
        // boks. Når brukeren trykker på OK-knappen skal utskrifts-tråden få beskjed
        // om å avslutte, og meldingsboks-tråden vil også være ferdig.
        // TODO -- b)

        System.out.println("Tråder er startet. Venter på at de er ferdige ...");

        //Her ventes det på at de andre trådene er ferdige før main avsluttes.
        // TODO -- c)

        System.out.println("Begge tråder er ferdige!");
        System.out.println("Main-tråd ferdig!");
    }

    // Meldingsboksen som venter på brukers OK kan fås frem slik:
    // JOptionPane.showMessageDialog(null, "Trykk OK for å avbryte utskriftstråden", "Avbryt", JOptionPane.PLAIN_MESSAGE);

    //NB! See PDF for eksempler på hvordan output skal se ut

    /** a)
     * Skriv koden for utskriftsloop-tråden. Du må selv avgjøre om dette kan/skal være en Thread
     * eller en Runnable, og om den skal være konkret eller anonym.
     */

    // TODO -- a)

    /** b)
     * Skriv koden for meldingsboks-tråden. Du må selv avgjøre om dette kan/skal være en Thread
     * eller en Runnable, og om den skal være konkret eller anonym.
     */

    // TODO -- b)

    /** c)
     * Skriv koden i main som oppretter, starter og venter på disse trådene (slik det er vist i
     * programkoden til main over)
     */

    // TODO -- c)

}
