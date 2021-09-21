package model;

import java.util.Date;

public class ClsAppointmentNurse implements ISchedulable {
    private int id;
    private ClsPatient patient;
    private ClsNurse nurse;
    private Date date;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsNurse getNurse() {
        return nurse;
    }

    public void setNurse(ClsNurse nurse) {
        this.nurse = nurse;
    }

    public ClsPatient getPatient() {
        return patient;
    }

    public void setPatient(ClsPatient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void schedule(Date dateS, String timeS) {
        //
    }
}
