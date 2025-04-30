module CENTINOJL_minmax {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
	requires jdk.jdi;
	
	opens application to javafx.graphics, javafx.fxml;
}
