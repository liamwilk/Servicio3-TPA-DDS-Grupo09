package repositories;

import entities.persistentes.UsoTarjeta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsosTarjetasRepository extends JpaRepository<UsoTarjeta, Long> {
  @Query("SELECT u FROM UsoTarjeta u WHERE u.barrio.nombreBarrio = :nombreBarrio")
  List<UsoTarjeta> buscarPorBarrio(@Param("nombreBarrio") String nombreBarrio);
}
