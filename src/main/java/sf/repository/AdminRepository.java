package sf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sf.entities.Admin;

public interface AdminRepository extends JpaRepository <Admin, Integer> {

}
