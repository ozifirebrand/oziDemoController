package africa.ozi.files.data.repositories;

import africa.ozi.files.data.models.Ozi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OziRepository extends MongoRepository<Ozi, String> {
}
