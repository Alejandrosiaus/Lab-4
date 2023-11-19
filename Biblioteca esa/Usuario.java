import java.util.ArrayList;
import java.util.List;

interface Prestamo {
    void imprimirListadoPrestamo();
}
public class Usuario implements Prestamo {
    private String username;
    private String password;
    private String plan;
    private List<String> librosPrestados;
    private List<String> revistasPrestadas;
    private List<String> opcionesPremium;
    private List<String> opcionesNoPremium;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.plan = "base";
        this.librosPrestados = new ArrayList<>();
        this.revistasPrestadas = new ArrayList<>();
        this.opcionesPremium = new ArrayList<>();
        this.opcionesNoPremium = new ArrayList<>();
    }

    public void setOpcionesPremium(List<String> opcionesPremium) {
        this.opcionesPremium = opcionesPremium;
    }

    public List<String> getOpcionesNoPremium() {
        return opcionesNoPremium;
    }

    public void setOpcionesNoPremium(List<String> opcionesNoPremium) {
        this.opcionesNoPremium = opcionesNoPremium;
    }

    public void seleccionarPlan(String plan) {
        this.plan = plan;
    }

    public void agregarLibro(String libro, int diasPrestamo) {
        if ((plan.equals("premium") && librosPrestados.size() < 5) ||
                (plan.equals("base") && librosPrestados.size() < 3)) {
            librosPrestados.add(libro);
            System.out.println("Libro agregado correctamente. Puede devolverlo en " + diasPrestamo + " dias.");
        } else {
            System.out.println("No puedes prestar mas libros.");
        }
    }

    public void agregarRevista(String revista) {
        revistasPrestadas.add(revista);
        System.out.println("Revista agregada correctamente.");
    }

 

    @Override
    public void imprimirListadoPrestamo() {
        System.out.println("Listado de prestamos:");

        System.out.println("Libros:");
        for (String libro : librosPrestados) {
            System.out.println("- " + libro);
        }

        System.out.println("Revistas:");
        for (String revista : revistasPrestadas) {
            System.out.println("- " + revista);
        }
    }

    public void cambiarContraseña(String nuevaContraseña) {
        this.password = nuevaContraseña;
        System.out.println("Contraseña cambiada exitosamente.");
    }

    public String getUsername() {
        return username;
    }

    public String getPlan() {
        return plan;
    }

    public List<String> getLibrosPrestados() {
        return librosPrestados;
    }

    public boolean verificarCredenciales(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public List<String> getRevistasPrestadas() {
    return revistasPrestadas;
    }
}