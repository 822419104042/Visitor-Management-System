package newproject.visitor.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Table(name="leave_details")
@Entity
@Getter
@Setter
public class Leave
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
    private int id;
    @Column(name="leave_type")
    private String leaveType;
    @Column(name="no_of_days")
    private int days;
}
