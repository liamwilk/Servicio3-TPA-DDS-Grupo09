package repositories;

import entities.persistentes.UsoTarjeta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsosTarjetasService {
  @Autowired
  private UsosTarjetasRepository usosTarjetasRepository;

  public List<UsoTarjeta> buscarTodos() {
    return usosTarjetasRepository.findAll();
  }

  public List<UsoTarjeta> buscarPorBarrio(String barrio) {
    return usosTarjetasRepository.buscarPorBarrio(barrio);
  }

  public void guardar(UsoTarjeta usoTarjeta) {
    usosTarjetasRepository.save(usoTarjeta);
  }
}
