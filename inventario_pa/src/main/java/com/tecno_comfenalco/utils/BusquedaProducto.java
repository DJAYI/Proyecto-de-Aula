
package com.tecno_comfenalco.utils;

import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.utils.listas.ListaProductos;

public class BusquedaProducto {
	ListaProductos listaProductos;
	Producto productoEncontrado;

	public BusquedaProducto(ListaProductos listaProductos, String id) {
		this.listaProductos = listaProductos;

		for (Producto producto : listaProductos.getProductos()) {
			if (producto.getId().equalsIgnoreCase(id)) {
				productoEncontrado = producto;
				break;
			}
		}
	}

	public Producto getProductoEncontrado() {
		return productoEncontrado;
	}
}
