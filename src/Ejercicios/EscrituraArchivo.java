package Ejercicios;

import Agenda.Cita;
import Agenda.Persona;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class EscrituraArchivo {
	public static void write(Persona persona) {
		try {
			FileWriter fw = new FileWriter("agenda.data", true);
            BufferedWriter bw = new BufferedWriter(fw);
			List<String> datos = persona.personaToList();
            for (String dato : datos) {
                bw.write(dato + "; ");
            }

            if (!persona.getCitas().isEmpty()) {
                bw.write(" | Citas: ");
                for (Cita cita : persona.getCitas()) {
                    bw.write(cita.toString() + "; ");
                }
            }

            bw.newLine();
            bw.close();
		} catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}