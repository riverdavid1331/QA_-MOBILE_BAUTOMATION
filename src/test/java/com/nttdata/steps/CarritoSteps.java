package com.nttdata.steps;

import com.nttdata.screens.CarritoScreen;


import com.nttdata.screens.ProductsScreen;
import net.serenitybdd.annotations.Steps;

public class CarritoSteps {

    CarritoScreen carritoScreen;

    public void concluirCompra(double montoEsperado){

        carritoScreen.esperar(2);
        carritoScreen.isCarritoDisplayed();
        carritoScreen.esCorrectoMontoTotal(montoEsperado);
        carritoScreen.pagarCompra();
    }

}
