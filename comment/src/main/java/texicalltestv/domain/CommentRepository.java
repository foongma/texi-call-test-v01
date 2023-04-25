package texicalltestv.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import texicalltestv.domain.*;

@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository
    extends PagingAndSortingRepository<Comment, Long> {}
