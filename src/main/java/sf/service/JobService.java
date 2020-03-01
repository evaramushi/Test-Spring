package sf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sf.dto.JobGetDto;
import sf.dto.JobPatchDto;
import sf.dto.JobPostDto;
import sf.entities.Admin;
import sf.entities.Job;
import sf.entities.User;
import sf.mappers.JobMapper;
import sf.repository.AdminRepository;
import sf.repository.JobRepository;
import sf.repository.UserRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private JobMapper jobMapp;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	/*------------------save---------------------*/
	
	public JobGetDto save (int userId,int adminId, JobPostDto dto ) {
		
		User usr = userRepo.findById(userId).orElseThrow (()-> new RuntimeException("this user is not find"+userId));
		Admin adm = adminRepo.findById(adminId).orElseThrow (()-> new RuntimeException("this user is not find"+adminId));
		
		Job entity = jobMapp.toEntity(dto);
		
		entity.setAdmin(adm);
		entity.setUser(usr);
		
		JobGetDto jobDto = jobMapp.fromEntity(jobRepo.save(entity));
		
		return jobDto;
	}
	
	/*------------------getUser---------------------*/
	
	public JobGetDto getJob(int userId, int jobId) {
		
		Job job = jobRepo.findById(userId).orElseThrow (()->new RuntimeException("canot find the job!"+jobId));
		
		if(!(job.getUser().getId() == userId)) {
			
			throw new RuntimeException("job does not belogn this user"+userId);
		}
		
		return jobMapp.fromEntity(job);
		
	}
	
	/*------------------getAll---------------------*/
	
	public List<JobGetDto> getAll() {
		return jobMapp.fromEntity(jobRepo.findAll());
	}
	
	
	
	
	
	/*------------------update---------------------*/

	public JobGetDto update (int userId, int jobId, JobPatchDto dto) {
		
		Job job = jobRepo.findById(userId).orElseThrow (()->new RuntimeException("canot find the job!"+jobId));
		
            if(!(job.getUser().getId() == userId)) {
			throw new RuntimeException("job does not belogn this user"+userId);
		}
            
            jobMapp.copy(job, dto);
		
            return jobMapp.fromEntity(jobRepo.save(job));
		
	}
	
	  /*------------------delete---------------------*/
	
	public void delete (int userId, int jobId) {
		
		Job job = jobRepo.findById(userId).orElseThrow (()->new RuntimeException("canot find the job!"+jobId));
		
        if(!(job.getUser().getId() == userId)) {
		throw new RuntimeException("job does not belogn this user"+userId);
	}
        
        jobRepo.deleteById(jobId);
        
	}
}
