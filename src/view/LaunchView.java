package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra,autor;
	private JLabel label_f1,label_f2,label_pal,label_libro;
	private JCheckBox primera;
	
	private JPanel panel;
	private JTextField libro;
	private JTextField editor;
	private JTextField txtNumeroDePaginas;
	private JTextField txtAnoDePublicacion;
	private JTextField identificador;
	private JButton btnGuardarLibro;
	private JButton btnRecuperarLibro;
	private JButton btnRecuperarTodos;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		label_libro = new JLabel("Libro:");
		
		primera = new JCheckBox("Primera aparici�n");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(label_libro);
		
		libro = new JTextField();
		panel.add(libro);
		libro.setColumns(10);
		panel.add(primera);
		panel.add(textArea);
		
        // A�adimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        btnGuardarLibro = new JButton("Guardar libro");
        panel.add(btnGuardarLibro);
        
        btnRecuperarTodos = new JButton("Recuperar todos");
        panel.add(btnRecuperarTodos);
        
        btnRecuperarLibro = new JButton("Recuperar libro");
        panel.add(btnRecuperarLibro);
        
        txtNumeroDePaginas = new JTextField();
        txtNumeroDePaginas.setText("1");
        panel.add(txtNumeroDePaginas);
        txtNumeroDePaginas.setColumns(10);
        
        txtAnoDePublicacion = new JTextField();
        txtAnoDePublicacion.setText("2020");
        panel.add(txtAnoDePublicacion);
        txtAnoDePublicacion.setColumns(10);
        
        editor = new JTextField();
        editor.setText("editor");
        panel.add(editor);
        editor.setColumns(10);
        
        identificador = new JTextField();
        identificador.setText("identificador");
        panel.add(identificador);
        identificador.setColumns(10);
        autor = new JTextField("autor",10);
        panel.add(autor);
		
	}	

	public JButton getBtnRecuperarTodos() {
		return btnRecuperarTodos;
	}
	public void setBtnRecuperarTodos(JButton btnRecuperarTodos) {
		this.btnRecuperarTodos = btnRecuperarTodos;
	}
	public JButton getBtnRecuperarLibro() {
		return btnRecuperarLibro;
	}
	public void setBtnRecuperarLibro(JButton btnRecuperarLibro) {
		this.btnRecuperarLibro = btnRecuperarLibro;
	}
	public JTextField getAutor() {
		return autor;
	}
	public void setAutor(JTextField autor) {
		this.autor = autor;
	}
	public JTextField getLibro() {
		return libro;
	}
	public void setLibro(JTextField libro) {
		this.libro = libro;
	}
	public JTextField getEditor() {
		return editor;
	}
	public void setEditor(JTextField editor) {
		this.editor = editor;
	}
	public JTextField getTxtNumeroDePaginas() {
		return txtNumeroDePaginas;
	}
	public void setTxtNumeroDePaginas(JTextField txtNumeroDePaginas) {
		this.txtNumeroDePaginas = txtNumeroDePaginas;
	}
	public JTextField getTxtAnoDePublicacion() {
		return txtAnoDePublicacion;
	}
	public void setTxtAnoDePublicacion(JTextField txtAnoDePublicacion) {
		this.txtAnoDePublicacion = txtAnoDePublicacion;
	}
	public JTextField getIdentificador() {
		return identificador;
	}
	public void setIdentificador(JTextField identificador) {
		this.identificador = identificador;
	}
	public JButton getBtnGuardarLibro() {
		return btnGuardarLibro;
	}
	public void setBtnGuardarLibro(JButton btnGuardarLibro) {
		this.btnGuardarLibro = btnGuardarLibro;
	}
	public JTextField getPalabra() {
		return palabra;
	}
	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}
	public JCheckBox getPrimera() {
		return primera;
	}
	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}
	public JButton getComparar() {
		return comparar;
	}
	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}
	public JButton getBuscar() {
		return buscar;
	}
	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}		
	public JTextField getFichero1() {
		return fichero1;
	}
	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}
	public JTextField getFichero2() {
		return fichero2;
	}
	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
}
