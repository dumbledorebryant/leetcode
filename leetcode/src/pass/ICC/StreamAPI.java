package pass.ICC;
import java.util.*;

class Employee{
    String fname;
    String lname;

    String job;
}

public class StreamAPI {
    public void testCases(){
        List<Employee> list = new ArrayList<>();
        list.stream().map(employee -> employee.fname + employee.lname + employee.job).forEach(e -> System.out.println(e));
    }
}
