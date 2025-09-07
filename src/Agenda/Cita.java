package Agenda;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Clase que representa una cita en la agenda electrónica.
 */
public class Cita{
    private String titulo;
    private Date fecha;// dd/mm/AAAA
    private Timestamp hora; // HH:mm

    /**
     * Constructor de la clase Cita.
     *
     * @param titulo Título o descripción de la cita
     * @param fecha Fecha de la cita
     * @param hora Hora de la cita
     */
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

    /**
     * Devuelve una representación en texto de la cita.
     *
     * @return Cadena con el título, fecha y hora de la cita
     */
    @Override
    public String toString() {
        return "Cita: " + titulo + " | Fecha: " + fecha + " | Hora: " + hora;
    }
}