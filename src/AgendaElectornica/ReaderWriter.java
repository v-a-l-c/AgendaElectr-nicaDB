package AgendaElectornica;
import Ejercicios.*;

public class ReaderWriter {

    public ReaderWriter() {}

    public void crearData(){
        CrearArchivo.crearArchivo();
    }

    public void appendPersona(Persona data){
        EscrituraArchivo.write(data);
    }

    public void searchData(String querry){
        return;
    }
}