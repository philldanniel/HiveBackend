package com.collab.hive.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collab.hive.dao.JobDAO;
import com.collab.hive.model.Job;
@RestController
public class JobRestController {
	@Autowired
	private Job job;
	
	@Autowired
	private JobDAO jobDAO;
	
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getJobs(){
		List <Job> jobList = jobDAO.list();
		if(jobList.isEmpty()){
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Job>>(jobList, HttpStatus.OK);
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") int id){
		job = jobDAO.get(id);
		if(job == null){
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@PostMapping("/job")
	public ResponseEntity<Job> createJob(@RequestBody Job newjob){
		jobDAO.saveOrUpdate(newjob);
		return new ResponseEntity<Job>(newjob , HttpStatus.OK);
	}
	
	@DeleteMapping("/job/{id}")
	public ResponseEntity<Job> deleteJob(@PathVariable("id") int id){
		if(jobDAO.get(id) == null){
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		jobDAO.delete(id);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}
	
	@PutMapping("/job/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable("id") int id, @RequestBody Job job){
		if(jobDAO.get(id) == null){
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		jobDAO.saveOrUpdate(job);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
}
