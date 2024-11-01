
package com.tecno_comfenalco.utils;

import java.util.ArrayList;

import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.utils.listas.ListaProductos;

public class EstadoProductos {
	public enum Estado {
		DISPONIBLE, AGOTADO, POR_AGOTARSE
	}

	ArrayList<Producto> productos;
	private static EstadoProductos instance;

	public static EstadoProductos getInstance() {
		if (instance == null) {
			instance = new EstadoProductos();
		}
		return instance;
	}

	private EstadoProductos() {
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getStock() == 0) {
				ImprimirEstado(producto, Estado.AGOTADO);

			} else if (producto.getStock() < 10) {
				ImprimirEstado(producto, Estado.POR_AGOTARSE);
			} else {
				ImprimirEstado(producto, Estado.DISPONIBLE);
			}
		}
	}

	public Estado GetEstado(Producto producto) {
		if (producto.getStock() == 0) {
			return Estado.AGOTADO;
		} else if (producto.getStock() < 10) {
			return Estado.POR_AGOTARSE;
		} else {
			return Estado.DISPONIBLE;
		}
	}

	public void ImprimirEstado(Producto producto, Estado estado) {
		System.out.println("===================================");
		System.out.println("Producto: " + producto.getName());
		System.out.println("Precio: " + producto.getPrice());
		System.out.println("Stock: " + producto.getStock());
		System.out.println("Estado: " + estado);
		System.out.println("===================================");
	}
}
