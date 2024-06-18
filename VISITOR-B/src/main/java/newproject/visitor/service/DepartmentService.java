package newproject.visitor.service;
import newproject.visitor.model.Department;
import newproject.visitor.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
    public Department CreateDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department getDepartmentById(Integer dept_id) {
        return departmentRepository.findById(dept_id).orElse(null);
    }
    public Department updateDepartment(Integer id, Department department) {
        Department d1 = departmentRepository.findById(id).orElse(null);
        d1.setDeptName(department.getDeptName());
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}


