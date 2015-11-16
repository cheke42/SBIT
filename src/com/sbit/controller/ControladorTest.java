package com.sbit.controller;

import java.util.ArrayList;
import java.util.List;

import com.sbit.enums.TipoMensaje;
import com.sbit.model.Mensaje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControladorTest {

	private TipoMensaje tipoMensaje;

	private List<Mensaje> listaMensajes = new ArrayList<Mensaje>();

	private Stage escenario;

	@FXML
	private Button buttonClose;

	@FXML
	private Button buttonMinimizer;

	@FXML
	private TitledPane contenedor;

	@FXML
	private AnchorPane panel;

	@FXML
	private Accordion acordeon;

	@FXML
	private Button botonEnviar;

	@FXML
	private TextArea textAreaMensaje;

	@FXML
	private GridPane gridtest;

	@FXML
	private ScrollPane scrollbar;

	public GridPane getGridtest() {
		return gridtest;
	}

	public void setGridtest(GridPane gridtest) {
		this.gridtest = gridtest;
	}

	public TitledPane getContenedor() {
		return contenedor;
	}

	public void setContenedor(TitledPane contenedor) {
		this.contenedor = contenedor;
	}

	public AnchorPane getPanel() {
		return panel;
	}

	public void setPanel(AnchorPane panel) {
		this.panel = panel;
	}

	public Accordion getAcordeon() {
		return acordeon;
	}

	public void setAcordeon(Accordion acordeon) {
		this.acordeon = acordeon;
	}

	public Button getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(Button buttonClose) {
		this.buttonClose = buttonClose;
	}

	public Button getButtonMinimizer() {
		return buttonMinimizer;
	}

	public void setButtonMinimizer(Button buttonMinimizer) {
		this.buttonMinimizer = buttonMinimizer;
	}

	public Button getBotonEnviar() {
		return botonEnviar;
	}

	public void setBotonEnviar(Button botonEnviar) {
		this.botonEnviar = botonEnviar;
	}

	public Stage getEscenario() {
		return escenario;
	}

	public void setEscenario(Stage escenario) {
		this.escenario = escenario;
	}

	public TextArea getTextAreaMensaje() {
		return textAreaMensaje;
	}

	public void setTextAreaMensaje(TextArea textAreaMensaje) {
		this.textAreaMensaje = textAreaMensaje;
	}

	public TipoMensaje getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(TipoMensaje tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public List<Mensaje> getListaMensajes() {
		return listaMensajes;
	}

	public void setListaMensajes(List<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}

	@FXML
	void minimizar(ActionEvent event) {

	}

	@FXML
	void salir(ActionEvent event) {
		escenario.close();
	}

	@FXML
	void enviarMensaje(ActionEvent event) {
		listaMensajes.add(new Mensaje());

		listaMensajes.get(listaMensajes.size() - 1).getTextArea().setEditable(false);
		agregarMensaje();
		listaMensajes.get(listaMensajes.size() - 1).getTextArea().setText(textAreaMensaje.getText());
		gridtest.add(listaMensajes.get(listaMensajes.size() - 1).getTextArea(), 0,
				Integer.parseInt(textAreaMensaje.getText()));
		textAreaMensaje.setText("");

	}

	private void agregarMensaje() {
		if (tipoMensaje == TipoMensaje.CLIENTE) {
			listaMensajes.get(listaMensajes.size() - 1).getTextArea().setStyle("-fx-background-color: #99CC99");
			Insets paddingChatCliente = new Insets(5, 0, 10, 5);
			listaMensajes.get(listaMensajes.size() - 1).getTextArea().setPadding(paddingChatCliente);
		} else {
			listaMensajes.get(listaMensajes.size() - 1).getTextArea().setStyle("-fx-background-color: #CCCCCC");
			Insets paddingChatServidor = new Insets(5, 60, 5, 0);
			listaMensajes.get(listaMensajes.size() - 1).getTextArea().setPadding(paddingChatServidor);
		}
	}

}
