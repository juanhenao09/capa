package co.com.qr.capacitaciones.web.taks.reservar;

import co.com.qr.capacitaciones.web.interations.comunes.Esperar;
import co.com.qr.capacitaciones.web.utilities.datos.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;

import static co.com.qr.capacitaciones.web.userinterface.reserva.MainReserva.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static co.com.qr.capacitaciones.web.interations.comunes.SwichtFrame.cambiarFrame;

public class Llenardatosiniciales implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            /*Ingreso de Origen y destino*/
            Click.on(TXT_ORIGEN),
            Type.theValue(DatosPrueba.obtener("origen")).into(TXT_ORIGEN),
            Click.on(LBL_ORIGEN.of(DatosPrueba.obtener("origen"))),
            Click.on(TXT_DESTINO),
            Type.theValue(DatosPrueba.obtener("destino")).into(TXT_DESTINO),
            Click.on(LBL_ORIGEN.of(DatosPrueba.obtener("destino"))));

    actor.attemptsTo(
            /*Ingreso de fechas en el calendario*/
           Click.on(FECHAINICIAL.of(DatosPrueba.obtener("fecha_inicial"))),
            Click.on(FECHAFINAL.of(DatosPrueba.obtener("fecha_final"))));

    actor.attemptsTo(
            /*Dar click en el boton buscar*/
            Click.on(BTN_BUSCAR)
    );

    }

    public static Llenardatosiniciales datosIniciales()
    {
        return instrumented(Llenardatosiniciales.class);
    }
}
