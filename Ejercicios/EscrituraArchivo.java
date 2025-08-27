import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class EscrituraArchivo {
	public static void main (String[] args) {
		try {
			FileWriter fw = new FileWriter("ejemplo.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Primera línea en el archivo.");
			bw.newLine();
			bw.write("Segunda" ) ;
			bw.newLine();
			bw.close();
		} catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}