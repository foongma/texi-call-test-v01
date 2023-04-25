package texicalltestv.domain;

import java.util.*;
import lombok.Data;
import texicalltestv.infra.AbstractEvent;

@Data
public class CommentSaved extends AbstractEvent {

    private Long id;
    private Long callId;
    private String comment;
}
