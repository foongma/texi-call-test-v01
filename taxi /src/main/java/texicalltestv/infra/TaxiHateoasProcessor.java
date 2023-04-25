package texicalltestv.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import texicalltestv.domain.*;

@Component
public class TaxiHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Taxi>> {

    @Override
    public EntityModel<Taxi> process(EntityModel<Taxi> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/departure")
                .withRel("departure")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/boarding")
                .withRel("boarding")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/arrival")
                .withRel("arrival")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/payment")
                .withRel("payment")
        );

        return model;
    }
}
