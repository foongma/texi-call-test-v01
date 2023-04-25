package texicalltestv.domain;

import java.util.*;
import lombok.*;
import texicalltestv.domain.*;
import texicalltestv.infra.AbstractEvent;

@Data
@ToString
public class CommentSaved extends AbstractEvent {

    private Long id;
    private Long callId;
    private String comment;

    public CommentSaved(Comment aggregate) {
        super(aggregate);
    }

    public CommentSaved() {
        super();
    }
}
