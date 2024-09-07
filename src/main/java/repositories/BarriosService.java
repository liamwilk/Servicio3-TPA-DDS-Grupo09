package repositories;

import entities.persistentes.Barrio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarriosService {
  @Autowired
  private BarriosRepository barriosRepository;

  public List<Barrio> buscarTodos() {
    return barriosRepository.findAll();
  }

  public void guardar(Barrio barrio) {
    barriosRepository.save(barrio);
  }
}
