
package com.tecno_comfenalco.controllers.movimiento;

import java.util.Date;
import com.tecno_comfenalco.models.Movimiento;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.models.Usuario;
import com.tecno_comfenalco.models.Movimiento.TipoMovimiento;
import com.tecno_comfenalco.services.HistorialMovimientos;
import com.tecno_comfenalco.utils.listas.ListaProductos;

public class MovimientoController {
	private static MovimientoController instance;

	private MovimientoController() {
	}

	public static MovimientoController getInstance() {
		if (instance == null) {
			return new MovimientoController();
		}
		return instance;
	}

	// Crear metodos para crear movimientos y listarlos desde el historial de movimientos

	// 1. Crear un movimiento
	public void crearMovimientoEntrada(String id, int cantidad, Usuario usuario) {
		// Crear un movimiento de entrada

		// 1.1. Validar que el producto exista
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId().equalsIgnoreCase(id) && cantidad > 0) {
				// El producto existe y la cantidad es mayor a 0

				// 1.2. Crear un movimiento de entrada
				new Movimiento(producto, cantidad, new Date(), TipoMovimiento.ENTRADA, usuario,
						"Entrada de producto");

				System.out.println("Movimiento de entrada creado");
			} else {
				System.out.println("Producto no encontrado");
			}
		}
	}

	// 2. Crear un movimiento de salida
	public void crearMovimientoSalida(String id, int cantidad, Usuario usuario) {
		// Crear un movimiento de salida

		// 2.1. Validar que el producto exista
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId().equalsIgnoreCase(id) && cantidad > 0) {
				// El producto existe y la cantidad es mayor a 0

				// 2.2. Crear un movimiento de salida
				new Movimiento(producto, cantidad, new Date(), TipoMovimiento.SALIDA, usuario,
						"Salida de producto");

				System.out.println("Movimiento de salida creado");
			} else {
				System.out.println("Producto no encontrado");
			}
		}
	}

	// 3. Listar movimientos
	public void listarMovimientos() {
		// Listar los movimientos del historial
		// 3.1. Recorrer el historial de movimientos
		for (Movimiento movimiento : HistorialMovimientos.getInstance().getMovimientos()) {
			// 3.2. Imprimir los movimientos
			System.out.println("==========================");
			System.out.println("Historial de Movimientos");
			System.out.println("==========================");
			System.out.println("Producto: " + movimiento.getProduct().getName());
			System.out.println("Cantidad: " + movimiento.getQuantity());
			System.out.println("Fecha: " + movimiento.getDate());
			System.out.println("Tipo: " + movimiento.getType());
			System.out.println("Descripcion: " + movimiento.getDescription());
			System.out.println("==========================");
		}

		if (HistorialMovimientos.getInstance().getMovimientos().isEmpty()) {
			System.out.println("======================");
			System.out.println("No hay movimientos");
			System.out.println("======================");
		}
	}
}
