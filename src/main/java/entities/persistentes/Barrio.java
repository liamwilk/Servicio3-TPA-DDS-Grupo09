package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un Barrio, con la Ciudad y la Provincia.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "barrios")
public class Barrio extends Persistente {

  @Column(name = "nombreBarrio")
  private String nombreBarrio;

  @Column(name = "nombreCiudad")
  private String ciudad;

  @Column(name = "nombreProvincia")
  private String provincia;
}
