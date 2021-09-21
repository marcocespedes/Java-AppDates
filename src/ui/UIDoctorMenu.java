package ui;

import model.ClsDoctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<ClsDoctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n*  Doctor Frame  *\n");
            System.out.println("Welcome " + UIMenu.doctorlogged.getName());
            System.out.println("1::Add Available Appointment");
            System.out.println("2::My Scheduled Appointment");
            System.out.println("0::Logout");

            System.out.print("Opción -> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAAMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    break;
            }

        } while(response != 0);
    }

    private static void showAddAAMenu() {
        int response = 0;
        do {
            System.out.println("\nAdd Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4) {
                // 1, 2, 3
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected - 1]);

                System.out.println("Insert the date available... [dd-mm-yyyy]");
                String dateD = sc.nextLine();

                System.out.println("You date is: " + dateD + "\n1. Correct\n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String timeD = "";
                do {
                    System.out.println("Insert the time available for date: " + dateD + " [16:00]");
                    timeD = sc.nextLine();
                    System.out.println("You time is: " + timeD + "\n1. Correct\n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime == 2);

                UIMenu.doctorlogged.addAvailableAppointment(dateD, timeD);
                checkDoctorAvailableAppointments(UIMenu.doctorlogged);

            } else if (response == 0) {
                showDoctorMenu();
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(ClsDoctor doctor) {
        if (doctor.getAvailableAppointment().size() > 0
                && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
