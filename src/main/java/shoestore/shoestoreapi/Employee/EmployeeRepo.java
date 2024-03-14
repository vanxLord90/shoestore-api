package shoestore.shoestoreapi.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    List<Employee> findById(int id);
    List<Employee> findByName(String name);
    List<Employee> findByPosition(String position);
    List<Employee> findBySalary(double salary);

}
