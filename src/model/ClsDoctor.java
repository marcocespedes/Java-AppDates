package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClsDoctor extends ClsUser {

    // Attributes----------------
    private String speciality;
    private ArrayList<AvailableAppointment> apoint = new ArrayList<>();

    // Construct Method----------
    public ClsDoctor(String nameD, String emailD) {
        super(nameD, emailD);
        System.out.println("...Building a new DOCTOR object...");
    }

    // Actions-------------------
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + getSpeciality() +
                "\n Available... \n" + apoint.toString();
    }

    // Clase Abstracta Heredada
    @Override
    public void showDataUser() {
        System.out.println("Hospital Employee: Cruz Verde");
        System.out.println("Department: Neurology");
    }


    // -----Class Static------------------
    public void addAvailableAppointment(String dateFreeSC, String timeFreeSC) {
        apoint.add(new ClsDoctor.AvailableAppointment(dateFreeSC, timeFreeSC));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment() {
        return apoint;
    }

    public static class AvailableAppointment {
        // -----Attributes----------------
        private int id;
        private Date dateFree;
        private String timeFree;

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        // -----Construct Method----------
        public AvailableAppointment(String dateFree, String timeFree) {
            try {
                this.dateFree = format.parse(dateFree);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.timeFree = timeFree;
        }

        // -----Actions-------------------
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDateFree(String DATE) {
            return dateFree;
        }
        // Para sobreCargar el método "getDateFree"
        public String getDateFree() {
            return format.format(dateFree);
        }

        public void setDateFree(Date dateFree) {
            this.dateFree = dateFree;
        }

        public String getTimeFree() {
            return timeFree;
        }

        public void setTimeFree(String timeFree) {
            this.timeFree = timeFree;
        }

        @Override
        public String toString() {
            return "\n...Available Appointments \n Date: " + getDateFree() +
                    "\n Time: " + getTimeFree() + "\n";
        }
    }
}
