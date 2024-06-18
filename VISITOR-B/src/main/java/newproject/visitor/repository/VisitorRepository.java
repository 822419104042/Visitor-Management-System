package newproject.visitor.repository;
import newproject.visitor.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer>
{
    public List<Visitor> findByDateBetween(Date startDate, Date EndDate);
}
