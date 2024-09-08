package entities;

import entities.persistentes.Vulnerable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * Informacion de Vulnerables por Barrio.
 */

@Getter
public class InformacionBarrio {
  private List<Vulnerable> vulnerables;
  private Integer cantidad;

  public InformacionBarrio() {
    this.vulnerables = new ArrayList<>();
    this.cantidad = 0;
  }

  public void agregarVulnerable(Vulnerable vulnerable) {
    this.vulnerables.add(vulnerable);
    this.cantidad++;
  }
}
