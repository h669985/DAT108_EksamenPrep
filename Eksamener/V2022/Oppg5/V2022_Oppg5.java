package Oppg5;

import java.util.Scanner;

public class V2022_Oppg5 {
    //NB! Se PDF for grafiske eksempler

    /**
     * I denne oppgaven skal vi se på hvordan vi kan styre en ball med
     * konsoll-kommandoer. I utgangspunktet har vi en Ball-klasse som
     * viser en ball i bevegelse i et grafisk vindu.
     */

    //Hjelpeklasse for å stoppe IDE klaging, metodene er ikke kjørbar, men vi antar at de fungerer som de skal
    public static class Ball {
        public Ball() {}
        void settOppGUI() {}
        void animer() {}
        void gass() {}
        void brems() {}
        void avslutt(){}
    }


    public static void foo_main(String[] args) { //Lagt til foo siden vi tar i bruk main metoden under istedenfor
        Ball ball = new Ball();
        ball.settOppGUI();
        ball.animer();
    }


    /**
     * Slik det er nå vil ikke animér()-metoden returnere før vi lukker det grafiske vinduet.
     *
     * Vi tenker oss å kjøre at animér() i en egen tråd slik at vi kan taste inn kommandoer for å "styre"
     * ballen etter at denne er satt i gang. Vi tenker at Ball utvides med metodene gass() og brems() som
     * endrer farten på ballen, og avslutt() som stopper animasjonen og lukker vinduet. Du kan anta at
     * disse virker slik de skal.
     *
     * Endre / utvid main() slik at vi kan "styre" farten på ballen med kommandoene "g" og "b", og avslutte
     * med kommandoen "exit". Strukturen på main kan være ca. slik:
     */

    public static void main(String[] args) {
        /* TODO Kode inn her */
        Scanner input = new Scanner(System.in);
        String kommando = input.nextLine();
        while (!kommando.equals("exit")) {
            /* TODO Kode inn her */
            kommando = input.nextLine();
        }
        /* TODO Kode inn her */
    }

}
