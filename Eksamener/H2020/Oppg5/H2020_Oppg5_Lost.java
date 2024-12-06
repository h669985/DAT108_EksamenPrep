package Oppg5;

import static java.lang.Thread.sleep;

public class H2020_Oppg5_Lost {
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

    // NB! Det er mange måter å løse disse oppgavene på, sjekk PDF for komentarer og alternative løsninger

    // Hjelpemetode for IDE validering, gjør egentlig ingen hasjing, men vi later som om den gjør det
    public static String hashOf(long number) {
        return String.valueOf(number);
    }

    public static class BitcoinMiner implements Runnable {
        @Override
        public void run() {
            for (long i = 0; i <= Long.MAX_VALUE; i++) {
                if(hashOf(i).startsWith("00000")) {
                    System.out.println(i + " -> " + hashOf(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread bitcoinMiner = new Thread(new BitcoinMiner());
        bitcoinMiner.start();
    }

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

    public static void main2(String[] args) {
         class Bankkonto {
            int saldo;
            Bankkonto(int saldo) {
                this.saldo = saldo;
            }

            synchronized void uttak(int mengde) throws InterruptedException {
                while (saldo < mengde) {
                    wait();
                }
                this.saldo -= mengde;
            }

            synchronized void innskudd(int mengde) {
                this.saldo += mengde;
                notifyAll();
            }
        }

        Bankkonto bankkonto = new Bankkonto(500);

        Thread inn = new Thread(() -> {
            while(true) {
                bankkonto.innskudd(500);
                bankkonto.innskudd(500);

                try {
                    sleep(1000);
                } catch (InterruptedException _) {}
            }
        });

        Thread ut = new Thread(() -> {
            while(true) {

                try {
                    bankkonto.uttak(1000);
                    bankkonto.uttak(1000);
                    sleep(1000);
                } catch (InterruptedException _) {}
            }
        });

        inn.start();
        ut.start();
    }
}
