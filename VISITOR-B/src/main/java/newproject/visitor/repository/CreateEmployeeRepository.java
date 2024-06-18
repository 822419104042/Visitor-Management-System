package newproject.visitor.repository;

import newproject.visitor.model.CreateEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateEmployeeRepository extends JpaRepository<CreateEmployee,Integer> {
}
