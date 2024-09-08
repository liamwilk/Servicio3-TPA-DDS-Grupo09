package domain;

import entities.persistentes.Barrio;
import entities.persistentes.Documento;
import entities.persistentes.TipoDocumento;
import entities.persistentes.UsoTarjeta;
import entities.persistentes.Vulnerable;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repositories.BarriosService;
import repositories.UsosTarjetasService;
import repositories.VulnerablesService;
import rest.AtencionMedicaApplication;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AtencionMedicaApplication.class)
public class ApiTest {

  @Autowired
  private BarriosService barriosService;

  @Autowired
  private UsosTarjetasService usosTarjetasService;

  @Autowired
  private VulnerablesService vulnerablesService;

  @BeforeEach
  public void setUp() {
    Documento documento1 = new Documento(5462484, TipoDocumento.DNI);
    Documento documento2 = new Documento(154862, TipoDocumento.LC);
    Documento documento3 = new Documento(459782, TipoDocumento.LE);
    Documento documento4 = new Documento(260611, TipoDocumento.LC);
    Documento documento5 = new Documento(3356924, TipoDocumento.DNI);

    Vulnerable santi = new Vulnerable("Santiago", documento2, null);
    Vulnerable liam = new Vulnerable("Liam", documento3, null);
    Vulnerable augusto = new Vulnerable("Augusto", documento5, null);
    Vulnerable iniaki = new Vulnerable("Iniaki", documento4, List.of(augusto));
    Vulnerable mati = new Vulnerable("Matias", documento1, List.of(augusto));

    Barrio almagro = new Barrio("Almagro", "CABA", "Buenos Aires");
    Barrio caballito = new Barrio("Caballito", "CABA", "Buenos Aires");
    Barrio adrogue = new Barrio("Adrogué", "Almirante Brown", "Buenos Aires");
    Barrio chacarita = new Barrio("Chacarita", "CABA", "Buenos Aires");

    UsoTarjeta usoTarjetaMati = new UsoTarjeta(mati, adrogue, LocalDate.of(2013, 6, 15));
    UsoTarjeta otraVezMati = new UsoTarjeta(mati, almagro, LocalDate.of(2024, 2, 15));
    UsoTarjeta usoLiam27 = new UsoTarjeta(liam, caballito, LocalDate.of(2023, 4, 22));
    UsoTarjeta usoTarjetaSanti = new UsoTarjeta(santi, chacarita, LocalDate.of(2024, 7, 23));
    UsoTarjeta usoTarjetaIniaki = new UsoTarjeta(iniaki, almagro, LocalDate.of(2024, 1, 9));
    UsoTarjeta usoTarjetaLiam = new UsoTarjeta(liam, chacarita, LocalDate.of(2024, 3, 15));

    vulnerablesService.guardar(augusto); //El chiquito primero :)
    vulnerablesService.guardar(mati);
    vulnerablesService.guardar(santi);
    vulnerablesService.guardar(liam);
    vulnerablesService.guardar(iniaki);

    barriosService.guardar(almagro);
    barriosService.guardar(caballito);
    barriosService.guardar(adrogue);
    barriosService.guardar(chacarita);

    usosTarjetasService.guardar(usoTarjetaMati);
    usosTarjetasService.guardar(otraVezMati);
    usosTarjetasService.guardar(usoLiam27);
    usosTarjetasService.guardar(usoTarjetaSanti);
    usosTarjetasService.guardar(usoTarjetaIniaki);
    usosTarjetasService.guardar(usoTarjetaLiam);
  }

  @Test
  public void testSomeFunctionality() {
    assertNotNull(barriosService);
    assertNotNull(usosTarjetasService);
    assertNotNull(vulnerablesService);
  }
}