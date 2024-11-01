
package com.tecno_comfenalco.models;

import java.util.Date;

import com.tecno_comfenalco.services.HistorialMovimientos;
import com.tecno_comfenalco.services.StockProducto;

public class Movimiento {

	public enum TipoMovimiento {
		ENTRADA, SALIDA
	}

	private final Producto product;
	private final int quantity;
	private final Date date;

	private final TipoMovimiento type;
	private final Usuario user;

	private final String description;

	public Movimiento(Producto product, int quantity, Date date, TipoMovimiento type, Usuario user,
			String description) {
		this.product = product;
		this.quantity = quantity;
		this.date = date;
		this.type = type;
		this.user = user;
		this.description = description;

		// Añadir el movimiento al historial

		HistorialMovimientos.getInstance().añadirMovimiento(this);
		product.setStock(new StockProducto().getStock(product));
	}

	public Producto getProduct() {
		return product;
	}


	public int getQuantity() {
		return quantity;
	}

	public Date getDate() {
		return date;
	}

	public TipoMovimiento getType() {
		return type;
	}

	public Usuario getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		System.out.println("\n===================================");
		System.out.println("Movimiento");
		System.out.println("===================================");

		System.out.println("Referencia del Producto: " + product.getId());
		System.out.println("Nombre del Producto: " + product.getName());
		System.out.println("Cantidad: " + quantity);
		System.out.println("Fecha: " + date);
		System.out.println("Tipo: " + type);
		System.out.println("Usuario: " + user.getName());
		System.out.println("Descripción: " + description);

		return "";
	}

}
