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

/** a.i:
 * Attributtet defer forteller nettleser at koden kan lastes parallelt med resten at web-
 * dokumentet, men koden blir først kjørt etter at selve web-dokumentet er ferdig
 * analysert.
 *
 * Dette kan ha en konsekvens for ytelsen da nettleser kan laste koden i en egen I/O
 * tråd parallelt med å hente og analysere resten av web-dokumentet.
 */

/** a.ii:
 * I headeren, siden det er øverst i dokumentet, så får vi lastet in resten av dokumentet og scriptet parallelt
 * så tidlig som mulig. All kode som ligger forran defer blir lastet in først.
 */

/** a.iii:
 * Den bør plasseres helt i slutten av dokumentet, i slutten av body- eller html-delen.
 * Når web-dokument blir lastet og nettleser møter script taggen vil JavaScript-koden
 * bli kjørt der og da. Dette har flere konsekvenser.
 *
 * JavaScript-kode kan kun aksessere DOM-strukturer som allerede er analysert av
 * nettleser. Derfor vil all HTML-koden nedenfor script-taggen være utilgjengelig for
 * JavaScript-koden.
 *
 * JavaScript-koden blir kjørt av samme tråd som bygger DOM-strukturen. HTML
 * nedenfor script-taggen blir derfor ikke vist i nettleser før JavaScript-koden er ferdig
 * med å kjøre. Dette kan gi dårlig brukeropplevelse hvis JavaScript-koden er treg eller henger.
 */

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

/** b.i:
 * innerHTML og insertAdjacentHTML kan brukes for å bygge rene HTML-skjeletter.
 * HTML-koden må ikke inneholde data eller parameter som har sitt opphav utenfor
 * metoden som oppretter skjelettet.
 * Eksempel på constructor i en klasse MemberGUI:
 */
class MemberGUI {
    constructor() {
        this.#memberTable = document.createElement("table");

        const tableContent = `
        <thead>
            <tr><th>Fornavn</th><th>Etternavn</th></tr>
        </thead>
        <tbody>
        </tbody>`;

        this.#memberTable.insertAdjacentHTML("beforeend", tableContent);
    }
}

/** b.ii:
 * innerHTML og insertAdjacentHTML må ikke brukes for å legge inn data på websiden
 * som har opphav utenfor metoden med innerHTML eller insertAdjacentHTML.
 *
 * Metoden nedenfor er en metode i klassen MemberGUI, og viser feil bruk av
 * insertAdjacentHTML
 */
class MemberGUI {
    addMemberBad(firstname, lastname) {
        const tableRowString = `
        <tr><td>${firstname}</td><td>${lastname}</td></tr>
        `;

        const tbodyElement = this.#memberTable.tBodies[0];
        tbodyElement.insertAdjacentHTML("beforeend", tableRowString);
    }
}

/** b.iii
 * textContent og innerText brukes begge for å sette inn ren tekst i web-dokumentet.
 * Eventuell HTML-kode vil bli omkodet og bli vist som ren tekst på websiden.
 *
 * Disse metodene må alltid brukes for å sette inn data på websiden som har opphav
 * utenfor metoden med textContent eller innerText. En angriper som forsøker å ta
 * kontroll over websiden ved f.eks. å fylle kode inn i et formskjema kan lykkes hvis data
 * blir vist med innerHTML eller insertAdjacentHTML. Derimot vil koden bli ufarliggjort
 * av textContent og innerText
 *
 * Metoden nedenfor er en metode i klassen MemberGUI, og viser riktig bruk av
 * insertAdjacentHTML og textContent. HTML-skjelettet lages av insertAdjacentHTML,
 * mens data blir fylt inn ved å bruke textContent.
 */

class MemberGUI {
    addMemberGood(firstname, lastname) {
        const tableRowString = `<tr><td></td><td></td></tr>`;

        const tbodyElement = this.#memberTable.tBodies[0];
        tbodyElement.insertAdjacentHTML("beforeend", tableRowString);

        const lastRow = tbodyElement.lastElementChild;
        lastRow.cells[0].textContent = firstname;
        lastRow.cells[1].textContent = lastname;
    }
}

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

// Fasit fra PDF:
class Parking {
    #countTotal;
    #cars = new Map();
    #priceInfo;

    constructor(count, priceInfo) {
        this.#countTotal = count;
        this.#priceInfo = priceInfo;
    };

    get isFull() {
        return this.#cars.size >= this.#countTotal
    }

    addCar(regno, taxgroup) {
        if (regno === undefined) return null;
        if (taxgroup === undefined) return null;
        if (this.#cars.has(regno)) return null;
        if (!this.#priceInfo.hasOwnProperty(taxgroup)) return null;
        if (this.isFull) return null;

        const arrival = Date.now();
        this.#cars.set(
            regno, {
            taxgroup: taxgroup,
            arrival: arrival
            }
        );

        return {
            regno: regno,
            taxgroup: taxgroup,
            arrival: arrival
        };
    }
    removeCar(regno) {
        if (regno === undefined) return null;
        if (!this.#cars.has(regno)) return null;

        const { taxgroup, arrival } = this.#cars.get(regno);
        const fee = this.#priceInfo[taxgroup];
        const departure = Date.now();
        const cost = this.#calculateCost(fee, arrival, departure);

        this.#cars.delete(regno);

        return {
            regno: regno,
            taxgroup: taxgroup,
            arrival: arrival,
            departure: departure,
            cost: cost
        };
    }

    #calculateCost(fee, start, end) {
        const ms = end - start;
        const seconds = ms / 1000;
        const minutes = seconds / 60;

        let cost = 0;
        if (minutes > 10) {
            const intervals = Math.ceil(minutes / 15);
            cost = intervals * fee;
        }

        return cost;
    }

}

// Min rotete besvarelse (en fordel med min versjon er at det er lettere å sette et annet intervall):
class Parking {

    constructor(antallParkeringsplasser, takstgrupper) {
        this.bilListe = []
        this.takstgrupper = takstgrupper
        this.antallParkeringsplasser = antallParkeringsplasser

        this.MINUTTT_KONVERTERING = 1000 * 60;
        this.INTERVALL_MINUTTTER = 15;
    }

    addCar(regno, taxgroup) {
        if(this.bilListe.length >= this.antallParkeringsplasser) {
            return null;
        }

        if(!(taxgroup in this.takstgrupper)) {
            return null;
        }

        if(this.bilListe.findIndex(bil => bil.regno === regno) !== -1) {
            return null
        }



        const nyBil = {
            "regno": regno,
            "taxgroup": taxgroup,
            "arrival": Date.now()
        };

        this.bilListe.push(nyBil);

        return nyBil;
    }

    removeCar(regno) {

        const bilIndeks = this.bilListe.findIndex(bil => bil.regno === regno);

        if(bilIndeks === -1) {
            return null
        }

        let bil = this.bilListe.splice(bilIndeks, 1)[0];

        let departure = Date.now();
        let duration = (departure - bil.arrival) / this.MINUTTT_KONVERTERING

        let intervaller = Math.ceil(duration / this.INTERVALL_MINUTTTER)

        // Parkering er gratis bare hvis man forlater innen 10 min,
        // men man får ikke de første 10 min gratis hvis man sto lengre enn 10 min
        let kostnad = (duration <= 10)
            ? 0
            : intervaller * this.takstgrupper[bil.taxgroup];

        return {
            "regno": bil.regno,
            "taxgroup": bil.taxgroup,
            "arrival": bil.arrival,
            "departure": departure,
            "cost": kostnad
        }
    }

}