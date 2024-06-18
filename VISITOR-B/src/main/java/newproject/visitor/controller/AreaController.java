package newproject.visitor.controller;
import newproject.visitor.model.Area;
import newproject.visitor.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/area")

    public List<Area> getAllArea() {
        return areaService.getAllArea();
    }

    @PostMapping("/area/add")

    public Area CreateArea(@RequestBody Area area) {
        return areaService.CreateArea(area);
    }

    @GetMapping("/area/{id}")

    public Area getAreaBYId(@PathVariable Integer id) {
        return areaService.getAreaById(id);
    }

    @PutMapping("/area/update/{id}")

    public Area updateArea(@PathVariable Integer id, @RequestBody Area area) {
        return areaService.updateArea(id, area);
    }

    @GetMapping("/area/delete/{id}")

    public void deleteAreaById(@PathVariable Integer id) {
        areaService.deleteAreaById(id);
    }


}
