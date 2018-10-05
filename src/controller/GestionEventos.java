package controller;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_guardarLibro,actionListener_recuperarLibro,actionListener_recuperarTodosLibro;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_compararContenido();// TODO: Llamar a la función call_compararContenido
				
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {	
				view.getTextArea().setText("Has apretado Buscar");
				call_buscarPalabra();// TODO: Llamar a la función call_buscarPalabra
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		//-- Ejercicio Libro --\\
		// Guardar Libro
		actionListener_guardarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.getTextArea().setText("Has apretado Guardar Libro");
				call_guardarLibro();// TODO: Llamar a la función call_guardarLibro
				
			}
		};
		view.getBtnGuardarLibro().addActionListener(actionListener_guardarLibro);
		// Recuperar un Libro
		actionListener_recuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.getTextArea().setText("Has apretado recuperar Libro");
				call_leerLibro();// TODO: Llamar a la función call_leerLibro
				
			}
		};
		view.getBtnRecuperarLibro().addActionListener(actionListener_recuperarLibro);
		
		// Recuperar todos los Libros
		actionListener_recuperarTodosLibro = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
			
				view.getTextArea().setText("Has apretado recuperar Todos Libro");
				
				ArrayList<String> arrayLibros = call_recuperar_todos();
				Iterator<String> iteratorLibro = arrayLibros.iterator();
				StringBuilder listadoTxT = new  StringBuilder();
				
				while(iteratorLibro.hasNext()) {
					
					listadoTxT.append(iteratorLibro.next()).append("\n");
					view.getTextArea().setText("\n" + listadoTxT);
				}	
			}
		};
		view.getBtnRecuperarTodos().addActionListener(actionListener_recuperarTodosLibro);
		
	}

	private int call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		String fichero1 = view.getFichero1().getText(); //almacena el nombre de fichero1
		String fichero2 = view.getFichero2().getText(); //almacena el nombre de fichero2
		
		try {
			//Mostramos el nombre del fichero1 y fichero 2 dentro del .compararContenido()
			boolean res = model.compararContenido(fichero1, fichero2 );
			
			if(res) { // Si el contenido es igual
				view.getTextArea().setText("Su contenido es Igual");
			}else { // el contenido es diferente 
				view.getTextArea().setText("No tienen el contenido Igual");
			}
		} catch (IOException e) {
			view.showError("Ha habido un error");
		}
		
		return 1;
	}

	private int call_buscarPalabra() {
		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		String fichero1 = view.getFichero1().getText(); //obtendremos el nombre del fichero1
		String palabra = view.getPalabra().getText(); // Obtendremos la palabra que vamos a buscar
		boolean primera_aparicion = view.getPrimera().isSelected(); //Obtenemos la informacion si esta activo o no	
		int res =0;
		
		try {
			// Este metodo Buscara del Fichero1 la palabra que hayamos puesto y nos dira en que linea aparecera
			res = model.buscarPalabra(fichero1, palabra, primera_aparicion);
			if(res>0) {
				
				view.getTextArea().setText("La Palabra que estas buscando es: "+ palabra + "\nLa palabra ha sido encontrada en la linea "+ res);
			}else {
				view.getTextArea().setText("La Palabra que estas buscando es: "+ palabra + "\nNo se ha encontrado ninguna palabra");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			view.showError("Ha habido un error");
		}
		return res;
	}
	
	// Ejercicio Libro
	/*
	 * En esta funcion rellenamos los inputs para guardar un libro( crear un .txt  ) con la informacion de la clase
	 */
	private void call_guardarLibro() {
		String identificador=view.getIdentificador().getText(),
			   titulo=view.getLibro().getText(),
			   autor=view.getAutor().getText(),
			   editor=view.getEditor().getText();
		int numeroDePaginas= Integer.parseInt(view.getTxtNumeroDePaginas().getText()),// Recogemos la informacion numerica de los inputs y lo convertimos en puros Integer
			anyoDePublicacion= Integer.parseInt(view.getTxtNumeroDePaginas().getText());
		
		
		Libro libro1 = new Libro(identificador, titulo, autor, editor,  numeroDePaginas, //Creamos un objeto de Libro
				 anyoDePublicacion);
		
		model.guardar_libro(libro1); // guardamos el libro
		
	}
	/*
	 * En esta funcion cogeremos un fichero txt creado por la funcion  call_guardarLibro();
	 * y leemos su informacion
	 */
	private void call_leerLibro() {
		String identificador=view.getIdentificador().getText();// Recogemos el Id del input Identificador
		Libro libro = model.recuperar_libro(identificador); // Recuperamos el libro(fichero)
		
		String id = libro.getIdentificador(),
			   titulo = libro.getTitulo(),
			   editor = libro.getEditor(),
			   autor = libro.getAutor();
		int  anyoDePublicacion = libro.getAnyoDePublicacion(),
			 numeroDePaginas = libro.getNumeroDePaginas();
		
		// Mostramos por el textArea la informacion del libro recuperado.	  
		view.getTextArea().setText("\n Id: " + id + "\n titulo: " + titulo + "\n Editor: " + editor + "\n Autor: " + autor + "\n Año de Publicacion: " + anyoDePublicacion + "\n Nº de Paginas "+ numeroDePaginas);
	}
	
	public ArrayList<String> call_recuperar_todos(){

		return model.recuperar_todos();
		
	}
	
}
