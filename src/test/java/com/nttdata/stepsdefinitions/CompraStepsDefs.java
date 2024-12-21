package com.nttdata.stepsdefinitions;


import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import com.nttdata.screens.CarritoScreen;
import com.nttdata.screens.ProductsScreen;

public class CompraStepsDefs {

    @Steps
    ProductSteps productSteps;
    @Steps
    CarritoSteps carritoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        productSteps.isProductDisplayed();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        productSteps.listaProductos();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidad, String producto) {
        productSteps.agregarAlCarrito(unidad, producto);
        productSteps.selecionarCarrito();
    }

    @Then("valido el carrito de compra actualice correctamente {double}")
    public void validoElCarritoDeCompraActualiceCorrectamente(double montoEsperado) {
        carritoSteps.concluirCompra(montoEsperado);
    }
}

//public class LoginStepsDefs {

//    @Steps
//    LoginSteps loginSteps;
//
//    @Given("que estoy en la aplicación de Swag Labs")
//    public void que_estoy_en_la_aplicación_de_swag_labs() {
//
//    }
//    @When("ingreso mis credenciales username {string} y password {string}")
//    public void ingreso_mis_credenciales_username_y_password(String user, String password) {
//        loginSteps.login(user, password);
//   }
//    @Then("el inicio de sesión es exitoso")
//    public void el_inicio_de_sesión_es_exitoso() {
//        loginSteps.loginSuccess();
//    }
//
//   @Then("se muestra el mensaje de error {string}")
//    public void seMuestraElMensajeDeError(String message) {
//       loginSteps.validateErrorMessage(message);
//   }
//}
