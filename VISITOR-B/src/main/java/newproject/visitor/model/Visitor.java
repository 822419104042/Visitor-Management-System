package newproject.visitor.model;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Table(name="visitor")
@ApiModel(description = "This table holds the details of visitors")
@Entity
@Getter
@Setter
public class Visitor
{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name="id")
  private int id;
  @Column(name="name_of_visitor")
  private String visitorName;
  @Column(name="date_of_visitor")
  private Date date;
  @Column(name="in_time")
  private String inTime;
  @Column(name="out_time")
  private String outTime;
  @Column(name="access_card_no")
  private Integer accessno;
  @Column(name="gender")
  private String gender;
  @Column(name="person_to_visit")
  private String person;
  @Column(name="purpose")
  private String purpose;
  @Column(name="phone_no")
  private String phoneno;
  @Column(name="authorized")
  private String authorized;

}
