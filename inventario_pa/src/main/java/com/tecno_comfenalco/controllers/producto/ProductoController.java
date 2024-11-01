
package com.tecno_comfenalco.controllers.producto;

import com.tecno_comfenalco.models.CategoriaProducto;
import com.tecno_comfenalco.models.Producto;
import com.tecno_comfenalco.utils.EstadoProductos;
import com.tecno_comfenalco.utils.listas.ListaProductos;

public class ProductoController {
	private static ProductoController instance;

	private ProductoController() {
	}

	public static ProductoController getInstance() {
		if (instance == null) {
			instance = new ProductoController();
		}
		return instance;
	}

	// Crear metodos para crear, leer, actualizar y eliminar productos

	// 1. Crear producto
	public void crearProducto(String id, String nombre, String descripcion, Double precio,
			CategoriaProducto categoria) {
		// Logica para crear producto

		// 1.1 Validar que los campos no sean nulos
		if (nombre == null || descripcion == null || precio == null || categoria == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (nombre.isEmpty() || descripcion.isEmpty() || precio == 0 || categoria == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 1.2 Validar que el producto no exista
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getName().equals(nombre)) {
				System.out.println("El producto ya existe");
				return;
			}
		}

		// 1.3 Crear producto
		new Producto(id, nombre, descripcion, precio, categoria);

	}

	// 2. Leer producto
	public void leerProducto(String id) {
		// Logica para leer producto
		// 2.1 Validar que el id no sea nulo
		if (id.isEmpty()) {
			System.out.println("El id del producto no puede ser nulo");
			return;
		}

		// 2.2 Buscar producto por id
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				System.out.println("===================================");
				System.out.println("Producto encontrado: " + producto.getName());
				System.out.println("Descripcion: " + producto.getDescription());
				System.out.println("Precio: " + producto.getPrice());

				System.out.println("Categoria: " + producto.getCategory().getName());
				System.out.println("Cantidad: " + producto.getStock());

				System.out
						.println("Estado: " + EstadoProductos.getInstance().GetEstado(producto).toString());

				System.out.println("===================================");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	// 3. Actualizar producto
	public void actualizarProducto(String id, String nombre, String descripcion, String precio,
			CategoriaProducto categoria) {
		// Logica para actualizar producto
		// 3.1 Validar que los campos no sean nulos
		if (nombre == null || descripcion == null || precio == null || categoria == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (nombre.isEmpty() || descripcion.isEmpty() || precio.isEmpty() || categoria == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar producto
				producto.setName(nombre);
				producto.setDescription(descripcion);
				producto.setPrice(Double.parseDouble(precio));
				producto.setCategory(categoria);

				System.out.println("Producto actualizado exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	public void actualizarNombre(String id, String nombre) {
		// Logica para actualizar nombre de producto
		// 3.1 Validar que los campos no sean nulos
		if (nombre == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (nombre.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar nombre
				producto.setName(nombre);
				System.out.println("Nombre actualizado exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	public void actualizarDescripcion(String id, String descripcion) {
		// Logica para actualizar descripcion de producto
		// 3.1 Validar que los campos no sean nulos
		if (descripcion == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (descripcion.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar descripcion
				producto.setDescription(descripcion);
				System.out.println("Descripcion actualizada exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	public void actualizarPrecio(String id, String precio) {
		// Logica para actualizar precio de producto
		// 3.1 Validar que los campos no sean nulos
		if (precio == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		if (precio.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar precio
				producto.setPrice(Double.parseDouble(precio));
				System.out.println("Precio actualizado exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	public void actualizarId(String id, String nuevoId) {
		// Logica para actualizar id de producto
		// 3.1 Validar que los campos no sean nulos
		if (nuevoId.isEmpty()) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar id
				producto.setId(nuevoId);
				System.out.println("Id actualizado exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	public void actualizarCategoria(String id, CategoriaProducto categoria) {
		// Logica para actualizar categoria de producto
		// 3.1 Validar que los campos no sean nulos
		if (categoria == null) {
			System.out.println("Los campos no pueden ser nulos");
			return;
		}

		// 3.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 3.3 Actualizar categoria
				producto.setCategory(categoria);
				System.out.println("Categoria actualizada exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	// 4. Eliminar producto
	public void eliminarProducto(String id) {
		// Logica para eliminar producto
		// 4.1 Validar que el id no sea nulo
		if (id.isEmpty()) {
			System.out.println("El id del producto no puede ser nulo");
			return;
		}

		// 4.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId() == id) {
				// 4.3 Eliminar producto
				ListaProductos.getInstance().getProductos().remove(producto);
				System.out.println("Producto eliminado exitosamente");
				return;
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}

	// 5. Listar productos
	public void listarProductos() {
		// Logica para listar productos
		System.out.println("===================================");
		System.out.println("Listado de productos");
		System.out.println("===================================");

		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			System.out.println("Id: " + producto.getId());
			System.out.println("Nombre: " + producto.getName());
			System.out.println("Descripcion: " + producto.getDescription());
			System.out.println("Precio: " + producto.getPrice());
			System.out.println("Categoria: " + producto.getCategory().getName());
			System.out.println("Cantidad: " + producto.getStock());
			System.out.println("Estado: " + EstadoProductos.getInstance().GetEstado(producto).toString());
			System.out.println("===================================");
		}
	}

	// 6. Buscar producto
	public void buscarProducto(String id) {
		// Logica para buscar producto
		// 6.1 Validar que el id no sea nulo
		if (id.isEmpty()) {
			System.out.println("El id del producto no puede ser nulo");
		}

		// 6.2 Buscar producto
		for (Producto producto : ListaProductos.getInstance().getProductos()) {
			if (producto.getId().equalsIgnoreCase(id)) {
				System.out.println("===================================");
				System.out.println("Producto encontrado: " + producto.getName());
				System.out.println("Descripcion: " + producto.getDescription());
				System.out.println("Precio: " + producto.getPrice());
				System.out.println("Categoria: " + producto.getCategory().getName());
				System.out.println("Cantidad: " + producto.getStock());
				System.out
						.println("Estado: " + EstadoProductos.getInstance().GetEstado(producto).toString());
				System.out.println("===================================");
			} else {
				System.out.println("Producto no encontrado");

			}
		}

	}
}

