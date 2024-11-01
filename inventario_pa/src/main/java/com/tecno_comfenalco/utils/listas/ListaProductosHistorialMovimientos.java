
package com.tecno_comfenalco.utils.listas;

import java.util.ArrayList;

import com.tecno_comfenalco.models.Movimiento;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.services.HistorialMovimientos;

public class ListaProductosHistorialMovimientos {

	ArrayList<Producto> productos = new ArrayList<Producto>();

	public ListaProductosHistorialMovimientos() {

		HistorialMovimientos historialMovimientos = HistorialMovimientos.getInstance();
		for (Movimiento movimiento : historialMovimientos.getMovimientos()) {
			Producto producto = movimiento.getProduct();
			if (!this.productos.contains(producto)) {
				this.productos.add(producto);
			}
		}
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public void mostrarProductos() {
		for (Producto producto : productos) {
			System.out.println("===================================");
			System.out.println("Producto: " + producto.getName());
			System.out.println("Precio: " + producto.getPrice());
			System.out.println("Stock: " + producto.getStock());
			System.out.println("===================================");
		}
	}

}
