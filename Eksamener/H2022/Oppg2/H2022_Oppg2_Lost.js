/** a)
 * JavaScript i nettleser har bla. objektene window, navigator, history og screen. For hvert av
 * disse objektene, hva kan vi bruke objektet til?
 * Du trenger ikke huske navn på egenskaper.
 */

/**
 *    window: Objektet representerer nettleservinduet som viser websiden. Alle globale variabler,
 *            funksjoner, objekter og klasser tilhører window. Objektet lar oss f.eks. finne størrelse på
 *            nettleservinduet og har også metoder for å åpne og arbeide med vinduer, timer metoder, osv.
 *
 * navigator: Objektet gir oss egenskapene til nettleseren som viser websiden, f.eks.
 *            nettlesertype, språk, operativsystem ol.
 *
 *   history: Objektet har bla. metoder for å navigere framover og bakover i historielisten til
 *            nettleser og navigere til nye adresser.
 *
 *    screen: Objektet har egenskaper, metoder og hendelser knyttet til datamaskinen sin skjerm.
 *            Vi kan finne finne skjermoppløsning og fargedybde og få kjørt metoder når skjermen roteres.
 */

//------------------------------------------------------------------------------------------------------

/** b)
 * JavaScript og datatyper:
 *      i. JavaScript betegnes som et type-svakt språk (weakly typed, loosely typed).
 *         Hva betyr dette i praksis i JavaScript? Når bestemmes en variable sin type i JavaScript?
 *
 *      ii. JavaScript sine 7 primitive datatyper inkluderer string, number, boolean og symbol.
 *          Når brukes datatypen symbol? Demonstrer bruken av symbol med et kodeeksempel.
 */

/** b.i:
 * I praksis så betyr det at typen til en variabel er dynamisk, og blir tilukket på kjøretid fremfor kompileringstid
 * Altså, en variabel i javascript må ikke defineres som en String, Integer, Boolean etc, slik som man må i Java.
 *
 * variabelen i javascript kan endre type flere ganger under kjøretid, alt ut i fra dataen som blir tilordnet
 */

/** b.ii:
 * Datatypen symbol brukes for å identifisere objekter, litt som primærnøkkel i en database
 * Symbol() funksjonen retunerer en unik verdi for hvert kall
 * Eksempel nedenfor:
 */
    const student = {
        id: Symbol(),
        navn: " Ole Olsen "
    };

//------------------------------------------------------------------------------------------------------

/**
 * Oppgave: Skriv JavaScript-koden for Studentarkiv.
 *
 * Hjelp:
 *       Både Map, Set og Array har en metode forEach.
 *       Map og Set sin metode values returnerer en iterator over alle verdier.
 *       Map sin metode keys returnerer en iterator over alle nøkler.
 *        Array sin statiske metode from, og også spre (spread) operator kan kopiere et itererbart
 *         objekt til en Array.
 *       Map har bla. metoder has, set, get og delete.
 *       Set har bla. metoder has, add og delete.
 *       Operator typeof returnerer en string som angir operanden sin type.
 *       Operator instanceof tester om operand er en forekomst av en klasse, også via arv.
 */

const ole = arkiv.nystudent({
    id: 101,
    etternavn: "Olsen",
    fornavn: "Ole",
    tlf: ["112 23 344", "323 22 323"]
});

class Studentarkiv {

    // # symbol sier at dette er en privat variabel, kun synlig inni klassen
    #arkiv = new Map();

    /**
     * Metoden legger en ny student inn i studentarkivet.
     *
     * @param {student} student - Studentobjektet som skal legges inn i studentarkivet
     * @returns {boolean|null} - Returnerer 'true' hvis studenten ble lagt inn,
     *                           'false' hvis studenten allerede finnes i arkivet,
     *                           og null hvis formatet på parameteren student ble feil.
     */
    nystudent(student) {
        const { id, etternavn, fornavn, tlf: liste } = student;
        if (typeof id !== "number") return null;
        if (this.#arkiv.has(id))    return false;

        if (liste === undefined) {
            this.#arkiv.set(id, {etternavn, fornavn});

        } else {
            const tlf = new Set();
            liste.forEach(nummer => tlf.add(nummer));
            this.#arkiv.set(id, {etternavn, fornavn, tlf});
        }

        return true;
    }

    /**
     * Metoden sjekker om en student med gitt id er registrert med gitt telefonummer.
     *
     * @param {number} id - ID-en til studenten.
     * @param {string} telefonnummer - Telefonnummeret til studenten.
     * @returns {boolean|null} - Returnerer 'true' hvis studenten er regristert med gitt telefonnummer,
     *                           'false' hvis ikke,
     *                           og null hvis studenten ikke finnes.
     */
    hartelefon(id, telefonnummer) {
        if (!this.#arkiv.has(id)) return null;

        const tlf = this.#arkiv.get(id).tlf;
        if (tlf === undefined) return false;

        return (tlf.has(telefonnummer));
    }

    /**
     * Metoden legger inn nytt telefonnummer for studenten med gitt id
     *
     * @param {number} id - ID-en til studenten.
     * @param {string} nummer - Nytt telefonnummere til studenten.
     * @returns {boolean|null} - Returnerer 'true' hvis telefonnummeret ble legt til for studenten,
     *                           'false' hvis studenten hadde samme nummer fra før,
     *                           og null hvis studenten ikke finnes.
     */
    nytelefon(id, nummer) {
        if (!this.#arkiv.has(id)) return null;
        if (this.#arkiv.get(id).tlf === undefined) {
            this.#arkiv.get(id).tlf = new Set();
        }

        const tlf = this.#arkiv.get(id).tlf;
        if (tlf.has(nummer)) return false;

        tlf.add(nummer);
        return true;
    }

    /**
     * Metoden returnerer en tekst med alt innhold i arkivet. Semikolon skiller
     * feltene, og linjeslutt skiller studentene.
     *
     * @return {string} - En tekst med alt innhold i arkivet.
     */
    eksporterdata() {
        /**
         * Kunne brukt iterator-metoder her, men det har vi ikke
         * brukt i kurset. Omformer derfor til forekomst av Array.
         */
        const keys = Array.from(this.#arkiv.keys());
        if (keys.length === 0) return "";

        let utskrift = this.#eksportlinje(keys[0]);
        for (let i = 1; i < keys.length; ++i) {
            utskrift += `\n${this.#eksportlinje(keys[i])}`;
        }
        return utskrift;
    }

    /**
     * Privat metode for å gjøre en student med gitt id til streng for utskrift
     *
     * @param {id} - Id til studenten
     * @returns {string} - Streng om studenten
     */
    #eksportlinje(id) {
        const { etternavn, fornavn, tlf } = this.#arkiv.get(id);
        let linje = `${id};${etternavn};${fornavn}`;
        if (tlf !== undefined) {
            tlf.forEach(
                nummer => { linje += `;${nummer}` }
            );
        }
        return linje;
    }

}