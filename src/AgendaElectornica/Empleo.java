package AgendaElectornica;

public class Empleo extends Persona{

    private String compania;
    private String puesto;

    public Empleo(String nombre, String apellido_materno, String apellido_Paterno,
                  String direcciones, String telefono, String movil,
                  String correo_Electronico, String url, String ig, String fbk,
                  String compania, String puesto){
        super(nombre, apellido_materno, apellido_Paterno, direcciones, telefono,
              movil, correo_Electronico, url, ig, fbk);
        this.compania = compania;
        this.puesto = puesto;
    }

    public String getCompania(){
        return compania;
    }
    public String getPuesto(){
        return puesto;
    }
    //Getters y setters
}