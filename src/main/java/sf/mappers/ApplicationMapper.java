package sf.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sf.dto.ApplicationGetDto;
import sf.dto.ApplicationPostDto;
import sf.entities.Application;

@Component
public class ApplicationMapper {
	
	@Autowired
	JobMapper jobMapp;
	
	@Autowired
	UserMapper userMapp;
	
	public Application toEntity(ApplicationPostDto dto) {
		
		Application app = new Application();
		return app;
		
	}
	
	
	public ApplicationGetDto fromEntity(Application entity) {
		
		ApplicationGetDto appGetDto = new ApplicationGetDto();
		
		appGetDto.setId(entity.getId());
		appGetDto.setJob(jobMapp.fromEntity(entity.getJob()));
		appGetDto.setUser(userMapp.fromEntity(entity.getUser()));
		
		return appGetDto;
		
	}
	
	public List<ApplicationGetDto> fromEntity(List<Application> entities){
		List<ApplicationGetDto> allAppDto = new ArrayList<ApplicationGetDto>();
		
		for(Application app: entities) {
			allAppDto.add(fromEntity(app));
		}
		
		return allAppDto; 
	}

}
