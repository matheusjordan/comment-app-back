package facisa.si2.comment.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import facisa.si2.comment.models.Comment;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>{

}
