package newproject.visitor.vo;
import lombok.Data;
import newproject.visitor.model.Department;
import java.util.Date;
@Data
public class VisitorVo{
    private int id;
    private String visitorName;
    private Date date;
    private String inTime;
    private String outTime;
    private Integer accessno;
    private String gender;
    private String person;
    private String purpose;
    private String phoneno;
    private String authorized;
    //private String area;
    //private Department department;
    private String areaName;
    private String departmentName;
    private String personName;
}
