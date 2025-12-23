package JDBC_Project.P1_HotelReservationSystem;

import java.sql.*;
import java.util.Scanner;

public class main {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Minsu@Agra972MySQL";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Loading Database Drivers ");
            loadingDots();

            // Establish connection
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                System.out.println("\n✅ Database connection established.");

                while (true) {
                    // Menu
                    System.out.println("\n==== Hotel Management System ====");
                    System.out.println("1. Reserve a Room");
                    System.out.println("2. View Reservations");
                    System.out.println("3. Get Room Number");
                    System.out.println("4. Update Reservation");
                    System.out.println("5. Delete Reservation");
                    System.out.println("0. Exit");
                    System.out.print("\nChoose an option: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Clear newline

                    switch (choice) {
                        case 1 -> reserveRoom(connection, scanner);
                        case 2 -> viewReservations(connection);
                        case 3 -> getRoomNumber(connection, scanner);
                        case 4 -> updateReservation(connection, scanner);
                        case 5 -> deleteReservation(connection, scanner);
                        case 0 -> {
                            System.out.print("Exiting ");
                            loadingDots();
                            return; // Exit program
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                }

            } catch (SQLException e) {
                System.err.println("❌ Database error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found.");
        } catch (InterruptedException e) {
            System.err.println("❌ Loading interrupted.");
        }
    }

    // ---------------------------
    // CASE 1: Reserve a Room
    // ---------------------------
    private static void reserveRoom(Connection connection, Scanner scanner) {
        String sql = "INSERT INTO reservations (guest_name, room_number, contact_number, reservation_date) VALUES (?, ?, ?, NOW())";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            System.out.println("\n==== Reservation Page ====");
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Room Number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine(); // clear newline

            System.out.print("Enter Contact Number: ");
            String contactNumber = scanner.nextLine();

            ps.setString(1, guestName);
            ps.setInt(2, roomNumber);
            ps.setString(3, contactNumber);

            int affectedRows = ps.executeUpdate();
            System.out.println(affectedRows > 0 ? "\n✅ Reservation successful!\n" : "\n❌ Reservation failed.\n");

        } catch (SQLException e) {
            System.err.println("❌ Error reserving room: " + e.getMessage());
        }
    }

    // ---------------------------
    // CASE 2: View Reservations
    // ---------------------------
    private static void viewReservations(Connection connection) {
        String sql = "SELECT * FROM reservations";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nCurrent Reservations:");
            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
            System.out.println("| Reservation ID | Guest           | Room Number   | Contact Number       | Reservation Date         |");
            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");

            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                String guestName = rs.getString("guest_name");
                int roomNumber = rs.getInt("room_number");
                String contactNumber = rs.getString("contact_number");
                String reservationDate = rs.getString("reservation_date");

                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s |\n",
                        reservationId, guestName, roomNumber, contactNumber, reservationDate);
            }
            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving reservations: " + e.getMessage());
        }
    }

    // ---------------------------
    // CASE 3: Get Room Number by ID and Name
    // ---------------------------
    private static void getRoomNumber(Connection connection, Scanner scanner) {
        String sql = "SELECT room_number FROM reservations WHERE reservation_id = ? AND guest_name = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            System.out.print("Enter Reservation ID: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            ps.setInt(1, reservationId);
            ps.setString(2, guestName);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("✅ Room Number: " + rs.getInt("room_number"));
                } else {
                    System.out.println("❌ Reservation not found.");
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving room number: " + e.getMessage());
        }
    }

    // ---------------------------
    // CASE 4: Update Reservation
    // ---------------------------
    private static void updateReservation(Connection connection, Scanner scanner) {
        String sql = "UPDATE reservations SET guest_name = ?, room_number = ?, contact_number = ? WHERE reservation_id = ?";

        try {
            System.out.print("Enter Reservation ID to update: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            if (!reservationExists(connection, reservationId)) {
                System.out.println("❌ Reservation ID not found.");
                return;
            }

            System.out.print("Enter New Guest Name: ");
            String guestName = scanner.nextLine();
            System.out.print("Enter New Room Number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New Contact Number: ");
            String contactNumber = scanner.nextLine();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, guestName);
                ps.setInt(2, roomNumber);
                ps.setString(3, contactNumber);
                ps.setInt(4, reservationId);

                int rows = ps.executeUpdate();
                System.out.println(rows > 0 ? "✅ Reservation updated." : "❌ Update failed.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error updating reservation: " + e.getMessage());
        }
    }

    // ---------------------------
    // CASE 5: Delete Reservation
    // ---------------------------
    private static void deleteReservation(Connection connection, Scanner scanner) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";

        try {
            System.out.print("Enter Reservation ID to delete: ");
            int reservationId = scanner.nextInt();
            scanner.nextLine();

            if (!reservationExists(connection, reservationId)) {
                System.out.println("❌ Reservation ID not found.");
                return;
            }

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, reservationId);
                int rows = ps.executeUpdate();
                System.out.println(rows > 0 ? "✅ Reservation deleted." : "❌ Delete failed.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error deleting reservation: " + e.getMessage());
        }
    }

    // ---------------------------
    // Utility: Check if reservation exists
    // ---------------------------
    private static boolean reservationExists(Connection connection, int reservationId) {
        String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("❌ Error checking reservation: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------
    // Utility: Loading dots
    // ---------------------------
    public static void loadingDots() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            Thread.sleep(450);
        }
        System.out.println();
    }
}
