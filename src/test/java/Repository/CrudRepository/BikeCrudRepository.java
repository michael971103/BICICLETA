package Repository.CrudRepository;


import model.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeCrudRepository extends CrudRepository<Bike, Integer>{
}
