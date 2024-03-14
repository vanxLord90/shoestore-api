package shoestore.shoestoreapi.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repo;

    List<Integer> empsId= new ArrayList<>();

    
    public Object createEmployee(@RequestBody Employee employee)throws Exception{
        try{
            if(!empsId.contains(employee.getId())){
                repo.save(employee);
                empsId.add(employee.getId());
            }
            else{
                throw new Exception("Employee with id "+employee.getId()+" already exists");
            }
        }catch(Exception e){
            return e.getMessage();
        }
        List<Employee> createdEmployee = new ArrayList<>();
        createdEmployee.add(employee);
        return createdEmployee;
    }
    public List<Employee> editEmployee(@RequestBody Employee employee){

        List<Employee> e = repo.findById(employee.getId());
        e.get(0).setName(employee.getName());
        e.get(0).setPosition(employee.getPosition());
        e.get(0).setSalary(employee.getSalary());
        repo.save(e.get(0));
        return e;
    }

    public List<Employee> getEmployeesBySalary(@PathVariable double salary) throws Exception{
        List<Employee> listOfEmployees = new ArrayList<>();

        try{
        listOfEmployees = repo.findBySalary(salary);
        if(listOfEmployees.isEmpty()){
            throw new Exception("No employee with the "+salary+" salary!");
        }
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());
            return listOfEmployees;
        }

        return listOfEmployees;
    }

    public List<Employee> getEmployeesByPosition(@PathVariable String position) throws Exception{
        List<Employee> listOfEmployees = new ArrayList<>();

        try{
        listOfEmployees = repo.findByPosition(position);
        if(listOfEmployees.isEmpty()){
            throw new Exception("No employee with the "+position+" position!");
        }
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());
            return listOfEmployees;
        }

        return listOfEmployees;
    } 

    
    public List<Employee> getEmployeesById(@PathVariable int id) throws Exception{
        List<Employee> listOfEmployees = new ArrayList<>();

        try{
        listOfEmployees = repo.findById(id);
        if(listOfEmployees==null){
            throw new Exception("No employee with the "+id+" id!");
        }
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());

            return listOfEmployees;
        }

        return listOfEmployees;
    } 
    public List<Employee> getEmployeesByName(@PathVariable String name) throws Exception{
        List<Employee> listOfEmployees = new ArrayList<>();
        try{
           listOfEmployees = repo.findByName(name);  
           if(listOfEmployees.isEmpty()){
             throw new Exception("No employee with the "+name+" name!");
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return listOfEmployees;
        }
        return listOfEmployees;
    }

    public List<Employee> getAllEmployees() throws Exception{
        List<Employee> listOfEmployees = new ArrayList<>();
        try{
            listOfEmployees=repo.findAll();
            if(listOfEmployees.isEmpty()){
                throw new Exception("There have been no employees created yet.");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return listOfEmployees;
        }
        return listOfEmployees;

    }

    public String deleteEmployeeById(@PathVariable int id){
        List<Employee> listOfEmployees = new ArrayList<>();
        try{
        listOfEmployees = repo.findById(id);
            if(listOfEmployees.isEmpty()){
                throw new Exception("No employee with id "+id+"!");
            }
        }
        catch(Exception e){
            return e.getMessage();
        }
        finally{
            repo.delete(listOfEmployees.get(0));
        }
        return "Employee with id "+id+" deleted successfully!";
    }
}
