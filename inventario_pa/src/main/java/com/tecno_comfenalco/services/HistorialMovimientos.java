
package com.tecno_comfenalco.services;

import java.util.ArrayList;

import com.tecno_comfenalco.models.Movimiento;

public class HistorialMovimientos {
	private ArrayList<Movimiento> movimientos;
	private static HistorialMovimientos instance;

	private HistorialMovimientos() {
		movimientos = new ArrayList<Movimiento>();
	}

	public static HistorialMovimientos getInstance() {
		if (instance == null) {
			instance = new HistorialMovimientos();
		}
		return instance;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void añadirMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}

	public void mostrarMovimientos() {

		// Ordenar movimientos por fechas de forma ascendente
		for (int i = 0; i < movimientos.size() - 1; i++) {
			if (movimientos.get(i).getDate().before(movimientos.get(i + 1).getDate())) {
				System.out.println("Fecha: " + movimientos.get(i).getDate());
				System.out.println("Producto: " + movimientos.get(i).getProduct());
				System.out.println("Cantidad: " + movimientos.get(i).getQuantity());
				System.out.println("Tipo: " + movimientos.get(i).getType());
				System.out.println("Usuario: " + movimientos.get(i).getUser());
			}
		}
	}
}
