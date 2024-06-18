package newproject.visitor.controller;
import io.swagger.annotations.ApiOperation;
import newproject.visitor.model.Visitor;
import newproject.visitor.service.VisitorService;
import newproject.visitor.vo.VisitorVo;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/com")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @GetMapping("/visitors")
    public List<VisitorVo> getAllVisitor() {
        return visitorService.getAllVisitor();
    }
    @PostMapping("/visitor/add")
    public Visitor CreateVisitor(@RequestBody Visitor visitor) {
        return visitorService.CreateVisitor(visitor);
    }
    @GetMapping("/visitor/{id}")
    public Visitor getVisitorById(@PathVariable Integer id) {
        return visitorService.getVisitorById(id);
    }
    @GetMapping("/visitor/{startDate}/{EndDate}")
    public List<VisitorVo> getVisitor(@PathVariable String startDate,@PathVariable String EndDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date sDate;
        Date eDate;
        try {
            sDate = dateFormat.parse(startDate);
            eDate = dateFormat.parse(EndDate);
            System.out.println(sDate);
            System.out.println(eDate);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return visitorService.getVisitor(sDate, eDate);
    }
    @PutMapping("visitor/update/{id}")
    public Visitor updateVisitor(@PathVariable Integer id, @RequestBody Visitor visitor) {
        return visitorService.updateVisitor(id, visitor);
    }
    @GetMapping("/visitor/delete/{id}")
    public void deleteVisitorById(@PathVariable Integer id) {
        visitorService.deleteVisitorById(id);
    }
    }


