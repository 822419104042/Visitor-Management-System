package newproject.visitor.vo;
import lombok.Data;

import java.util.Date;
@Data
public class AddLeaveVo
{
    private int id;
    private String name;
    private String leave;
    private String fromDate;
    private String toDate;
    private int days;
    private int alreadyTakenLeave;
    private int remainingLeaveDay;
    private String leaveStatus;
    private String reason;
    private String username;
    private String leavetype;

}
