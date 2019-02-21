/**
 * 
 */
package br.med.maisvida.jobchallenger.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.med.maisvida.jobchallenger.entity.Job;

/**
 * @author gekson
 *
 */
public interface JobService {

	public List<Job> findAllJobs();
	public Job findJob(@PathVariable long id);
	public void deleteJob(@PathVariable long id);
	public ResponseEntity<Object> createJob(@RequestBody Job Job);
	public ResponseEntity<Object> updateJob(@RequestBody Job Job, @PathVariable long id);
}
