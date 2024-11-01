
package com.tecno_comfenalco.models;

import com.tecno_comfenalco.utils.listas.ListaUsuarios;

// Role enum for Usuario class

public class Usuario {
	public enum Role {
		ADMINISTRADOR, ASISTENTE
	}

	private int id;
	private String name;
	private String lastname;
	private String username;
	private String email;
	private String password;

	private Role role;

	public Usuario(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.id = ListaUsuarios.getInstance().getUsuarios().size() != 0
				? ListaUsuarios.getInstance().getUsuarios().size() + 1
				: 1;

		ListaUsuarios.getInstance().addUsuario(this);
	}

	public Usuario(String name, String lastname, String username, String email, String password,
			Role role) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.id = ListaUsuarios.getInstance().getUsuarios().size() != 0
				? ListaUsuarios.getInstance().getUsuarios().size() + 1
				: 1;

		ListaUsuarios.getInstance().addUsuario(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return "*".repeat(this.password.length());
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		System.out.println("-----------------------------");
		System.out.println("Usuario " + "'" + this.username + "'");
		System.out.println("-----------------------------");

		System.out.println("ID: " + this.id);
		System.out.println("Usuario: " + this.username);
		System.out.println("Nombre: " + this.name);
		System.out.println("Apellido: " + this.lastname);
		System.out.println("Email: " + this.email);
		System.out.println("Rol: " + this.role);

		return "";
	}

}
