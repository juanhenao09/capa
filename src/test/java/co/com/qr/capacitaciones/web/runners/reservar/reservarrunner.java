package co.com.qr.capacitaciones.web.runners.reservar;

import co.com.qr.capacitaciones.web.utilities.exceldata.BeforeRunner;
import co.com.qr.capacitaciones.web.utilities.exceldata.DatosFeature;
import co.com.qr.capacitaciones.web.utilities.runner.RunnerCapaWeb;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import java.io.IOException;

@CucumberOptions(
    features ="src/test/resources/co.com.qr.capacitaciones.web/features/reservar/reserva_exitosa.feature",
    snippets = SnippetType.CAMELCASE,
    glue = {"co.com.qr.capacitaciones.web.stepdefinitions.reservar"},
    plugin = {"json:target/cucumber_json/cucumber.json"})
@RunWith(RunnerCapaWeb.class)
public class reservarrunner {
    @BeforeRunner
    public static void test() throws InvalidFormatException, IOException {
    DatosFeature.overrideFeatureFiles(
        "./src/test/resources/co.com.qr.capacitaciones.web/features/reservar");
    }
}
