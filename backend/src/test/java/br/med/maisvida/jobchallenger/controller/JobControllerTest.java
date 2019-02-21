package br.med.maisvida.jobchallenger.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.med.maisvida.jobchallenger.entity.Job;
import br.med.maisvida.jobchallenger.service.JobService;

@RunWith(SpringRunner.class)
@WebMvcTest(JobController.class)
public class JobControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private JobService service;
    
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAllJobs() throws Exception {
		Job job1 = new Job(1l, "job", true);
		 
	    List<Job> allEmployees = Arrays.asList(job1);
	 
	    when(service.findAllJobs()).thenReturn(allEmployees);
	 
	    mvc.perform(get("/Jobs")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is(job1.getName())));
	}

	@Test
	public void testFindJob() throws Exception {
		Job job1 = new Job(1l, "job", true);
		 
	    when(service.findJob(1l)).thenReturn(job1);
	 
	    mvc.perform(get("/Jobs/1")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.name", is(job1.getName())));
	}

	@Test
	@Ignore
	public void testDeleteJob() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateJob() throws IOException, Exception {
		Job job1 = new Job(1l, "job", true);
		
		when(service.createJob(job1)).thenReturn(null);
		 
        mvc.perform(post("/Jobs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(job1))
        )
                .andExpect(status().isOk());
	}

	@Test
	@Ignore
	public void testUpdateJob() {
		fail("Not yet implemented");
	}

	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
