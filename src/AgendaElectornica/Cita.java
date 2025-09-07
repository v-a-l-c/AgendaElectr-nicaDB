package AgendaElectornica;

import java.sql.Timestamp;
import java.util.Date;

public class Cita{
    private String titulo;
    private Date fecha;// dd/mm/AAAA
    private Timestamp hora; // HH:mm

    public Cita(String titulo, Date fecha, Timestamp hora){
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Timestamp getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Cita: " + titulo + " | Fecha: " + fecha + " | Hora: " + hora;
    }
}