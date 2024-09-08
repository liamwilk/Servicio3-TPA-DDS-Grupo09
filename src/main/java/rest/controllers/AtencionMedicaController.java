package rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.InformacionBarrio;
import entities.InformacionBarrioDTO;
import entities.persistentes.UsoTarjeta;
import entities.persistentes.Vulnerable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    //Se obtienen los usos
    List<UsoTarjeta> usos = usosTarjetasService.buscarTodos();

    //Se genera un Map que relaciona un barrio con la informacion deseada
    Map<String, InformacionBarrio> vulnerablesPorBarrio = this.crearMapaVulnerablesPorBarrio(usos);

    //Se convierte el Map en un string
    List<InformacionBarrioDTO> dtoList = this.generarDTO(vulnerablesPorBarrio);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(dtoList);
  }

  @GetMapping("/localidadesVulnerables/{nombreBarrio}")
  public String obtenerVulernablesPorBarrio(@PathVariable("nombreBarrio") String nombreBarrio)
          throws JsonProcessingException {
    //Se obtienen los usos en el barrio a buscar
    List<UsoTarjeta> usos = usosTarjetasService.buscarPorBarrio(nombreBarrio);

    //Se genera un Map que relaciona un barrio con la informacion deseada
    Map<String, InformacionBarrio> vulnerablesPorBarrio = this.crearMapaVulnerablesPorBarrio(usos);

    //Se convierte el Map en un string
    List<InformacionBarrioDTO> dtoList = this.generarDTO(vulnerablesPorBarrio);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(dtoList);
  }

  public Map<String, InformacionBarrio> crearMapaVulnerablesPorBarrio(List<UsoTarjeta> usos) {
    Map<String, InformacionBarrio> map = new HashMap<>();
    for (UsoTarjeta uso : usos) {
      String barrio = uso.getBarrio().getNombreBarrio();
      Vulnerable vulnerable = uso.getVulnerable();

      //Obtengo tambien los menores a cargo
      List<Vulnerable> familiaVulnerable = vulnerable.getMenoresAcargo();
      familiaVulnerable.add(vulnerable);

      //Evito repetidos
      for (Vulnerable v : familiaVulnerable) {
        if (map.containsKey(barrio) && map.get(barrio).getVulnerables().contains(v)) {
          continue;
        }
        this.agregarVulnerable(map, barrio, v);
      }
    }
    return map;
  }

  private void agregarVulnerable(Map<String, InformacionBarrio> map, String barrio, Vulnerable vulnerable) {
    InformacionBarrio informacionBarrio = map.containsKey(barrio) ? map.get(barrio) : new InformacionBarrio();
    informacionBarrio.agregarVulnerable(vulnerable);
    map.put(barrio, informacionBarrio);
  }

  private List<InformacionBarrioDTO> generarDTO(Map<String, InformacionBarrio> vulnerablesPorBarrio) {
    return vulnerablesPorBarrio.entrySet().stream()
        .map(entry -> new InformacionBarrioDTO(
            entry.getKey(),
            entry.getValue().getVulnerables().stream()
                .map(Vulnerable::getNombre)
                .toList(),
            entry.getValue().getCantidad()
        )).toList();
  }
}