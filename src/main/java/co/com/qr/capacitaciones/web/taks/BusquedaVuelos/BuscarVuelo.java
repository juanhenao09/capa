package co.com.qr.capacitaciones.web.taks.BusquedaVuelos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.qr.capacitaciones.web.interations.Esperar.esperarEnSegundos;
import static co.com.qr.capacitaciones.web.userinterface.reserva.MainReserva.*;
import static co.com.qr.capacitaciones.web.utilities.datos.DatosPrueba.obtener;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarVuelo implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ORIGEN),
                esperarEnSegundos(1000),
                Enter.theValue(obtener("origen")).into(INPUT_ORIGEN),
                esperarEnSegundos(2000),
                Click.on(OPTION_ORIGEN),
                esperarEnSegundos(1000),
                Enter.theValue(obtener("destino")).into(INPUT_DESTINO),
                esperarEnSegundos(2000),
                Click.on(OPTION_DESTINO),
                Enter.theValue(obtener("fechainicial")).into(INPUT_FECHAIDA),
                Enter.theValue(obtener("fechafinal")).into(INPUT_FECHAREGRESO)
                );
    }
    public static BuscarVuelo hacerReserva(){
        return instrumented(BuscarVuelo.class);
    }
}
