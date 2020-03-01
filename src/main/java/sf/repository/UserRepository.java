package sf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sf.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


}
