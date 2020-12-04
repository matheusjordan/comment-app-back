package facisa.si2.comment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facisa.si2.comment.models.Comment;
import facisa.si2.comment.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;

	public Iterable<Comment> getAll() {
		return this.repository.findAll();
	}

	public Comment getComment(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Comment createComment(Comment comment) {
		return this.repository.save(comment);
	}
	
	public Comment editComment(Comment comment) {
		return this.repository.save(comment);
	}
	
	public void deleteComment(Long id) {
		this.repository.deleteById(id);
	}
}
