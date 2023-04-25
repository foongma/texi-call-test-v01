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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointSaved'"
    )
    public void wheneverPointSaved_UserNotification(
        @Payload PointSaved pointSaved
    ) {
        PointSaved event = pointSaved;
        System.out.println(
            "\n\n##### listener UserNotification : " + pointSaved + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_UserNotification(@Payload Accepted accepted) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UserNotification : " + accepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Departured'"
    )
    public void wheneverDepartured_UserNotification(
        @Payload Departured departured
    ) {
        Departured event = departured;
        System.out.println(
            "\n\n##### listener UserNotification : " + departured + "\n\n"
        );
        // Sample Logic //

    }
}
