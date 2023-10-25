import java.util.ArrayList;

abstract class Employee{

    private int employeeId;
    private String name;

  // constructor   
   public Employee(String name, int employeeId){
    this.employeeId = employeeId;
    this.name = name;
   }
  
   public String getName(){
    return name;
   }
  
   public int getemployeeId(){
    return employeeId;
    }
    // abstract method implementation in child class when we extends.
   public abstract double calculateSalary(); 

    
    public String toString(){
    return "Employee[name= "+name+", id="+employeeId+",salary="+calculateSalary()+"]";
    }
}
  
class fullTimeEmployee extends Employee{
     private double monthlySalary;

    public fullTimeEmployee(String name, int employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    
    public double calculateSalary() {
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee{
    
    private int hoursWorked;
    private double hourlyRate;
    
    public partTimeEmployee(String name, int employeeId, int hoursWorked, double hourlyRate) {
        super(name, employeeId);
         this.hoursWorked = hoursWorked;
         this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
      return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    
    private ArrayList<Employee> employeeList;

     public PayrollSystem(){
     employeeList = new ArrayList<>();
     }

     public void addEmployee(Employee employee){
        employeeList.add(employee);
     }

     public void removeEmployee(int employeeId){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getemployeeId()==employeeId){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
     }

     public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println("display employee: "+employee);
        }
     }


}


public class Main {
    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("pratik", 1, 3500.0);
        partTimeEmployee emp2 = new partTimeEmployee("nency", 2, 40, 240.0);

        ps.addEmployee(emp1);
        ps.addEmployee(emp2);

        System.out.println("=== initial employee detais ===");
        ps.displayEmployee();
        System.out.println("=== remove employee ===");
        ps.removeEmployee(2);;
        System.out.println("=== remaining employee details ===");
        ps.displayEmployee();
    }
}
