public class Employee {
    public int id;
    public static int nextId = 0;
    public String firstName, lastName;
    public double salary;
    public Employee(String _firstName, String _lastName, double _salary) throws FieldLengthLimitException, IncorrectSalaryException {
        this.id = nextId++;
        if(_firstName.length() > 8 ){
            throw new FieldLengthLimitException("Too many symbols in field 'First name'.");
        }
        if(_lastName.length() > 14){
            throw new FieldLengthLimitException("Too many symbols in field 'Last name'.");
        }
        if(_salary < 0) {
            throw new IncorrectSalaryException("Field 'salary' can't be negative value.");
        }
        else{
            this.firstName = _firstName;
            this.lastName = _lastName;
            this.salary = _salary;
        }
    }

    void Output(){
        System.out.println("ID: " + id  + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nSalary: " + salary + " $");
    }
}
