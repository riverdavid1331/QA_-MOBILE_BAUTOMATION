package com.nttdata.steps;

import com.nttdata.screens.ProductsScreen;

public class ProductSteps {

    ProductsScreen productsScreen;

    public void agregarAlCarrito(int unidad, String producto){
        productsScreen.esperar(1);
        productsScreen.seleccionarProducto(producto);
        productsScreen.esperar(1);
        productsScreen.selecionarCantidad(unidad);
        productsScreen.agregarAlCarrito();
    }

    public void listaProductos(){
        productsScreen.listaProductos();
    }

    public void isProductDisplayed(){
        productsScreen.esperar(2);
        boolean valor = productsScreen.isProductDisplayed();
        if (valor) System.out.println("Se abrió la app");
    }

    public void selecionarCarrito(){
        productsScreen.selecionarCarrito();
    }
}
