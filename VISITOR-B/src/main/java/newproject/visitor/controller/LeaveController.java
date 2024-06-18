package newproject.visitor.controller;
import newproject.visitor.model.Leave;
import newproject.visitor.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/leave")
public class LeaveController {
@Autowired
private LeaveService leaveService;
@GetMapping("/leaves")
public List<Leave>getAllLeave(){
    return leaveService.getAllLeave();
}
@GetMapping("/leave/{id}")
public Leave getLeaveById (@PathVariable Integer id)
{
    return leaveService.getLeaveById(id);
}
@PostMapping("/leave/add")

public Leave CreateLeave(@RequestBody Leave leave)
{
        return leaveService.CreateLeave(leave);
}
@PutMapping("/leave/update/{id}")
public Leave updateLeave(@PathVariable Integer id, @RequestBody Leave leave)
{
    return leaveService.updateLeave(id,leave);
}
@GetMapping("leave/delete/{id}")
public void deleteLeave(@PathVariable Integer id)
{
        leaveService.deleteLeave(id);
}
}
