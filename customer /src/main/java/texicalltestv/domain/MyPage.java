package texicalltestv.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long callId;
    private String userLocation;
    private String destination;
    private String status;
    private String taxiNumber;
    private String taxiModel;
    private String driverName;
    private String driverMobileNumber;
    private Long point;
    private String comment;
    private String userId;
}
