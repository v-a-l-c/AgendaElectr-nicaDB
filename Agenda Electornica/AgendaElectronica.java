import java.lang.StringBuilder;
import java.util.Scanner;

public class AgendaElectronica {
    public static void main(String[] args){
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
        Scanner scanner = new Scanner(System.in);
        String menu = menu();
        while (!exit) {
            System.out.print(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
            case "1":
                System.out.print("op1");
                break;
            case "2":
                System.out.print("op2");
                break;
            case "3":
                System.out.print("op3");
                break;
            case "4":
                System.out.print("op4");
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
}