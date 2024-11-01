
package com.tecno_comfenalco.views.modules;

import com.tecno_comfenalco.controllers.producto.ProductoController;
import com.tecno_comfenalco.models.CategoriaProducto;
import com.tecno_comfenalco.utils.EstadoProductos;
import com.tecno_comfenalco.utils.listas.ListaCategorias;
import com.tecno_comfenalco.utils.listas.ListaProductos;
import com.tecno_comfenalco.views.Views;

public class ProductoView extends Views {

	String input;

	public ProductoView() {

		do {
			show();

		} while (!input.equalsIgnoreCase("7"));
	}

	@Override
	public void show() {
		System.out.println("===================================");
		System.out.println("Inventario PA - Gestion de Productos");
		System.out.println("===================================");
		System.out.println("1. Crear Producto");
		System.out.println("2. Editar Producto");
		System.out.println("3. Eliminar Producto");
		System.out.println("4. Listar Productos");
		System.out.println("5. Listar Estados de Productos");
		System.out.println("6. Buscar Producto");
		System.out.println("7. Salir");
		System.out.println("===================================");

		this.input = keyboardScanner.nextLine();

		clearScreen();

		switch (input) {
			case "1" -> {
				createProducto();
				break;
			}
			case "2" -> {
				editProducto();
				break;
			}
			case "3" -> {
				deleteProducto();
				break;
			}
			case "4" -> {
				listProductos();
				break;
			}
			case "5" -> {
				listEstados();
				break;
			}
			case "6" -> {
				buscarProducto();
				break;
			}
			case "7" -> {
				System.out.println("Saliendo...");
				break;
			}
			default -> {
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

	public void createProducto() {
		System.out.println("===================================");
		System.out.println("Crear Producto");
		System.out.println("===================================");

		System.out.println("Ingrese el id del producto: ");
		String id = keyboardScanner.nextLine();

		System.out.println("Ingrese el nombre del producto: ");
		String nombre = keyboardScanner.nextLine();

		System.out.println("Ingrese la descripcion del producto: ");
		String descripcion = keyboardScanner.nextLine();

		System.out.println("Ingrese el precio del producto: ");
		String precio = keyboardScanner.nextLine();

		System.out.println("Ingrese la categoria del producto: ");
		String categoria = keyboardScanner.nextLine();

		for (CategoriaProducto categoriaIndex : ListaCategorias.getInstance().getCategorias()) {
			if (categoriaIndex.getName().equalsIgnoreCase(categoria)) {
				ProductoController.getInstance().crearProducto(id, nombre, descripcion,
						Double.parseDouble(precio), categoriaIndex);
			} else {
				System.out.println("===================================");
				System.out.println("La categoria no existe");
				System.out.println("===================================");
			}
		}

		System.out.println("===================================");
		System.out.println("Producto creado con exito");
		System.out.println("===================================");
	}

	public void editProducto() {
		System.out.println("===================================");
		System.out.println("Editar Producto");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre del producto a editar: ");
		String id = keyboardScanner.nextLine();

		clearScreen();
		System.out.println("¿Que desea editar?");
		System.out.println("1. Nombre");
		System.out.println("2. Descripcion");
		System.out.println("3. Precio");
		System.out.println("4. Categoria");
		System.out.println("5. Todos los campos");
		System.out.println("5. Salir");

		String opcion = keyboardScanner.nextLine();

		switch (opcion) {
			case "0" -> {
				System.out.println("Ingrese el nuevo id del producto: ");
				String nuevoId = keyboardScanner.nextLine();
				ProductoController.getInstance().actualizarId(id, nuevoId);
			}

			case "1" -> {
				System.out.println("Ingrese el nuevo nombre del producto: ");
				String nuevoNombre = keyboardScanner.nextLine();
				ProductoController.getInstance().actualizarNombre(id, nuevoNombre);
			}
			case "2" -> {
				System.out.println("Ingrese la nueva descripcion del producto: ");
				String nuevaDescripcion = keyboardScanner.nextLine();
				ProductoController.getInstance().actualizarDescripcion(id, nuevaDescripcion);
			}
			case "3" -> {
				System.out.println("Ingrese el nuevo precio del producto: ");
				String nuevoPrecio = keyboardScanner.nextLine();
				ProductoController.getInstance().actualizarPrecio(id, nuevoPrecio);
			}
			case "4" -> {
				System.out.println("Ingrese la nueva categoria del producto: ");
				String nuevaCategoria = keyboardScanner.nextLine();

				for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
					if (categoria.getName().equals(nuevaCategoria)) {
						ProductoController.getInstance().actualizarCategoria(id, categoria);
					} else {
						System.out.println("===================================");
						System.out.println("La categoria no existe");
						System.out.println("===================================");
					}
				}
			}
			case "5" -> {
				System.out.println("Ingrese el nuevo nombre del producto: ");
				String nuevoNombre = keyboardScanner.nextLine();
				System.out.println("Ingrese la nueva descripcion del producto: ");
				String nuevaDescripcion = keyboardScanner.nextLine();
				System.out.println("Ingrese el nuevo precio del producto: ");
				String nuevoPrecio = keyboardScanner.nextLine();
				System.out.println("Ingrese la nueva categoria del producto: ");
				String nuevaCategoria = keyboardScanner.nextLine();

				for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
					if (categoria.getName().equals(nuevaCategoria)) {
						ProductoController.getInstance().actualizarProducto(id, nuevoNombre, nuevaDescripcion,
								nuevoPrecio, categoria);
					} else {
						System.out.println("===================================");
						System.out.println("La categoria no existe");
						System.out.println("===================================");
					}
				}
			}
			case "6" -> {
				break;
			}
			default -> {
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

	public void deleteProducto() {
		System.out.println("===================================");
		System.out.println("Eliminar Producto");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre del producto a eliminar: ");
		String id = keyboardScanner.nextLine();
		ProductoController.getInstance().eliminarProducto(id);
	}

	public void listProductos() {
		System.out.println("===================================");
		System.out.println("Listar Productos");
		System.out.println("===================================");
		ProductoController.getInstance().listarProductos();
	}

	public void listEstados() {
		System.out.println("===================================");
		System.out.println("Listar Estados de Productos");
		System.out.println("===================================");
		ListaProductos.getInstance().getProductos().forEach(producto -> {
			System.out.println("Id: " + producto.getId());
			System.out.println("Nombre: " + producto.getName());
			System.out.println("Estado: " + EstadoProductos.getInstance().GetEstado(producto));
		});
	}

	public void buscarProducto() {
		System.out.println("===================================");
		System.out.println("Buscar Producto");
		System.out.println("===================================");
		System.out.println("Ingrese el id del producto a buscar: ");
		String id = keyboardScanner.nextLine();
		ProductoController.getInstance().buscarProducto(id);
	}

}
