package sf.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import sf.dto.UserGetDto;
import sf.dto.UserPatchDto;
import sf.dto.UserPostDto;
import sf.entities.User;

@Component
public class UserMapper {
	
	public User toEntity(UserPostDto dto) {
		
		User usr = new User();
		
	
		usr.setFirstName(dto.getFirstName());
		usr.setLastName(dto.getLastName());
		usr.setEmail(dto.getEmail());
		usr.setUsername(dto.getUsername());
		usr.setPassword(dto.getPassword());

		
		return usr;
	}
	
	
	public User toEntity (UserPatchDto dto) {
		
		User usr = new User();
		
		
		usr.setFirstName(dto.getFirstName());
		usr.setLastName(dto.getLastName());
		usr.setEmail(dto.getEmail());
		usr.setUsername(dto.getUsername());
		usr.setPassword(dto.getPassword());

		
		return usr;
	}
	
public UserPatchDto fromEntityPatch(User entity) {
		
		UserPatchDto userPatchDto = new UserPatchDto();
		
		
		userPatchDto.setId(entity.getId());
		userPatchDto.setFirstName(entity.getFirstName());
		userPatchDto.setLastName(entity.getLastName());
		userPatchDto.setEmail(entity.getEmail());
		userPatchDto.setUsername(entity.getUsername());
		userPatchDto.setPassword(entity.getPassword());


		
		return userPatchDto;

		
	}
	
	
	public UserGetDto fromEntity(User entity) {
		
		UserGetDto userGetDto = new UserGetDto();
		
		
		userGetDto.setId(entity.getId());
		userGetDto.setFirstName(entity.getFirstName());
		userGetDto.setLastName(entity.getLastName());
		userGetDto.setEmail(entity.getEmail());
		userGetDto.setUsername(entity.getUsername());
		userGetDto.setPassword(entity.getPassword());


		
		return userGetDto;

		
	}
	
	public List<UserGetDto> fromEntity(List<User> entities) {
   	 
   	 List<UserGetDto> allUserDto = new ArrayList<UserGetDto>();
   	 
   	for(User s: entities) {
   		
   		allUserDto.add(fromEntity(s));
   		
   	}
   	 
   	 return allUserDto ;
    }
	
public void copy(User entity, UserPatchDto dto) {
    	
    	if(dto.getEmail()!=null) {
    		entity.setEmail(dto.getEmail());
    	}
    	
    	if(dto.getFirstName()!=null) {
    		entity.setFirstName(dto.getFirstName());
    	}
    	
    	if(dto.getLastName()!=null)
    	{
    		entity.setLastName(dto.getLastName());
    		
    	}
    	
    	if(dto.getPassword()!=null) {
    		entity.setPassword(dto.getPassword());
    	}
    	
    	if(dto.getUsername()!=null) {
    		entity.setUsername(dto.getUsername());
    	}
    	
    	
    }
	

}
