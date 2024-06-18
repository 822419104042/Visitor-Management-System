package newproject.visitor.controller;
import newproject.visitor.model.AddLeave;
import newproject.visitor.service.AddLeaveService;
import newproject.visitor.vo.AddLeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/addLeave")
public class AddLeaveController
{
    @Autowired
    private AddLeaveService addLeaveService;
    @GetMapping("/getAllEmpLeave")
    public List<AddLeaveVo> getAllEmpLeave(){
        return addLeaveService.getAllEmpLeave();
    }
    @PostMapping("/add")
    public AddLeave CreateEmpLeave(@RequestBody AddLeave addLeave)
    {
        return addLeaveService.CreateEmpLeave(addLeave);
    }
    @GetMapping("/get/{id}")
    public AddLeave getEmpLeaveById(@PathVariable Integer id)
    {
        return addLeaveService.getEmpLeaveById(id);
    }
    @PutMapping("update/{id}")
    public AddLeave updateEmpLeave(@PathVariable Integer id,@RequestBody AddLeave addLeave) {
        return addLeaveService.updateEmpLeave(id, addLeave);
    }
    @GetMapping("delete/{id}")
    public String  deleteEmpLeaveById(@PathVariable Integer id)
    {
       addLeaveService.deleteEmpLeaveById(id);
       return"employee details deleted successfully";
    }

}
