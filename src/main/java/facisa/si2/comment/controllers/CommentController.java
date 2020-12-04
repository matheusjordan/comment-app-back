package facisa.si2.comment.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import facisa.si2.comment.models.Comment;
import facisa.si2.comment.services.CommentService;

@CrossOrigin(origins = "*")
@RequestMapping("/comments")
@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	
	@GetMapping("/")
	public ResponseEntity<Iterable<Comment>> getAll() {
		return new ResponseEntity(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getById(@PathParam(value = "id") Long id) {
		return new ResponseEntity<Comment>(this.service.getComment(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Comment> post(@RequestBody Comment comment) {
		return new ResponseEntity<Comment>(this.service.createComment(comment), HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Comment> put(@RequestBody Comment comment) {
		return new ResponseEntity<Comment>(this.service.editComment(comment), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Long id) {
		System.out.println(id);
		Boolean status = false;

		try {
			this.service.deleteComment(id);
			status = true;
		} catch (Exception e) {
			status = false;
		}

		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}
	
}
