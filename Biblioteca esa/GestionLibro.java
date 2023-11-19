import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionLibro {
    private Usuario usuarioActual;
    private Scanner scanner;

    public GestionLibro(Usuario usuario, Scanner scanner) {
        this.usuarioActual = usuario;
        this.scanner = scanner;
    }

    public void agregarLibro() {
        if (usuarioActual.getPlan().equalsIgnoreCase("premium")) {
            if (usuarioActual.getLibrosPrestados().size() >= 5) {
                System.out.println("Ya alcanzó el límite máximo de libros prestados (5). No puede agregar más libros.");
                return;
            }

            System.out.print("Ingrese el nombre del libro que desea agregar: ");
            String nombreLibro = scanner.nextLine();
            usuarioActual.agregarLibro(nombreLibro, 50);

            // Otras opciones para el usuario premium
            System.out.print("Ingrese el horario de entrega (ejemplo: 14:00): ");
            String horarioEntrega = scanner.nextLine();

            System.out.print("Seleccione el lugar de envío: ");
            System.out.println("1. Casa");
            System.out.println("2. Oficina");
            int opcionEnvio = scanner.nextInt();
            scanner.nextLine();

            String lugarEnvio;
            switch (opcionEnvio) {
                case 1:
                    lugarEnvio = "Casa";
                    break;
                case 2:
                    lugarEnvio = "Oficina";
                    break;
                default:
                    System.out.println("Opcion de envio no valida. Seleccionado por defecto: Casa.");
                    lugarEnvio = "Casa";
                    break;
            }

            List<String> opcionesPremium = new ArrayList<>();
            opcionesPremium.add("Horario de entrega: " + horarioEntrega);
            opcionesPremium.add("Lugar de envio: " + lugarEnvio);
            usuarioActual.setOpcionesPremium(opcionesPremium);

        } else {
            if (usuarioActual.getLibrosPrestados().size() >= 3) {
                System.out.println("Ya alcanzo el limite de libros prestados (3). No puede agregar mas libros.");
                return;
            }

            System.out.print("Ingrese el nombre del libro que desea agregar: ");
            String nombreLibro = scanner.nextLine();
            usuarioActual.agregarLibro(nombreLibro, 30);

            System.out.print("Ingrese el nombre de la sucursal: ");
            String nombreSucursal = scanner.nextLine();

            System.out.print("Seleccione el horario en que recogera el prestamo (12 o 24 horas despues de la solicitud): ");
            String horarioPrestamo = scanner.nextLine();

            List<String> opcionesNoPremium = new ArrayList<>();
            opcionesNoPremium.add("Sucursal: " + nombreSucursal);
            opcionesNoPremium.add("Horario de prestamo: " + horarioPrestamo);
            usuarioActual.setOpcionesNoPremium(opcionesNoPremium);
        }
    }

    public void agregarRevista() {
        if (usuarioActual.getPlan().equalsIgnoreCase("premium")) {

            System.out.print("Ingrese el nombre de la revista que desea agregar: ");
            String nombreRevista = scanner.nextLine();
            usuarioActual.agregarRevista(nombreRevista);

            System.out.print("Ingrese el horario de entrega (ejemplo: 14:00): ");
            String horarioEntrega = scanner.nextLine();

            System.out.print("Seleccione el lugar de envío: ");
            System.out.println("1. Casa");
            System.out.println("2. Oficina");
            int opcionEnvio = scanner.nextInt();
            scanner.nextLine();

            String lugarEnvio;
            switch (opcionEnvio) {
                case 1:
                    lugarEnvio = "Casa";
                    break;
                case 2:
                    lugarEnvio = "Oficina";
                    break;
                default:
                    System.out.println("Opción de envío no válida. Seleccionado por defecto: Casa.");
                    lugarEnvio = "Casa";
                    break;
            }

            List<String> opcionesPremium = new ArrayList<>();
            opcionesPremium.add("Horario de entrega: " + horarioEntrega);
            opcionesPremium.add("Lugar de envío: " + lugarEnvio);
            usuarioActual.setOpcionesPremium(opcionesPremium);

        } else {
            System.out.print("Ingrese el nombre de la revista que desea agregar: ");
            String nombreRevista = scanner.nextLine();
            usuarioActual.agregarRevista(nombreRevista);

            System.out.print("Ingrese el nombre de la sucursal: ");
            String nombreSucursal = scanner.nextLine();

            System.out.print("Seleccione el horario de préstamo (12/24 horas después de la solicitud): ");
            String horarioPrestamo = scanner.nextLine();

            List<String> opcionesNoPremium = new ArrayList<>();
            opcionesNoPremium.add("Sucursal: " + nombreSucursal);
            opcionesNoPremium.add("Horario de préstamo: " + horarioPrestamo);
            usuarioActual.setOpcionesNoPremium(opcionesNoPremium);
        }
    }

    public void vaciarLista() {
        System.out.println("¿Qué lista desea vaciar?");
        System.out.println("1. Lista de libros");
        System.out.println("2. Lista de revistas");
        System.out.print("Ingrese la opción deseada: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                usuarioActual.getLibrosPrestados().clear();
                if (usuarioActual.getPlan().equalsIgnoreCase("premium")) {
                    usuarioActual.setOpcionesPremium(new ArrayList<>());
                } else {
                    usuarioActual.setOpcionesNoPremium(new ArrayList<>());
                }
                System.out.println("Lista de libros vaciada exitosamente.");
                break;
            case 2:
                usuarioActual.getRevistasPrestadas().clear();
                if (usuarioActual.getPlan().equalsIgnoreCase("premium")) {
                    usuarioActual.setOpcionesPremium(new ArrayList<>());
                } else {
                    usuarioActual.setOpcionesNoPremium(new ArrayList<>());
                }
                System.out.println("Lista de revistas vaciada exitosamente.");
                break;
                
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
}
