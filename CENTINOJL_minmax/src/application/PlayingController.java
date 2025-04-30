package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayingController {
	
	private PlayingScene current;
	private String move;
	
	@FXML
	Button pos00;
	@FXML
	Button pos01;
	@FXML
	Button pos02;
	@FXML
	Button pos10;
	@FXML
	Button pos11;
	@FXML
	Button pos12;
	@FXML
	Button pos20;
	@FXML
	Button pos21;
	@FXML
	Button pos22;
	@FXML
	Text turnText;
	@FXML
	Text turnText2;
	@FXML
	ImageView imageTurn;
	
	public PlayingController() {

	}
	
	public void setAiImage() {
		Image newImage = new Image(getClass().getResource("/application/ai.png").toExternalForm());
		imageTurn.setImage(newImage);
	}
	
	public void setPlayerImage() {
		Image newImage = new Image(getClass().getResource("/application/player.png").toExternalForm());
		imageTurn.setImage(newImage);
	}
	
	public void setTieImage() {
		Image newImage = new Image(getClass().getResource("/application/tie.png").toExternalForm());
		imageTurn.setImage(newImage);
	}
	
	public void setTurn(String s) {
		turnText.setText(s);
	}
	
	public void setTurn2(String s) {
		turnText2.setText(s);
	}
	
	public void setCurrent(PlayingScene thePlayingScene) {
		this.current = thePlayingScene;
	}
	
	public void handleMenu(ActionEvent event) throws IOException {
		this.current.handleMenu(event, move);
	}
	
	public void handleNewGame(ActionEvent event) throws IOException {
		this.current.handleNewGame(event);;
	}
	
	public void handle00() {
		this.setMove();
		this.setButton(pos00, this.move);
		this.current.setBoard(this.move, 0);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle01() {
		this.setMove();
		this.setButton(pos01, this.move);
		this.current.setBoard(this.move, 1);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle02() {
		this.setMove();
		this.setButton(pos02, this.move);
		this.current.setBoard(this.move, 2);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle10() {
		this.setMove();
		this.setButton(pos10, this.move);
		this.current.setBoard(this.move, 3);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle11() {
		this.setMove();
		this.setButton(pos11, this.move);
		this.current.setBoard(this.move, 4);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle12() {
		this.setMove();
		this.setButton(pos12, this.move);
		this.current.setBoard(this.move, 5);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle20() {
		this.setMove();
		this.setButton(pos20, this.move);
		this.current.setBoard(this.move, 6);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle21() {
		this.setMove();
		this.setButton(pos21, this.move);
		this.current.setBoard(this.move, 7);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle22() {
		this.setMove();		
		this.setButton(pos22, this.move);
		this.current.setBoard(this.move, 8);
		try {
			this.current.checkWin();
			
			if(this.current.getWin()) {
				// nothing
			}
			else if(this.current.getAiMove()) {
				
				System.out.println("AI Move");
				this.setTurn("AI");
				this.setAiImage();
				this.current.aiMove();
			}
			else {
				this.setPlayerImage();
				this.setTurn("Your");
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void setButton(Button button, String s) {
		Font font = Font.font("Poppins", FontWeight.EXTRA_BOLD, 25);
		
		button.setFont(font);
		button.setText(s);
		button.setStyle("-fx-font-size:61; -fx-font-weight: bold; -fx-background-color: #FFB177; ");
		button.setDisable(true);
		button.setOpacity(1);
		
		this.current.setMove();
	}

	public void setMove() {
		if(this.current.getPlayerMove()) this.move = this.current.getPlayerSIgn();
		else this.move = this.current.getAiSign();
	}
	
	public String getMove() {
		return this.move;
	}
	
	
}
