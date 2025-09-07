package AgendaElectornica;

public class Nota{

    private String nota;

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