package pass.ICC;

@Service
public class ServiceLayer {
    private EmployeeDao eDao;

    @Autowired
    public void setDao(EmployeeDao eDao){
        this.eDao = eDao;
    }

    public void addEmployee(Employee employee){
        eDao.add(employee);
    }
}
