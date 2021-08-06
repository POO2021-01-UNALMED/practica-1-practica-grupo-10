package baseDatos;

import gestorAplicacion.Configuracion;

import java.io.IOException;

public class RepositorioConfiguracionImp implements RepositorioConfiguracion {

    public void guardar(Configuracion configuracion) throws IOException {
        Serializador.serializar(configuracion);
    }

    public Configuracion leer() {
        return Deserializador.deserializarConfiguracion();
    }
}
