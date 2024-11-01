
package com.tecno_comfenalco.views.utils;

import com.tecno_comfenalco.views.Views;
import com.tecno_comfenalco.views.auth.LoginView;
import com.tecno_comfenalco.views.auth.RegisterView;

public class InitialView extends Views {
	String input;

	public InitialView() {

		do {
			clearScreen();
			show();

		} while (input != "3");
	}

	@Override
	public void show() {
		System.out.println("===================================");
		System.out.println("Inventario PA - Menu Principal");
		System.out.println("===================================");
		System.out.println("1. Iniciar Sesion");
		System.out.println("2. Registrar usuario");
		System.out.println("3. Salir");
		System.out.println("===================================");

		input = keyboardScanner.nextLine();
		switch (input) {
			case "1" -> {
				LoginView loginView = new LoginView();
				break;
			}

			case "2" -> {
				RegisterView registerView = new RegisterView();
				break;
			}

			case "3" -> {
				System.out.println("Saliendo...");
				System.exit(0);
				break;
			}

			default -> {
				System.out.println("Opcion no valida");
				System.exit(0);
				break;
			}
		}
	}
}
