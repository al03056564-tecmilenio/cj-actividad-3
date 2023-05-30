import java.util.Scanner;

public class Decks {
    private static Deck deck;
    public static void main(String[] args) {
        deck = new Deck();
        System.out.println(Colores.RED + " ~~~ " + Colores.WHITE_BOLD + "Bienvenido a DECK " + Colores.RED + "~~~");
        System.out.print(Colores.RESET);
        mostrarMenu();
    }
    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] opciones = {"1: Head", "2: Pick", "3: Hand", "4: Shuffle", "5: Show Cards", "9: SALIR"};
            for (String opcion: opciones) {
                System.out.print(Colores.WHITE + "[" + Colores.GREEN + opcion + Colores.WHITE + "] ");
            }
            System.out.println("");
            System.out.print(Colores.RED +"        Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    deck.head();
                    break;
                case 2:
                    deck.pick();
                    break;
                case 3:
                    deck.hand();
                    break;
                case 4:
                    deck.shuffle();
                    break;
                case 5:
                    deck.showDeck();
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.\n");
            }
        }
        System.out.println("¡Hasta luego!");
    }
}
