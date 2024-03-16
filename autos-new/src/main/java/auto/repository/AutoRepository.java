package auto.repository;

import auto.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AutoRepository extends JpaRepository<Auto,Long> {

  @Query(nativeQuery = true, value = "select * from autos where vin like :vin || '%'")
    List<Auto> findByVin( String vin);



}
