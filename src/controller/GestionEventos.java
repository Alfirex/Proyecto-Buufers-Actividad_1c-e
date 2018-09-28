package controller;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_compararContenido();
				// TODO: Llamar a la función call_compararContenido
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				view.getTextArea().setText("Has apretado Buscar");
				call_buscarPalabra();
				
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
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

}
