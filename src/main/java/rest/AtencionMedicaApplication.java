package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * API REST launcher.
 */

@SpringBootApplication(scanBasePackages = {"repositories", "rest", "entities"})
@EnableJpaRepositories("repositories")
@EntityScan("entities.persistentes")
public class AtencionMedicaApplication {
  public static void main(String[] args) {
    SpringApplication.run(AtencionMedicaApplication.class, args);
  }
}
