package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

	public static boolean modifyRegister(int numeroLinea, String nuevoContenido) {
        try {
            List<String> lineas = readAll();
            if (numeroLinea < 1 || numeroLinea > lineas.size()) {
                return false;
            }
            
            lineas.set(numeroLinea - 1, nuevoContenido);
            
            // Reescribir el archivo completo
            FileWriter fw = new FileWriter("agenda.data");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
            
            bw.close();
            return true;
            
        } catch (IOException e) {
            System.out.println("Error al modificar registro");
            e.printStackTrace();
            return false;
        }
    }

	public static boolean delete(int numeroLinea) {
        try {
            List<String> lineas = readAll();
            if (numeroLinea < 1 || numeroLinea > lineas.size()) {
                return false;
            }
            
            lineas.remove(numeroLinea - 1);

            FileWriter fw = new FileWriter("agenda.data");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
            
            bw.close();
            return true;
            
        } catch (IOException e) {
            System.out.println("Error al eliminar registro");
            e.printStackTrace();
            return false;
        }
    }

	public static String getRegister(int numeroLinea) {
        List<String> lineas = readAll();
        if (numeroLinea < 1 || numeroLinea > lineas.size()) {
            return null;
        }
        return lineas.get(numeroLinea - 1);
    }
}