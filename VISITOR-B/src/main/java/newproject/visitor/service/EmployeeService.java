package newproject.visitor.service;
import newproject.visitor.model.Area;
import newproject.visitor.model.Department;
import newproject.visitor.model.Employee;
import newproject.visitor.repository.AreaRepository;
import newproject.visitor.repository.DepartmentRepository;
import newproject.visitor.repository.EmployeeRepository;
import newproject.visitor.util.JwtUtil;
import newproject.visitor.vo.EmployeeVo;
import newproject.visitor.vo.LoginVo;
import newproject.visitor.vo.TokenVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<EmployeeVo> getAllEmployee() {
        List<EmployeeVo> employeeVoList = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(src -> {
            EmployeeVo obj = new EmployeeVo();
            BeanUtils.copyProperties(src, obj);
            Department department = departmentRepository.findById(Integer.valueOf(src.getDepartment())).get();
            obj.setDepartmentName(department.getDeptName());
            Area area = areaRepository.findById(Integer.valueOf(src.getArea())).get();
            obj.setAreaName(area.getAreaName());
            employeeVoList.add(obj);
        });
        return employeeVoList;
    }

    public Employee createEmployee(Employee employee) {
        employee.setPassword("test@123");
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Integer emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee e1 = employeeRepository.findById(id).orElse(null);
        e1.setContactNo(employee.getContactNo());
        e1.setMailId(employee.getMailId());
        e1.setUsername(employee.getUsername());
        e1.setPassword(employee.getPassword());
        e1.setJoiningdate(employee.getJoiningdate());
        e1.setDepartment(employee.getDepartment());
        e1.setArea(employee.getArea());
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public TokenVo loginEmployee(LoginVo loginVo) {
        TokenVo vo = new TokenVo();
        Employee isMailId = employeeRepository.findByMailIdAndPassword(loginVo.getEmailId(), loginVo.getPassword());
        if (isMailId != null) {
            String token = jwtUtil.generateToken(loginVo.getEmailId());
            isMailId.setToken(token);
            employeeRepository.save(isMailId);
            vo.setToken(token);
            vo.setMessage("valid credential");
        } else {
            vo.setMessage("invalid credentials");
        }
        return vo;
    }
}
