package Agenda;

/**
 * Clase que representa una nota asociada a una persona en la agenda.
 */
public class Nota{

    private String nota;

    /**
     * Constructor de la clase Nota.
     *
     * @param descripcion Texto que representa la nota
     */
    public Nota(String descripcion){
        nota = descripcion;
    }

    public void setDescripcion(String nota){
        this.nota = nota;
    }

    public String getDescripcion(){
        return nota;
    }
}