import java.lang.StringBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import Agenda.*;
import Ejercicios.CrearArchivo;

/**
 * Clase principal de la aplicación de Agenda Electrónica.
 * 
 * Permite al usuario:
 * - Añadir registros de contactos.
 * - Buscar registros existentes.
 * - Eliminar registros.
 * - Modificar registros.
 */
public class AgendaElectronica {

     /** Escaner global para lectura desde consola */
    private static Scanner scanner;
    public static void main(String[] args){
        CrearArchivo.crearArchivo();
        scanner = new Scanner(System.in);
        handleMenu();
    }

    /**
     * Construye el texto del menú principal.
     * @return Cadena con las opciones del menú.
     */
    private static String menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Seleccione la opcion que desea:\n");
        menu.append("1. Anadir registro\n");
        menu.append("2. Buscar registro\n");
        menu.append("3. Eliminar registro\n");
        menu.append("4. Modificar registro\n");
        menu.append("5. Mostrar calendario\n");
        menu.append("6. Salir\n");
        menu.append("Opción seleccionada:\n");
        return menu.toString();
    }

    /**
     * Controla el flujo del menú principal.
     * Ejecuta las acciones según la opción seleccionada por el usuario.
     */
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
                mostrarCalendario();
                break;
            case "6":
                System.out.print("Byeeee");
                exit = true;
                break;
            default:
                System.out.print(selectedOption + " no es una opcion valida.\n");
            }
        }
        scanner.close();
    }

    /**
     * Añade un nuevo registro (contacto).
     * Valida campos como email, teléfono, URL, Facebook e Instagram.
     * Si el usuario lo desea, permite asociar una cita al contacto.
     */
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

    /**
     * Permite añadir una cita a un contacto existente.
     * Valida formato de fecha y hora antes de agregarla.
     * 
     * @param contacto Persona a la que se asociará la cita.
     */
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

    /**
     * Menú de búsqueda de registros.
     * Permite buscar por texto o mostrar todos los registros.
     */
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

    /**
     * Busca registros que contengan el texto ingresado.
     */
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

    /**
     * Muestra todos los registros guardados en la agenda.
     */
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

    /**
     * Formatea un registro de texto para mostrarlo más legible en consola.
     * @param registro Cadena con los datos en formato plano.
     * @return Cadena formateada para mostrar.
     */
    private static String formatearRegistro(String registro) {
        String formato = registro
            .replace("; ", "\n")
            .replace(" | Citas: ", "\n--- CITAS ---\n")
            .replace(";", "\n");
        
        return formato;
    }

    /**
     * Elimina un registro seleccionado por número de lista.
     * Pide confirmación antes de borrarlo.
     */
    private static void deleteRegister() {
        System.out.println("=== ELIMINAR REGISTRO ===");

        ReaderWriter rw = new ReaderWriter();
        List<String> todosRegistros = rw.getAllData();
        
        if (todosRegistros.isEmpty()) {
            System.out.println("No hay registros para eliminar.");
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }
        
        System.out.println("=== LISTA DE REGISTROS ===");
        for (int i = 0; i < todosRegistros.size(); i++) {
            System.out.println("\n--- Registro " + (i + 1) + " ---");
            System.out.println(formatearRegistro(todosRegistros.get(i)));
            System.out.println("-----------------------");
        }
        
        System.out.print("\nIngrese el número del registro a eliminar (0 para cancelar): ");
        try {
            int numeroRegistro = Integer.parseInt(scanner.nextLine());
            
            if (numeroRegistro == 0) {
                System.out.println("Operación cancelada.");
                return;
            }
            
            if (numeroRegistro < 1 || numeroRegistro > todosRegistros.size()) {
                System.out.println("Número de registro inválido.");
                return;
            }

            System.out.println("\n¿Está seguro de eliminar este registro? (S/N):");
            String confirmacion = scanner.nextLine();
            
            if (confirmacion.equalsIgnoreCase("S")) {
                boolean eliminado = rw.eliminarRegistro(numeroRegistro);
                if (eliminado) {
                    System.out.println("Registro eliminado exitosamente.");
                } else {
                    System.out.println("Error al eliminar el registro.");
                }
            } else {
                System.out.println("Eliminación cancelada.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        }
        
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Permite modificar campos específicos de un registro seleccionado.
     */
    private static void modifyRegister() {
        System.out.println("=== MODIFICAR REGISTRO ===");
        
        ReaderWriter rw = new ReaderWriter();
        List<String> todosRegistros = rw.getAllData();
        
        if (todosRegistros.isEmpty()) {
            System.out.println("No hay registros para modificar.");
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }
        
        System.out.println("=== LISTA DE REGISTROS ===");
        for (int i = 0; i < todosRegistros.size(); i++) {
            System.out.println("\n--- Registro " + (i + 1) + " ---");
            System.out.println(formatearRegistro(todosRegistros.get(i)));
            System.out.println("-----------------------");
        }
        
        System.out.print("\nIngrese el número del registro a modificar (0 para cancelar): ");
        try {
            int numeroRegistro = Integer.parseInt(scanner.nextLine());
            
            if (numeroRegistro == 0) {
                System.out.println("Operación cancelada.");
                return;
            }
            
            if (numeroRegistro < 1 || numeroRegistro > todosRegistros.size()) {
                System.out.println("Número de registro inválido.");
                return;
            }
            
            String registroActual = rw.obtenerRegistro(numeroRegistro);
            System.out.println("\n--- REGISTRO ACTUAL ---");
            System.out.println(formatearRegistro(registroActual));
            
            System.out.println("\n¿Qué campo desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido Paterno");
            System.out.println("3. Apellido Materno");
            System.out.println("4. Email");
            System.out.println("5. Dirección");
            System.out.println("6. Teléfono");
            System.out.println("7. Móvil");
            System.out.println("8. URL");
            System.out.println("9. Facebook");
            System.out.println("10. Instagram");
            System.out.println("11. Cancelar");
            System.out.print("Opción: ");
            
            String opcion = scanner.nextLine();
            String nuevoValor = "";
            boolean modificado = false;
            
            switch (opcion) {
                case "1":
                    System.out.print("Nuevo nombre: ");
                    nuevoValor = scanner.nextLine();
                    registroActual = modificarCampo(registroActual, 0, nuevoValor);
                    modificado = true;
                    break;
                case "2":
                    System.out.print("Nuevo apellido paterno: ");
                    nuevoValor = scanner.nextLine();
                    registroActual = modificarCampo(registroActual, 2, nuevoValor);
                    modificado = true;
                    break;
                case "3":
                    System.out.print("Nuevo apellido materno: ");
                    nuevoValor = scanner.nextLine();
                    registroActual = modificarCampo(registroActual, 1, nuevoValor);
                    modificado = true;
                    break;
                case "4":
                    System.out.print("Nuevo email: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.contains("@")) {
                        System.out.println("El email debe contener '@'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 6, nuevoValor);
                    modificado = true;
                    break;
                case "5":
                    System.out.print("Nueva dirección: ");
                    nuevoValor = scanner.nextLine();
                    registroActual = modificarCampo(registroActual, 3, nuevoValor);
                    modificado = true;
                    break;
                case "6":
                    System.out.print("Nuevo teléfono: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.startsWith("55")) {
                        System.out.println("El teléfono debe comenzar con '55'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 4, nuevoValor);
                    modificado = true;
                    break;
                case "7":
                    System.out.print("Nuevo móvil: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.startsWith("55")) {
                        System.out.println("El móvil debe comenzar con '55'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 5, nuevoValor);
                    modificado = true;
                    break;
                case "8":
                    System.out.print("Nueva URL: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.toLowerCase().startsWith("http")) {
                        System.out.println("La URL debe comenzar con 'http'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 7, nuevoValor);
                    modificado = true;
                    break;
                case "9":
                    System.out.print("Nuevo Facebook: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.toLowerCase().contains("facebook.com")) {
                        System.out.println("El Facebook debe contener 'facebook.com'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 9, nuevoValor);
                    modificado = true;
                    break;
                case "10":
                    System.out.print("Nuevo Instagram: ");
                    nuevoValor = scanner.nextLine();
                    while (!nuevoValor.startsWith("@")) {
                        System.out.println("El Instagram debe comenzar con '@'. Intente de nuevo:");
                        nuevoValor = scanner.nextLine();
                    }
                    registroActual = modificarCampo(registroActual, 8, nuevoValor);
                    modificado = true;
                    break;
                case "11":
                    System.out.println("Modificación cancelada.");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            
            if (modificado) {
                boolean exito = rw.modificarRegistro(numeroRegistro, registroActual);
                if (exito) {
                    System.out.println("Registro modificado exitosamente.");
                } else {
                    System.out.println("Error al modificar el registro.");
                }
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        }
        
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Reemplaza un campo específico dentro de un registro de texto.
     * @param registro Registro completo en formato plano.
     * @param indiceCampo Índice del campo a modificar.
     * @param nuevoValor Nuevo valor para ese campo.
     * @return Cadena con el registro modificado.
     */
    private static String modificarCampo(String registro, int indiceCampo, String nuevoValor) {
        String[] partes = registro.split("; ");
        
        if (indiceCampo < partes.length) {
            partes[indiceCampo] = nuevoValor;
            StringBuilder nuevoRegistro = new StringBuilder();
            for (int i = 0; i < partes.length; i++) {
                nuevoRegistro.append(partes[i]);
                if (i < partes.length - 1) {
                    nuevoRegistro.append("; ");
                }
            }
            return nuevoRegistro.toString();
        }
        return registro;
    }

    private static void mostrarCalendario() {
        System.out.println("=== MOSTRAR CALENDARIO ===");
        
        int año = getYear();
        int mes = getMes();
        
        Calendario calendario = new Calendario(mes, año);
        String calendarioStr = calendario.generaCalendario();
        
        System.out.println("\n" + calendarioStr);
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    private static int getYear() {
        int año = 0;
        while (año < 1900 || año > 2100) {
            try {
                System.out.print("Ingrese el año (1900-2100): ");
                año = Integer.parseInt(scanner.nextLine());
                if (año < 1900 || año > 2100) {
                    System.out.println("Año fuera del rango válido (1900-2100).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return año;
    }

    private static int getMes() {
        int mes = 0;
        while (mes < 1 || mes > 12) {
            try {
                System.out.print("Ingrese el mes (1-12): ");
                mes = Integer.parseInt(scanner.nextLine());
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes fuera del rango válido (1-12).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return mes;
    }
}