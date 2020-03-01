package sf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sf.dto.JobGetDto;
import sf.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	public List<Job> findByUserId(int userId);
	
}
