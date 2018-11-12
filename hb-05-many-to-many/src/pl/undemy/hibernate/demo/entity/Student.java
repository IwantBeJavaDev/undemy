package pl.undemy.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="s_student")
	@SequenceGenerator(name="s_student", sequenceName="s_student", allocationSize=1)
	@Column(name="id_student")
	private Long idStudent;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinTable(
		name="course_student",
		joinColumns=@JoinColumn(name="id_student"),
		inverseJoinColumns=@JoinColumn(name="id_course")
		)
	private List<Course> courses;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	
	public Long getIdStudent() {
		return idStudent;
	}


	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
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


	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(course);
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
	
}
