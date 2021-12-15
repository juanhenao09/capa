package co.com.qr.capacitaciones.web.userinterface.reserva;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;

@NamedUrls({
        @NamedUrl(name = "open.viva", url = "http://{1}"),
})

public class MainReserva extends PageObject {

    public static final Target BTN_ACEPTAR = Target.the("aceptar terminos").locatedBy("//button[contains(text(),'Aceptar y continuar')]");

    public static final Target MAIN_FRAME = Target.the("frame principal").located(By.xpath("//iframe[@id='ce_proto_iframe']"));
    public static final Target TXT_ORIGEN = Target.the("campo origen").located(By.xpath("//input[contains(@id,'station')]"));
    public static final Target TXT_DESTINO = Target.the("campo destino").located(By.xpath("//input[contains(@id,'station-second')]"));
    public static final Target LBL_ORIGEN = Target.the("campo ORIGEN").locatedBy(("//span[contains(.,'{0}')]"));
    public static final Target LBL_DESTINO = Target.the("campo DESTINO").locatedBy(("//span[contains(.,'{0}')]"));

    public static final Target FECHAINICIAL = Target.the("fecha inicial").locatedBy("(//div[contains(@class,'month')]//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first--')]//div[contains(.,'{0}')])[1]");
    public static final Target FECHAFINAL = Target.the("fecha final").locatedBy("(//div[contains(@class,'month')]//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first--')]//div[contains(.,'{0}')])[2]");
    public static final Target FLECHA_SIGUIENTE = Target.the("Flecha siguiente calendario").locatedBy("//div[@class='chevron right big']");
    public static final Target LBL_MES_IZQUIERDA = Target.the("fecha final").locatedBy("(//div[@class='calendar__date_picker']//following::span[@class='name'])[1]");

    public static final Target BTN_BUSCAR = Target.the("buscar reserva").locatedBy("//button[contains(.,buscar)]");

    public static final Target BTN_PRIMER_VUELO = Target.the("Seleccionar primer vuelo").locatedBy("(//div[contains(@class,'flight__lowest-fare d-flex align-items-center justify-content-around')])[1]");
    public static final Target BTN_CONTINUAR = Target.the("Botón continuar").located(By.id("booking-continue-btn"));

    public static final Target TXT_NOMBRE = Target.the("Input nombre pasajero").located(By.id("nombre1ADT"));
    public static final Target TXT_APELLIDO = Target.the("Input apellido pasajero").located(By.id("apellido1ADT"));
    public static final Target TXT_CORREO = Target.the("Input correo pasajero").located(By.id("correo-electronico1ADT"));
    public static final Target TXT_TELEFONO = Target.the("Input telefono pasajero").located(By.id("telefono"));
    public static final Target TXT_CEDULA = Target.the("Input cedula pasajero").located(By.id("identificacion1ADT"));
    public static final Target BTN_CONTINUAR_PASAJERO = Target.the("Botón continuar frame pasajero").locatedBy("(//div[contains(text(),'Continuar')]//following::img[@class='button-icon'])[1]");

    public static final Target BTN_PAGAR = Target.the("Botón pagar").locatedBy("//button[@id='booking-continue-btn']");


    public static final Target LBL_FECHA_IDA = Target.the("label fecha de ida").locatedBy("//h1[contains(text(),'Vuelo de ida')]//following::p[1]");
    public static final Target LBL_FECHA_REGRESO = Target.the("label fecha de regreso").locatedBy("//h1[contains(text(),'Vuelo de regreso')]//following::p[1]");

    public static final Target LBL_TU_RESERVA = Target.the("label tu reserva").locatedBy("//h1[contains(.,'Tu reserva')]");
}
