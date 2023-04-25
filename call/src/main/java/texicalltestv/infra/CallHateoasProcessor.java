package texicalltestv.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import texicalltestv.domain.*;

@Component
public class CallHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Call>> {

    @Override
    public EntityModel<Call> process(EntityModel<Call> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancel")
                .withRel("cancel")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/comment")
                .withRel("comment")
        );

        return model;
    }
}
