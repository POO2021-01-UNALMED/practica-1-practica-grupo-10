package gestorAplicacion.usuarios;

import java.io.Serializable;

public class Desarrollador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1;
    private int id;

    public Desarrollador() {
        super();
    }

    public Desarrollador(String nombre, String correo, int id) {
        super(nombre, correo);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario Desarrollador: \n"
                + "\tid: " + id + "\n"
                + "\tnombre: " + nombre + "\n"
                + "\tcorreo: " + correo + "\n";
    }
}
