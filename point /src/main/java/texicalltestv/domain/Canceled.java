package texicalltestv.domain;

import java.util.*;
import lombok.*;
import texicalltestv.domain.*;
import texicalltestv.infra.AbstractEvent;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String userId;
    private String userlocation;
    private String destination;
    private String payType;
    private String driverComment;
}
