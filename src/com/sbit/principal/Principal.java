package com.sbit.principal;

import java.util.ArrayList;
import java.util.List;

import com.sbit.controller.ControladorTest;
import com.sbit.enums.TipoMensaje;
import com.sbit.model.Conversacion;
import com.sbit.model.Mensaje;
import com.sbit.model.Usuario;
import com.sbit.util.HibernateUtil;
import com.sbit.util.Utilidades;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Principal extends Application {

	private Stage primaryStage;
	private AnchorPane layoutPrincipal;
	public List<Conversacion> listaConversacion = new ArrayList<Conversacion>();
	public Usuario usuarioActivo;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		cargarVentanaLogin();
		primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

			public void handle(WindowEvent event) {
				HibernateUtil.getSessionFactory().close();
			}
		});

	}

	public void cargarVentanaLogin() throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Utilidades.restToURL("/com/sbit/view/test.fxml"));
		layoutPrincipal = loader.load();
		Scene escena = new Scene(layoutPrincipal);
		escena.setFill(Color.TRANSPARENT);
		primaryStage.setScene(escena);
		// primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		ControladorTest cp = loader.getController();
		cp.setTipoMensaje(TipoMensaje.SERVIDOR);
		cp.getPanel().setStyle("-fx-background-color: rgba(0, 100, 100, 0);");
		cp.setEscenario(primaryStage);
		primaryStage.show();

	}
}
