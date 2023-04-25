package texicalltestv.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import texicalltestv.config.kafka.KafkaProcessor;
import texicalltestv.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paymented'"
    )
    public void wheneverPaymented_PointSave(@Payload Paymented paymented) {
        Paymented event = paymented;
        System.out.println(
            "\n\n##### listener PointSave : " + paymented + "\n\n"
        );

        // Sample Logic //
        Point.pointSave(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceled'"
    )
    public void wheneverCanceled_PointDeduction(@Payload Canceled canceled) {
        Canceled event = canceled;
        System.out.println(
            "\n\n##### listener PointDeduction : " + canceled + "\n\n"
        );

        // Sample Logic //
        Point.pointDeduction(event);
    }
}
