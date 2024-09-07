package repositories;

import entities.persistentes.Barrio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarriosRepository extends JpaRepository<Barrio, Long> {

}
