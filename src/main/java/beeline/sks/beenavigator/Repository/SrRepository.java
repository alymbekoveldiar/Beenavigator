package beeline.sks.beenavigator.Repository;

import beeline.sks.beenavigator.Entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SrRepository extends JpaRepository<ServiceRequest, Long> {
    @Query(value = "select * from service_request  where upper(name) like upper( :param )", nativeQuery = true)
    List<ServiceRequest> getAllByName(@Param(value = "param") String param);
        
}
