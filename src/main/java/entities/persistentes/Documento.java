package entities.persistentes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Representa un documento, con el número y el tipo.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Documento {
  @Column(name = "nroDocumento")
  private Integer nroDocumento;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipoDocumento")
  private TipoDocumento tipoDocumento;
}
