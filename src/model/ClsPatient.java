package model;

import java.util.ArrayList;
import java.util.Date;

public class ClsPatient extends ClsUser {

    // Attributes----------------
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<ClsAppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<ClsAppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<ClsAppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(ClsDoctor doctor, Date date, String time) {
        ClsAppointmentDoctor appointmentDoctor = new ClsAppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<ClsAppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<ClsAppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    // Construct Method----------
    public ClsPatient(String nameP, String emailP) {
        super(nameP, emailP);
    }

    // Actions-------------------
    // Data Validators - GETTERS & SETTERS (Generado con Alt+Ins)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return this.weight + " kg.";
    }

    public void setWeight(double weightP) {
        this.weight = weightP;
    }

    public String getHeight() {
        return this.height + " mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Age " + getBirthday() + "\n Weight " + getWeight() +
                "\n Height " + getHeight() + "\n Blood " + getBlood();
    }

    // Clase Abstracta Heredada
    @Override
    public void showDataUser() {
        System.out.println("Hospital Patient: Cruz Verde");
        System.out.println("Condition: Grave");
    }
}
