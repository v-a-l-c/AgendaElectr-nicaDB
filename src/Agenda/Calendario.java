package Agenda;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Clase que genera y representa un calendario mensual en formato de texto.
 * 
 * Se puede crear un calendario para un mes y year específicos o bien
 * generar el calendario del mes actual.
 */
public class Calendario{
    private int mes;
    private int year;
    
    /**
     * Constructor de la clase Calendario.
     * 
     * @param mes número del mes (1-12)
     * @param year year correspondiente al calendario
     */
    public Calendario(int mes, int year) {
        this.mes = mes;
        this.year = year;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getyear() {
        return year;
    }
    
    public void setyear(int year) {
        this.year = year;
    }

    /**
     * Genera un calendario en formato de texto para el mes y year definidos.
     * 
     * @return cadena que representa el calendario con formato
     */
    public String generaCalendario() {
        StringBuilder calendario = new StringBuilder();

        LocalDate primerDia = LocalDate.of(year, mes, 1);
        String nombreMes = primerDia.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

        calendario.append(" ".repeat(10)).append(nombreMes.toUpperCase()).append(" ").append(year).append("\n");
        calendario.append("=".repeat(35)).append("\n");

        calendario.append("  DOM  LUN  MAR  MIE  JUE  VIE  SAB\n");

        int diaSemana = primerDia.getDayOfWeek().getValue();
        int espaciosInicio = (diaSemana == 7) ? 0 : diaSemana;
        espaciosInicio = (espaciosInicio + 6) % 7;

        int diasEnMes = primerDia.lengthOfMonth();

        int dia = 1;
        boolean primeraLinea = true;
        
        for (int i = 0; dia <= diasEnMes; i++) {
            for (int j = 0; j < 7; j++) {
                if (primeraLinea && j < espaciosInicio) {
                    calendario.append("     ");
                } else if (dia <= diasEnMes) {
                    if (dia < 10) {
                        calendario.append("   ").append(dia).append(" ");
                    } else {
                        calendario.append("  ").append(dia).append(" ");
                    }
                    dia++;
                } else {
                    calendario.append("     ");
                }
            }
            primeraLinea = false;
            if (dia <= diasEnMes) {
                calendario.append("\n");
            }
        }
        
        return calendario.toString();
    }
    

    public static String generaCalendarioActual() {
        LocalDate hoy = LocalDate.now();
        Calendario calendario = new Calendario(hoy.getMonthValue(), hoy.getYear());
        return calendario.generaCalendario();
    }
    
    /**
     * Devuelve la representación en texto del calendario.
     * 
     * @return cadena con el calendario
     */
    @Override
    public String toString() {
        return generaCalendario();
    }
}