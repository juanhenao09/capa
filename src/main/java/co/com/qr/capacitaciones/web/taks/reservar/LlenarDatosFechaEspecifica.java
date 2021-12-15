package co.com.qr.capacitaciones.web.taks.reservar;

import co.com.qr.capacitaciones.web.interations.comunes.Esperar;
import co.com.qr.capacitaciones.web.utilities.datos.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import org.openqa.selenium.support.ui.Wait;


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

        /*Dar click en el boton buscar*/
        actor.attemptsTo(
            Click.on(BTN_BUSCAR)
    );
        /*Seleccionar vuelo de ida*/
        actor.attemptsTo(
                WaitUntil.the(BTN_PRIMER_VUELO, isCurrentlyEnabled()).forNoMoreThan(3).seconds(),
                Click.on(BTN_PRIMER_VUELO),
                WaitUntil.the(BTN_CONTINUAR, isCurrentlyEnabled()).forNoMoreThan(3).seconds(),
                Esperar.esperarSegundos(2000),
                Click.on(BTN_CONTINUAR)
                );

        /*Seleccionar vuelo de regreso*/
        actor.attemptsTo(
                WaitUntil.the(BTN_PRIMER_VUELO, isCurrentlyEnabled()).forNoMoreThan(3).seconds(),
                Click.on(BTN_PRIMER_VUELO),
                WaitUntil.the(BTN_CONTINUAR, isCurrentlyEnabled()).forNoMoreThan(3).seconds(),
                Esperar.esperarSegundos(2000),
                Click.on(BTN_CONTINUAR)
        );
        /*Ingresar informacion del pasajero*/
        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBRE, isCurrentlyEnabled()).forNoMoreThan(4).seconds(),
                Scroll.to(TXT_NOMBRE),
                Enter.theValue("Juan").into(TXT_NOMBRE),
                Enter.theValue("Ramírez").into(TXT_APELLIDO),
                Enter.theValue("correoprueba@gmail.com").into(TXT_CORREO),
                Enter.theValue("3004445566").into(TXT_TELEFONO),
                Enter.theValue("34789664").into(TXT_CEDULA),
                Click.on(BTN_CONTINUAR_PASAJERO)
                );

        /*Dar clic en el botón pagar*/
        actor.attemptsTo(
                WaitUntil.the(BTN_PAGAR, isCurrentlyEnabled()).forNoMoreThan(4).seconds(),
                Click.on(BTN_PAGAR),
                Esperar.esperarSegundos(3000)
        );

    }

    public static LlenarDatosFechaEspecifica datosFechaEspecificaTask()
    {
        return instrumented(LlenarDatosFechaEspecifica.class);
    }
}
