package newproject.visitor.service;
import newproject.visitor.model.CreateEmployee;
import newproject.visitor.model.Department;
import newproject.visitor.repository.CreateEmployeeRepository;
import newproject.visitor.repository.DepartmentRepository;
import newproject.visitor.vo.CreateEmployeeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class CreateEmployeeService {
    @Autowired
    private CreateEmployeeRepository createEmployeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<CreateEmployeeVo> getAllEmp() {
        List<CreateEmployeeVo> createEmployeeVoList = new ArrayList<>();
        List<CreateEmployee> employees = createEmployeeRepository.findAll();
        employees.forEach(src -> {
            CreateEmployeeVo obj = new CreateEmployeeVo();
            BeanUtils.copyProperties(src, obj);
            Department department = departmentRepository.findById(Integer.valueOf(src.getDepartment())).get();
            obj.setDepartmentName(department.getDeptName());
            createEmployeeVoList.add(obj);
        });
        return createEmployeeVoList;
    }
    public CreateEmployee CreateEmp(CreateEmployee createEmployee) {
        return createEmployeeRepository.save(createEmployee);
    }
    public CreateEmployee  getEmpById(Integer id) {
        return createEmployeeRepository.findById(id).orElse(null);
    }
    public CreateEmployee  updateEmp(Integer id, CreateEmployee createEmployee) {
        CreateEmployee ce=createEmployeeRepository.findById(id).orElse(null);
        ce.setFirstname(createEmployee.getFirstname());
        ce.setLastname(createEmployee.getLastname());
        ce.setDob(createEmployee.getDob());
        ce.setGender(createEmployee.getGender());
        ce.setMailId(createEmployee.getMailId());
        ce.setContactNo(createEmployee.getContactNo());
        ce.setGroup(createEmployee.getGroup());
        ce.setAddress(createEmployee.getAddress());
        ce.setDepartment(createEmployee.getDepartment());
        ce.setJoiningdate(createEmployee.getJoiningdate());
        return createEmployeeRepository.save(createEmployee);
    }
    public void deleteEmpById(Integer id) {
        createEmployeeRepository.deleteById(id);
    }
}

