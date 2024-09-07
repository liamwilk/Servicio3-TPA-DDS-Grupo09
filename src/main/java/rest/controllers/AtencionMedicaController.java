package rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.InformacionBarrio;
import entities.persistentes.UsoTarjeta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.UsosTarjetasService;

@RestController
@RequestMapping("/api/atencion-medica")
public class AtencionMedicaController {

  @Autowired
  private UsosTarjetasService usosTarjetasService;

  @GetMapping("/localidadesVulnerables")
  public String obtenerVulnerablesPorBarrio() throws JsonProcessingException {
    List<UsoTarjeta> usos = usosTarjetasService.buscarTodos();
    Map<String, InformacionBarrio> vulnerablesPorBarrio = this.crearMapaVulnerablesPorBarrio(usos);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(vulnerablesPorBarrio);
  }

  @GetMapping("/localidadesVulnerables/{nombreBarrio}")
  public String obtenerVulernablesPorBarrio(@PathVariable("nombreBarrio") String nombreBarrio)
          throws JsonProcessingException {
    List<UsoTarjeta> usos = usosTarjetasService.buscarPorBarrio(nombreBarrio);
    Map<String, InformacionBarrio> vulnerablesPorBarrio = this.crearMapaVulnerablesPorBarrio(usos);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(vulnerablesPorBarrio);
  }

  public Map<String, InformacionBarrio> crearMapaVulnerablesPorBarrio(List<UsoTarjeta> usos) {
    Map<String, InformacionBarrio> map = new HashMap<>();
    for (UsoTarjeta uso : usos) {
      String barrio = uso.getBarrio().getNombreBarrio();
      String vulnerable = uso.getVulnerable().getNombre();
      if (map.containsKey(barrio) && map.get(barrio).getVulnerables().contains(vulnerable)) {
        continue;
      }
      this.agregarVulnerable(map, barrio, vulnerable);
    }
    return map;
  }

  private void agregarVulnerable(Map<String, InformacionBarrio> map, String barrio, String vulnerable) {
    InformacionBarrio informacionBarrio = map.containsKey(barrio) ? map.get(barrio) : new InformacionBarrio();
    informacionBarrio.agregarVulnerable(vulnerable);
    map.put(barrio, informacionBarrio);
  }
}