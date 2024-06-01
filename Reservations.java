// ika 22005669

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservations {
    private static List<Reservation> reservations = new ArrayList<>();

    public static void addReservation(String studentName, String studentEmail, String studentPhoneNumber, String tutorName, String tutorPhoneNumber, String tutorId, String tutorSubject, String date, String time) {
        Reservation newReservation = new Reservation(studentName, studentEmail, studentPhoneNumber, tutorName, tutorPhoneNumber, tutorId, tutorSubject, date, time);
        reservations.add(newReservation);
        System.out.println("Reservation added: " + newReservation);
    }


    public static void removeReservation(String studentName, String tutorName, String date, String time) {
        Reservation reservationToRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getStudentName().equals(studentName) &&
                    reservation.getTutorName().equals(tutorName) &&
                    reservation.getDate().equals(date) &&
                    reservation.getTime().equals(time)) {
                reservationToRemove = reservation;
                break;
            }
        }
        if (reservationToRemove != null) {
            reservations.remove(reservationToRemove);
            System.out.println("Reservation removed: " + reservationToRemove);
        } else {
            System.out.println("No reservation found to remove.");
        }
    }

    public static void printReservations() {
        System.out.println("Current reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void findReservation(String studentName, String tutorName) {
        for (Reservation reservation : reservations) {
            if (reservation.getStudentName().equals(studentName) &&
                    reservation.getTutorName().equals(tutorName)) {
                System.out.println("Found reservation: " + reservation);
                return;
            }
        }
        System.out.println("No reservation found for student " + studentName + " with tutor " + tutorName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option: 1) Add Reservation 2) Remove Reservation 3) Print Reservations 4) Find Reservation 5) Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter student email:");
                    String studentEmail = scanner.nextLine();
                    System.out.println("Enter student phone number:");
                    String studentPhoneNumber = scanner.nextLine();
                    System.out.println("Enter tutor name:");
                    String tutorName = scanner.nextLine();
                    System.out.println("Enter tutor phone number:");
                    String tutorPhoneNumber = scanner.nextLine();
                    System.out.println("Enter tutor ID:");
                    String tutorId = scanner.nextLine();
                    System.out.println("Enter tutor subject:");
                    String tutorSubject = scanner.nextLine();
                    System.out.println("Enter date (dd-mm-yyyy):");
                    String date = scanner.nextLine();
                    System.out.println("Enter time (hh:mm AM/PM):");
                    String time = scanner.nextLine();
                    addReservation(studentName, studentEmail, studentPhoneNumber, tutorName, tutorPhoneNumber, tutorId, tutorSubject, date, time);
                    break;
                case 2:
                    System.out.println("Enter student name:");
                    String studentToRemove = scanner.nextLine();
                    System.out.println("Enter tutor name:");
                    String tutorToRemove = scanner.nextLine();
                    System.out.println("Enter date (dd-mm-yyyy):");
                    String dateToRemove = scanner.nextLine();
                    System.out.println("Enter time (hh:mm AM/PM):");
                    String timeToRemove = scanner.nextLine();
                    removeReservation(studentToRemove, tutorToRemove, dateToRemove, timeToRemove);
                    break;
                case 3:
                    printReservations();
                    break;
                case 4:
                    System.out.println("Enter student name:");
                    String studentToFind = scanner.nextLine();
                    System.out.println("Enter tutor name:");
                    String tutorToFind = scanner.nextLine();
                    findReservation(studentToFind, tutorToFind);
                    break;
                case 5:
                    System.out.println("Already existed.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid. Please try again.");
            }
        }
    }
}
