import java.util.Scanner;

public class Menu {
    
    private EmployeeDatabase db = new EmployeeDatabase();
    private Scanner in = new Scanner(System.in);

    public void showMenu(){
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("    Employee Management System");
            System.out.println("\n-----------------------------------------------");

            System.out.println("1. Build Table");
            System.out.println("2. Insert New Entry");
            System.out.println("3. Delete Entry");
            System.out.println("4. Search Record");
            System.out.println("5. Exit");

            System.out.println("Enter you Choice");
            
            int choice = in.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> db.buildTable();
                case 2 -> db.insertEmployee();
                case 3 -> db.deleteEmployee();
                case 4 -> db.searchEmployee();
                case 5 -> {
                    System.out.println("Exiting ... Goodbye");
                    return;
                }
                default -> System.out.println("invalid choice! Please try again. ");
            }
        }
    }
}
