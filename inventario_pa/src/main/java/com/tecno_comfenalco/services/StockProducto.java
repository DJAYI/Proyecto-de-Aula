
package com.tecno_comfenalco.services;

import com.tecno_comfenalco.models.Movimiento;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.models.Movimiento.TipoMovimiento;

public class StockProducto {
	private int stock;

	private int entries;
	private int exits;

	public StockProducto() {
		this.entries = 0;
		this.exits = 0;
		this.stock = 0;
	}


	public int getStock(Producto product) {
		for (Movimiento movimiento : HistorialMovimientos.getInstance().getMovimientos()) {

			// Si el movimiento es del producto actual
			if (movimiento.getProduct().getId() == product.getId()) {

				// Si es una entrada, sumar a las entradas
				if (movimiento.getType() == TipoMovimiento.ENTRADA) {
					entries += movimiento.getQuantity();
				} else {

					// Si es una salida, sumar a las salidas
					exits += movimiento.getQuantity();
				}

				// Calcular el stock
				stock = entries - exits;
				movimiento.getProduct().setStock(stock);

			} else {
				System.out.println("Producto no encontrado");
			}

		}
		return stock;
	}
}
