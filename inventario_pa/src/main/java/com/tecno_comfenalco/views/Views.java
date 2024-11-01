
package com.tecno_comfenalco.views;

import java.util.Scanner;

public abstract class Views {

	public Scanner keyboardScanner = new Scanner(System.in);

	public abstract void show();

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void pauseScreen() {
		System.out.println("Presione enter para continuar...");
		try {
			String pause = keyboardScanner.nextLine();
		} catch (Exception e) {
		}
	}
}
