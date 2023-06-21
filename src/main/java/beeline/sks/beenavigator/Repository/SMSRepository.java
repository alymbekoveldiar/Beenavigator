package beeline.sks.beenavigator.Repository;

import beeline.sks.beenavigator.Entity.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<SMS, Long> {
}
