package co.com.qr.capacitaciones.web.taks.opensite;


import co.com.qr.capacitaciones.web.userinterface.reserva.MainReserva;
import co.com.qr.capacitaciones.web.utilities.properties.PropertiesProject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenSiteTask implements Task {

    MainReserva usuario = new MainReserva();

    public static OpenSiteTask openSiteCapaVivaAir()
    {
        return (OpenSiteTask) instrumented(OpenSiteTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String strUrl = "";
        try {
            strUrl = PropertiesProject.getUrlCapaWeb();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!strUrl.isEmpty() && !strUrl.equals("")) {
            //Metodo Open Absoluto
            usuario.openUrl(strUrl);
        }
    }
}
