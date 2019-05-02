package mx.com.axity.persistence;

import mx.com.axity.model.MovieDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieBotDAO extends CrudRepository<MovieDO, Long> {
    List<MovieDO> findAll();
}
