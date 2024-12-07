/** a)
 * Teksten under blir ofte brukt i JavaScript-kode:
 *
 *      "use strict";
 *
 * i. Hva er konsekvensene av å legge denne teksten i JavaScript-koden?
 *
 * ii. Hvor i JavaScript-koden skriver vi denne teksten?
 */

/** a.i:
 * "use strict"; har en del konsekvenser:
 *      * Skrivefeil i variabler vil gi javascript fel, uten så blir en ny variabel opprettet istedenfor
 *      * Mange feil blir ignorert uten "use strict"; for eks:
 *             - Slette en egenskap som ikke kan slettes
 *             - Tilordne noe til en egenskap som ikke er skrivebar
 *      * Reserverte ord, og potensiele fremtidige reserverte ord kan ikke brukes som variabler
 *      * Bruk av with konstruksjonen er ulovlig.
 *      * Hvis metode kjøres utenfor kontekst av et objekt er this udefinert.
 */

/** a.ii:
 * I starten av javascript koden for å gjelde hele koden, eller før en funksjon for å gjelde kun koden inni funksjonen
 */

//---------------------------------------------------------------------------------------

/** b)
 * Nøkkelordet this og mistet kontekst.
 *
 * i. I noen situasjoner vil this miste konteksten av objektet som eier metoden som bruker
 *    this. Gi eksempler på situasjoner når dette skjer, og forklar årsaken.
 *
 * ii. Gi eksempler på løsninger for å bevare konteksten ved bruk av this.
 *
 * iii. I noen situasjoner kan bruk av pil-syntaks for funksjoner løse problemer knyttet til
 *      bruk av this. Vis med eksempel hva som er problemet og forklar hvordan pil-syntaks
 *      kan løse problemet
 */

/** b.i:
 * Størrelsen this mister sin kontekst hvis en metode kjøres via en referanse. I
 * DAT108 har vi kun sett på dette i forbindelse med hendelseshåndterere.
 *
 * elmRef.addEventListener(hendelse,objekt.metode);
 *
 * Her er objekt.metode en referanse til metoden. Når hendelsen skjer, kjøres metoden
 * via referansen, og da er konteksten av objekt borte. Istedet vil this være elmRef.
 *
 */

/** b.ii:
 * I DAT108 brukte vi bind for å binde konteksten:
 *
 * elmRef.addEventListener("click",objekt.metode.bind(objekt);
 *
 * En annen vanlig løsning er å bruker en omsluttende funksjon:
 *
 * elmRef.addEventListener("click",e => {objekt.metode(e)};
 */

/** b.iii:
 * Funksjoner lager sin egen binding av this, normalt til objektet som har funksjonen
 * som metode.
 *
 * Funksjon laget med pilsyntaks lager ingen egen binding av this, men bruker det
 * omsluttende miljøet sin this.
 *
 * Anta at koden under finnes i en metode til et objekt, og at m er en annen metode i
 * objektet:
 *
 * elmRef.addEventListener("click",function(e) {this.m(e)});
 *
 * Funksjonen over lage sin egen binding av this, til elmRef som trigget hendelsen.
 * Koden feiler da this.m forsøker å kjøre elmRef.m.
 *
 * I koden under lages ingen egen binding av this. Verdien til this tas fra det
 * omsluttende miljøet, og vil da være objektet som eier metoden med koden.
 *
 * elmRef.addEventListener("click",(e) => {this.m(e)});
 */

//---------------------------------------------------------------------------------------

/** c)
 * Se PDF, for my tekst...
 */

class TekstAnalyse {
    _ordliste = null;
    _statistikk = new Map();

    /**
     * @public
     * @param{String} innhold
     */
    set tekst(innhold) {
        /**
         * Kunne opprettet Array og Map i de tilsvarende metodene,
         * men da gjøres det hver gang metodene kjøres.
         * Velger istedet å gjøre det her. Ulempen er at da blir Map
         * og Array opprettet også om de ikke blir brukt.
         * Kunne alternativt sjekket ved bruk om Array og Map
         * finnes, hvis ikke, lag dem.
         **/
        this._ordliste = innhold.match(/\p{Letter}+/ug);
        this._statistikk.clear();
        this._ordliste.forEach(
            ord => {
                this._registrer(ord)
            }
        );
    }

    get liste() {return this._ordliste;}
    get antallord() {return this._ordliste.length;}

    finnhyppigsteord() {
        const ord = [];
        const maksantall = Math.max(...this._statistikk.values());
        this._statistikk.forEach(
            (value, key) => {
                if (value === maksantall) {
                    ord.push(key);
                }
            }
        );

        return { antall: maksantall, ord: ord };
    }

    _registrer(ord) {
        ord = ord.toLocaleUpperCase();
        if (this._statistikk.has(ord)) {
            const count = this._statistikk.get(ord);
            this._statistikk.set(ord, count + 1);

        } else {
            this._statistikk.set(ord, 1);
        }
    }

}