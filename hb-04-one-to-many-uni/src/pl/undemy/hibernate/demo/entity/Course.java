package pl.undemy.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(generator="s_course", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="s_course", sequenceName="s_course",allocationSize=1)
	@Column(name="id_course")
	private Long idCourse;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="id_instructor")
	private Instructor instructor;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id_course")
	private List<Review> reviews;
	
	public Course() {
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", title=" + title + ", instructor=" + instructor + ", review=" + reviews
				+ "]";
	}
	
	
	public void add(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(review);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
