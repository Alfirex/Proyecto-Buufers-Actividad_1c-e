package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionDatos {

	public GestionDatos() {

	}

	//TODO: Implementa una función para abrir ficheros
	public static BufferedReader abrirFichero(String nombreFichero) throws FileNotFoundException, IOException {
	     
	      FileReader fr = new FileReader(nombreFichero); // Inicializamos la lectura por caracter
	      BufferedReader br = new BufferedReader(fr); // Inicializamos la lectura por linea
	   
	      return br;
	      
	}
	//TODO: Implementa una función para cerrar ficheros
	public static void cerrarFichero(BufferedReader br) throws IOException {
		br.close();
	}
	public boolean compararContenido (String fichero1, String fichero2) throws IOException, IOException{
		//TODO: Implementa la función

		BufferedReader br = abrirFichero(fichero1), br2 = abrirFichero(fichero2);

		/*
		 * cadenaFichero almacenara la linea del fichero1
		 * cadenaFichero2 almacenara la linea del fichero2
		 * contenido1 almacenara el contenido del fichero1 en esta variable
		 * contenido2 almacenara el contenido del fichero2 en esta variable
		 */
		String cadenaFichero, cadenaFichero2, contenido1 =null, contenido2 =null; 
		
		while((cadenaFichero = br.readLine())!=null) {// Recorremos el contenido de fichero 1
			contenido1 += cadenaFichero; // Almacenamos el contenido de una Linea del fichero 1
	    }
		
		while((cadenaFichero2 = br2.readLine())!=null) {// Recorremos el contenido de fichero 2
			contenido2 += cadenaFichero2; // Almacenamos el contenido de una Linea del fichero 2
	    }
		
		cerrarFichero(br); // Cerramos la lectura del fichero1
		cerrarFichero(br2); // Cerramos la lectura del fichero2
		
		// Hacemos la comparacion de que si los ficheros son iguales o no.
		if( contenido1.compareTo(contenido2) == 0 ) {
			return true;
		}else {
			return false;
		}
	
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws FileNotFoundException, IOException{
		//TODO: Implementa la función
		 BufferedReader br = abrirFichero(fichero1);
		 /*
		  * linea en este variable obtendremos la linea
		  * apareaciones en esta variable añadiremos la palabra que contenga linea en ese momento del bucle
		  */
		 String linea = null, apareaciones = null;
		 /*
		  * primeraLinea obtendra el primer numero que aparecera en la linea
		  * contador_de_linea servira para contar la lineas del documento
		  * ultimo averiguara cual es la ultima linea que aparecera la plabra buscada
		  */
		 int primeraLinea = 0, contador_de_linea = 0, ultimo = 0;
		 
		 
		 
		 while ((linea = br.readLine()) != null) {
			 apareaciones = linea;
			 //System.out.println(appearances);
			 contador_de_linea++;
			 
			 if(apareaciones.compareTo(palabra)==0) { //Comparamos si la palabra coincide con el texto del documento
				 
				 ultimo = contador_de_linea; //Almacena en ultimo el numero de esa linea
			    	
				 if(primeraLinea == 0 && primera_aparicion) { // comprueba de que el checkbox este activo y que la variable no se haya sido incrementada
					 primeraLinea = contador_de_linea;//Sacamos la primera linea
				 }								  	    	
			 }
		 }
		
		 cerrarFichero(br); //cerramos el lector del fichero
		 
		  if(primera_aparicion) { // si en el caso que el check boxs este activo
			  return primeraLinea; //devuelve la primera linea
		  }else { // en el caso que no este activo el check box
			  return ultimo; // devuelve la ultima
		  }
	}	

}
