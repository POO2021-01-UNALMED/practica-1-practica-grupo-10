package gestorAplicacion.tablero;
import java.util.Date;

public class Comentario {
	private String texto;
	private String fechaCreacion;
	
	private void editartexto(String texto) {
		this.texto = texto;
		this.fechaCreacion = new Date().toString();
	}
}
