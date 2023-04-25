package texicalltestv.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import texicalltestv.CallApplication;
import texicalltestv.domain.Called;

@Entity
@Table(name = "Call_table")
@Data
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userlocation;

    private String destination;

    private String payType;

    private String driverComment;

    @PostPersist
    public void onPostPersist() {
        Called called = new Called(this);
        called.publishAfterCommit();
    }

    public static CallRepository repository() {
        CallRepository callRepository = CallApplication.applicationContext.getBean(
            CallRepository.class
        );
        return callRepository;
    }

    public void cancel(CancelCommand cancelCommand) {
        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public void comment(CommentCommand commentCommand) {
        Commented commented = new Commented(this);
        commented.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        texicalltestv.external.Comment comment = new texicalltestv.external.Comment();
        // mappings goes here
        CallApplication.applicationContext
            .getBean(texicalltestv.external.CommentService.class)
            .commentSave(comment);
    }
}
