package repositories;

import entities.persistentes.Vulnerable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Repositorio para persistir las entidades de dominio.
 */

@Service
public class VulnerablesService {

  @Autowired
  private VulnerablesRepository vulnerablesRepository;
  
  public List<Vulnerable> buscarTodos() {
    return vulnerablesRepository.findAll();
  }

  public Vulnerable buscarPor(Long id) {
    return vulnerablesRepository.findById(id).orElse(null);
  }

  public void guardar(Vulnerable vulnerable) {
    vulnerablesRepository.save(vulnerable);
  }

  public void guardar(List<Vulnerable> vulnerables)
  {
    vulnerablesRepository.saveAll(vulnerables);
  }

  public void borrar(Vulnerable vulnerable)
  {
    vulnerablesRepository.delete(vulnerable);
  }

  public void borrar(List<Vulnerable> vulnerables){
    vulnerablesRepository.deleteAll(vulnerables);
  }

  public void modificar(Vulnerable vulnerable) {
    //El metodo save de Spring tambien se puede usar para modificar
    //Por eso llamamos al metodo guardar que hace save
    this.guardar(vulnerable);
  }
}
