package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

public class PlayingScene {
	private Stage stage;
	private Scene scene;
	private Parent root;	
	private PlayingController controller;
	private MinMax minmaxAlgo;
	
	private String playerSign = "";
	private String aiSign = "";
	private boolean aiMove = false;
	private boolean playerMove = false;
	
	private boolean win = false;
	
	private ArrayList<String[]> boardState;
	
	public PlayingScene(Scene scene) throws IOException {
		
		this.scene = scene;
		
		FXMLLoader loader = null;
		loader = new FXMLLoader(getClass().getResource("PlayingScene.fxml"));
		this.root = loader.load();
		this.controller = loader.getController();
		this.controller.setCurrent(this);
		
		this.minmaxAlgo = new MinMax();
		this.minmaxAlgo.setCurrent(this);
		
		this.boardState = new ArrayList<>();
	}
	
	public void setStage(Stage stage, String s) throws InterruptedException {	
		
		this.stage = stage;
		
		this.scene = new Scene(this.root);
		String css = this.getClass().getResource("PlayingScene.css").toExternalForm();
		this.scene.getStylesheets().add(css);
		this.stage.setScene(this.scene); 
		
		this.playerSign = s;
		
		if(s.equals("x")) {
			this.playerMove = true;
			this.aiSign = "o";
			this.controller.setPlayerImage();
			this.controller.setTurn("Your");
		}
		else {
			this.aiMove = true;
			this.aiSign = "x";
			this.controller.setAiImage();
			this.controller.setTurn("AI");
		}

		this.initializeBoard();
	}
	
	public boolean getAiMove() {
		return this.aiMove;
	}
	
	public boolean getPlayerMove() {
		return this.playerMove;
	}
	
	public String getPlayerSIgn() {
		return this.playerSign;
	}
	
	public String getAiSign() {
		return this.aiSign;
	}
	
	public boolean getWin() {
		return this.win;
	}
	
	public void setWin(boolean val) {
		this.win = val;
	}
	
	public void setMove() {

		this.aiMove = !this.aiMove;
		this.playerMove = !this.playerMove;
		
	}
	
	public ArrayList<String[]> getBoard() {
		return this.boardState;
	}
	
	public void aiMove() throws InterruptedException {
	
		System.out.println("Task running...");

		// Add a 2-second pause before executing the task
		PauseTransition pause = new PauseTransition(Duration.seconds(2));
		pause.setOnFinished(event -> {
		    int resultMove;
			try {
				resultMove = this.minmaxAlgo.minmax(this.boardState, true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
				
				System.out.println("\n"+ resultMove);
		        Platform.runLater(() -> this.move(this.aiSign, resultMove));
		        System.out.println("Task completed.\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		// Start the pause transition
		pause.play();
	    
	}
	
	public void initializeBoard() throws InterruptedException {
		
		for(int i=0; i<3; i++) {
			String[] temp = new String[3];
			
			temp[0] = "";
			temp[1] = "";
			temp[2] = "";
			
			this.boardState.add(temp);
		}
		
		if(this.aiMove) {
			
			System.out.println("Task running...");

			// Add a 2-second pause before executing the task
			PauseTransition pause = new PauseTransition(Duration.seconds(2));
			pause.setOnFinished(event -> {
			    int resultMove;
				Random rand = new Random();
				int pos = rand.nextInt(9);
				
				Platform.runLater(() -> this.move(aiSign, pos));
				System.out.println("Task completed.\n");
			});
			
			// Start the pause transition
			pause.play();
		}
	}
	
	public void setBoard(String move, int pos) {
		this.boardState.get(pos/3)[pos%3] = move;
	}
	
	public void move(String move, int pos) {	
		
		if(pos == 0) this.controller.handle00();
		else if(pos == 1) this.controller.handle01();
		else if(pos == 2) this.controller.handle02();
		else if(pos == 3) this.controller.handle10();
		else if(pos == 4) this.controller.handle11();
		else if(pos == 5) this.controller.handle12();
		else if(pos == 6) this.controller.handle20();
		else if(pos == 7) this.controller.handle21();
		else if(pos == 8) this.controller.handle22();
		
	}
	
	public void checkWin() throws InterruptedException {
		
		
		for(int i=0; i<3; i++) {
			
			if(this.boardState.get(i)[0].equals(this.boardState.get(i)[1]))
				if(this.boardState.get(i)[0].equals(this.boardState.get(i)[2]))
					if(this.boardState.get(i)[0].equals(this.aiSign)) this.aiWin();
					else if(this.boardState.get(i)[0].equals(this.playerSign)) this.playerWin();
			
			if(this.boardState.get(0)[i].equals(this.boardState.get(1)[i]))
				if(this.boardState.get(0)[i].equals(this.boardState.get(2)[i]))
					if(this.boardState.get(0)[i].equals(this.aiSign)) this.aiWin();
					else if(this.boardState.get(0)[i].equals(this.playerSign)) this.playerWin();
		}
		
		if(this.boardState.get(0)[0].equals(this.boardState.get(1)[1]))
			if(this.boardState.get(0)[0].equals(this.boardState.get(2)[2]))
				if(this.boardState.get(0)[0].equals(this.aiSign)) this.aiWin();
				else if(this.boardState.get(0)[0].equals(this.playerSign)) this.playerWin();
		
		if(this.boardState.get(0)[2].equals(this.boardState.get(1)[1]))
			if(this.boardState.get(0)[2].equals(this.boardState.get(2)[0]))
				if(this.boardState.get(0)[2].equals(this.aiSign)) this.aiWin();
				else if(this.boardState.get(0)[2].equals(this.playerSign)) this.playerWin();
		
		boolean tie = true;
		
		for(int i = 0; i<this.boardState.size(); i++) {
			
			for(int j=0; j<this.boardState.get(i).length; j++) {
				if(this.boardState.get(i)[j].equals("")) {
					tie = false;
					break;
				}
			}
			
			if(!tie) break;
		}
		
		if(tie) this.Tie();
	}
	
	public void Tie() throws InterruptedException {

		this.controller.setTieImage();
		this.controller.setTurn("It's a");
		this.controller.setTurn2("Tie");
		this.setWin(true);
	}
	
	public void aiWin() throws InterruptedException {
		
		this.controller.setAiImage();
		this.controller.setTurn("AI");
		this.controller.setTurn2("Wins");
		this.setWin(true);
	}
	
	public void playerWin() throws InterruptedException {
		
		this.controller.setPlayerImage();
		this.controller.setTurn("You");
		this.controller.setTurn2("Win");
		this.setWin(true);
	}
	
	
	public void handleMenu(ActionEvent event, String s) throws IOException {
		
		this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();	
		StartScene theStartScene = new StartScene();
		theStartScene.setStage(this.stage);
	}
	
	public void handleNewGame(ActionEvent event) throws IOException {
		this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();	
		SelectScene theSelectScene = new SelectScene(this.scene);
		theSelectScene.setStage(this.stage);
	}
	
}
