package texicalltestv.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import texicalltestv.domain.*;

@RestController
// @RequestMapping(value="/calls")
@Transactional
public class CallController {

    @Autowired
    CallRepository callRepository;

    @RequestMapping(
        value = "calls/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Call cancel(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelCommand cancelCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /call/cancel  called #####");
        Optional<Call> optionalCall = callRepository.findById(id);

        optionalCall.orElseThrow(() -> new Exception("No Entity Found"));
        Call call = optionalCall.get();
        call.cancel(cancelCommand);

        callRepository.save(call);
        return call;
    }

    @RequestMapping(
        value = "calls/{id}/comment",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Call comment(
        @PathVariable(value = "id") Long id,
        @RequestBody CommentCommand commentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /call/comment  called #####");
        Optional<Call> optionalCall = callRepository.findById(id);

        optionalCall.orElseThrow(() -> new Exception("No Entity Found"));
        Call call = optionalCall.get();
        call.comment(commentCommand);

        callRepository.save(call);
        return call;
    }
}
