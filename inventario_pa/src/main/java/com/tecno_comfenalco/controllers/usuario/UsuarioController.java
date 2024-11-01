
package com.tecno_comfenalco.controllers.usuario;

import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Usuario.Role;
import com.tecno_comfenalco.utils.listas.ListaUsuarios;

public class UsuarioController {
	private static UsuarioController instance;

	private UsuarioController() {
	}

	public static UsuarioController getInstance() {
		if (instance == null) {
			instance = new UsuarioController();
		}
		return instance;
	}

	// Crear metodos para poder crear, leer, actualizar y eliminar usuarios

	// 1. Crear usuario
	public void crearUsuario(String name, String lastname, String username, String email,
			String password, String rol) {
		// Logica para crear usuario

		// 1.1 Validar que los campos no sean nulos
		if (name == null || username == null || email == null || password == null || rol == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()
				|| rol.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 1.2 Validar que el usuario no exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				System.out.println("El usuario ya existe");
				return;
			}
		}

		// 1.3 Crear usuario
		new Usuario(name, lastname, username, email, password, Role.valueOf(rol));
		System.out.println("Usuario " + username + " registrado exitosamente");
	}

	// 2. Leer usuario
	public void leerUsuario(String username) {
		// Logica para leer usuario
		// 2.1 Validar que el nombre no sea nulo
		if (username == null) {
			System.out.println("El nombre de usuario no puede ser nulo");
			return;
		}

		if (username.isEmpty()) {
			System.out.println("El nombre de usuario no puede ser nulo");
			return;
		}

		// 2.2 Buscar usuario
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				System.out.println("Usuario encontrado: " + usuario.toString());
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	// 3. Actualizar usuario
	public void actualizarUsuario(String username, String name, String lastname, String email,
			String password, String rol) {
		// Logica para actualizar usuario
		// 3.1 Validar que los campos no sean nulos
		if (name == null || username == null || email == null || password == null || rol == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()
				|| rol.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setName(name);
				usuario.setLastname(lastname);
				usuario.setEmail(email);
				usuario.setPassword(password);
				usuario.setRole(Role.valueOf(rol));
				System.out.println("Usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarNombreUsuario(String username, String name) {
		// Logica para actualizar nombre de usuario
		// 3.1 Validar que los campos no sean nulos
		if (name == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (name.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setName(name);
				System.out.println("Nombre de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarApellidoUsuario(String username, String lastname) {
		// Logica para actualizar apellido de usuario
		// 3.1 Validar que los campos no sean nulos
		if (lastname == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (lastname.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setLastname(lastname);
				System.out.println("Apellido de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarEmailUsuario(String username, String email) {
		// Logica para actualizar email de usuario
		// 3.1 Validar que los campos no sean nulos
		if (email == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (email.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setEmail(email);
				System.out.println("Email de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarPasswordUsuario(String username, String password) {
		// Logica para actualizar password de usuario
		// 3.1 Validar que los campos no sean nulos
		if (password == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (password.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setPassword(password);
				System.out.println("Password de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarRolUsuario(String username, String rol) {
		// Logica para actualizar rol de usuario
		// 3.1 Validar que los campos no sean nulos
		if (rol == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (rol.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setRole(Role.valueOf(rol));
				System.out.println("Rol de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	public void actualizarNombre(String username, String name) {
		// Logica para actualizar nombre de usuario
		// 3.1 Validar que los campos no sean nulos
		if (name == null || username == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (name.isEmpty() || username.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				usuario.setName(name);
				System.out.println("Nombre de usuario actualizado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	// 4. Eliminar usuario
	public void eliminarUsuario(String username) {
		// Logica para eliminar usuario
		// 4.1 Validar que el nombre no sea nulo
		if (username == null) {
			System.out.println("El nombre de usuario no puede ser nulo");
			return;
		}

		if (username.isEmpty()) {
			System.out.println("El nombre de usuario no puede ser nulo");
			return;
		}

		// 4.2 Validar que el usuario exista
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			if (usuario.getUsername().equals(username)) {
				ListaUsuarios.getInstance().getUsuarios().remove(usuario);
				System.out.println("Usuario eliminado exitosamente");
				return;
			}
		}

		System.out.println("Usuario no encontrado");
	}

	// 5. Listar usuarios
	public void listarUsuarios() {
		// Logica para listar usuarios
		for (Usuario usuario : ListaUsuarios.getInstance().getUsuarios()) {
			System.out.println(usuario.toString());
		}
	}
}
