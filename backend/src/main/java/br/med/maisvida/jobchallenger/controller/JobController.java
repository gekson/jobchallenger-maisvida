package br.med.maisvida.jobchallenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.med.maisvida.jobchallenger.entity.Job;
import br.med.maisvida.jobchallenger.service.JobService;

/**
 * @author gekson
 *
 */
@RestController
public class JobController {

	@Autowired
	private JobService jobService;
	
	@GetMapping("/Jobs")
	public List<Job> findAllJobs() {
		return jobService.findAllJobs();
	}

	@GetMapping("/Jobs/{id}")
	public Job findJob(@PathVariable long id) {
		return jobService.findJob(id);
	}

	@DeleteMapping("/Jobs/{id}")
	public void deleteJob(@PathVariable long id) {
		jobService.deleteJob(id);
	}

	@PostMapping("/Jobs")
	public ResponseEntity<Object> createJob(@RequestBody Job job) {
		return jobService.createJob(job);
	}
	
	@PutMapping("/Jobs/{id}")
	public ResponseEntity<Object> updateJob(@RequestBody Job job, @PathVariable long id) {
		return jobService.updateJob(job, id);
	}
}
