package shoestore.shoestoreapi.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepo repo;


    @GetMapping("/get")
    public Object getAll() throws Exception{
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            return "There are no employees with this name!";
        }
        return employees;
    }

    @GetMapping("/getname/{name}")
    public Object getByName(@PathVariable String name) throws Exception{
        List<Employee> employees = employeeService.getEmployeesByName(name);
        if (employees.isEmpty()) {
            return "There are no employees with this name "+name+" !";
        }
        return employees;
    }


    @GetMapping("/getid/{id}")
    public Object getByID(@PathVariable int id) throws Exception{
        List<Employee> listOfEmployees =  new ArrayList<>();
        listOfEmployees = employeeService.getEmployeesById(id);
        if(listOfEmployees==null){
            return "There is no employees with id " + id+"!";
        }
        return listOfEmployees;      
    }

    @GetMapping("/getpos/{position}")
    public Object getByPosition(@PathVariable String position) throws Exception{
        List<Employee> listOfEmployees = employeeService.getEmployeesByPosition(position);
        if(listOfEmployees.isEmpty()){
            return "There is no employees with the position of "+position+"!";
        }
        return listOfEmployees;    
    }

    @GetMapping("/getsalary/{salary}")
    public Object getBySalaryRange(@PathVariable double salary)throws Exception {
        List<Employee> listOfEmployees = employeeService.getEmployeesBySalary(salary);
        if(listOfEmployees.isEmpty()){
            return "There is no employees at the salary of "+salary+".";
        }
        return listOfEmployees;

    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <?> addEmployee(@RequestBody Employee employee)throws Exception{
        Object r = employeeService.createEmployee(employee);
        return new ResponseEntity<>(r,HttpStatus.CREATED);
    }
    @PutMapping("/edit")
    public ResponseEntity<?> editEmployeeById(@RequestBody Employee employee,BindingResult result){
        
        if (result.hasErrors()) {
            // Return bad request with validation errors
            List<String> errors = result.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
    
        // Check for unexpected fields in JSON
        if (!validateJsonFields(employee)) {
            return ResponseEntity.badRequest().body("Unexpected fields in JSON");
        }
    

        List<Employee> listOfEmployees = employeeService.editEmployee(employee);
        return ResponseEntity.ok(listOfEmployees.get(0)); 
    }
    
    
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int id){
        String r = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(r,HttpStatus.ACCEPTED);
    }
    private boolean validateJsonFields(Employee employeeRequest) {
    // Check for unexpected fields
    if (employeeRequest.getId() == 0 || employeeRequest.getName() == null ||
        employeeRequest.getPosition() == null || employeeRequest.getSalary() == 0) {
        return false;
    }
    return true;
}

}
