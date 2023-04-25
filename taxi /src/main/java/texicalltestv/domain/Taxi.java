package texicalltestv.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import texicalltestv.TaxiApplication;

@Entity
@Table(name = "Taxi_table")
@Data
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    private String model;

    private String driverName;

    private String driverMobileNumber;

    private Long callId;

    private String status;

    private String userId;

    private Long payment;

    @PostPersist
    public void onPostPersist() {}

    public static TaxiRepository repository() {
        TaxiRepository taxiRepository = TaxiApplication.applicationContext.getBean(
            TaxiRepository.class
        );
        return taxiRepository;
    }

    public void accept(AcceptCommand acceptCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void departure(DepartureCommand departureCommand) {
        Departured departured = new Departured(this);
        departured.publishAfterCommit();
    }

    public void boarding(BoardingCommand boardingCommand) {
        Boardinged boardinged = new Boardinged(this);
        boardinged.publishAfterCommit();
    }

    public void arrival(ArrivalCommand arrivalCommand) {
        Arrivaled arrivaled = new Arrivaled(this);
        arrivaled.publishAfterCommit();
    }

    public void payment(PaymentCommand paymentCommand) {
        Paymented paymented = new Paymented(this);
        paymented.publishAfterCommit();
    }

    public static void duplicateCall(Called called) {
        /** Example 1:  new item 
        Taxi taxi = new Taxi();
        repository().save(taxi);

        */

        /** Example 2:  finding and process
        
        repository().findById(called.get???()).ifPresent(taxi->{
            
            taxi // do something
            repository().save(taxi);


         });
        */

    }
}
