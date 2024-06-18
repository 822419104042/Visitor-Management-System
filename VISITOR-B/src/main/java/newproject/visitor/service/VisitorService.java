package newproject.visitor.service;
import newproject.visitor.model.Area;
import newproject.visitor.model.Department;
import newproject.visitor.model.Employee;
import newproject.visitor.model.Visitor;
import newproject.visitor.repository.AreaRepository;
import newproject.visitor.repository.DepartmentRepository;
import newproject.visitor.repository.EmployeeRepository;
import newproject.visitor.repository.VisitorRepository;
import newproject.visitor.vo.VisitorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class VisitorService
{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private VisitorRepository visitorRepository;

    public List<VisitorVo> getAllVisitor()
   {
       List<VisitorVo>visitorVoList=new ArrayList<>();
       List<Visitor>visitors=visitorRepository.findAll();
       visitors.forEach(src->{
           VisitorVo obj=new VisitorVo();
           BeanUtils.copyProperties(src, obj);

           Employee employee=employeeRepository.findById(Integer.valueOf(src.getPerson())).get();
           obj.setPersonName(employee.getUsername());
           Department department = departmentRepository.findById(Integer.valueOf(employee.getDepartment())).get();
           obj.setDepartmentName(department.getDeptName());
           Area area=areaRepository.findById(Integer.valueOf(employee.getArea())).get();
           obj.setAreaName(area.getAreaName());
           visitorVoList.add(obj);
       });
       return visitorVoList;
   }
    public Visitor CreateVisitor(Visitor visitor)
    {
        return visitorRepository.save(visitor);
    }
    public Visitor getVisitorById(Integer id)
    {
        return visitorRepository.findById(id).orElse(null);
    }
    public List<VisitorVo> getVisitor(Date startDate,Date EndDate)
    {
        List<VisitorVo>visitorVoList=new ArrayList<>();
        List<Visitor>visitors=visitorRepository.findByDateBetween(startDate,EndDate);
        visitors.forEach(src->{
            VisitorVo obj=new VisitorVo();
            BeanUtils.copyProperties(src, obj);

            Employee employee=employeeRepository.findById(Integer.valueOf(src.getPerson())).get();
            obj.setPersonName(employee.getUsername());
            Department department = departmentRepository.findById(Integer.valueOf(employee.getDepartment())).get();
            obj.setDepartmentName(department.getDeptName());
            Area area=areaRepository.findById(Integer.valueOf(employee.getArea())).get();
            obj.setAreaName(area.getAreaName());
            visitorVoList.add(obj);
        });
        return visitorVoList;
    }
    public Visitor updateVisitor(Integer id,Visitor visitor)
    {
        Visitor v1=visitorRepository.findById(id).orElse(null);
        v1.setPerson(visitor.getPerson());
        v1.setDate(visitor.getDate());
        v1.setInTime(visitor.getInTime());
        v1.setVisitorName(visitor.getVisitorName());
        v1.setAccessno(visitor.getAccessno());
        v1.setOutTime(visitor.getOutTime());
        v1.setAuthorized(visitor.getAuthorized());
        v1.setPurpose(visitor.getPurpose());
        return visitorRepository.save(visitor);
    }
    public void deleteVisitorById(Integer id) {
        visitorRepository.deleteById(id);
    }
}
