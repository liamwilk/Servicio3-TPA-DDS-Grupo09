package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un Vulnerable con su nombre, su Documento y la cantidad de menores a cargo.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vulnerables")
public class Vulnerable extends Persistente {
  @Column(name = "nombre")
  private String nombre;

  @Embedded
  private Documento documento;

  @Column(name = "cantMenoresACargo")
  private Integer menoresAcargo;
}
