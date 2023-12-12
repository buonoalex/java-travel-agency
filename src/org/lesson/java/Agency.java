package org.lesson.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args){
        //Apro Scanner
        Scanner myBroScan = new Scanner(System.in);

        boolean sentinella = false;
        while (!sentinella){
            System.out.println("Vuoi inserire una nuova vacanza (y/n) : ");
            String Answer = null;
            boolean flagAnswer = false;
            while (!flagAnswer) {
                try {
                    Answer = myBroScan.nextLine();
                    flagAnswer = true;
                } catch (Exception e) {
                    System.err.println("Invalid type");
                }
            }
            if (Answer.equals("y")){

                //Input Destinazione
                System.out.println("Inserisci la tua destinazione : ");
                boolean flagDestinationAnswer = false;
                String destinationAnswer = null;
                while (!flagDestinationAnswer){
                    try {
                        destinationAnswer = myBroScan.nextLine();
                        flagDestinationAnswer = true;
                    } catch (Exception e) {
                        System.err.println("Invalid type");
                    }
                }

                //Input Data partenza
                System.out.println("Inserisci la data di partenza della tua vacanza (yyyy-MM-dd) : ");
                boolean flegstartDateAnswer = false;
                LocalDate startDateAnswer = null;
                while (!flegstartDateAnswer) {
                    try {
                        startDateAnswer = LocalDate.parse(myBroScan.nextLine());
                        flegstartDateAnswer = true;
                    } catch (Exception e) {
                        System.out.println("La data non è corretta");
                    }
                }

                //Input Data ritorno
                System.out.println("Inserisci la data di ritorno della tua vacanza : (yyyy-MM-dd) ");
                boolean flegfinishDateAnswer = false;
                LocalDate finishDateAnswer = null;
                while (!flegfinishDateAnswer) {
                    try {
                        finishDateAnswer = LocalDate.parse(myBroScan.nextLine());
                        flegfinishDateAnswer = true;
                    } catch (Exception e) {
                        System.out.println("La data non è corretta");
                    }
                }

                //Creazione Vacanza
                try{
                    Vacation vacationUser = new Vacation(destinationAnswer,startDateAnswer,finishDateAnswer);
                    vacationUser.PrintVacation();
                }catch (Exception e){
                    System.err.println("La creazione non ha avuto successo");
                }

            } else if (Answer.equals("n")) {
                System.out.println("Arrivederci");
                sentinella = true;
            }
        }

        //Chiudo Scanner
        myBroScan.close();

    }
}
