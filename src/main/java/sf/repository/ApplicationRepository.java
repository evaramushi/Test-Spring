package sf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sf.entities.Application;

public interface ApplicationRepository extends JpaRepository< Application , Integer> {

	public List<Application> findByJobId(int jobId);
	
}
