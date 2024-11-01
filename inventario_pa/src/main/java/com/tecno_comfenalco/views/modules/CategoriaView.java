
package com.tecno_comfenalco.views.modules;

import com.tecno_comfenalco.controllers.categoria.CategoriaController;
import com.tecno_comfenalco.models.CategoriaProducto;
import com.tecno_comfenalco.utils.listas.ListaCategorias;
import com.tecno_comfenalco.views.Views;

public class CategoriaView extends Views {
	String input;

	public CategoriaView() {
		do {
			clearScreen();
			show();

		} while (!input.equalsIgnoreCase("6"));
	}

	@Override
	public void show() {
		System.out.println("===================================");
		System.out.println("Inventario PA - Gestion de Categorias");
		System.out.println("===================================");
		System.out.println("1. Crear Categoria");
		System.out.println("2. Editar Categoria");
		System.out.println("3. Eliminar Categoria");
		System.out.println("4. Listar Categorias");
		System.out.println("5. Buscar Categoria");
		System.out.println("6. Salir");
		System.out.println("===================================");

		this.input = keyboardScanner.nextLine();

		switch (input) {
			case "1" -> {
				createCategoria();
				break;
			}
			case "2" -> {
				editCategoria();
				break;
			}
			case "3" -> {
				deleteCategoria();
				break;
			}
			case "4" -> {
				listCategorias();
				break;
			}
			case "5" -> {
				buscarCategoria();
				break;
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

	public void createCategoria() {
		System.out.println("===================================");
		System.out.println("Crear Categoria");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de la categoria:");
		String nombre = keyboardScanner.nextLine();
		System.out.println("Ingrese la descripcion de la categoria:");
		String descripcion = keyboardScanner.nextLine();

		CategoriaController.getInstance().crearCategoria(nombre, descripcion);

		System.out.println("Categoria creada exitosamente");
	}

	public void editCategoria() {
		System.out.println("===================================");
		System.out.println("Editar Categoria");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de la categoria a editar:");
		String nombre = keyboardScanner.nextLine();

		for (CategoriaProducto categoria : ListaCategorias.getInstance().getCategorias()) {
			if (categoria.getName().equals(nombre)) {

				clearScreen();

				System.out.println("===================================");
				System.out.println("Seleccione el campo a editar:");
				System.out.println("1. Nombre");
				System.out.println("2. Descripcion");
				System.out.println("3. Salir");
				System.out.println("===================================");

				String value = keyboardScanner.nextLine();
				switch (value) {
					case "1" -> {
						System.out.println("Ingrese el nuevo nombre de la categoria:");
						String newName = keyboardScanner.nextLine();

						CategoriaController.getInstance().actualizarNombreCategoria(categoria.getName(),
								newName);
						break;
					}

					case "2" -> {
						System.out.println("Ingrese la nueva descripcion de la categoria:");
						String newDescription = keyboardScanner.nextLine();
						CategoriaController.getInstance().actualizarDescripcionCategoria(categoria.getName(),

								newDescription);

						break;
					}

					case "3" -> {
						break;
					}

					default -> {
						System.out.println("Opcion no valida");
					}
				}
			}

		}
	}

	public void deleteCategoria() {
		System.out.println("===================================");
		System.out.println("Eliminar Categoria");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de la categoria a eliminar:");
		String nombre = keyboardScanner.nextLine();

		CategoriaController.getInstance().eliminarCategoria(nombre);
	}

	public void listCategorias() {
		CategoriaController.getInstance().listarCategorias();
		pauseScreen();
	}

	public void buscarCategoria() {
		System.out.println("===================================");
		System.out.println("Buscar Categoria");
		System.out.println("===================================");
		System.out.println("Ingrese el nombre de la categoria a buscar:");
		String nombre = keyboardScanner.nextLine();

		CategoriaController.getInstance().leerCategoria(nombre);

		pauseScreen();
	}
}
