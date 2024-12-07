/** a)
 * Nedenfor ser du JavaScript kode for to metoder som begge oppretter et nytt HTML P-
 * element (tagg P) og legger inn noe data i P-elementet
 */

// Metoden showUserdata:
    function showUserdata(userData,rootElement) {
        rootElement.insertAdjacentHTML('beforeend',`<p>${userData}</p>`)
    }

// Metoden viewUserdata:
    function viewUserdata(userData,rootElement) {
        rootElement.insertAdjacentHTML('beforeend',`<p></p>`)
        rootElement.lastElementChild.textContent = userData
    }

/**
 *      i. Gå gjennom koden linje for linje og forklar koden.
 *      ii. Den ene av de to metoden over kan gi problemer i praksis. Diskuter dette og vis med
 *          et eksempel hvorfor denne metoden ikke bør brukes.
 */

// TODO -- a) besvarelse

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

// TODO -- b) besvarelse

//-----------------------------------------------------------------------------------------------------------

/** c)
 * Opprett en JavaScript klasse Calculator. Klassen har en metode calculate og to egenskaper
 * status og result som kan brukes utenfor klassen (brukes public).
 */

class foo { //Hjelpeklasse for å stoppe IDE klaging, bare til å fjerne når du kopierer metoden nedenfor til din nye klasse
// Metode calculate er gitt av følgende kode:

    /**
     * Metode for å utføre utregning
     * @public
     * @param {String} operation - Matematikk operasjon
     * @param {Array.<String>} numberList - Array av input-data
     */
    calculate(operation, numberList) {
        /* JavaScript kode for å utføre utregning */
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

// TODO -- c) besvarelse