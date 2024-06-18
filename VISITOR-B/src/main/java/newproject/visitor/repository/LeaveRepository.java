package newproject.visitor.repository;

import newproject.visitor.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository  extends JpaRepository<Leave,Integer> {
}
