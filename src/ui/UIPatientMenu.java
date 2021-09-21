package ui;

import model.ClsDoctor;
import model.ClsPatient;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n*  Patient Frame  *\n");
            System.out.println("Welcome " + UIMenu.patientlogged.getName());
            System.out.println("1::Book an Appointment");
            System.out.println("2::My Appointments");
            System.out.println("0::Logout");

            System.out.print("Opción -> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAMenu();
                    break;
                case 2:
                    showMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    break;
            }

        } while(response != 0);
    }

    private static void showBookAMenu() {
        int response = 0;
        do {
            System.out.println("\nBook Appointment::");
            System.out.println(":: Select a Date");
            // Numeracion de la lista de Fechas Disponibles
            // Indice de fechas seleccionadas (Doctores)
            // 1. Doctor X
                // - Fecha1
                // - Fecha2
            // 2. Doctor Y
            // 3. Doctor Z
            Map<Integer, Map<Integer, ClsDoctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<ClsDoctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointment();

                Map<Integer, ClsDoctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDateFree());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, ClsDoctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            ClsDoctor doctorSelected = new ClsDoctor("", "");
            for (Map.Entry<Integer, ClsDoctor> docs : doctorAvailableSelected.entrySet()) {
                indexDate = docs.getKey();
                doctorSelected = docs.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointment().get(indexDate).getDateFree() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointment().get(indexDate).getTimeFree());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Date");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientlogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointment().get(indexDate).getDateFree(null),
                        doctorSelected.getAvailableAppointment().get(indexDate).getTimeFree()
                );
            }

            showPatientMenu();

        } while (response != 0);
    }

    private static void showMyAppointments() {
        int response = 0;
        do {
            System.out.println("\nMy Appointments::");
            if (UIMenu.patientlogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointments!");
                break;
            }

            for (int i = 0; i < UIMenu.patientlogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + "." +
                        "Date " +
                        UIMenu.patientlogged.getAppointmentDoctors().get(i).getDate() +
                        "Time " +
                        UIMenu.patientlogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doc. " +
                        UIMenu.patientlogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }

            System.out.println("0. Return");
        } while (response != 0);
    }
}
