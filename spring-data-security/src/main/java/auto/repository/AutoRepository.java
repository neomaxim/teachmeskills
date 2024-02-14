package auto.repository;

import auto.dto.AutoDto;
import auto.dto.AutoVinDto;
import auto.dto.HasVin;
import auto.model.Auto;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;


public interface AutoRepository extends JpaRepository<Auto,Long> {
    @Query("select auto from Auto auto") // обращение к базе данных по формированию запроса по сортировке
    List<Auto> findContent(Pageable page);



  @Query(nativeQuery = true, value = "select * from autos where vin like :vin || '%'")
    List<Auto> findByVin( String vin);                    // запрос в базу по поиску нужного нам vin

    List<Auto> findAutosByVin(String vin);

    List<Auto>findAutosByIdGreaterThan(long id);   // выводит списак тех id которые выше указанного

    List<Auto>findAutosByVinLikeOrBrandLike(String vin,String Brand);
    @Modifying
    void deleteAutosByBrand(String Brand);


    @EntityGraph(value = "Auto.role")
  //  Optional<Auto> findByLogin(String login);
  List<Auto> findAutosByBrand(String brand);

/*    @Query("""
select  new auto.dto.AutoVinDto(auto.id,auto.vin) from Auto auto
where auto.id= :id
""")
    List<AutoVinDto>findAutosBy(Long id);*/


   @Query("""
select  auto.id as id,auto.vin as AutoVin from Auto auto  
where auto.id= :id
""")
  List<Auto>findAutosProjectionBy(Long id);   // запрос к базе с получением только нужных данных к нашей базе с помощтю проекции
}
