package texicalltestv.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import texicalltestv.PointApplication;
import texicalltestv.domain.PointSaved;

@Entity
@Table(name = "Point_table")
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String status;

    private Long point;

    @PostPersist
    public void onPostPersist() {
        PointSaved pointSaved = new PointSaved(this);
        pointSaved.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    public static void pointSave(Paymented paymented) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointSaved pointSaved = new PointSaved(point);
        pointSaved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymented.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointSaved pointSaved = new PointSaved(point);
            pointSaved.publishAfterCommit();

         });
        */

    }

    public static void pointDeduction(Canceled canceled) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

    }
}
