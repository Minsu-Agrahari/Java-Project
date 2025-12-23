public class Employee {
    String name;
    long code;
    String designation;
    int exp;
    int age;

    public Employee(String name, long code, String designation, int exp, int age){
        this.name = name;
        this.code = code;
        this.designation = designation;
        this.exp = exp;
        this.age = age;
    }

    public void display(){
        System.out.println("Name :- "+ name);
        System.out.println("Employee ID :- " + code);
        System.out.println("Designation :- "+ designation);
        System.out.println("Experience :- "+ exp);
        System.out.println("Age :- "+age);
    }
}
