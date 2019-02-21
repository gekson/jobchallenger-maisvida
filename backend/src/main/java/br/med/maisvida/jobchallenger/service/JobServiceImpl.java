/**
 * 
 */
package br.med.maisvida.jobchallenger.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.med.maisvida.jobchallenger.entity.Job;
import br.med.maisvida.jobchallenger.exception.JobNotFoundException;
import br.med.maisvida.jobchallenger.repository.JobRepository;

/**
 * @author gekson
 *
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	@GetMapping("/Jobs/{id}")
	public Job findJob(@PathVariable long id) {
		Optional<Job> Job = jobRepository.findById(id);

		if (!Job.isPresent())
			throw new JobNotFoundException("id-" + id);

		return Job.get();
	}

	@DeleteMapping("/Jobs/{id}")
	public void deleteJob(@PathVariable long id) {
		jobRepository.deleteById(id);
	}

	@PostMapping("/Jobs")
	public ResponseEntity<Object> createJob(@RequestBody Job Job) {
		Job savedJob = jobRepository.save(Job);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedJob.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/Jobs/{id}")
	public ResponseEntity<Object> updateJob(@RequestBody Job Job, @PathVariable long id) {
		Optional<Job> JobOptional = jobRepository.findById(id);

		if (!JobOptional.isPresent())
			return ResponseEntity.notFound().build();

		Job.setId(id);

		jobRepository.save(Job);

		return ResponseEntity.noContent().build();
	}
}
