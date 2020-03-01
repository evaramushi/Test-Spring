package sf.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sf.dto.JobGetDto;
import sf.dto.JobPatchDto;
import sf.dto.JobPostDto;
import sf.entities.Job;



@Component
public class JobMapper {
	
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AdminMapper adminMapp;
	
	
	
	public Job toEntity(JobPostDto dto) {
		
		Job job = new Job();
		

		job.setName(dto.getName());
		job.setDescription(dto.getDescription());
		job.setOwner(dto.getOwner());
		
		
		return job;
		
	}
	
	
	public Job toEntity(JobPatchDto dto) {
		
		Job job = new Job();
		
		job.setName(dto.getName());
		job.setDescription(dto.getDescription());
		job.setOwner(dto.getOwner());
		
		
		return job;
		
	}
	
	public JobGetDto fromEntity(Job entity) {
		JobGetDto jobGetDto = new JobGetDto();
		
		jobGetDto.setId(entity.getId());
		jobGetDto.setName(entity.getName());
		jobGetDto.setDescription(entity.getDescription());
		jobGetDto.setOwner(entity.getOwner());
		jobGetDto.setUser(userMapper.fromEntity(entity.getUser()));
		jobGetDto.setAdmin(adminMapp.fromEntity(entity.getAdmin()));
		
		
		return jobGetDto;
	}
	
	public List<JobGetDto> fromEntity(List<Job> entities){
		
		List<JobGetDto> allJobDto = new ArrayList<JobGetDto>();
		
		
		for(Job j:entities) {
			
			allJobDto.add(fromEntity(j));
		}
		
		
		return allJobDto;
		
	}
	
	public void copy(Job entity , JobPatchDto dto) {
		
		if(dto.getName()!=null) {
			entity.setName(dto.getName());
		}
		
		if(dto.getDescription()!=null) {
			entity.setDescription(dto.getDescription());
			
		}
		if(dto.getOwner() !=null) {
			entity.setOwner(dto.getOwner());
		}
	}
	
	

}
