package newproject.visitor.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Table(name="empdetails")
@Entity
@Getter
@Setter
public class CreateEmployee
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="dob")
    private String dob;
    @Column(name="gender")
    private String gender;
    @Column(name="mail_id")
    private String mailId;
    @Column(name="contact_no")
    private long contactNo;
    @Column(name="blood_group")
    private String group;
    @Column(name="address")
    private String address;
    @Column(name="department")
    private String department;
    @Column(name="date_of_joining")
    private String joiningdate;
}
