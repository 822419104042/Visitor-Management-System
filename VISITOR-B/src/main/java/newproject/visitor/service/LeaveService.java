package newproject.visitor.service;
import newproject.visitor.model.Leave;
import newproject.visitor.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LeaveService
{
    @Autowired
    private LeaveRepository leaveRepository;
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }
    public Leave CreateLeave(Leave leave) {
        return leaveRepository.save(leave);
    }
    public Leave getLeaveById(Integer id) {
        return leaveRepository.findById(id).orElse(null);
    }
    public Leave updateLeave(Integer id,Leave leave) {
        Leave l1 = leaveRepository.findById(id).orElse(null);
        l1.setLeaveType(leave.getLeaveType());
        l1.setDays(leave.getDays());
        return leaveRepository.save(leave);
    }
    public void deleteLeave(Integer id) {
        leaveRepository.deleteById(id);
    }
}


