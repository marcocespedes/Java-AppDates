package model;

public class ClsNurse extends ClsUser {
    private String speciality;

    public ClsNurse(String nameN, String emailN) {
        super(nameN, emailN);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // Clase Abstracta Heredada
    @Override
    public void showDataUser() {
        System.out.println("Hospital Employee: Cruz Verde");
        System.out.println("Department: UCI");
    }
}
