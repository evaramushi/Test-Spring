package sf.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import sf.dto.AdminGetDto;
import sf.dto.AdminPatchDto;
import sf.dto.AdminPostDto;
import sf.entities.Admin;

@Component
public class AdminMapper {
	
	public Admin toEntity(AdminPostDto dto) {
		
		Admin adm = new Admin();
		
		adm.setUsername(dto.getUsername());
		adm.setPassword(dto.getPassword());
		
		return adm;
	}
	
	public Admin toEntity (AdminPatchDto dto) {
		
		Admin adm = new Admin();
		
		adm.setUsername(dto.getUsername());
		adm.setPassword(dto.getPassword());
		
		return adm;
	}
	
	
	public AdminGetDto fromEntity(Admin entity) {
		
		AdminGetDto adminGetDto = new AdminGetDto();
		
		adminGetDto.setId(entity.getId());
		adminGetDto.setUsername(entity.getUsername());
		adminGetDto.setPassword(entity.getPassword());
		
		
		return adminGetDto;
		
		
	}
	
	public List<AdminGetDto> fromEntity(List<Admin> entities){
		
		List<AdminGetDto>  allAdminDto = new ArrayList<AdminGetDto>();
		for(Admin a: entities) {
			allAdminDto.add(fromEntity(a));
		}
		
		
		return allAdminDto;
		
	}
	
	public void copy(Admin entity, AdminPatchDto dto) {
		
		if(dto.getUsername()!=null) {
			entity.setUsername(dto.getUsername());
		}
		
		if(dto.getPassword()!=null) {
			entity.setPassword(dto.getPassword());
		}
		
	}
	
	
	

}
