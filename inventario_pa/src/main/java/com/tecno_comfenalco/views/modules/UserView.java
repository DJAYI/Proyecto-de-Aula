
package com.tecno_comfenalco.views.modules;

import com.tecno_comfenalco.controllers.usuario.UsuarioController;
import com.tecno_comfenalco.views.Views;

public class UserView extends Views {
	String input;

	public UserView() {

		do {
			clearScreen();
			show();
		} while (!input.equalsIgnoreCase("6"));
	}

	@Override
	public void show() {
		System.out.println("===================================");
		System.out.println("Inventario PA - Gestion de Usuarios");
		System.out.println("===================================");
		System.out.println("1. Crear Usuario");
		System.out.println("2. Editar Usuario");
		System.out.println("3. Eliminar Usuario");
		System.out.println("4. Listar Usuarios");
		System.out.println("5. Buscar Usuario");
		System.out.println("6. Salir");
		System.out.println("===================================");
		input = keyboardScanner.nextLine();

		switch (input) {

			case "1" -> {
				crearUsuario();

			}

			case "2" -> {
				editarUsuario();

			}

			case "3" -> {
				eliminarUsuario();

			}

			case "4" -> {
				listarUsuarios();

			}

			case "5" -> {
				buscarUsuario();

			}

			case "6" -> {
				System.out.println("Saliendo...");
				break;
			}

			default -> {
				System.out.println("Opcion no valida");
				System.exit(0);

			}
		}
	}


	public void crearUsuario() {

		System.out.println("===================================");
		System.out.println("Crear Usuario");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre del usuario");
		String name = keyboardScanner.nextLine();
		System.out.println("Ingrese el apellido del usuario");
		String lastname = keyboardScanner.nextLine();
		System.out.println("Ingrese el nombre de usuario");
		String username = keyboardScanner.nextLine();
		System.out.println("Ingrese el correo electronico");
		String email = keyboardScanner.nextLine();
		System.out.println("Ingrese la contraseña");
		String password = keyboardScanner.nextLine();
		System.out.println("Ingrese el rol");
		String rol = keyboardScanner.nextLine().toUpperCase();

		UsuarioController.getInstance().crearUsuario(name, lastname, username, email, password, rol);
	}

	public void editarUsuario() {

		System.out.println("===================================");
		System.out.println("Editar Usuario");
		System.out.println("===================================");
		System.out.println("¿Que desea editar?");
		System.out.println("1. Nombre");
		System.out.println("2. Apellido");
		System.out.println("3. Correo");
		System.out.println("4. Contraseña");
		System.out.println("5. Rol");

		System.out.println("6. Salir");

		String input = keyboardScanner.nextLine();

		clearScreen();
		switch (input) {
			case "1" -> {

				System.out.println("Ingrese el nombre de usuario");
				String username = keyboardScanner.nextLine();
				System.out.println("Ingrese el nuevo nombre");
				String name = keyboardScanner.nextLine();
				UsuarioController.getInstance().actualizarNombreUsuario(username, name);
				pauseScreen();

			}

			case "2" -> {

				System.out.println("Ingrese el nombre de usuario");
				String username = keyboardScanner.nextLine();
				System.out.println("Ingrese el nuevo apellido");
				String lastname = keyboardScanner.nextLine();
				UsuarioController.getInstance().actualizarApellidoUsuario(username, lastname);
				pauseScreen();

			}

			case "3" -> {

				System.out.println("Ingrese el nombre de usuario");
				String username = keyboardScanner.nextLine();
				System.out.println("Ingrese el nuevo correo");
				String email = keyboardScanner.nextLine();
				UsuarioController.getInstance().actualizarEmailUsuario(username, email);
				pauseScreen();

			}

			case "4" -> {

				System.out.println("Ingrese el nombre de usuario");
				String username = keyboardScanner.nextLine();
				System.out.println("Ingrese la nueva contraseña");
				String password = keyboardScanner.nextLine();
				UsuarioController.getInstance().actualizarPasswordUsuario(username, password);
				pauseScreen();

			}

			case "5" -> {

				System.out.println("Ingrese el nombre de usuario");
				String username = keyboardScanner.nextLine();
				System.out.println("Ingrese el nuevo rol");
				String rol = keyboardScanner.nextLine();
				UsuarioController.getInstance().actualizarRolUsuario(username, rol);


			}

			case "6" -> {
				System.out.println("Saliendo...");


			}

			default -> {
				System.out.println("Opcion no valida");
				System.exit(0);

			}
		}

	}

	public void eliminarUsuario() {
		System.out.println("===================================");
		System.out.println("Eliminar Usuario");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de usuario");
		String username = keyboardScanner.nextLine();

		UsuarioController.getInstance().eliminarUsuario(username);
		pauseScreen();
	}

	public void listarUsuarios() {
		System.out.println("===================================");
		System.out.println("Listar Usuarios");
		System.out.println("===================================");
		UsuarioController.getInstance().listarUsuarios();
		pauseScreen();
	}

	public void buscarUsuario() {
		System.out.println("===================================");
		System.out.println("Buscar Usuario");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de usuario");
		String username = keyboardScanner.nextLine();

		UsuarioController.getInstance().leerUsuario(username);
		pauseScreen();
	}
}
