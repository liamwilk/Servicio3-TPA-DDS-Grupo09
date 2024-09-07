package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"repositories", "rest", "entities"})
@EnableJpaRepositories("repositories")
@EntityScan("entities.persistentes")
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
