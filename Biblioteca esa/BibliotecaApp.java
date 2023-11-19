import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la AppBiblioteca");

        System.out.println("\nPor favor, regístrese:");
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("¿Qué tipo de membresía desea (premium/base)?: ");
        String tipoMembresia = scanner.nextLine();

        if (tipoMembresia.equalsIgnoreCase("premium")) {
            System.out.println("\n¡Felicidades por elegir la membresía Premium!");
            System.out.println("Beneficios:");
            System.out.println("- Mayor cantidad de libros prestados.");
            System.out.println("- Plazos de préstamo extendidos.");
            System.out.println("- Opciones adicionales en el proceso de préstamo.");
            // Puedes añadir más beneficios aquí...
        } else {
            System.out.println("\nUsted ha seleccionado la membresía base.");
            System.out.println("Se le recomienda cambiar su membresía a premium para obtener los siguientes beneficios:");
            System.out.println("- Mayor cantidad de libros prestados.");
            System.out.println("- Plazos de préstamo extendidos.");
            System.out.println("- Opciones adicionales en el proceso de préstamo.");
        }

        Usuario usuario = new Usuario(username, password);
        usuario.seleccionarPlan(tipoMembresia);

        usuarios.add(usuario);
        System.out.println("Usuario registrado exitosamente.");

        // Inicio de sesión
        boolean credencialesCorrectas = false;
        while (!credencialesCorrectas) {
            System.out.println("\n¡Inicio de sesión!");
            System.out.print("Nombre de usuario: ");
            String userLogin = scanner.nextLine();
            System.out.print("Contraseña: ");
            String passwordLogin = scanner.nextLine();

            boolean usuarioEncontrado = false;
            for (Usuario user : usuarios) {
                if (user.verificarCredenciales(userLogin, passwordLogin)) {
                    usuarioEncontrado = true;
                    usuarioActual = user;
                    credencialesCorrectas = true; 
                    break;
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("\nUsuario o contraseña incorrectos. Intente nuevamente.");
            }
        }
        mostrarMenu(scanner);


    }

    private static void mostrarMenu(Scanner scanner) {
        boolean continuar = true;
        GestionLibro gestionLibro = new GestionLibro(usuarioActual, scanner);

        while (continuar) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar revista");
            System.out.println("3. Vaciar lista");
            System.out.println("4. Libros/Revistas prestados");
            System.out.println("5. Cambiar la contraseña");
            System.out.println("6. Salir");

            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    gestionLibro.agregarLibro();
                    break;
                case 2:
                    gestionLibro.agregarRevista();
                    break;
                case 3:
                    gestionLibro.vaciarLista();
                    break;
                case 4:
                    usuarioActual.imprimirListadoPrestamo();
                    break;
                case 5:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContraseña = scanner.nextLine();
                    usuarioActual.cambiarContraseña(nuevaContraseña);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}


