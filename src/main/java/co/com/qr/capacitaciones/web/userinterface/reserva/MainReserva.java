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

    public static final Target MAIN_FRAME = Target.the("frame principal").located(By.xpath("//iframe[@id='ce_proto_iframe']"));
    public static final Target TXT_ORIGEN = Target.the("campo origen").located(By.xpath("//input[contains(@id,'station')]"));
    public static final Target TXT_DESTINO = Target.the("campo destino").located(By.xpath("//input[contains(@id,'station-second')]"));
    public static final Target LBL_ORIGEN = Target.the("campo ORIGEN").locatedBy(("//span[contains(.,'{0}')]"));
    public static final Target LBL_DESTINO = Target.the("campo DESTINO").locatedBy(("//span[contains(.,'{0}')]"));

    public static final Target FECHAINICIAL = Target.the("fecha inicial").locatedBy("//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first--wed')]//div[contains(.,'{0}')]");
    public static final Target FECHAFINAL = Target.the("fecha final").locatedBy("//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first--fri')]//div[contains(.,'{0}')]");
    public static final Target FLECHA_SIGUIENTE = Target.the("Flecha siguiente calendario").locatedBy("//div[@class='chevron right big']");
    public static final Target LBL_MES_IZQUIERDA = Target.the("fecha final").locatedBy("(//div[@class='calendar__date_picker']//following::span[@class='name'])[1]");

    public static final Target BTN_BUSCAR = Target.the("buscar reserva").locatedBy("//button[contains(.,buscar)]");

    public static final Target BTN_ACEPTAR = Target.the("aceptar terminos").locatedBy("//button[contains(text(),'Aceptar y continuar')]");

    public static final Target LBL_TU_RESERVA = Target.the("label tu reserva").locatedBy("//h1[contains(.,'Tu reserva')]");
}
