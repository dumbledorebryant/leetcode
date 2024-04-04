package pass.ICC;

import java.util.*;

@Repository
public class DaoLayer {
    private List<Employee> list = new ArrayList<>();

    public void add(Employee e){
        list.add(e);
    }
}
