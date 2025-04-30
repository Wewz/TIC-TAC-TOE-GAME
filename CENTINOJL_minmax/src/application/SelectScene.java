package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelectScene {
	private Scene scene;
	private Parent root;	
	private SelectController controller;
	private Stage stage;
	
	public SelectScene(Scene scene) throws IOException {
		
		this.scene = scene;
		
		FXMLLoader loader = null;
		loader = new FXMLLoader(getClass().getResource("SelectScene.fxml"));
		this.root = loader.load();
		this.controller = loader.getController();
		this.controller.setCurrent(this);
	}
	
	public void setStage(Stage stage) {
		
		this.scene = new Scene(this.root);
		String css = this.getClass().getResource("SelectScene.css").toExternalForm();
		this.scene.getStylesheets().add(css);
		stage.setScene(this.scene); 
	}
	
	public void handleButton(ActionEvent event, String s) throws IOException, InterruptedException {
		
		this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();	
		PlayingScene thePlayingScene = new PlayingScene(this.scene);
		thePlayingScene.setStage(this.stage, s);
	}
	
	public void handleMenu(ActionEvent event, String s) throws IOException {
		
		this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();	
		StartScene theStartScene = new StartScene();
		theStartScene.setStage(this.stage);
	}
	
}
