package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Database loader.
 */

@Configuration
public class DatabaseLoader {
  private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

  @Bean
  CommandLineRunner init() {
    return args -> {
      log.info("Loading data...");
    };
  }



}
