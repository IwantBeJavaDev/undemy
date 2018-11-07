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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_instructor")
	@SequenceGenerator(name = "s_instructor", allocationSize = 1)
	@Column(name="id_instructor")
	private Long idInstructor;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_instructor_detail")
	private InstructorDetail instructorDetail;
	
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="instructor",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses;
	
	
	public Instructor() {
	}
	
	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Long idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public void add(Course course) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(course);
	}
	
	
	@Override
	public String toString() {
		return "Instructor [idInstructor=" + idInstructor + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", instructorDetail=" + instructorDetail + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
