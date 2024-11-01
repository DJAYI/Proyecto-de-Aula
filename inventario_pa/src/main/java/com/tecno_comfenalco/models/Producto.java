
package com.tecno_comfenalco.models;

import com.tecno_comfenalco.services.StockProducto;
import com.tecno_comfenalco.utils.listas.ListaProductos;

public class Producto {
	private String id;
	private String name;
	private String description;
	private double price;
	private int stock;

	private CategoriaProducto category;

	public Producto(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = 0;
	}

	public Producto(String id, String name, String description, double price,
			CategoriaProducto category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;

		this.stock = new StockProducto().getStock(this);
		ListaProductos.getInstance().addProducto(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoriaProducto getCategory() {
		return category;
	}

	public void setCategory(CategoriaProducto category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stock=" + stock + ", category=" + category + "]";
	}

}
