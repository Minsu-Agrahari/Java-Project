import java.util.*;

public class EmployeeDatabase {
    private final int MAX = 20;
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public void buildTable(){
        System.out.println("Build The Table");
        System.out.println("Maximum Entries can be "+ MAX);

        System.out.println("Enter the number of entries required: ");
        int num = in.nextInt();
        in.nextLine();  // consume newline

        if(num > MAX){
            System.out.println("Maximum number of entries are 20");
            num = MAX;
        }

        for(int i=0; i<num; i++){
            employeeList.add(readEmployee());
        }

        System.out.println("Table built successfully! \n");
    }

    public void insertEmployee(){
        if(employeeList.size() >= MAX){
            System.out.println("Employee Table is Full");
            return;
        }

        System.out.println("Enter the information of the new Employee: ");
        employeeList.add(readEmployee());
        System.out.println("Employee add sucessfully !");
    }

    public void deleteEmployee(){
        System.out.println("Enter the Employee Id to Delete: ");
        long code = in.nextLong();

        boolean remove = employeeList.removeIf(emp -> emp.code == code);

        if(remove) System.out.println("Recode deleted successfully ! ");
        else System.out.println("Employee not found !");
    }

    public void searchEmployee(){
        System.out.print("Enter the Employee ID to Search");
        long code = in.nextLong();

        for(Employee emp : employeeList){
            if(emp.code == code){
                System.out.println("\nEmployee Found: ");
                emp.display();
                return;
            }
        }

        System.out.println("Employee not found! ");
    }

    // helper function to take employee input
    private Employee readEmployee(){
        System.out.print("Name : ");
        String name = in.next();

        System.out.print("Employee ID: ");
        long code = in.nextLong();

        System.out.print("Designation ");
        String designation = in.next();
        
        System.out.print("Experience (years): ");
        int exp = in.nextInt();

        System.out.print("Age: ");
        int age = in.nextInt();

        return new Employee(name, code, designation, exp, age);
    }
}
