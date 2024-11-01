
package com.tecno_comfenalco.views.auth;

import com.tecno_comfenalco.auth.UserAuthentication;
import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.utils.listas.ListaUsuarios;
import com.tecno_comfenalco.views.Views;
import com.tecno_comfenalco.views.utils.DashboardView;

public class LoginView extends Views {

	private String username;
	private String password;
	private String role;


	public LoginView() {
		do {
			show();

		} while ((UserAuthentication.getInstance().isLogged == false)
				&& (ListaUsuarios.getInstance().getUsuarios().size() > 0));

	}

	@Override
	public void show() {
		clearScreen();
		System.out.println("-----------------------------");
		System.out.println("Inventario PA - Login");
		System.out.println("-----------------------------");
		System.out.println("Ingrese su usuario: ");
		username = keyboardScanner.nextLine();

		System.out.println("Ingrese su contraseña: ");
		password = "*".repeat(keyboardScanner.nextLine().length());

		System.out.println("Ingrese su rol: ");
		role = keyboardScanner.nextLine().toUpperCase();

		System.out.println("-----------------------------");


		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {

			// Validacion de la vista de Login
			// Si el usuario, contraseña y rol son iguales a los del usuario registrado

			if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)
					&& usuario.getRole().toString().equals(role)) {

				// Llamar al metodo login de la clase UserAuthentication para autenticar al usuario
				// en el sistema, haciendo uso de los parametros de entrada

				// Si el usuario esta logueado, mostrar el DashboardView
				if (UserAuthentication.getInstance().login(username, password, role)) {
					UserAuthentication.getInstance(usuario);
					DashboardView dashboardView = new DashboardView();
				} else {
					// Si el usuario no esta logueado, imprimir un mensaje de que el usuario no esta logueado
					System.out.println("Usuario: " + username + " No autenticado");
				}

			} else {
				// Si el usuario no esta logueado, imprimir un mensaje de que el usuario no esta logueado
				System.out.println("Usuario: " + username + " No Registrado");

			}
		}
	}
}
