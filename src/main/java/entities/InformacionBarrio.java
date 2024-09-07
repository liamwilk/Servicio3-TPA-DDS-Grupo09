package entities;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * Informacion de Vulnerables por Barrio.
 */

@Getter
public class InformacionBarrio {
  private List<String> vulnerables;
  private Integer cantidad;

  public InformacionBarrio() {
    this.vulnerables = new ArrayList<>();
    this.cantidad = 0;
  }

  public void agregarVulnerable(String vulnerable) {
    this.vulnerables.add(vulnerable);
    this.cantidad++;
  }
}
