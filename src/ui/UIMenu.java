package ui;
import model.ClsDoctor;
import model.ClsNurse;
import model.ClsPatient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"
    };
    public enum Day {
        SUNDAY("Domingo", "Dimanche"),
        MONDAY("Lunes", "Lundi"),
        TUESDAY("Martes", "Mardi"),
        WEDNESDAY("Miércoles", "Mercredi"),
        THURSDAY("Jueves", "Jeudi"),
        FRIDAY("Viernes", "Vendredi"),
        SATURDAY("Sábado", "Samedi");

        private String spanish;
        private String french;

        private Day(String s, String f) {
            spanish = s;
            french = f;
        }

        public String getSpanish() {
            return spanish;
        }

        public String getFrench() {
            return french;
        }
    }
    public static ClsDoctor doctorlogged;
    public static ClsNurse nurselogged;
    public static ClsPatient patientlogged;

    public static void showMenu() {
        System.out.println("\nSelecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            System.out.print("Opción -> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("\n*  Nurse  *\n");
                    response = 0;
                    authUser(2);
                    break;
                case 3:
                    response = 0;
                    authUser(3);
                    break;
                case 0:
                    System.out.println("Gracias por visitarnos.");
                    break;
                default:
                    System.out.println("Porfavor elije una opción correcta.");
            }
        } while (response != 0);
    }

    /*
    static void showPatientMenu() {
        int response = 0;

        do {
            System.out.println("\nPatient\n-------");
            System.out.println("(1) Book an appointment");
            System.out.println("(2) My appointment");
            System.out.println("(0) Return");

            System.out.print("Opción -> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println("1." + i + "." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointment");
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Error!!!");
                    break;
            }
        } while (response != 0);
    } */

    // Creando una Lista de Usuarios para simulación
    private static void authUser(int userType) {
        // userType = 1  => Doctor
        // userType = 2  => Nurse
        // userType = 3  => Patient

        // Agregando una lista de Doctores en Memoria
        ArrayList<ClsDoctor> doctors = new ArrayList<>();
        doctors.add(new ClsDoctor("Alejandro Mendez", "amendez@mail.com"));
        doctors.add(new ClsDoctor("Sofia Lorent", "slorent@mail.com"));
        doctors.add(new ClsDoctor("Peter Tale", "ptale@mail.com"));
        // Agregando una lista de Enfermeras en Memoria
        ArrayList<ClsNurse> nurses = new ArrayList<>();
        nurses.add(new ClsNurse("Tatiana Torres", "ttorres@mail.com"));
        nurses.add(new ClsNurse("Angie Curtis", "acurtis@mail.com"));
        nurses.add(new ClsNurse("Ashley Bloom", "abloom@mail.com"));
        // Agregando una lista de Pacientes en Memoria
        ArrayList<ClsPatient> patients = new ArrayList<>();
        patients.add(new ClsPatient("James Cameron", "jcameron@mail.com"));
        patients.add(new ClsPatient("Tonny Stark", "tstark@mail.com"));
        patients.add(new ClsPatient("Quentin Tarantino", "qtarantino@mail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: your@mail.com");
            Scanner sc = new Scanner(System.in);
            String emailM = sc.nextLine();

            if (userType == 1) {
                for (ClsDoctor d: doctors) {
                    if (d.getEmail().equals(emailM)) {  // Comparando dato REGISTRADO con el INGRESADO
                        emailCorrect = true;
                        // Obtener datos del Usuario logeado
                        doctorlogged = d;
                        // showDoctorMenu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2) {
                for (ClsNurse n: nurses) {
                    if (n.getEmail().equals(emailM)) {
                        emailCorrect = true;
                        nurselogged = n;
                        // showNurseMenu
                    }
                }
            }
            if (userType == 3) {
                for (ClsPatient p: patients) {
                    if (p.getEmail().equals(emailM)) {
                        emailCorrect = true;
                        patientlogged = p;
                        // showPatientMenu
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        } while(!emailCorrect);
    }
}
