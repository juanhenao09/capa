package co.com.qr.capacitaciones.web.utilities.datos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarDatos implements Task {
  private static final Logger LOGGER = LogManager.getLogger(co.com.qr.capacitaciones.web.utilities.datos.CargarDatos.class.getName());
  private List<Map<String, Object>> datosPrueba;

  public CargarDatos(List<Map<String, Object>> datosPrueba) {
    this.datosPrueba = datosPrueba;
  }

  @Override
  @Step("{0} Cargo los datos de la prueba para la automatización #datosPrueba")
  public <T extends Actor> void performAs(T actor) {
    if (!datosPrueba.isEmpty()) {
      Set<Map.Entry<String, Object>> setMapaAux = datosPrueba.get(0).entrySet();
      Map<String, Object> mapAuxiliar =
          setMapaAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
      if (DatosPrueba.getMap() == null) {
        DatosPrueba.setMap(mapAuxiliar);
      } else {
        DatosPrueba.getMap().putAll(mapAuxiliar);
      }
    } else {
      actor.remember("", new HashMap<>());
      LOGGER.info("La lista se encuentra vacia");
    }
  }
  public static CargarDatos conLaSiguiente(
          List<Map<String, Object>> informacion) {
    return instrumented(CargarDatos.class, informacion);
  }
}
