package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase abstracta que representa a las entidades persistentes.
 */

@MappedSuperclass
@Getter
@Setter
public abstract class Persistente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(name = "activo")
  private Boolean activo;

  @Column(name = "fechaAlta", columnDefinition = "DATE")
  private LocalDate fechaAlta;

  public Persistente() {
    this.fechaAlta = LocalDate.now();
    this.activo = true;
  }
}
