package co.com.qr.capacitaciones.web.interations.comunes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwichtFrame implements Interaction {
    private static Target elementoEsperar;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try
        {
            BrowseTheWeb.as(actor).getDriver().switchTo().frame(elementoEsperar.resolveFor(actor));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static SwichtFrame cambiarFrame(Target elemento)
    {
        elementoEsperar=elemento;
        return instrumented(SwichtFrame.class);
    }
}
