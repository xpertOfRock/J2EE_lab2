import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Test

    public void EmloyeeTest1(){
        String firstName = "Arsen", lastName = "Chuvachok";
        double salary = 10000;
        try{
            Employee emp = new Employee(firstName, lastName, salary);
        }
        catch(FieldLengthLimitException | IncorrectSalaryException ex){
            Logger.getLogger(EmployeeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(firstName, 10000, salary, 0);
        assertEquals(lastName, 10000, salary, 0);
    }
}