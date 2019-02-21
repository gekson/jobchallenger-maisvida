/**
 * 
 */
package br.med.maisvida.jobchallenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.med.maisvida.jobchallenger.entity.Job;

/**
 * @author gekson
 *
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
