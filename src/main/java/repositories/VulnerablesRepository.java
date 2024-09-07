package repositories;

import entities.persistentes.Vulnerable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define un repositorio con persistencia simple.
 */

@Repository
public interface VulnerablesRepository extends JpaRepository<Vulnerable, Long> {

}
