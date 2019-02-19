package br.med.maisvida.jobchallenger.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer weight;
	private Boolean completed;
	private Date createdAt;
	private Long jobId;
	
	public Task() {
		super();
	}
}
