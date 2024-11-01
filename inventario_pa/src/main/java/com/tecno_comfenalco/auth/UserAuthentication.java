
package com.tecno_comfenalco.auth;

import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.utils.listas.ListaUsuarios;

public class UserAuthentication {
	public boolean isLogged;

	// username, password, and role of an already registered user

	private static UserAuthentication instance;

	private Usuario usuario;

	private UserAuthentication(Usuario user) {
		this.usuario = user;
	}

	private UserAuthentication() {
	}


	public static UserAuthentication getInstance(Usuario user) {
		if (instance == null) {
			return new UserAuthentication(user);
		}
		return instance;
	}

	public static UserAuthentication getInstance() {
		if (instance == null) {
			return new UserAuthentication();
		}
		return instance;
	}


	public Boolean login(String usernameLogin, String passwordLogin, String roleLogin) {
		// Chequear si el usuario esta logueado
		// Se comprueba si el username, password y role inicializados en el
		// constructor son iguales a los parametros de entrada en el login

		// Si el usuario esta logueado, imprimir un mensaje de que el usuario ya esta logueado y
		// retornar true
		// Si el usuario no esta logueado, imprimir un mensaje de que el usuario no esta logueado y
		// retornar false

		for (Usuario usuarioIndex : ListaUsuarios.getInstance().getUsuarios()) {
			isLogged = usuarioIndex.getUsername().equals(usernameLogin)
					&& usuarioIndex.getPassword().equals("*".repeat(passwordLogin.length()))
					&& usuarioIndex.getRole().toString().equals(roleLogin);
		}
		return isLogged;
	}

	public void logout() {
		isLogged = false;
		usuario = null;
		System.out.println("Usuario Deslogueado");

	}

	/**
	 * Gets the currently authenticated user.
	 *
	 * @return the currently authenticated Usuario object, or null if no user is authenticated.
	 */
	/**
	 * Sets the current user.
	 *
	 * @param usuario the user to set
	 */
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
