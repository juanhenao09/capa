package co.com.qr.capacitaciones.web.stepdefinitions.reservar;

import co.com.qr.capacitaciones.web.utilities.datos.CargarDatos;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.qr.capacitaciones.web.taks.opensite.OpenSiteTask.openSiteCapaVivaAir;
import static co.com.qr.capacitaciones.web.taks.reservar.Llenardatosiniciales.datosIniciales;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class reservarstepdefinitions {

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario tiene toda la informacion que necesita$")
    public void queElUsuarioTieneTodaLaInformacionQueNecesita(List<Map<String, Object>> informacion)  {
        theActorCalled("Usuario").attemptsTo(CargarDatos.conLaSiguiente(informacion));
    }

    @Cuando("^realiza la reserva con los datos$")
    public void realizaLaReservaConLosDatos() throws Exception {
        theActorInTheSpotlight().attemptsTo(openSiteCapaVivaAir());
        theActorInTheSpotlight().attemptsTo(datosIniciales());
    }

    @Entonces("^el usuario deberia ver los resultados$")
    public void elUsuarioDeberiaVerLosResultados() throws Exception {

    }

}
