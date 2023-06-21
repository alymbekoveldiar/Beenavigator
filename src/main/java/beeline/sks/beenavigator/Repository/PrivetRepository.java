package beeline.sks.beenavigator.Repository;
import beeline.sks.beenavigator.Entity.Privet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrivetRepository extends JpaRepository<Privet, Long > {
    @Query(value = "select * from privet p  where (p.author ilike %:authorName%) or (p.title ilike %:authorName%) or (p.code ilike %:authorName%)or (p.genre ilike %:authorName%)", nativeQuery = true)
    List<Privet> getAllByName(@Param(value = "authorName") String authorName);
}
