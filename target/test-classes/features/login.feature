
@login
Feature: Prueba de compras en My Demo App

  @compras
  Scenario Outline: Compra de productos

    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente <MONTOESPERADO>

    Examples:
      | PRODUCTO                  | UNIDADES | MONTOESPERADO |
      | Sauce Labs Backpack       | 2        |   59.98       |
      | Sauce Labs Bolt - T-Shirt | 3        |   47.97       |
      | Sauce Labs Bike Light     | 5        |   49.95       |
