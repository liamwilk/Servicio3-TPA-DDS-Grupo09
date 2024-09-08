package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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

  @ManyToMany
  @JoinTable(name = "menores_por_vulnerables",
      joinColumns = @JoinColumn(name = "vulnerable_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "menor_id", referencedColumnName = "id"))
  private List<Vulnerable> menoresAcargo;
}
