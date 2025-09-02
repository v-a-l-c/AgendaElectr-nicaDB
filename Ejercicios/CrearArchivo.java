import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivo {
    public static void main(String[] args) {
        try {
            File archivo = new File("ejemplo.txt");
            if (archivo.createNewFile())
                System.out.println("Archivo creado: " + archivo.getName());
            else
                System.out.println("El archivo ya existe.");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("stuff");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}
