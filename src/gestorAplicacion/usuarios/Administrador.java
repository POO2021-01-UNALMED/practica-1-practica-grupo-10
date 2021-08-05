package gestorAplicacion.usuarios;

import java.io.Serializable;

public class Administrador extends Usuario {
    public Administrador() {
        super("Administrador", "admin@correo.com");
    }

    public static Administrador getInstance() {
        return new Administrador();
    }

    public Administrador(String nombre, String correo) {
        super(nombre, correo);
    }

    @Override
    public String toString() {
        return "Usuario Administrador: \n"
                + "\tnombre: " + nombre + "\n"
                + "\tcorreo: " + correo + "\n";
    }
}
