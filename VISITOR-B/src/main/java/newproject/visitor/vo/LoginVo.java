package newproject.visitor.vo;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class LoginVo
{
    private String emailId;
    private String password;
}
