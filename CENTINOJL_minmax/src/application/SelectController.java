package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SelectController {
	private SelectScene current;
	
	public SelectController() {
		
	}
	
	public void setCurrent(SelectScene current) {
		this.current = current;
	}
	
	public void xButton(ActionEvent event) throws IOException, InterruptedException {
		System.out.println("Game Start");
		
		this.current.handleButton(event, "x");
	}
	
	public void oButton(ActionEvent event) throws IOException, InterruptedException {
		System.out.println("Game Start");
		
		this.current.handleButton(event, "o");
	}
	
	public void menuButton(ActionEvent event) throws IOException {
		System.out.println("Menu");
		
		this.current.handleMenu(event, null);
	}
}
