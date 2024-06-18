package newproject.visitor.controller;
import newproject.visitor.model.Department;
import newproject.visitor.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
    @PostMapping("/department/add")
    public Department CreateDepartment(@RequestBody Department department) {
        return departmentService.CreateDepartment(department);
    }
    @PutMapping("/department/update/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }
    @GetMapping("department/delete/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}

