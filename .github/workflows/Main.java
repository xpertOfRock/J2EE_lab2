
public class Main {
    public static void main(String[] args) {
        try{
            Employee employee = new Employee("Nuno","Bettencourt", 1500000);
            employee.Output();
        }catch(FieldLengthLimitException | IncorrectSalaryException exception){
            System.out.println(exception.getMessage());
        }
        try{
            Employee employee = new Employee("Abd","Abushammala El Rakhem", 100000);
            employee.Output();
        }catch(FieldLengthLimitException | IncorrectSalaryException exception){
            System.out.println(exception.getMessage());
        }
        try{
            Employee employee = new Employee("Vlad","Olkhovik", 2000000);
            employee.Output();
        }catch(FieldLengthLimitException | IncorrectSalaryException exception){
            System.out.println(exception.getMessage());
        }
    }
}
