package Agenda;

import java.util.List;

/**
 * Clase que representa un libro de direcciones,
 * el cual contiene la información de un empleado,
 * así como sus citas y notas asociadas.
 */
public class LibroDirecciones{
    
    private Empleo empleado;
    private List<Cita> citas;
    private List<Nota> notas;

    /**
     * Constructor de la clase LibroDirecciones.
     *
     * @param empleado Empleado al que pertenece el libro
     * @param citas Lista de citas asociadas al empleado
     * @param notas Lista de notas asociadas al empleado
     */
    private LibroDirecciones(Empleo empleado, List<Cita> citas,List<Nota> notas){
        this.empleado = empleado;
        this.citas = citas;
        this.notas = notas;
    }

    public Empleo getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleo empleado) {
        this.empleado = empleado;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}