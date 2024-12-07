/** a)
 * HTML taggen script kan brukes sammen med et attributt defer.
 *
 *      i. Hva er konsekvensen av defer attributtet. Kan defer ha noe å si for ytelsen til
 *         webapplikasjonen? Svaret må begrunnes.
 *
 *      ii. Hvor i et webdokument bør script tagg med defer plassers? Svaret må begrunnes.
 *
 *      iii. Hvor i et webdokument bør script tagg uten defer plasseres? Svaret må begrunnes.
 */

// TODO -- a) besvarelse

//------------------------------------------------------------------------------------------------

/** b)
 * For å modifisere DOM-strukturen til et webdokument har vi blant annet egenskapene
 * innerHTML, textContent og innerText, og metoden insertAjacentHTML.
 *
 *      i. Gi eksempler på når det er riktig å bruke innerHTML og insertAjacentHTML.
 *         Svaret må begrunnes.
 *
 *      ii. Gi eksempler på situasjoner der innerHTML og insertAjacentHTML ikke må brukes. .
 *          Svaret må begrunnes.
 *
 *      iii. Gi eksempler på når det er riktig å bruke textContent og innerText.
 *           Svaret må begrunnes.
 */

// TODO -- b) besvarelse

//------------------------------------------------------------------------------------------------

/** c)
 * Opprett en JavaScript klasse Parking. Instanser av klassen skal kunne administrere et
 * parkeringsområde og parkeringsavgift for biler på området.
 *
 * Et parkeringsområde har et gitt antall plasser for biler, og hver bil må tilhøre en takstgruppe.
 * Klassen har metodene addCar og removeCar for å registrere at biler kjører inn og ut av
 * parkeringsområdet.
 */

// Kodeeksempelet under demonstrer hvordan en instans av Parking kan bli opprettet:
    const carpark= new Parking(50, { electric: 5, normal: 30 });

/**
 * Første argument til konstruktøren er antall parkeringsplasser på parkeringsområdet, og
 * andre argument er et objekt med takstgrupper og parkeringsavgift per påbegynt 15 minutt
 * intervall. I eksempelet koster det 5 kroner per påbegynt 15 minutt intervall for biler i
 * takstgruppe electric og 30 for biler i takstgruppe normal
 *
 * For biler som forlater området innen 10 minutter beregnes det ingen parkeringsavgift.
 *
 * Klassen Parking har følgende metoder:
 *
 *      • addCar(regno,taxgroup): Metoden registrerer at bil med registreringsnummer regno
 *        som er i takstgruppe taxgroup har kjørt inn på parkeringsområdet.
 *
 *        Parametere:
 *          o Inn-parametere: String, String
 *          o Returverdi: Object
 *
 *         Metoden returnerer et objekt, eller null. Returverdi null betyr at registrering av bil
 *         feilet. Grunner for returverdi null kan være at parkeringsområdet er fullt, eller at
 *         takstgruppen taxgroup ikke finnes.
 *
 *         Kodeeksempelet under registrerer at bilen «EK12345» som har takstgruppe
 *         «electric» har kjørt inn på parkeringsområdet
 *
 *              const arrival = carpark.addCar("EK12345", "electric");
 *
 *         Returverdi er følgende objekt:
 *         {
 *              regno: "EK12345",
 *              taxgroup: "electric",
 *              arrival: 1637065716428
 *         }
 *
 *         Egenskapene regno og taxgroup viser parameterverdiene som ble brukt i
 *         metodekallet. Egenskapen arrival er tidspunktet for når bilen ble registrert inn,
 *         representert ved antall millisekunder siden 1. januar 1970.
 *
 *      • removeCar(regno): Metoden brukes når bil med registreringsnummer regno forlater
 *        parkeringsområdet.
 *
 *        Parametere:
 *          o Inn-parameter: String
 *          o Returverdi: Object
 *
 *        Metoden returnerer et objekt, eller null. Returverdi er null hvis bilen ikke var
 *        registrert inn på parkeringsområdet.
 *
 *        Kodeeksempelet under fjerner bilen «EK12345» fra carpark:
 *
 *              const departure = carpark.removeCar("EK12345");
 *
 *        Returverdi er følgende objekt:
 *        {
 *          regno: "EK12345",
 *          taxgroup: "electric",
 *          arrival: 1637065716428,
 *          departure: 1637070036428,
 *          cost: 25
 *        }
 *       Egenskapene regno, taxgroup og arrival er som for addCar. Egenskapen departure er
 *       tidspunktet for når bilen forlot parkeringsområdet, representert ved antall
 *       millisekunder siden 1. januar 1970. Egenskapen cost er parkeringsavgiften for denne
 *       parkeringen.
 *
 * Oppgave: Skriv JavaScript-koden for Parking i samsvar med teksten over.
 */

// TODO -- c) besvarelse