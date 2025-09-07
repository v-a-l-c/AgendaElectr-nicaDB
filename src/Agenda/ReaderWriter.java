package Agenda;
import java.util.List;

import Ejercicios.*;

public class ReaderWriter {

    public ReaderWriter() {}

    public void appendPersona(Persona data){
        EscrituraArchivo.write(data);
    }

    public List<String> searchData(String data){
        return LeerArchivo.search(data);
    }

    public List<String> getAllData(){
        return LeerArchivo.readAll();
    }
}