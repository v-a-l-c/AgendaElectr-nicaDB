package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {
	public static List<String> readAll() {
        List<String> lineas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("agenda.data"));
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
        return lineas;
    }

	public static List<String> search(String texto) {
        List<String> resultados = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("agenda.data"));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(texto.toLowerCase())) {
                    resultados.add(linea);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al buscar en el archivo");
            e.printStackTrace();
        }
        return resultados;
    }
}