
package com.tecno_comfenalco.controllers.categoria;

import com.tecno_comfenalco.models.CategoriaProducto;
import com.tecno_comfenalco.utils.listas.ListaCategorias;

public class CategoriaController {

	private static CategoriaController instance;

	private CategoriaController() {
	}

	public static CategoriaController getInstance() {
		if (instance == null) {
			instance = new CategoriaController();
		}
		return instance;
	}


	// Crear metodos para crear, leer, actualizar y eliminar categorias

	// 1. Crear categoria
	public void crearCategoria(String name, String description) {
		// Logica para crear categoria

		// 1.1 Validar que el nombre o descripcion no sean nulos
		if (name == null || description == null) {
			System.out.println("El nombre ni la descripcion de la categoria no puede ser nulo");
			return;
		}

		if (description.isEmpty() || name.isEmpty()) {
			System.out.println("La descripcion ni el nombre de la categoria no puede ser nula");
			return;
		}

		// 1.2 Validar que la categoria no exista
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(name)) {
				System.out.println("La categoria ya existe");
				return;
			}
		}
		// 1.3 Crear categoria

		CategoriaProducto categoria = new CategoriaProducto(name, description);
	}

	// 2. Leer categoria
	public void leerCategoria(String name) {
		// Logica para leer categoria
		// 2.1 Validar que el nombre no sea nulo
		if (name == null) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		if (name.isEmpty()) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		// 2.2 Validar que la categoria exista
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(name)) {
				System.out.println("---------------------------------");
				System.out.println("Categoria encontrada");
				System.out.println("---------------------------------");
				System.out.println("Nombre: " + categoria.getName());
				System.out.println("Descripcion: " + categoria.getDescription());
				System.out.println("---------------------------------");
				return;
			}
		}
		System.out.println("Categoria no encontrada");
	}

	// 3. Actualizar nombre de la categoria
	public void actualizarNombreCategoria(String name, String newName) {
		// Logica para actualizar nombre de la categoria
		// 3.1 Validar que el nombre no sea nulo
		if (name == null || newName == null) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		if (name.isEmpty() || newName.isEmpty()) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		// 3.2 Validar que la categoria exista
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(name)) {
				categoria.setName(newName);
				System.out.println("Nombre de la categoria actualizado");
				return;
			}
		}
		System.out.println("Categoria no encontrada");
	}

	// 4. Actualizar descripcion de la categoria
	public void actualizarDescripcionCategoria(String name, String newDescription) {
		// Logica para actualizar descripcion de la categoria
		// 4.1 Validar que el nombre no sea nulo
		if (name == null || newDescription == null) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		if (name.isEmpty() || newDescription.isEmpty()) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		// 4.2 Validar que la categoria exista
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(name)) {
				categoria.setDescription(newDescription);
				System.out.println("Descripcion de la categoria actualizada");
				return;
			}
		}
		System.out.println("Categoria no encontrada");
	}

	// 5. Eliminar categoria
	public void eliminarCategoria(String name) {
		// Logica para eliminar categoria
		// 5.1 Validar que el nombre no sea nulo
		if (name == null) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		if (name.isEmpty()) {
			System.out.println("El nombre de la categoria no puede ser nulo");
			return;
		}

		// 5.2 Validar que la categoria exista
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(name)) {
				ListaCategorias.getInstance().getCategorias().remove(categoria);
				System.out.println("Categoria eliminada");
				return;
			}
		}
		System.out.println("Categoria no encontrada");
	}

	// 6. Listar categorias
	public void listarCategorias() {
		// Logica para listar categorias
		System.out.println("Listado de categorias");
		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + categoria.getName());
			System.out.println("Descripcion: " + categoria.getDescription());
			System.out.println("---------------------------------");
		}
	}
}
