
package com.tecno_comfenalco.utils.listas;

import java.util.ArrayList;

import com.tecno_comfenalco.models.CategoriaProducto;

public class ListaCategorias {
	private ArrayList<CategoriaProducto> categorias = new ArrayList<CategoriaProducto>();

	private static ListaCategorias instance;

	private ListaCategorias() {
	}

	public static ListaCategorias getInstance() {
		if (instance == null) {
			instance = new ListaCategorias();
		}
		return instance;
	}

	private void MostrarCategorias() {
		for (CategoriaProducto categoria : categorias) {
			System.out.println("===================================");
			System.out.println("Categoria: " + categoria.getName());
			System.out.println("Descripcion: " + categoria.getDescription());
			System.out.println("===================================");
		}
	}

	public void añadirCategoria(CategoriaProducto categoria) {
		categorias.add(categoria);
	}

	public void eliminarCategoria(CategoriaProducto categoria) {
		categorias.remove(categoria);
	}


	public ArrayList<CategoriaProducto> getCategorias() {
		return categorias;
	}


	@Override
	public String toString() {
		MostrarCategorias();
		return "";
	}


}
