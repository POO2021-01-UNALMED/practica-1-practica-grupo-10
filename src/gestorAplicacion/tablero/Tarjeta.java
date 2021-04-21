package gestorAplicacion.tablero;

import java.io.Serializable;
import gestorAplicacion.usuarios.*;

public class Tarjeta implements Serializable{
	  private String titulo;
	  private Columna columna;
	  private String descripcion;
	  private String color;
	  private Usuario usuario;
	  
	  public Tarjeta() {}
	  
	  
	  public Tarjeta(String titulo, Columna columna, String descripcion, String color, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.columna = columna;
		this.descripcion = descripcion;
		this.color = color;
		this.usuario = usuario;
	  }
	  
	 


	  private void mover(Columna columna) {
		    
	  }
	  private void agregarComentario(Columna columna) {
		    
	  }


	public Columna getColumna() {
		return columna;
	}


	public void setColumna(Columna columna) {
		this.columna = columna;
	}
    
	
	  
}
