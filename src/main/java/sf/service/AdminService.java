package sf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sf.dto.JobGetDto;
import sf.mappers.AdminMapper;
import sf.mappers.JobMapper;
import sf.repository.AdminRepository;
import sf.repository.JobRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapp;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private JobMapper jobMapp;
	
	@Autowired
	private JobRepository jobRepo;
	
	
	/*------------------getAllJobs---------------------*/
	
	public List<JobGetDto> getAllJobs(){
		
		
		return jobMapp.fromEntity(jobRepo.findAll());
		
	}
	
	/*------------------delete Jobs---------------------*/
	
	public void delete(int jobId) {
		jobRepo.deleteById(jobId);
	}

}
