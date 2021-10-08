package uber.repository;

import org.springframework.data.repository.CrudRepository;
import uber.entity.DriverComments;

public interface CommentsRepository extends CrudRepository<DriverComments, Integer> {
}
