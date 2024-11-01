
package com.tecno_comfenalco.utils.listas;

import java.util.ArrayList;
import com.tecno_comfenalco.models.Usuario;

public class ListaUsuarios {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ListaUsuarios instance;


	private ListaUsuarios() {
	}

	public static ListaUsuarios getInstance() {
		if (instance == null) {
			instance = new ListaUsuarios();
		}
		return instance;
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public String toString() {
		return "ListaUsuarios [usuarios=" + usuarios + "]";
	}


}
