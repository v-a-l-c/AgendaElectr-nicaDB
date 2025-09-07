package Agenda;
import java.util.List;

import Ejercicios.*;

/**
 * Utiliza las clases utilitarias de {@code Ejercicios.*}
 * para persistir, buscar, modificar y eliminar registros de personas.
 */
public class ReaderWriter {

    /**
     * Constructor vacío. 
     * No realiza ninguna inicialización extra.
     */
    public ReaderWriter() {}

    /**
     * Añade un registro de persona al archivo.
     * 
     * @param data Objeto de tipo {@link Persona} que será persistido en el archivo.
     */
    public void appendPersona(Persona data){
        EscrituraArchivo.write(data);
    }

    /**
     * Busca registros en el archivo que contengan el texto proporcionado.
     * 
     * @param data Texto que se desea buscar en los registros.
     * @return Lista de cadenas con los registros que coinciden con el criterio de búsqueda.
     */
    public List<String> searchData(String data){
        return LeerArchivo.search(data);
    }

    /**
     * Obtiene todos los registros almacenados en el archivo.
     * 
     * @return Lista con todos los registros en forma de cadenas.
     */
    public List<String> getAllData(){
        return LeerArchivo.readAll();
    }

    /**
     * Elimina un registro específico identificado por su número de línea.
     * 
     * @param numeroLinea Número de línea del registro a eliminar.
     * @return {@code true} si el registro fue eliminado correctamente,
     *         {@code false} en caso contrario.
     */
    public boolean eliminarRegistro(int numeroLinea) {
        return LeerArchivo.delete(numeroLinea);
    }

    /**
     * Modifica un registro específico en el archivo.
     * 
     * @param numeroLinea Número de línea del registro a modificar.
     * @param nuevoContenido Nuevo contenido del registro.
     * @return {@code true} si la modificación fue exitosa,
     *         {@code false} en caso de error.
     */
    public boolean modificarRegistro(int numeroLinea, String nuevoContenido) {
        return LeerArchivo.modifyRegister(numeroLinea, nuevoContenido);
    }
    
    /**
     * Obtiene un registro específico a partir de su número de línea.
     * 
     * @param numeroLinea Número de línea del registro deseado.
     * @return Cadena que representa el contenido del registro solicitado.
     */
    public String obtenerRegistro(int numeroLinea) {
        return LeerArchivo.getRegister(numeroLinea);
    }
}