package Ejercicios;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivo {
    public static void main(String[] args) {
        try {
            File archivo = new File("ejemplo.txt");
            if (archivo.createNewFile())
                System.Out.println("Archivo creado: " + archivo.getName())
            else
                System.Out.println("El archivo ya existe.");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("stuff");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}
