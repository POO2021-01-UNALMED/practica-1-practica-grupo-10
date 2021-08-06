package gestorAplicacion.usuarios;

public class Administrador extends Usuario {

    final private String password = "admin";

    public Administrador() {
        super("Administrador", "admin@correo.com");
    }

    public static Administrador getInstance() {
        return new Administrador();
    }

    public Administrador(String nombre, String correo) {
        super(nombre, correo);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario Administrador: \n"
                + "\tnombre: " + nombre + "\n"
                + "\tcorreo: " + correo + "\n";
    }
}
