package shoestore.shoestoreapi.DBTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shoestore.shoestoreapi.Employee.Employee;
import shoestore.shoestoreapi.Employee.EmployeeRepo;

import java.util.List;

@Component
public class DBInspector {

    private static final Logger logger = LoggerFactory.getLogger(DBInspector.class);

    @Autowired
    private EmployeeRepo employeeRepo;

    public void inspectDatabase() {
        List<Employee> employees = employeeRepo.findAll();
        for (Employee employee : employees) {
            logger.info("Employee: {}", employee);
        }
    }
}

