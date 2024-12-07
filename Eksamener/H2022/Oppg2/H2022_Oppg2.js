/** a)
 * JavaScript i nettleser har bla. objektene window, navigator, history og screen. For hvert av
 * disse objektene, hva kan vi bruke objektet til?
 * Du trenger ikke huske navn på egenskaper.
 */

// TODO -- a) besvarelse

//------------------------------------------------------------------------------------------------------

/** b)
 * JavaScript og datatyper:
 *      i. JavaScript betegnes som et type-svakt språk (weakly typed, loosely typed).
 *         Hva betyr dette i praksis i JavaScript? Når bestemmes en variable sin type i JavaScript?
 *
 *      ii. JavaScript sine 7 primitive datatyper inkluderer string, number, boolean og symbol.
 *          Når brukes datatypen symbol? Demonstrer bruken av symbol med et kodeeksempel.
 */

// TODO -- b) besvarelse

//------------------------------------------------------------------------------------------------------

// c) For mye tekst, se PDF... (I det minste så har jeg satt opp en fin startkode for deg :D )

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

class Studentarkiv {

    // TODO -- sett opp arkiv

    /**
     * Metoden legger en ny student inn i studentarkivet.
     *
     * @param {student} student - Studentobjektet som skal legges inn i studentarkivet
     * @returns {boolean|null} - Returnerer 'true' hvis studenten ble lagt inn,
     *                           'false' hvis studenten allerede finnes i arkivet,
     *                           og null hvis formatet på parameteren student ble feil.
     */
    nystudent(student) {
        // TODO -- Fyll inn
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
        // TODO -- Fyll inn
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
        // TODO -- Fyll inn
    }

    /**
     * Metoden returnerer en tekst med alt innhold i arkivet. Semikolon skiller
     * feltene, og linjeslutt skiller studentene.
     *
     * @return {string} - En tekst med alt innhold i arkivet.
     */
    eksporterdata() {
        // TODO -- Fyll inn
    }

}