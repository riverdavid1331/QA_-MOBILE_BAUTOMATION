package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
//librerias de cucumber
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //pretty para este caso
        plugin = {"pretty"},
        features = "src/test/resources/features", //carpetas de los festures con Path From content route
        glue = "com.nttdata.stepsdefinitions", //carpetas de los festures con Copy reference
        tags = "compras"
)
public class CucumberTestSuite {
}
