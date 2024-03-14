package shoestore.shoestoreapi.Employee;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Employees", schema = "public")
@Data
public class Employee {
    @Id
    @NotEmpty
    public int id;

    @NotEmpty
    public String name;

    @NotEmpty
    public String position;

    @NotEmpty
    public double salary;
    public Employee(){

    }
    public Employee(int id, String n, String p, double s){
        super();
        this.id = id;
        this.name=n;
        this.position = p;
        this.salary = s;
    }
}
