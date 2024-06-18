package newproject.visitor.repository;
import newproject.visitor.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    Employee findByMailIdAndPassword(String emailId, String password);
    Employee findByMailId(String email);

}
