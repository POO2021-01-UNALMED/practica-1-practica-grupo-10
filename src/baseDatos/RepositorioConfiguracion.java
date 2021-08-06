package baseDatos;

import gestorAplicacion.Configuracion;

import java.io.IOException;

public interface RepositorioConfiguracion {
    void guardar(Configuracion configuracion) throws IOException;
    Configuracion leer();
}
