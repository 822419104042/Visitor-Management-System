package newproject.visitor.service;
import newproject.visitor.model.Area;
import newproject.visitor.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;
    public List<Area> getAllArea()
    {
        return areaRepository.findAll();
    }
    public Area CreateArea(Area area)
    {
        return areaRepository.save(area);
    }
    public Area getAreaById(Integer area_id)
    {
        return areaRepository.findById(area_id).get();
    }
    public Area updateArea(Integer id ,Area area)
    {
        Area a1=areaRepository.findById(id).orElse(null);
        a1.setAreaName(area.getAreaName());
        return areaRepository.save(area);
    }
    public void deleteAreaById(Integer id)
    {
        areaRepository.deleteById(id);
    }
}