/** a)
 * Nedenfor ser du JavaScript kode for to metoder som begge oppretter et nytt HTML P-
 * element (tagg P) og legger inn noe data i P-elementet
 */

// Metoden showUserdata:
    function showUserdata(userData, rootElement) {
        rootElement.insertAdjacentHTML('beforeend',`<p>${userData}</p>`)
    }

// Metoden viewUserdata:
    function viewUserdata(userData, rootElement) {
        rootElement.insertAdjacentHTML('beforeend',`<p></p>`)
        rootElement.lastElementChild.textContent = userData
    }

/**
 *      i. Gå gjennom koden linje for linje og forklar koden.
 *      ii. Den ene av de to metoden over kan gi problemer i praksis. Diskuter dette og vis med
 *          et eksempel hvorfor denne metoden ikke bør brukes.
 */

/** a.i:
 * showUserData forklaring:
 *      metoden insertAdjacentHTML setter inn et HTML P-element som siste barn av rotelementet,
 *      med userData som innholdet til P-elementet.
 *
 * viewUserdata forklaring:
 *      metoden insertAdjacentHTML setter inn et HTML P-element som siste barn av rotelementet.
 *      deretter bruker vi en referanse til det siste barnet til rotelementet og setter textContent til
 *      innholdet i userData
 */

/** a.ii:
 *
 * I showUserdata, så blir brukerdata satt inn direkte som parameter i insertAdjaventHTML metoden.
 * Det kan tilate brukeren å sette inn sin egen HTML kode, altså det er ikke e trygg måte å håndere brukerdataen på.
 *
 * I den andre metoden vierUserData, så setter vi det heller som textContent, som parser brukerdaten til String,
 * all forsøk på å sette in HTML kode blir unngått pga parsingen.
 *
 * Eksempel fra fasit
 *   Eksempelet nedenfor bruker HTML og CSS for å skjule alt innholdet på websiden, og i stedet vise
 *   teksten i userdata sitt SPAN element:
 */
       const userdata = `<span
           style="background-color:white;
           position:fixed;
           top:0;left:0;
           font-size:3em;">
           Betal pengene til kontonummer 1111.22.3333
       </span>`
       showUserdata (userData)

//-----------------------------------------------------------------------------------------------------------

// b) Begge kodelinjene under vil opprette en liste av HTML-elementer med tagg DIV.
    const divElementList = rootElement.querySelectorAll('div')
    const divElements = rootElement.getElementsByTagName('div')

/**
 * Begge listene vil i utgangspunktet returnere de samme elementene, men vil kunne avvike
 * etter hvert som JavaScript-kode arbeider med dokumentet.
 *
 *      i. Utdyp forskjellen på de to listene, og vis eksempel på kode som gjør at de to listene
 *         ikke lengre inneholder de samme elementene.
 *
 *      ii. Legg til et HTML class attributt info på alle elementene i listen divElementList.
 *          Observer, elementene kan allerede ha andre class attributt elementer, og disse skal
 *          ikke røres.
 */

/** b.i:
 *      Metoden querySelectorAll returnerer en statisk liste. Innholdet er DIV-elementene under
 *      rootElement som fantes da metoden ble kalt.
 *
 *      Metoden getElementsByTagName returnerer en dynamisk liste. Listen blir oppdatert automatisk når
 *      websiden oppdateres, og vil til enhver tid være en list av alle DIV-elementer under rootElement.
 *
 *      Koden under legger til et nytt DIV-element under rootElement. Listen divElements vil inneholde det
 *      nye elementet, men ikke listen divElementList.
 */
        rootElement.insertAdjacentHTML('beforeend',`<div>Hei</div>`)

// Notat: queryselector er alltid preferabel så lenge vi ikke trenger en dynamisk liste, metoden er enkel å jobbe med,
//        lett å lære, og kan hente omtrent hva som helst fra HTML dokumentet.

// b.ii:
divElementList.forEach(divElement => {
    divElement.classList.add('info');
})

//-----------------------------------------------------------------------------------------------------------

/** c)
 * Opprett en JavaScript klasse Calculator. Klassen har en metode calculate og to egenskaper
 * status og result som kan brukes utenfor klassen (brukes public).
 */

class Calculator {

    constructor() {
        /** @public {String} */ this.status = null
        /** @public {Number} */ this.result = null
    }

// Metode calculate er gitt av følgende kode:

    /**
     * Metode for å utføre utregning
     * @public
     * @param {String} operation - Matematikk operasjon
     * @param {Array.<String>} numberList - Array av input-data
     */
    calculate(operation, numberList) {
        /* JavaScript kode for å utføre utregning */

        const numbers = numberList.map(value => value.trim()).filter(
            value => /^\d+$/.test(value)).map(
            number => parseInt(number,10))

        if (numbers.length === 0) {
            this.status = 'Ingen tall i tallisten'

        } else if (!operations[operation]) {
            this.status = 'Ukjent operasjon'

        } else {
            if (numbers.length === numberList.length) {
                this.status='Alle input-verdier ble prosessert'

            } else {
                this.status='Tallisten inneholder verdi(er) som ikke er tall'
            }

            /** Notat:
             *  Her har jeg valg å unngå bruk av switch-case siden det tar mye plass, istedenfor
             *  lager jeg en liste med lamba funksjoner der vi tilukker hver streng en operasjon
             *  da kan vi enkelt hente ut operasjonen slik: operations[operation]
             *  der operations er listen vår, og operation er parameteren fra metodekallet calculate(...)
             *
             *  Vi kunne dratt denne listen ut av metoden og gjort den static evt
             *
             *  Løsningsforslag på PDFen bruker switch-case, som er kansje letter å forså, men jeg vil tro
             *  at sensor vil like denne løsning mye mer siden den er lett å utvide med så mange operasjoner
             *  som man ønsker
             */
            const operations = {
                "sum": n => n.reduce((sum, number) => sum + parseInt(number)),
                "produkt": n => n.reduce((product, number) => product * parseInt(number)),
                "min": n => Math.min(...n),
                "max": n => Math.max(...n)
            };

            this.result = operations[operation](numbers)
        }
    }

}

/**
 * Parameter operation angir en regneoperasjon, og parameter numberList er en Array av
 * heltall. Listen av heltall kan ha sitt opphav i HTML INPUT elementer. Hvert tall i listen kan
 * derfor være en tekststreng som må konverteres til heltall før utregning.
 *
 * Parameter operation kan ha en av følgende verdier:
 *       ‘sum’: Metoden skal finne summen av heltallene i numberList.
 *       ‘produkt’: Metoden skal finne produktet av heltallene i numberList.
 *       'min': Metoden skal finne det minste tallet i numberList.
 *       'max': Metoden skal finne det største tallet i numberList.
 *
 * Metoden calculate skal gjøre svaret fra utregningen tilgjengelig i egenskapen result, og
 * egenskapen status er en tekststreng med informasjon om utregningen
 *
 * Egenskapen status kan ha en av følgende verdier:
 *       'Ingen tall i tallisten'
 *              o Angir at numberList ikke har noen elementer som er heltall.
 *
 *       'Tallisten inneholder verdi(er) som ikke er tall'
 *              o Angir at numberList har noen elementer som ikke er heltall. Disse har blitt
 *                ignorert i utregningen.
 *
 *       'Alle input-verdier ble prosessert'
 *              o Alle elementer i numberList er heltall og har blitt brukt i utregningen
 *
 * Eksempelet under viser bruk av Calculator:
 *      const calculator = new Calculator()
 *      calculator.calculate('sum', ['1','3','7'])
 *      console.log(`Svaret er: ${calculator.result}`)
 *      console.log(`Status for utregning: ${calculator.status}`)
 *
 * Under vises utskriften i nettleserkonsollet fra koden over:
 *      Svaret er: 11
 *      Status for utregning: Alle input-verdier ble prosessert
 *
 * Oppgave: Skriv JavaScript koden for Calculator i samsvar med teksten over.
 */
