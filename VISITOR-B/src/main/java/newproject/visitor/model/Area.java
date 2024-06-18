package newproject.visitor.model;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Table(name="area")
@ApiModel(description = "This table holds the details of area")
@Entity
@Getter
@Setter
public class Area
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column (name="area_id")
    private int id;
    @Column (name="area_name")
    private String areaName;
}
