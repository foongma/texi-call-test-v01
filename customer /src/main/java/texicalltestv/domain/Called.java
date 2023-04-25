package texicalltestv.domain;

import java.util.*;
import lombok.Data;
import texicalltestv.infra.AbstractEvent;

@Data
public class Called extends AbstractEvent {

    private Long id;
    private String userId;
    private String userlocation;
    private String destination;
    private String payType;
    private String driverComment;
}
