package gestorAplicacion.usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1;

    protected String nombre;
    protected String correo;

    public Usuario(){}

    public Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
