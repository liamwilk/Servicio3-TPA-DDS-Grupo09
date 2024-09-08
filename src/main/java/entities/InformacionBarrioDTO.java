package entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InformacionBarrioDTO {
  private String nombreBarrio;
  private List<String> vulnerables;
  private Integer cantidad;
}
