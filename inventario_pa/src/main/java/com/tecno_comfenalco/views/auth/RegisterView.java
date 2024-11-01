
package com.tecno_comfenalco.views.auth;

import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Usuario.Role;
import com.tecno_comfenalco.views.Views;

public class RegisterView extends Views {

	private String name;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String role;


	public RegisterView() {
		show();
	}

	@Override
	public void show() {
		clearScreen();
		System.out.println("===================================");
		System.out.println("Inventario PA - Registro de Usuario");
		System.out.println("===================================");
		System.out.println("Ingrese su nombre: ");
		this.name = keyboardScanner.nextLine();

		System.out.println("Ingrese su apellido: ");
		this.lastname = keyboardScanner.nextLine();

		System.out.println("Ingrese su nombre de usuario: ");
		this.username = keyboardScanner.nextLine();

		System.out.println("Ingrese su correo electrónico: ");
		this.email = keyboardScanner.nextLine();

		System.out.println("Ingrese su contraseña: ");
		this.password = keyboardScanner.nextLine();

		System.out.println("Ingrese su rol: ");
		this.role = keyboardScanner.nextLine().toUpperCase();

		System.out.println("===================================");

		if (this.role.equals(Role.ADMINISTRADOR.toString())
				|| this.role.equals(Role.ASISTENTE.toString())) {
			new Usuario(this.name, this.lastname, this.username, this.email, this.password,
					Role.valueOf(this.role));
			System.out.println("Usuario " + this.username + " registrado exitosamente");
			pauseScreen();

		} else {
			System.out.println("Datos incorrectos, por favor intente de nuevo");
		}
	}
}
