package newproject.visitor.controller;
import newproject.visitor.model.CreateEmployee;
import newproject.visitor.service.CreateEmployeeService;
import newproject.visitor.vo.CreateEmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/emp")
public class CreateEmployeeController {

@Autowired
private CreateEmployeeService createEmployeeService;
@GetMapping("/getEmp")
public List<CreateEmployeeVo>getAllEmp()
{
    return createEmployeeService.getAllEmp();
}
@PostMapping("/emp/add")
public String CreateEmp(@RequestBody CreateEmployee createEmployee) {
    createEmployeeService.CreateEmp(createEmployee);
    return "user added successfully";
}
@PostMapping("/emp/{id}")
public CreateEmployee  getEmpById(@PathVariable  Integer id)
{
    return createEmployeeService.getEmpById(id);

}
@PutMapping("/emp/update/{id}")
public CreateEmployee  updateEmp(@PathVariable  Integer id,@RequestBody CreateEmployee createEmployee)
{
    return createEmployeeService.updateEmp(id,createEmployee);
}
@GetMapping("emp/delete/{id}")
public String deleteEmpById(@PathVariable  Integer id)
{
    createEmployeeService.deleteEmpById(id);
    return "employee detail deleted successfully";
}
}
