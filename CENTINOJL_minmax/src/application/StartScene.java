package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class StartScene {
	private Scene scene;
	private Parent root;	
	private StartController controller;
	private Stage stage;
	
	public StartScene() throws IOException {
		FXMLLoader loader = null;
		loader = new FXMLLoader(getClass().getResource("StartScene.fxml"));
		this.root = loader.load();
		this.controller = loader.getController();
		this.controller.setCurrent(this);
	}
	
	public void setStage(Stage stage) {
		
		this.stage = stage;
		
		stage.setTitle("");	
		stage.show();
		
		stage.setMinWidth(938);
		stage.setMinHeight(717);
		
		stage.setMaxHeight(717);
		stage.setMaxWidth(938);
		
		this.scene = new Scene(this.root);
		String css = this.getClass().getResource("StartScene.css").toExternalForm();
		this.scene.getStylesheets().add(css);
		stage.setScene(this.scene); 
	}
	
	public void handleStart(ActionEvent event) throws IOException {
		
		this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		SelectScene theSelectScene = new SelectScene(this.scene);
		theSelectScene.setStage(this.stage);
	}
	
	public void handleAbout() {
		
	}
}
