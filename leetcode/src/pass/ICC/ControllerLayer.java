package pass.ICC;


@RestController
@RequestMapping("/Employees")
public class ControllerLayer {
    @Autowired
    private EmployeeService eService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        eService.addEmployee(employee);
        return ResponseEntity.status("OK").message("add successfully");
    }
}
