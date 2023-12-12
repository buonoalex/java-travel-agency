package org.lesson.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        //Apro Scanner
        Scanner myBroScan = new Scanner(System.in);

        boolean sentinella = false;
        while (!sentinella){
            System.out.println("Vuoi inserire una nuova vacanza (y/n) : ");
            String Answer = null;
            try {
                Answer = myBroScan.nextLine();
            }catch (Exception e1){
                System.err.println("Invalid type");
            }
            if (Answer.equals("y")){

                //Input Destinazione
                System.out.println("Inserisci la tua destinazione : ");
                boolean flegDestinationAnswer = false;
                String destinationAnswer = null;
                while (!flegDestinationAnswer){
                    try {
                        destinationAnswer = myBroScan.nextLine();
                        flegDestinationAnswer = true;
                    } catch (Exception e) {
                        System.err.println("Invalid type");
                    }
                }

                //Input Data partenza
                System.out.println("Inserisci la data di partenza della tua vacanza (yyyy-MM-dd) : ");
                boolean flegstartDateAnswer = false;
                LocalDate startDateAnswer = null;
                String inputDate = null;
                while (!flegstartDateAnswer) {
                    try {
                        inputDate = myBroScan.nextLine();
                        DateTimeFormatter form = DateTimeFormatter.ofPattern(inputDate);
                        startDateAnswer = LocalDate.parse(inputDate,form);
                        flegstartDateAnswer = true;
                    } catch (Exception e2) {
                        System.out.println("La data non è corretta");
                    }
                }

                //Input Data ritorno
                System.out.println("Inserisci la data di ritorno della tua vacanza : ");
                boolean flegfinishDateAnswer = false;
                LocalDate finishDateAnswer = null;
                while (!flegfinishDateAnswer) {
                    try {
                        finishDateAnswer = LocalDate.parse(myBroScan.nextLine());
                        flegfinishDateAnswer = true;
                    } catch (Exception e3) {
                        System.out.println("La data non è corretta");
                    }
                }

                //Creazione Vacanza
                try{
                    Vacation vacationUser = new Vacation(destinationAnswer,startDateAnswer,finishDateAnswer);
                }catch (Exception e4){
                    System.out.println("La creazione non ha avuto successo");
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
