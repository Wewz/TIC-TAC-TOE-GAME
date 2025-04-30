package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class StartController {

	private StartScene current;
	
	public StartController() {

	}
	
	public void setCurrent(StartScene current) {
		this.current = current;
	}
	
	public void startButton(ActionEvent event) {
		System.out.println("Game Start");
		
		try {
			this.current.handleStart(event);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exitButton() {
		System.exit(0);
	}
	
	
	
}
