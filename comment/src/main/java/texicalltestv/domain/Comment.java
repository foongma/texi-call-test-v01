package texicalltestv.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import texicalltestv.CommentApplication;
import texicalltestv.domain.CommentSaved;

@Entity
@Table(name = "Comment_table")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long callId;

    private String comment;

    @PostPersist
    public void onPostPersist() {
        CommentSaved commentSaved = new CommentSaved(this);
        commentSaved.publishAfterCommit();
    }

    public static CommentRepository repository() {
        CommentRepository commentRepository = CommentApplication.applicationContext.getBean(
            CommentRepository.class
        );
        return commentRepository;
    }
}
