package co.com.qr.capacitaciones.web.taks.reservar;

import co.com.qr.capacitaciones.web.interations.comunes.Esperar;
import co.com.qr.capacitaciones.web.utilities.datos.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.qr.capacitaciones.web.userinterface.reserva.MainReserva.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarDatosFechaEspecifica implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Esperar.esperarSegundos(5000)
        );

        actor.attemptsTo(
        Check.whether(BTN_ACEPTAR.resolveFor(actor).isCurrentlyEnabled()).andIfSo(
                Click.on(BTN_ACEPTAR))
        );

         actor.attemptsTo(
            /*Ingreso de Origen y destino*/
            Click.on(TXT_ORIGEN),
            Type.theValue(DatosPrueba.obtener("origen")).into(TXT_ORIGEN),
            Click.on(LBL_ORIGEN.of(DatosPrueba.obtener("origen"))),
            Click.on(TXT_DESTINO),
            Type.theValue(DatosPrueba.obtener("destino")).into(TXT_DESTINO),
            Click.on(LBL_ORIGEN.of(DatosPrueba.obtener("destino")))
         );

         while(!LBL_MES_IZQUIERDA.resolveFor(actor).containsText("Junio")){
             actor.attemptsTo(
                     Click.on(FLECHA_SIGUIENTE)
             );
         }

         /*Ingreso de fechas en el calendario*/
        actor.attemptsTo(
                Esperar.esperarSegundos(2000),
                Click.on(FECHAINICIAL.of(DatosPrueba.obtener("fecha_inicial"))),
                Click.on(FECHAFINAL.of(DatosPrueba.obtener("fecha_final")))
        );

        actor.attemptsTo(
            /*Dar click en el boton buscar*/
            Click.on(BTN_BUSCAR)
    );

    }

    public static LlenarDatosFechaEspecifica datosFechaEspecificaTask()
    {
        return instrumented(LlenarDatosFechaEspecifica.class);
    }
}
