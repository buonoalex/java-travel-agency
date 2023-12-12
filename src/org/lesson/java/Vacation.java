package org.lesson.java;

import java.time.Duration;
import java.time.LocalDate;

public class Vacation {
    private String destionation;
    private LocalDate dateStart;
    private LocalDate dateFinish;

    //Costruttori

    //Costruttore default
    public Vacation(){

    }

    //Costruttore personale
    public Vacation(String destionation, LocalDate dateStart, LocalDate dateFinish) {
        this.destionation = destionation;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    //Metodi
    public int CalculateDays(){
        Duration duration = Duration.between(dateStart,dateFinish);
        long days = duration.toDays();
        return (int) days;
    }

    //Getter and Setter
    public String getDestionation() {
        return destionation;
    }

    public void setDestionation(String destionation) throws IllegalArgumentException {
        if (destionation.isEmpty()){
            throw new IllegalArgumentException("Il valore non può essere nullo");
        }
        this.destionation = destionation;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) throws IllegalArgumentException {

        if (dateStart == null){
            throw new IllegalArgumentException("Il valore inserito non è valido");
        } else if (dateStart.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data inserita non è valida");
        }
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) throws IllegalArgumentException {
        if (dateFinish == null){
            throw new IllegalArgumentException("Il valore inserito non è valido");
        }else if (dateFinish.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La data inserita non è valida");
        }
        this.dateFinish = dateFinish;
    }
}
