package africa.ozi.files.data.repositories;

import africa.ozi.files.data.models.PrinterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PrinterUser, Long> {
}
