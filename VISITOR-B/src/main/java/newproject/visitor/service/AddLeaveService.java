package newproject.visitor.service;
import newproject.visitor.model.*;
import newproject.visitor.repository.AddLeaveRepository;
import newproject.visitor.repository.CreateEmployeeRepository;
import newproject.visitor.repository.LeaveRepository;
import newproject.visitor.vo.AddLeaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class AddLeaveService
{
    @Autowired
    private AddLeaveRepository addLeaveRepository;
    @Autowired
    private CreateEmployeeRepository createEmployeeRepository;
    @Autowired
    private LeaveRepository leaveRepository;

    public List<AddLeaveVo> getAllEmpLeave() {
        List<AddLeaveVo> AddLeaveVoList = new ArrayList<>();
        List<AddLeave> leaves = addLeaveRepository.findAll();
        leaves.forEach(src -> {
            AddLeaveVo obj = new AddLeaveVo();
            BeanUtils.copyProperties(src, obj);

            CreateEmployee createEmployee = createEmployeeRepository.findById(Integer.valueOf(src.getName())).get();
            obj.setUsername(createEmployee.getFirstname());
            Leave leave = leaveRepository.findById(Integer.valueOf(src.getLeaveType())).get();
            obj.setLeavetype(leave.getLeaveType());
            AddLeaveVoList.add(obj);
        });
        return AddLeaveVoList;
    }
    public AddLeave CreateEmpLeave(AddLeave addLeave)
    {
        return addLeaveRepository.save(addLeave);
    }
    public AddLeave getEmpLeaveById(Integer id)

    {
        return addLeaveRepository.findById(id).orElse(null);
    }
    public AddLeave updateEmpLeave(Integer id,AddLeave addLeave)
    {
        AddLeave al=addLeaveRepository.findById(id).orElse(null);
        al.setName(addLeave.getName());
        al.setLeaveType(addLeave.getLeaveType());
        al.setFromDate(addLeave.getFromDate());
        al.setToDate(addLeave.getToDate());
        al.setDays(addLeave.getDays());
        al.setAlreadyTakenLeave(addLeave.getAlreadyTakenLeave());
        al.setRemainingLeaveDay(addLeave.getRemainingLeaveDay());
        al.setReason(addLeave.getReason());
        return addLeaveRepository.save(addLeave);
    }
    public void deleteEmpLeaveById(Integer id) {
        addLeaveRepository.deleteById(id);
    }





}


