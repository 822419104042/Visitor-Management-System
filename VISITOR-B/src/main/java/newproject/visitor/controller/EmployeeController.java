package newproject.visitor.controller;
import newproject.visitor.model.Employee;
import newproject.visitor.service.EmployeeService;;
import newproject.visitor.util.JwtUtil;
import newproject.visitor.vo.EmployeeVo;
import newproject.visitor.vo.LoginVo;
import newproject.visitor.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/user")
@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String Welcome() {
        return "welcome to login page";
    }

    @GetMapping("/employee")
    public List<EmployeeVo> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/employee/add")
    public String CreateEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return "user added successfully";
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("employee/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @PostMapping(value="/login")
    public ResponseEntity<TokenVo> loginEmployee(@RequestBody LoginVo loginVo) {
        TokenVo tokenVo = employeeService.loginEmployee(loginVo);
        return ResponseEntity.ok(tokenVo);
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "deleted successfully";
    }

    @PostMapping("/generateToken")
    public String loadUserByEmail(@RequestBody LoginVo loginVo) {
        return jwtUtil.generateToken(loginVo.getEmailId());
    }
}




