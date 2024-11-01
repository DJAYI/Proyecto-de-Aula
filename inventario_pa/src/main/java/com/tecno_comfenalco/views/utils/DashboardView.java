
package com.tecno_comfenalco.views.utils;

import com.tecno_comfenalco.auth.UserAuthentication;
import com.tecno_comfenalco.views.Views;
import com.tecno_comfenalco.views.modules.CategoriaView;
import com.tecno_comfenalco.views.modules.MovimientoView;
import com.tecno_comfenalco.views.modules.ProductoView;
import com.tecno_comfenalco.views.modules.UserView;

public class DashboardView extends Views {

	String option;

	public DashboardView() {
		do {
			clearScreen();
			show();

		} while (!option.equalsIgnoreCase("5"));
	}


	@Override
	public void show() {
		System.out.println("-----------------------------");
		System.out.println("Dashboard");
		System.out.println("-----------------------------");

		System.out.println("[1. Gestion de Usuarios]");
		System.out.println("[2. Gestion de Productos]");
		System.out.println("[3. Gestion de Categorias]");
		System.out.println("[4. Gestion de Movimientos]");
		System.out.println("[5. Salir del sistema]");

		System.out.println("[6. Cerrar sesion]");
		System.out.println("Seleccione una opcion: ");


		System.out.println("-----------------------------");

		option = keyboardScanner.nextLine();


		switch (option) {
			case "1" -> {
				UserView usersView = new UserView();
				break;
			}

			case "2" -> {
				ProductoView productoView = new ProductoView();
				break;
			}

			case "3" -> {
				CategoriaView categoriaView = new CategoriaView();
				break;
			}

			case "4" -> {
				MovimientoView movimientoView = new MovimientoView();
				break;
			}

			case "5" -> {
				System.out.println("Saliendo...");
				System.exit(0);
				break;
			}

			case "6" -> {
				UserAuthentication.getInstance().logout();
				System.out.println("Sesion cerrada");

				InitialView initialView = new InitialView();
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
