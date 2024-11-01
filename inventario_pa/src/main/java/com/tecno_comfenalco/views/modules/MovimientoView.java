
package com.tecno_comfenalco.views.modules;

import com.tecno_comfenalco.auth.UserAuthentication;
import com.tecno_comfenalco.controllers.movimiento.MovimientoController;
import com.tecno_comfenalco.views.Views;

public class MovimientoView extends Views {
	String input;

	public MovimientoView() {
		do {
			clearScreen();
			show();
		} while (!input.equalsIgnoreCase("3"));
	}

	@Override
	public void show() {
		System.out.println("===================================");
		System.out.println("Inventario PA - Gestion de Movimientos");
		System.out.println("===================================");
		System.out.println("1. Crear Movimiento");
		System.out.println("2. Listar Movimientos del historial");
		System.out.println("3. Salir");
		System.out.println("===================================");

		this.input = keyboardScanner.nextLine();

		clearScreen();
		switch (input) {
			case "1" -> {
				System.out.println("Ingrese el id del producto");
				String id = keyboardScanner.nextLine();

				System.out.println("Ingrese la cantidad");
				int cantidad = Integer.parseInt(keyboardScanner.nextLine());


				System.out.println("Ingrese el tipo de movimiento (1. Entrada, 2. Salida)");
				String tipoMovimiento = keyboardScanner.nextLine();

				switch (tipoMovimiento) {
					case "1" -> {
						MovimientoController.getInstance().crearMovimientoEntrada(id, cantidad,
								UserAuthentication.getInstance().getUsuario());
						break;
					}
					case "2" -> {
						MovimientoController.getInstance().crearMovimientoSalida(id, cantidad,
								UserAuthentication.getInstance().getUsuario());
						break;
					}
					default -> {
						System.out.println("Opcion no valida");
						break;
					}
				}

				break;
			}
			case "2" -> {
				MovimientoController.getInstance().listarMovimientos();
				pauseScreen();
				break;
			}
			case "3" -> {
				break;
			}
			default -> {
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

}
