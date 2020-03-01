package sf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sf.dto.ApplicationGetDto;
import sf.dto.ApplicationPostDto;
import sf.dto.JobGetDto;
import sf.dto.JobPatchDto;
import sf.dto.JobPostDto;
import sf.dto.UserGetDto;
import sf.dto.UserPatchDto;
import sf.dto.UserPostDto;
import sf.entities.Admin;
import sf.entities.Application;
import sf.entities.Job;
import sf.entities.User;
import sf.mappers.ApplicationMapper;
import sf.mappers.JobMapper;
import sf.mappers.UserMapper;
import sf.repository.AdminRepository;
import sf.repository.ApplicationRepository;
import sf.repository.JobRepository;
import sf.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserMapper userMapp;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private JobMapper jobMapp;
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private ApplicationMapper appMapp;
	
	@Autowired
	private ApplicationRepository appRepo;
	
	
	public UserGetDto save(UserPostDto userPostDto) {
		
		User entity = userMapp.toEntity(userPostDto);
		
		UserGetDto dto = userMapp.fromEntity(userRepo.save(entity));
		
		
		return dto;
		
	}
	
	public UserGetDto getUser(int userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("canot find the user!"+userId));
		
		return userMapp.fromEntity(user);
	}
	
	
	
	
	
	/*---------------GET All Users------------*/
	public List<UserGetDto> getAll() {
		
		return userMapp.fromEntity(userRepo.findAll());
	}
	
	
	/*---------------GET Users Patch Id------------*/
	
	
public UserPatchDto getUserPatch(int userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("canot find the user!"+userId));
		
		return userMapp.fromEntityPatch(user);
	}
	
	
/*---------------UPDATE Users------------*/	
	
	public UserGetDto update(int userId,UserPatchDto dto) {
		
		User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("canot find the user with that ID: "+userId));
		
		userMapp.copy(user, dto);
		
		return userMapp.fromEntity(userRepo.save(user));
		
	}
	
	public void deleteUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("canot find the user with this ID: "+userId));
		
		userRepo.deleteById(userId);
	}
	
	
	/*--------------------getJobs By UserId--------------*/
	
	public List<JobGetDto> getAllJobsToUser(int userId){
		return jobMapp.fromEntity(jobRepo.findByUserId(userId));
	}
	
	
	/*--------------------save Jobs--------------*/
public JobGetDto saveJob (int userId,int adminId, JobPostDto dto ) {
		
		User usr = userRepo.findById(userId).orElseThrow (()-> new RuntimeException("this user is not find"+userId));
		Admin adm = adminRepo.findById(adminId).orElseThrow (()-> new RuntimeException("this user is not find"+adminId));
		
		Job entity = jobMapp.toEntity(dto);
		
		entity.setAdmin(adm);
		entity.setUser(usr);
		
		JobGetDto jobDto = jobMapp.fromEntity(jobRepo.save(entity));
		
		return jobDto;
	}

   public void deleteJob (int userId, int jobId) {
	   
	   Job job = jobRepo.findById(jobId).orElseThrow (()->new RuntimeException("canot find the job! "+jobId));
		
       if(!(job.getUser().getId() == userId)) {
		throw new RuntimeException("job does not belogn to this user: "+userId+" * you can delete just jobs created by your user!!!");
	}
	   
    jobRepo.deleteById(jobId);
    
    }
   
   public JobGetDto update (int userId, int jobId, JobPatchDto dto) {
		
//		Job jobs = jobRepo.findById(userId).orElseThrow (()->new RuntimeException("canot find the job with userId !"+userId));
	   Job job = jobRepo.findById(jobId).orElseThrow (()->new RuntimeException("canot find the job! "+jobId));
		
           if(!(job.getUser().getId() == userId)) {
			throw new RuntimeException("job does not belogn to this user: "+userId+" * you can update just jobs created by your user!!!");
		}
         
          
        
          jobMapp.copy(job, dto);
		
           return jobMapp.fromEntity(jobRepo.save(job));
		
	}
   
   /*--------------------getAll Jobs--------------*/
   
   public List<JobGetDto> getJobs() {
		return jobMapp.fromEntity(jobRepo.findAll());
	}
   
   /*--------------------create Application--------------*/
   
   public ApplicationGetDto saveApp (int jobId, int userId, ApplicationPostDto dto) {
	   
	   Job job = jobRepo.findById(jobId).orElseThrow (()-> new RuntimeException("this jobId is not find : "+jobId));
	   User usr = userRepo.findById(userId).orElseThrow (()-> new RuntimeException("this userId is not find : "+userId));
	  
	   Application entity = appMapp.toEntity(dto);
	   
	   entity.setJob(job);
	   entity.setUser(usr);
	   
	   ApplicationGetDto appDto = appMapp.fromEntity(appRepo.save(entity));
	   
	return appDto;
   }
   
   /*--------------------getAll Application--------------*/
   
   public List<ApplicationGetDto> getAllApp(){
	   return appMapp.fromEntity(appRepo.findAll());
   }
   
   /*--------------------get Application--------------*/
   
   public List<ApplicationGetDto> findByJobId(int jobId){
	   return appMapp.fromEntity(appRepo.findByJobId(jobId));
   }

}
