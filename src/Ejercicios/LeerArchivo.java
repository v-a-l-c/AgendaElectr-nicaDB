package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
	public static void main (String[] args) {
		try {
			File archivo = new File("ejemplo.txt");
			Scanner lector = new Scanner(archivo) ;
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				System.out.print(linea);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.print("cannot");
		}
	}
}