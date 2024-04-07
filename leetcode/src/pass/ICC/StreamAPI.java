package pass.ICC;
import java.util.*;

class Employee{
    String fname;
    String lname;

    String job;

    public Employee(String f, String l, String j){
        fname = f;
        lname = l;
        job = j;
    }
}

public class StreamAPI {
    public void testCases(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Joey", "Zhang", "SDE"));
        list.stream().map(employee -> employee.fname + employee.lname + employee.job).forEach(e -> System.out.println(e));
    }

    public static void main(String[] args){
        StreamAPI sa = new StreamAPI();
        sa.testCases();
    }
}
