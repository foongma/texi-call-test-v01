package texicalltestv.domain;

import java.util.*;
import lombok.*;
import texicalltestv.domain.*;
import texicalltestv.infra.AbstractEvent;

@Data
@ToString
public class Arrivaled extends AbstractEvent {

    private Long id;
    private String number;
    private String model;
    private String driverName;
    private String driverMobileNumber;
    private Long callId;
    private String status;
    private String userId;
    private Long payment;

    public Arrivaled(Taxi aggregate) {
        super(aggregate);
    }

    public Arrivaled() {
        super();
    }
}
