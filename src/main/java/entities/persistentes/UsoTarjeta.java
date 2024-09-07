package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa el Uso de una Tarjeta.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usos_tarjetas")
public class UsoTarjeta extends Persistente{
  @ManyToOne
  @JoinColumn(name = "vulnerable_id", referencedColumnName = "id")
  private Vulnerable vulnerable;

  @ManyToOne
  @JoinColumn(name = "barrio_id", referencedColumnName = "id")
  private Barrio barrio;

  @Column(name = "fecha", columnDefinition = "DATE")
  private LocalDate fecha;

  //Rari
  @PrePersist
  protected void onInsert() {
    if (this.fecha == null) {
      this.fecha = LocalDate.now();
    }
  }
}
