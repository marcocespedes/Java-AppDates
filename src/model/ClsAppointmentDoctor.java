package model;

import java.util.Date;

public class ClsAppointmentDoctor implements ISchedulable {
    private int id;
    private ClsPatient patient;
    private ClsDoctor doctor;
    private Date date;
    private String time;

    public ClsAppointmentDoctor(ClsPatient patient, ClsDoctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsPatient getPatient() {
        return patient;
    }

    public void setPatient(ClsPatient patient) {
        this.patient = patient;
    }

    public ClsDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(ClsDoctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time + " hrs.";
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void schedule(Date dateS, String timeS) {
        this.date = dateS;
        this.time = timeS;
    }
}
