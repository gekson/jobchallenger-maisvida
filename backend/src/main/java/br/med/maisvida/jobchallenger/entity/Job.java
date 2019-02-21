package br.med.maisvida.jobchallenger.entity;

/**
 * @author gekson
 * 
 */
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Job {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String name;
	private Boolean active;
	
	@ManyToOne(optional=true)
    @JoinColumn(name="parent_id", nullable = true)
	private Job parentJob;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "jobId")
	private List<Task> tasks;
	
	public Job() {
		super();
	}
	
	public Job(Long id, String name, Boolean active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}
}
