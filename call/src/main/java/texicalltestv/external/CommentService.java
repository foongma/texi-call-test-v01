package texicalltestv.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment", url = "${api.url.comment}")
public interface CommentService {
    @RequestMapping(method = RequestMethod.POST, path = "/comments")
    public void commentSave(@RequestBody Comment comment);
}
