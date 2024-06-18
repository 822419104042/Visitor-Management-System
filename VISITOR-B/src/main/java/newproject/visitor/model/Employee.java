package newproject.visitor.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "employee")
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int empid;
    @Column(name = "contact_no")
    private long contactNo;
    @Column(name = "mail_id")
    private String mailId;
    @Column(name = "user_name")
    private String username;
    @Column(name = "pass_word")
    private String password;
    @Column(name="date_of_joining")
    private Date joiningdate;
    @Column(name="department")
    private String department;
    @Column (name="area")
    private String area;
    @Column(name="token")
    private String token;
}


