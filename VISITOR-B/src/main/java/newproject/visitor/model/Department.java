package newproject.visitor.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Table(name="department")
@Entity
@Getter
@Setter
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="dept_id")
    private int deptId;
    @Column(name="department")
    private String deptName;
}
