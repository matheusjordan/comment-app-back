package facisa.si2.comment.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String text;
	
	@Column
	private Date createdAt;
	
	@Column
	private String author;
	
	protected Comment() {
		this.createdAt = new Date();
	}
	
	public Comment(Long id, String text) {
		this.text = text;
		this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
