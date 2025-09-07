package AgendaElectornica;

import java.util.List;

public class LibroDirecciones{
    
    private Empleo empleado;
    private List<Cita> citas;
    private List<Nota> notas;

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

    // Getter y Setter para notas
    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}