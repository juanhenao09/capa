package co.com.qr.capacitaciones.web.stepdefinitions.reservar;

import co.com.qr.capacitaciones.web.utilities.datos.CargarDatos;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.EnsureFieldVisible;

import java.util.List;
import java.util.Map;

import static co.com.qr.capacitaciones.web.taks.opensite.OpenSiteTask.openSiteCapaVivaAir;
import static co.com.qr.capacitaciones.web.taks.reservar.LlenarDatosFechaEspecifica.datosFechaEspecificaTask;
import static co.com.qr.capacitaciones.web.taks.reservar.Llenardatosiniciales.datosIniciales;
import static co.com.qr.capacitaciones.web.userinterface.reserva.MainReserva.*;
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

    @Cuando("^realiza la reserva con los datos para los meses de junio y julio de 2022$")
    public void realizaLaReservaConLosDatosParaLosMesesDeJunioYDulioDe2022() throws Exception {
        theActorInTheSpotlight().attemptsTo(openSiteCapaVivaAir());
        theActorInTheSpotlight().attemptsTo(datosFechaEspecificaTask());

    }
    @Entonces("^el usuario deberia ver los resultados$")
    public void elUsuarioDeberiaVerLosResultados() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LBL_TU_RESERVA).isEnabled()
        );
    }

    @Entonces("^el usuario deberia ver los vuelos para la fecha especificada$")
    public void elUsuarioDeberiaVerLosVuelosParaLaFechaEspecificada() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LBL_FECHA_IDA).textContent().contains("junio"),
                Ensure.that(LBL_FECHA_REGRESO).textContent().contains("julio")
                );
    }
}
