
package com.tecno_comfenalco.utils.listas;

import java.util.ArrayList;
import com.tecno_comfenalco.models.Producto;

public class ListaProductos {
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private static ListaProductos instance;

	private ListaProductos() {
	}

	public static ListaProductos getInstance() {
		if (instance == null) {
			instance = new ListaProductos();
		}
		return instance;
	}

	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	@Override
	public String toString() {
		return "ListaProductos [productos=" + productos + "]";
	}


}
