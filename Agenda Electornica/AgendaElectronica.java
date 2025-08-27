import java.StringBuilder;
import java.util.Scanner;

public class AgendaElectronica {
    public static void main(String[] args){
        handleMenu();
    }

    private static String menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Seleccione la opción que desea:\n");
        menu.append("1. Añadir registro\n");
        menu.append("2. Buscar registro\n");
        menu.append("3. Eliminar registro\n");
        menu.append("4. Modificar registro\n");
        menu.append("5. Salir\n");
        menu.append("Opción seleccionada:\n");
        return menu.toString();
    }
    private static void handleMenu() {
        System.Out.print(menu());
        Scanner scanner = new Scanner(System.in);
        String selectedOption = scanner.nextLine();
        switch (selectedOption) {
        case "1":
            System.Out.print("op1");
        case "2":
            System.Out.print("op2");
        case "3":
            System.Out.print("op3");
        case "4":
            System.Out.print("op4");
        case "5":
            System.Out.print("Byeeee");
            System.Exit(0);
        default:
            accepted = false;
            System.Out.print(option + "is not a valid option");
        }
    }
}