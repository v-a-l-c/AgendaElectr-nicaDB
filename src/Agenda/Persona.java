package Agenda;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

/**
 * Clase que representa una Persona dentro de la agenda electrónica.
 * 
 * Contiene información básica de contacto (nombre, apellidos, correo, etc.),
 * así como listas de {@link Cita} y {@link Nota} asociadas.
 * 
 * Permite además guardar los datos en un archivo mediante {@link ReaderWriter}.
 */
public class Persona{
    
    private String nombre;
    private String apellido_materno;
    private String apellido_Paterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo_Electronico;
    private String url;
    private String ig;
    private String fbk;

    private List<Cita> citas;

    private List<Nota> notas;

    private ReaderWriter rw;


    //URL, IG, Fck
    /**
     * Constructor principal para inicializar los datos de la persona.
     */
    public Persona(String nombre, String apellido_materno, String apellido_Paterno,
                    String direcciones, String telefono, String movil,
                    String correo_Electronico, String url, String ig, String fbk){
        this.nombre = nombre;
        this.apellido_materno= apellido_materno;
        this.apellido_Paterno= apellido_Paterno;
        this.direcciones = direcciones;
        this.telefono= telefono;
        this.movil= movil;
        this.correo_Electronico = correo_Electronico;
        this.url = url;
        this.ig = ig;
        this.fbk = fbk;
        this.citas = new ArrayList<>();
        this.notas = new ArrayList<>();
        rw = new ReaderWriter();
    }

    public String getnombre(){
        return this.nombre;
    }

    public String getapellido_materno(){
        return this.apellido_materno;
    }

    public String getapellido_Paterno(){
        return this.apellido_Paterno;
    }

    public String getdirecciones(){
        return this.direcciones;
    }

    public String gettelefeno(){
        return this.telefono;
    }

    public String getmovil(){
        return this.movil;
    }

    public String getcorreo_Electronico(){
        return this.correo_Electronico;
    }

    public String getURL(){
        return this.url;
    }

    public String getIg(){
        return this.ig;
    }

    public String getFbk(){
        return this.fbk;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setapellido_materno( String apellido_materno){
        this.apellido_materno= apellido_materno;
    }

    public void setapellido_Paterno(String apellido_Paterno){
        this.apellido_Paterno= apellido_Paterno;
    }

    public void setdirecciones(String direcciones){
       this.direcciones= direcciones;
    }

    public void settelefono(String telefono){
        this.telefono= telefono;
    }

    public void setmovil(String movil){
        this.movil= movil;
    }

    public void setcorreoElectronico(String correo_Electronico){
        this.correo_Electronico= correo_Electronico;
    }

    public void setURL(String url){
        this.url= url;
    }

    public void setIg(String ig){
        this.ig= ig;
    }

    public void setFbk(String fbk){
        this.fbk= fbk;
    }

    /**
     * Convierte los datos de la persona en una lista de strings
     * para facilitar el almacenamiento en archivos.
     *
     * @return lista con los datos de la persona
     */
    public List<String> personaToList(){
        List<String> data = new ArrayList<>();
        data.add(nombre);
        data.add(apellido_materno);
        data.add(apellido_Paterno);
        data.add(direcciones);
        data.add(telefono);
        data.add(movil);
        data.add(correo_Electronico);
        data.add(url);
        data.add(ig);
        data.add(fbk);
        return data;
    }

    /**
     * Agrega una nueva cita a la lista de citas de la persona.
     *
     * @param titulo título de la cita
     * @param fecha fecha de la cita
     * @param hora hora de la cita
     */
    public void appendCita(String titulo, Date fecha, Timestamp hora){
        Cita nuevaCita = new Cita(titulo, fecha, hora);
        citas.add(nuevaCita);
    }

    /**
     * Agrega una nueva nota a la lista de notas de la persona.
     *
     * @param descripcion texto de la nota
     */
    public void appendNota(String descripcion){
        Nota note = new Nota(descripcion);
        notas.add(note);
    }

    /**
     * Guarda la persona en el archivo a través de {@link ReaderWriter}.
     */
    public void savePersona(){
        rw.appendPersona(this);
    }
}