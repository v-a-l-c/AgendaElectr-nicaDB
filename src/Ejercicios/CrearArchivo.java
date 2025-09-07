package Ejercicios;

import java.io.File;
import java.io.IOException;

public class CrearArchivo {
    public static void crearArchivo(){
        try {
            File archivo = new File("agenda.data");
            if (archivo.createNewFile())
                System.out.println("Archivo creado: " + archivo.getName());
            else
                return;
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}
