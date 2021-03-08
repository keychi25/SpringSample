package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Name;

@Repository
public interface NameRepo extends JpaRepository<Name, Long> {

}