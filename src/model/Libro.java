package model;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable{
	 String identificador=null,titulo=null,autor=null,editor=null;
	 int numeroDePaginas;
	 int anyoDePublicacion;
	 
	 
	 
	 public Libro(String identificador, String titulo, String autor, String editor, int numeroDePaginas,
			int anyoDePublicacion) {
		super();
		this.identificador = identificador;
		this.titulo = titulo;
		this.autor = autor;
		this.editor = editor;
		this.numeroDePaginas = numeroDePaginas;
		this.anyoDePublicacion = anyoDePublicacion;
	}
	 
	 
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	public int getAnyoDePublicacion() {
		return anyoDePublicacion;
	}
	public void setAnyoDePublicacion(int anyoDePublicacion) {
		this.anyoDePublicacion = anyoDePublicacion;
	}
	
	
	
}
