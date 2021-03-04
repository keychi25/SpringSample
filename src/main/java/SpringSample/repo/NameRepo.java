package repo;

import org.springframework.data.repository.CrudRepository;
import model.Name;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NameRepo extends CrudRepository<Name, Integer> {

}