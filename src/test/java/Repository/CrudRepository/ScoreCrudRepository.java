package Repository.CrudRepository;


import model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}
