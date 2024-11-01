
package com.tecno_comfenalco.models;

import com.tecno_comfenalco.utils.listas.ListaCategorias;

public class CategoriaProducto {
	private String name;
	private String description;

	public CategoriaProducto(String name, String description) {
		this.name = name;
		this.description = description;

		ListaCategorias.getInstance().añadirCategoria(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoriaProducto [name=" + name + ", description=" + description + "]";
	}

}
