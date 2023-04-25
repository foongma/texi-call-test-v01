package texicalltestv.domain;

import java.util.*;
import lombok.*;
import texicalltestv.domain.*;
import texicalltestv.infra.AbstractEvent;

@Data
@ToString
public class PointSaved extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private Long point;

    public PointSaved(Point aggregate) {
        super(aggregate);
    }

    public PointSaved() {
        super();
    }
}
