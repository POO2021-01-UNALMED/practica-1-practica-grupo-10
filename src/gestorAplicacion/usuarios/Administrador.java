package gestorAplicacion.usuarios;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1;

    public Administrador(){
        super();
    }

    public Administrador(String nombre, String correo){
        super(nombre, correo);
    }

    @Override
    public String toString(){
        return "Administrador: \n"
                +"nombre: " + nombre + "\n"
                +"correo: " + correo + "\n";
    }
}
