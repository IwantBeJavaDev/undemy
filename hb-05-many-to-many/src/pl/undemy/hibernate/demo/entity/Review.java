package pl.undemy.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(generator="s_review", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="s_review", allocationSize=1)
	@Column(name="id_review")
	private Long idReview;
	
	@Column(name="comment")
	private String comment;
	
	
	public Review(String comment) {
		super();
		this.comment = comment;
	}

	public Review() {
	}

	public Long getIdReview() {
		return idReview;
	}

	public void setIdReview(Long idReview) {
		this.idReview = idReview;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
