import java.lang.StringBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import Agenda.*;
import Ejercicios.CrearArchivo;

public class AgendaElectronica {

    private static Scanner scanner;
    public static void main(String[] args){
        CrearArchivo.crearArchivo();
        scanner = new Scanner(System.in);
        handleMenu();
    }

    private static String menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Seleccione la opcion que desea:\n");
        menu.append("1. Anadir registro\n");
        menu.append("2. Buscar registro\n");
        menu.append("3. Eliminar registro\n");
        menu.append("4. Modificar registro\n");
        menu.append("5. Salir\n");
        menu.append("Opción seleccionada:\n");
        return menu.toString();
    }
    private static void handleMenu() {
        boolean exit = false;
        String menu = menu();
        System.out.println("Bienvenido a Agenda electronica:");
        while (!exit) {
            System.out.print(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
            case "1":
                addRegister();
                break;
            case "2":
                searchRegister();
                break;
            case "3":
                deleteRegister();
                break;
            case "4":
                modifyRegister();
                break;
            case "5":
                System.out.print("Byeeee");
                exit = true;
                break;
            default:
                System.out.print(selectedOption + " no es una opcion valida.\n");
            }
        }
        scanner.close();
    }

    private static void addRegister() {
        System.out.println("Añadir Registro:");

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Apellido Paterno:");
        String app = scanner.nextLine();

        System.out.println("Apellido Materno:");
        String apm = scanner.nextLine();

        System.out.println("e-mail:");
        String correo;
        do {
            correo = scanner.nextLine();
            if (!correo.contains("@")) {
                System.out.println("El correo debe contener '@'. Intente de nuevo:");
            }
        } while (!correo.contains("@"));

        System.out.println("Dirección:");
        String dir = scanner.nextLine();

        System.out.println("Telefono:");
        String tel;
        do {
            tel = scanner.nextLine();
            if (!tel.startsWith("55")) {
                System.out.println("El telefono debe comenzar con 55. Intente de nuevo:\n");
            }
        } while (!tel.startsWith("55"));

        System.out.println("Movil:");
        String mov;
        do {
            mov = scanner.nextLine();
            if (!mov.startsWith("55")) {
                System.out.println("El movil debe comenzar con 55. Intente de nuevo:\n");
            }
        } while (!mov.startsWith("55"));

        System.out.println("Compania:");
        String comp = scanner.nextLine();

        System.out.println("Puesto:");
        String puesto = scanner.nextLine();

        System.out.println("URL:");
        String url;
        do {
            url = scanner.nextLine();
            if (!url.toLowerCase().startsWith("http")) {
                System.out.println("La URL debe comenzar con http o https. Intente de nuevo:");
            }
        } while (!url.toLowerCase().startsWith("http"));

        System.out.println("Facebook:");
        String fbk;
        do {
            fbk = scanner.nextLine();
            if (!fbk.toLowerCase().contains("facebook.com")) {
                System.out.println("El Facebook debe contener 'facebook.com'. Intente de nuevo:");
            }
        } while (!fbk.toLowerCase().contains("facebook.com"));

        System.out.println("Instagram:");
        String ig;
        do {
            ig = scanner.nextLine();
            if (!ig.startsWith("@")) {
                System.out.println("El Instagram debe comenzar con '@'. Intente de nuevo:");
            }
        } while (!ig.startsWith("@"));

        Persona contacto = new Empleo(nombre, apm, app, dir, tel, mov, correo, url, ig, fbk, comp, puesto);
        System.out.println("Quieres agendar una cita?");
        System.out.println("1.Si");
        System.out.println("2.nO");
        String addCita = scanner.nextLine();
        if (addCita.equals("1")) {
            addCitaToContacto(contacto);
        }
        contacto.savePersona();
        System.out.println("Contacto agregado con éxito:");
        System.out.println(contacto.getnombre() + " " + contacto.getapellido_Paterno());
    }

    private static void addCitaToContacto(Persona contacto){
        System.out.println("Dame el titulo de la Cita");
        String titulo = scanner.nextLine();

        LocalDate fechaLocal = null;
        LocalTime horaLocal = null;
        while (fechaLocal == null) {
            System.out.println("Dame la fecha (dd/MM/yyyy):");
            String fechaInput = scanner.nextLine();
            try {
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaLocal = LocalDate.parse(fechaInput, formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha invalida. Intente de nuevo.");
            }
        }
        while (horaLocal == null) {
            System.out.println("Dame la hora (HH:mm):");
            String horaInput = scanner.nextLine();
            try {
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
                horaLocal = LocalTime.parse(horaInput, formatoHora);
            } catch (DateTimeParseException e) {
                System.out.println("Hora invalida. Intente de nuevo.");
            }
        }
        java.sql.Date fecha = java.sql.Date.valueOf(fechaLocal);
        java.sql.Timestamp hora = java.sql.Timestamp.valueOf(horaLocal.atDate(fechaLocal));
        
        contacto.appendCita(titulo, fecha, hora);
        System.out.println("Se agregó tu cita:");
    }

    private static void searchRegister() {
        System.out.println("=== BUSCAR REGISTRO ===");
        System.out.println("1. Buscar por cualquier texto");
        System.out.println("2. Mostrar todos los registros");
        System.out.println("3. Volver al menú");
        System.out.print("Opción: ");
        
        String opcion = scanner.nextLine();
        
        switch (opcion) {
            case "1":
                searchData();
                break;
            case "2":
                showAllRegisters();
                break;
            case "3":
                return;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void searchData() {
        System.out.print("Ingrese el texto a buscar: ");
        String textoBusqueda = scanner.nextLine();
        
        ReaderWriter rw = new ReaderWriter();
        List<String> resultados = rw.searchData(textoBusqueda);
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias para: " + textoBusqueda);
        } else {
            System.out.println("=== RESULTADOS DE BÚSQUEDA ===");
            System.out.println("Se encontraron " + resultados.size() + " coincidencia(s):");
            
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println("\n--- Registro " + (i + 1) + " ---");
                System.out.println(formatearRegistro(resultados.get(i)));
            }
        }
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    private static void showAllRegisters() {
        ReaderWriter rw = new ReaderWriter();
        List<String> todosRegistros = rw.getAllData();
        
        if (todosRegistros.isEmpty()) {
            System.out.println("No hay registros en la agenda");
        } else {
            System.out.println("=== TODOS LOS REGISTROS ===");
            System.out.println("Total de registros: " + todosRegistros.size());
            
            for (int i = 0; i < todosRegistros.size(); i++) {
                System.out.println("\n--- Registro " + (i + 1) + " ---");
                System.out.println(formatearRegistro(todosRegistros.get(i)));
            }
        }
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    private static String formatearRegistro(String registro) {
        String formato = registro
            .replace("; ", "\n")
            .replace(" | Citas: ", "\n--- CITAS ---\n")
            .replace(";", "\n");
        
        return formato;
    }

    private static void deleteRegister() {
        System.out.println("op3");
    }

    private static void modifyRegister() {
        System.out.println("op4");
    }
}