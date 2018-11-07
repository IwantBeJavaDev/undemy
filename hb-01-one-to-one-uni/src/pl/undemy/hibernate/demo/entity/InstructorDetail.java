package pl.undemy.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@Column(name="id_instructor_detail")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="s_instructor_detail")
	@SequenceGenerator(name="s_instructor_detail", allocationSize=1 )
	private Long idInstructorDetail;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;

	
	public InstructorDetail() {
	
	}
	
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public Long getIdInstructorDetail() {
		return idInstructorDetail;
	}

	public void setIdInstructorDetail(Long idInstructorDetail) {
		this.idInstructorDetail = idInstructorDetail;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return "InstructorDetail [idInstructorDetail=" + idInstructorDetail + ", youtubeChannel=" + youtubeChannel
				+ ", hobby=" + hobby + "]";
	}
	
	
}
