package newproject.visitor.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="emp_leave_details")
@Getter
@Setter
public class AddLeave
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="emp_name")
    private String name;
    @Column(name="leave_type")
    private String leaveType;
    @Column(name="from_date")
    private Date fromDate;
    @Column(name="to_date")
    private Date toDate;
    @Column(name="days")
    private int days;
    @Column(name="no_of_leave_already_taken")
    private int alreadyTakenLeave;
    @Column(name="remaining_leave_days")
    private int remainingLeaveDay;
    @Column(name="reason")
    private String reason;
}
